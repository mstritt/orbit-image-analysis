#Quantize graph
/root/tensorflow/bazel-bin/tensorflow/tools/graph_transforms/transform_graph \
  --in_graph='/resnet_101/frozen_model.pb' \
  --out_graph='/resnet_101/frozen_model_quantized.pb' \
  --inputs='image_batch' \
  --outputs='predictions' \
  --transforms='add_default_attributes sort_by_execution_order strip_unused_nodes quantize_weights'
