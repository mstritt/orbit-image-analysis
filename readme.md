# Orbit Image Analysis
![Orbit](src/main/resources/resource/orbit_round_64.png)

### A versatile image analysis software for biological image-based quantification.

#####News:
* 2.54: >8bit,<16bit bugfix (fluo rendering), only for Omero 5.3.x!
* 2.53: Using bioformats 5.4.0, multichannel (fluo) support, multi series support, works with Omero 5.3.x, Ice36
* 2.52: Using bioformats 5.4.0, multichannel (fluo) support, multi series support, works with Omero 5.2.x, Ice36

#####Available backends:

* Image provider local (local file system via Bioformats)
* Omero image server (image-provider-omero)

#####Scaleout via

* Spark scaleout (map-reduce-exec-spark)

#####Use gradle to build

Generic jar:

    gradle jar
    java -XX:MaxPermSize=150m -Djavax.xml.parsers.DocumentBuilderFactory=com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl -cp "build/libs/orbit-image-analysis.jar;build/libs/lib/*" com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis

License: GPLv3

Website: http://www.orbit.bio
