from __future__ import absolute_import
from __future__ import division
from __future__ import print_function

import argparse
import sys

from tensorflow.core.framework import graph_pb2
from tensorflow.python.client import session
from tensorflow.python.framework import importer
from tensorflow.python.framework import ops
from tensorflow.python.platform import app
from tensorflow.python.platform import gfile
from tensorflow.python.summary import summary

model_dir = 'D:/data/glomeruli/20180202_glomeruli_detection_noquant.pb'
log_dir = 'd:/temp/tf'

with session.Session(graph=ops.Graph()) as sess:
    with gfile.FastGFile(model_dir, "rb") as f:
        graph_def = graph_pb2.GraphDef()
        graph_def.ParseFromString(f.read())
        importer.import_graph_def(graph_def)

        # pb_visual_writer = summary.FileWriter(log_dir)
        # pb_visual_writer.add_graph(sess.graph)
        file_writer = summary.FileWriter(log_dir, sess.graph)
        print("Model Imported. Visualize by running: tensorboard --logdir={}".format(log_dir))



