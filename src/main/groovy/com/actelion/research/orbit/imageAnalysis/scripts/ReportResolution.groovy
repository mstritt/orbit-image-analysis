import loci.common.services.ServiceFactory
import loci.formats.IFormatReader
import loci.formats.ImageReader
import loci.formats.meta.IMetadata
import loci.formats.services.OMEXMLService

/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

/**
 * Reports the pixel size of an image.
 */

String imageName = "test.czi"
IFormatReader r = new ImageReader()
r.setFlattenedResolutions(false)
ServiceFactory factory = new ServiceFactory();
OMEXMLService service = factory.getInstance(OMEXMLService.class)
IMetadata meta = service.createOMEXMLMetadata()
r.setMetadataStore(meta)
r.setId(imageName)
imgIdx = 0
println "pixel resolution x: "+ meta.getPixelsPhysicalSizeX(imgIdx).value()+ " " + meta.getPixelsPhysicalSizeX(imgIdx).unit().symbol
println "pixel resolution y: "+ meta.getPixelsPhysicalSizeY(imgIdx).value()+ " " + meta.getPixelsPhysicalSizeY(imgIdx).unit().symbol
println "pixel size: " + (meta.getPixelsPhysicalSizeX(imgIdx).value() * meta.getPixelsPhysicalSizeY(imgIdx).value()) +" "+meta.getPixelsPhysicalSizeX(imgIdx).unit().symbol+"^2"
r.close()
