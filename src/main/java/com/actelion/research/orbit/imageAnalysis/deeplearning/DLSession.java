package com.actelion.research.orbit.imageAnalysis.deeplearning;

import org.tensorflow.Session;
import org.intel.openvino.*;

public class DLSession {
    // TensorFlow
    public Session tfSession;

    // OpenVINO
    public InferRequest ovRequest;
    private IECore ovSession;
    private ExecutableNetwork ovNet;

    DLSession() {}

    DLSession(Session s) {
        tfSession = s;
    }

    boolean isTensorFlow() {
        return tfSession != null;
    }

    boolean isOpenVINO() {
        return ovSession != null;
    }

    public void close() {
        if (tfSession != null) {
            tfSession.close();
        }
    }

    public static DLSession createOpenVINOSession(String fileName) {
        System.loadLibrary(IECore.NATIVE_LIBRARY_NAME);

        IECore ie = new IECore();

        CNNNetwork net = ie.ReadNetwork(fileName);
        InputInfo inputInfo = net.getInputsInfo()
                                 .get("image_batch/placeholder_port_0");
        inputInfo.setLayout(Layout.NHWC);

        ExecutableNetwork execNet = ie.LoadNetwork(net, "CPU");
        InferRequest req = execNet.CreateInferRequest();

        DLSession s = new DLSession();
        s.ovSession = ie;
        s.ovNet = execNet;
        s.ovRequest = req;
        return s;
    }
}
