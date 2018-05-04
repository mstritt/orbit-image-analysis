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

package com.actelion.research.orbit.imageAnalysis.tasks;

import com.actelion.research.mapReduceGeneric.IMapReduce;
import com.actelion.research.mapReduceGeneric.utils.KeyValue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MRTest implements IMapReduce<String, Integer, String> {
    @Override
    public List<KeyValue<Integer, String>> map(String element) {
        writefile("","map1.txt","map");
        writefile(System.getProperty("user.dir"),"map2.txt","map");
        writefile("/mnt/mesos/sandbox","map3.txt","map");

        boolean ex1 = new File("map1.txt").exists();
        boolean ex2 = new File(System.getProperty("user.dir")+File.separator+"map2.txt").exists();
        boolean ex3 = new File("/mnt/mesos/sandbox"+File.separator+"map3.txt").exists();

        List<String> res = new ArrayList<>();
        res.add("file1: "+ex1);
        res.add("file2: "+ex2);
        res.add("file3: "+ex3);

        List<KeyValue<Integer,String>> resKV = new ArrayList<>();
        int i=1;
        for (String s: res) {
            resKV.add(new KeyValue<>(i++,s+"\n"));
        }

        resKV.add(new KeyValue<>(i++,"abs path: "+new File("test.txt").getAbsolutePath()+"\n"));
        resKV.add(new KeyValue<>(i++,"current dir: "+System.getProperty("user.dir")+"\n"));
        for (String s: new File(System.getProperty("user.dir")).list()) {
            resKV.add(new KeyValue<>(i++,"list: "+s+"\n"));
        }

        return resKV;
    }

    @Override
    public String reduce(Integer key, List<String> valueList) {
//        writefile("","reduce1.txt","reduce");
//        writefile(System.getProperty("user.dir"),"reduce2.txt","reduce");
//        writefile("/mnt/mesos/sandbox","reduce3.txt","reduce");

        StringBuilder sb = new StringBuilder();
        if (valueList!=null) {
            for (String v: valueList) {
                sb.append(v+"\n");
            }
        }

        return sb.toString();
    }

    private void writefile(String dir, String filename, String content) {
        try (FileWriter fw = new FileWriter(dir+ File.separator+filename)) {
            fw.write(content);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<String> parseParams(String s) {
        Collection<String> collection = new ArrayList<>();
        return collection;
    }

    @Override
    public String serializeParam(String element) {
        return "";
    }
}
