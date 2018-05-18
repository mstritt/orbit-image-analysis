based on https://github.com/zhengyang-wang/Deeplab-v2--ResNet-101--Tensorflow

# Summary
- files in / data (images jpeg, masks png)
- preprocess_data.py start: conversion to 512x512 and rotations
- dataset / generate_dataset.py -> create filelists
- main.py: directories, adjust parameters, start to work out
- export_model.py: customize iterations step, export model as pb
- segment-py for segmentation, or frozen_model_backup * for visualization


# Segmentation
With the help of this implementation objects can be segmented.

## 1. Requirements
```
Python 3.5
Tensorflow 1.4.0
Jupyter notebook
NVIDIA graphics card (optional for GPU based training)
```

## 2. Preparations
Run the * setup.sh * script to create all necessary folders
and download the Resnet Checkfile.
```
bash setup.sh
```

## 3. Training
Store all data for the training in the directory * data *. Pictures are in the
JPG format, masks in PNG format. The Notebook * preprocess_data.ipynb *
to prepare the data for the training. The pictures are going on
brought the format 512x512 and created corresponding 1D vector masks.
The results are stored in the * data_preprocessed * directory.

Update: use preprocess_data.py -> adjust file separator on split

### 3.1 Creating a dataset
For the training now a dataset must be created. For this the script call
* generate_dataset_txt.py * in the * dataset * folder. Text files are created with file lists for testing, training and validation.
```
python generate_dataset_txt.py
```

### 3.2 Start training
Then the training can be started. Simply call the script
* main.py *.

```
python main.py
```

If you like, the hyperparameters can be adjusted in the * main.py * script. Important is the number of steps * num_steps * and * save_interval *. Watch for a falling loss when running the workout.

```
num_steps: how many iterations to train

save_interval: how many steps to save the model and save a checkpoint

random_seed: random seed for tensorflow

weight_decay: l2 regularization parameter

learning_rate: initial learning rate

power: parameter for poly learning rate
```

### 3.3 Tensor board for visualization
During the training you can visualize every checkpoint. In the
Main directory execute the following command.
```
tensorboard --logdir = log
```

## 4. Testing / Validation
To test and validate please first adjust the parameters in the * Main.py *.
The checkpoint number and the number of validations (number of
Lines in the file * valid.txt * in the directory * data_preprocessed *)

```
valid_step: checkpoint number for testing / validation

valid_num_steps: = number of testing / validation samples
```
Then call the script * main.py * with the parameter test as follows.
```
python main.py --option = test
```
You then get the "pixel accuracy" and the "mean IoU". In the future also the
F1 score.

### Validation with notebook
With the laptop * validate.ipynb * you can get validation results
graphically. Please also the parameter * valid_num_steps * on the number
validations and define the checkpoint number * valid_step *.

Update: does not work

## 5. Publish a model
To publish the model in other applications please use the notebook
* use export_pb_file.ipynb *. The notebook creates a * .pb file * with
the name * frozen_model.bp * in the main directory.

Update: use export_pb_file.py

### Check model before delivery
Whether the finished model works flawlessly, you can with the notebook
* frozen_model_showcase.ipynb * check. It uses the previously created pb file
for interference. Sample files from the * input_images * folder will be checked for review
used.

## 6. Notes
The implementation is based on the work * DeepLab v2 (ResNet-101) in TensorFlow *. See https://github.com/zhengyang-wang/Deeplab-v2--ResNet-101--Tensorflow