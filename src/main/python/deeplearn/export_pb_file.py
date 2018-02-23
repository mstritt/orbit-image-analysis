import model
import tensorflow as tf

tf.VERSION

class Config:
    def __init__(self):
        self.valid_step = 2000
        self.valid_num_steps = 765
        self.valid_data_list = './dataset/valid.txt'
        self.data_dir = './data_preprocessed'
        self.batch_size = 2
        self.input_height = 512
        self.input_width = 512
        self.num_classes = 2
        self.ignore_label = 0
        self.random_scale = False
        self.random_mirror = False
        self.modeldir = 'model'
        self.logfile = 'log.txt'
        self.logdir = 'log'
        self.encoder_name = 'res101'


sess = tf.Session()
m = model.Model(sess, Config())
m.test_setup()

from tensorflow.python.framework import graph_util

output_graph = "./frozen_model.pb"

# Before exporting our graph, we need to precise what is our output node
# This is how TF decides what part of the Graph he has to keep and what part it can dump
# NOTE: this variable is plural, because you can have multiple output nodes
input_node_names = "image_batch"
output_node_names = "predictions"

# We retrieve the protobuf graph definition
graph = tf.get_default_graph()
input_graph_def = graph.as_graph_def()

m.sess.run(tf.global_variables_initializer())
m.sess.run(tf.local_variables_initializer())

# load checkpoint
checkpointfile = m.conf.modeldir+ '/model.ckpt-' + str(m.conf.valid_step)
m.load(m.loader, checkpointfile)


# We use a built-in TF helper to export variables to constants
output_graph_def = graph_util.convert_variables_to_constants(
    sess, # The session is used to retrieve the weights
    input_graph_def, # The graph_def is used to retrieve the nodes
    output_node_names.split(",") # The output node names are used to select the usefull nodes
)

# Finally we serialize and dump the output graph to the filesystem
with tf.gfile.GFile(output_graph, "wb") as f:
    f.write(output_graph_def.SerializeToString())
print("%d ops in the final graph." % len(output_graph_def.node))
