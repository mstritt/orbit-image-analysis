# Orbit Image Analysis
![Orbit](src/main/resources/resource/orbit_round_64.png)

### A versatile image analysis software for biological image-based quantification.

#####Available backends:

* OMERO image server (imageprovideromero)

#####Scaleout via

* gridmapreduce (e.g. spark support)

#####Use gradle to build

Generic jar:

    gradle jar
    java -cp "build/libs/orbit-image-analysis.jar;build/libs/lib/*" com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis

License: GPLv3

Website: http://www.orbit.bio
