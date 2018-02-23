import tensorflow as tf
from PIL import Image
import glob
import matplotlib.pyplot as plt
import numpy as np

def load_graph(frozen_graph_filename):

    with tf.gfile.GFile(frozen_graph_filename, "rb") as f:
        graph_def = tf.GraphDef()
        graph_def.ParseFromString(f.read())
    with tf.Graph().as_default() as graph:
        tf.import_graph_def(graph_def, name="prefix")
    return graph

label_colours = [(0,0,0), (255,255,255)]
                #0=unclassified, 1=globoli

def decode_labels(mask, num_images=1, num_classes=2):
    n, h, w, c = mask.shape
    outputs = np.zeros((num_images, h, w, 3), dtype=np.uint8)
    for i in range(num_images):
      img = Image.new('RGB', (len(mask[i, 0]), len(mask[i])))
      pixels = img.load()
      for j_, j in enumerate(mask[i, :, :, 0]):
          for k_, k in enumerate(j):
              if k < num_classes:
                  pixels[k_,j_] = label_colours[k]
      outputs[i] = np.array(img)
    return outputs


graph = load_graph('C:/git/python/glomeruli3/frozen_model.pb')

# We access the input and output nodes
x = graph.get_tensor_by_name('prefix/create_inputs/img_filename:0')
y = graph.get_tensor_by_name('prefix/predictions:0')

plt.rcParams["figure.figsize"] = (10, 10)
config = tf.ConfigProto(device_count={'GPU': 0})
# We launch a Session
with tf.Session(graph=graph, config=config) as sess:
    img = 'C:/git/python/glomeruli/testin.jpg'
    y_out = sess.run(y, feed_dict={
        x: img
    })

    decoded_out = decode_labels(y_out.reshape(1, 512, 512, 1)).reshape(512, 512, 3)
    output_img = Image.fromarray(decoded_out)
    output_img.save('d:/test.jpg')
