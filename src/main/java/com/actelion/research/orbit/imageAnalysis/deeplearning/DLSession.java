package com.actelion.research.orbit.imageAnalysis.deeplearning;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.net.URL;

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
        // Load native libraries
        String[] nativeFiles = {
            "plugins.xml",
            "libngraph.so",
            "libinference_engine_transformations.so",
            "libinference_engine.so",
            "libinference_engine_ir_reader.so",
            "libinference_engine_legacy.so",
            "libinference_engine_lp_transformations.so",
            "libMKLDNNPlugin.so",
            "libinference_engine_java_api.so"  // Should be at the end
        };
        try {
            File tmpDir = Files.createTempDirectory("openvino-native").toFile();
            for (String file : nativeFiles) {
                URL url = IECore.class.getClassLoader().getResource(file);
                tmpDir.deleteOnExit();
                File nativeLibTmpFile = new File(tmpDir, file);
                nativeLibTmpFile.deleteOnExit();
                try (InputStream in = url.openStream()) {
                    Files.copy(in, nativeLibTmpFile.toPath());
                }
                String path = nativeLibTmpFile.getAbsolutePath();
                if (file.endsWith(".so")) {
                    System.load(path);
                }
            }
        } catch (IOException ex) {
        }

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
