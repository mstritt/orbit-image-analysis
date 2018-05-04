/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2018 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

package com.actelion.research.orbit.imageAnalysis.dal.MapReduceExecutor;

import com.actelion.research.mapReduceGeneric.IMapReduce;
import com.actelion.research.mapReduceGeneric.executors.IMapReduceExecutor;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;


/**
 * Executes a MapReduce via Spark.
 * By default appName is MapReduceExecutorSpark and master is local[*]. To change it set appName and master variables.
 *
 * @param <T> Type Input (e.g. Integer for IDs)
 * @param <K> Output Key (measurement identifier)
 * @param <V> Output Value (e.g. Integer for a count)
 */
public final class MapReduceExecutorSparkProxy<T, K, V> implements IMapReduceExecutor<T, K, V>, Serializable {

    private static final Logger logger = LoggerFactory.getLogger(MapReduceExecutorSparkProxy.class);
    private double progress = 0d;
    private String appName = "MapReduceExecutorSpark";
    private transient String[] jars = new String[]{};
    private int totalClusterCores = 330;
    private double clusterUsage = 0.75;
    private int coresPerJob = 10;
    private int memPerJobGB = 62;
    private String fatJarName = "orbit-image-analysis-all-2.81.jar";


    public MapReduceExecutorSparkProxy() {
    }

    public MapReduceExecutorSparkProxy(String appName, int coresPerJob, int memPerJobGB, double clusterUsage) {
        this.appName = appName;
        //if (jars != null) this.jars = jars;
        this.coresPerJob = coresPerJob;
        this.memPerJobGB = memPerJobGB;
        this.clusterUsage = clusterUsage;
    }

    public Map<K, V> execute(final Collection<T> elements, final IMapReduce<T, K, V> mapReduce) {
        String serUUID = UUID.randomUUID().toString();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] bytes = null;
        try {
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(mapReduce);
            oos.writeObject(elements);
            outputStream.flush();
            bytes = outputStream.toByteArray();
            logger.debug("serialization done");
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeToSMB(serUUID, bytes);
        
        logger.debug("executing task on cluster");
        try {
            deployTask(serUUID, elements.size());
            logger.info("task deployment successfull");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void writeToSMB(String serUUID, byte[] bytes) {
        String path = "spark/MR-"+serUUID+".ser";
        try  {
            //OrbitUtils.getSmbUtils().copyToRemote(bytes,"spark","MR-"+serUUID+".ser");
            DALConfig.getScaleOut().getRemoteContextStore().copyToRemote(bytes,"spark", "MR-"+serUUID+".ser");
            logger.info("serialized map-reduce task to samba share: "+path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String path, String serUUID, byte[] bytes) {
        //String path = httproot + File.separator + serUUID;
        logger.info("serializing map-reduce task to "+path);
        try  {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void deployTask(String serUUID, int parallelism) throws IOException {
        String host_port = "spark-imaging.idorsia.com:80";
        int numCPUs = Math.min((int)(totalClusterCores*clusterUsage), coresPerJob*parallelism);

        String payload = "{" +
                "  \"action\": \"CreateSubmissionRequest\"," +

                "  \"mainClass\": \"com.actelion.research.mapReduceExecSpark.executors.MapReduceExecutorSparkExec\"," +
                "  \"appArgs\": [ \"spark/MR-"+serUUID+".ser\" ]," +
                "  \"appResource\": \"/arcite/orbit/"+fatJarName+"\"," +

                "  \"clientSparkVersion\": \"2.1.1\"," +
                "  \"environmentVariables\" : {" +
                "    \"SPARK_ENV_LOADED\" : \"1\"" +
                "    ,\"MESOS_SANDBOX\" : \"/mnt/mesos/sandbox\"" +
                "  }," +
                "  \"sparkProperties\": {" +
              //  "    \"spark.jars\": \"deps.jar\"," +    // does not work
                "    \"spark.app.name\": \""+appName+"\"," +
                "    \"spark.driver.supervise\":\"false\"," +
                "    \"spark.executor.memory\": \""+memPerJobGB+"G\"," +
              //  "    \"spark.executor.cores\": \"10\"," +     //
              //  "    \"spark.executor.instances\": \"3\"," +   // not taken into account
                "    \"spark.cores.max\": \""+numCPUs+"\"," +  
                "    \"spark.task.cpus\": \""+coresPerJob+"\"," +

                "    \"spark.driver.memory\": \"1G\"," +
                "    \"spark.driver.cores\": \"2\"," +
                "    \"spark.default.parallelism\": \""+parallelism+"\"," +        
                "    \"spark.submit.deployMode\":\"cluster\"," +
                "    \"spark.mesos.executor.docker.image\": \"mesosphere/spark:2.1.0-2.2.1-1-hadoop-2.6\"," +
                "    \"spark.mesos.executor.docker.volumes\": \"/arcite/orbit/:orbit:rw\"" +
                "  }" +
                "}";
        StringEntity entity = new StringEntity(payload,
                ContentType.APPLICATION_JSON);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("http://"+host_port+"/v1/submissions/create");
        request.setEntity(entity);

        HttpResponse response = httpClient.execute(request);
        System.out.println("Status Code: "+response.getStatusLine().getStatusCode());
        String responseString = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
        System.out.println(responseString);

    }


    public double getProgress() {
        return progress;
    }

    protected void setProgress(double progress) {
        this.progress = progress;
    }

    public void cancel() {
        // not implemented
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String[] getJars() {
        return jars;
    }

    public void setJars(String[] jars) {
        this.jars = jars;
    }

}
