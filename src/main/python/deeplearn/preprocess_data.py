import glob
from PIL import Image
import numpy as np
import os
import tqdm
import multiprocessing
import threading

# used instead of proprocess_data.ipynb -> adjust dirs and path separator, here \\ for windows, replace by / for linux
# multithreading dies not work -> replaced by for loop

dest_dir = 'C:\git\python\glomeruli3\data_preprocessed'
dest_dir_masks = os.path.join( dest_dir, 'masks')
dest_dir_img = os.path.join( dest_dir, 'img')

palette = {(0,   0,   0) : 0 ,
         (0,  0, 255) : 0 ,
         (255,  255,  255) : 1
          }

def convert_from_color_segmentation(arr_3d):
    arr_2d = np.zeros((arr_3d.shape[0], arr_3d.shape[1]), dtype=np.uint8)

    for c, i in palette.items():
        m = np.all(arr_3d == np.array(c).reshape(1, 1, 3), axis=2)
        arr_2d[m] = i

    return arr_2d


images = glob.glob('C:\git\python\glomeruli3\data/*.jpg')
masks = glob.glob('C:\git\python\glomeruli3\data/*.png')

masks.sort()
images.sort()

assert( len(images) == len(masks))


def rotate(img, img_name, mask, mask_name, degree, postfix):
    img = img.rotate(degree)
    mask = mask.rotate(degree)

    mask_arr = np.array(mask)
    mask_conved = convert_from_color_segmentation(mask_arr)

    img.save(os.path.join(dest_dir_img, postfix + img_name))
    Image.fromarray(mask_conved).save(os.path.join(dest_dir_masks, postfix + mask_name))
    return


def process(args):
    image_src, mask_src = args

    image_name = '_'.join(image_src.split('\\')[-3:])
    mask_name = '_'.join(mask_src.split('\\')[-3:])

    img = Image.open(image_src)
    mask = Image.open(mask_src)

    img = img.resize((512, 512), Image.NEAREST)
    mask = mask.resize((512, 512), Image.NEAREST)

    rotate(img, image_name, mask, mask_name, 90, "90_")
    rotate(img, image_name, mask, mask_name, 180, "180_")
    rotate(img, image_name, mask, mask_name, 270, "270_")

    mask_arr = np.array(mask)
    mask_conved = convert_from_color_segmentation(mask_arr)

    img.save(os.path.join(dest_dir_img, image_name))
    Image.fromarray(mask_conved).save(os.path.join(dest_dir_masks, mask_name))


for i in range(len(masks)):
   print(str(i+1)+"/"+str(len(masks)) +": "+ images[i]+" / "+masks[i])
   process((images[i], masks[i]))

#pool = multiprocessing.Pool(8)
#tasks = []
#for i in range(len(masks)):
#    tasks.append((images[i], masks[i]))#
#
#for _ in tqdm.tqdm(pool.imap_unordered(process, tasks), total=len(tasks)):
#    pass
