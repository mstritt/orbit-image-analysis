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

package com.actelion.research.orbit.imageAnalysis.models;

import com.actelion.research.orbit.beans.RawAnnotation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;

public class ModelAnnotation extends RawAnnotation {

    private OrbitModel model;

    public ModelAnnotation(RawAnnotation ra) throws IOException, ClassNotFoundException {
        modifyDate = ra.getModifyDate();
        setRawAnnotationType(getRawAnnotationType());
        setDescription(ra.getDescription());
        setRawAnnotationId(ra.getRawAnnotationId());
        setRawDataFileId(ra.getRawDataFileId());
        setUserId(ra.getUserId());
        ByteArrayInputStream is = new ByteArrayInputStream(ra.getData());
        model = OrbitModel.LoadFromInputStream(is);
        is.close();
    }

    public ModelAnnotation(OrbitModel model, String elb, String name, String userId) {
        this.model = model;
        String descr = name;
        if (elb != null && elb.length() > 0) {
            descr = "[" + elb + "] " + name;
        }
        setDescription(descr);
        setModifyDate(new Date());
        setUserId(userId);
        setRawAnnotationType(getRawAnnotationType());
        setRawDataFileId(-1); // not assigned to a particular id
    }

    @Override
    public int getRawAnnotationType() {
        return ANNOTATION_TYPE_MODEL;
    }

    @Override
    public byte[] getData() {
        return model.getAsByteArray();
    }

    public OrbitModel getModel() {
        return model;
    }
}
