[![Image.sc forum](https://img.shields.io/badge/dynamic/json.svg?label=forum&url=https%3A%2F%2Fforum.image.sc%2Ftags%2Forbit.json&query=%24.topic_list.tags.0.topic_count&colorB=brightgreen&suffix=%20topics&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAOCAYAAAAfSC3RAAABPklEQVR42m3SyyqFURTA8Y2BER0TDyExZ+aSPIKUlPIITFzKeQWXwhBlQrmFgUzMMFLKZeguBu5y+//17dP3nc5vuPdee6299gohUYYaDGOyyACq4JmQVoFujOMR77hNfOAGM+hBOQqB9TjHD36xhAa04RCuuXeKOvwHVWIKL9jCK2bRiV284QgL8MwEjAneeo9VNOEaBhzALGtoRy02cIcWhE34jj5YxgW+E5Z4iTPkMYpPLCNY3hdOYEfNbKYdmNngZ1jyEzw7h7AIb3fRTQ95OAZ6yQpGYHMMtOTgouktYwxuXsHgWLLl+4x++Kx1FJrjLTagA77bTPvYgw1rRqY56e+w7GNYsqX6JfPwi7aR+Y5SA+BXtKIRfkfJAYgj14tpOF6+I46c4/cAM3UhM3JxyKsxiOIhH0IO6SH/A1Kb1WBeUjbkAAAAAElFTkSuQmCC)](https://forum.image.sc/tags/orbit)

# Orbit Image Analysis
![Orbit](src/main/resources/resource/orbit_round_64.png)

### A versatile image analysis software for biological image-based quantification.

##### News:
* 3.15: Omero 5.5.x, bioformats 6.1.1, bugfixes, AWS scaleout preperation.

##### Available backends:

* Image provider local (local file system via Bioformats)
* Omero image server (image-provider-omero)

##### Scaleout via

* Spark scaleout (map-reduce-exec-spark)

##### Use gradle to build

Generic jar:

    gradle jar
    java -XX:MaxPermSize=150m -Djavax.xml.parsers.DocumentBuilderFactory=com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl -cp "build/libs/orbit-image-analysis.jar;build/libs/lib/*" com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis

License: GPLv3

Website: http://www.orbit.bio
