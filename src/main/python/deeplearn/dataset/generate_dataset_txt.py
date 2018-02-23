import os, glob, sys
import pandas as pd

# Print an error message and quit
def printError(message):
    print('ERROR: {}'.format(message))
    sys.exit(-1)

def main():
    # Where to look for Data
    path = os.environ['DATASET']
    # how to search for all ground truth
    searchImg = os.path.join(path, "**", "*.jpg")
    searchMask = os.path.join(path, "**", "*.png")

    # search files
    filesImg = glob.glob(searchImg)
    filesImg.sort()
    filesMask = glob.glob(searchMask)
    filesMask.sort()
   
    assert len(filesImg) == len(filesMask)
    all_data = pd.DataFrame( {'img': filesImg, 'mask':filesMask} )
    test_data = all_data.sample( frac=0.1 )
    all_data = all_data.drop( test_data.index )
    valid_data = all_data.sample( frac=0.1 )
    train_data = all_data.drop( valid_data.index )
    
    print( test_data.shape, valid_data.shape, train_data.shape)

    
    # create txt
    dir_path = '.'
    print("---create test.txt---")
    with open(os.path.join(dir_path, 'test.txt'), 'w') as f:
        for i, l in test_data.iterrows():
            print(l)
            f.write(l['img'][len(path):] + '\n')
            
    print("---create valid.txt---")
    with open(os.path.join(dir_path, 'valid.txt'), 'w') as f:
        for i, l in valid_data.iterrows():
            print(l)
            f.write(l['img'][len(path):] + ' ' + l['mask'][len(path):] + '\n'  )
                        
            
    print("---create train.txt---")
    with open(os.path.join(dir_path, 'train.txt'), 'w') as f:
        for i, l in train_data.iterrows():
            print(l)
            f.write(l['img'][len(path):] + ' ' + l['mask'][len(path):] + '\n'  )
            
            
# call the main
if __name__ == "__main__":
    os.environ['DATASET'] = '../data_preprocessed'
    main()
