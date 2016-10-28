/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2016 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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
import com.actelion.research.orbit.imageAnalysis.components.*
import com.actelion.research.orbit.imageAnalysis.models.*

/**
 * Demo to show how active Orbit objects can be accessed.
 */
final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance(); // get the current (running) Orbit instance
// this allows us to query active objects like model and loaded images
ImageFrame iFrame = OIA.getIFrame();
println("selected image: "+iFrame);

OrbitModel model = OIA.getModel();
println("active model: "+model);

