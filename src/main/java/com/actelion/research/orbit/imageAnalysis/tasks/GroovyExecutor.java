/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.actelion.research.orbit.imageAnalysis.tasks;

import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import groovy.lang.GroovyShell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.net.URL;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class GroovyExecutor {
    private static final Logger logger = LoggerFactory.getLogger(GroovyExecutor.class);

    public static void doTrustToCertificates() throws Exception {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                        return;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                        return;
                    }
                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                    System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                }
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }

    public static void main(String[] args) throws Exception {
        OrbitLogAppender.GUI_APPENDER = false;
        if (args == null || args.length < 1)
            throw new IllegalArgumentException("No URL argument found. Call: GroovyExecutor <URL>");
        doTrustToCertificates();
        //URL url = new URL("https://chiron.europe.actelion.com/stash/projects/ORBIT/repos/public-scripts/browse/QuantPerGroupLocalTest.groovy?at=5ff41667c494870aaacbe37fa43fd46fd4c9659c&raw");
        URL url = new URL(args[0]);
        String content = RawUtilsCommon.getContentStr(url);
        logger.debug("executing code:\n" + content);
        logger.info("start executing groovy code");
        GroovyShell shell = new GroovyShell();
        shell.evaluate(content);
        logger.info("finished");
    }
}
