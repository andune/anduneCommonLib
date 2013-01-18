/**
 * 
 */
package com.andune.minecraft.commonlib.reflections;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.reflections.Reflections;
import org.reflections.serializers.Serializer;
import org.reflections.util.Utils;
import org.yaml.snakeyaml.Yaml;

import com.google.common.collect.Multimap;
import com.google.common.io.Files;

/**
 * @author andune
 *
 */
public class YamlSerializer implements Serializer {

    @Override
    public Reflections read(InputStream inputStream) {
        Yaml yaml = new Yaml();
        Reflections reflections = new Reflections();
        Map<String, Map<String, Collection<String>>> map =
                (Map<String, Map<String, Collection<String>>>) yaml.load(inputStream);
        for(String index : map.keySet()) {
            for(String key : map.get(index).keySet()) {
                for(String value : map.get(index).get(key)) {
                    reflections.getStore().getOrCreate(index).put(key, value);
                }
            }
        }
        return reflections;
//        return yaml.loadAs(inputStream, Reflections.class);
    }

    @Override
    public File save(Reflections reflections, String filename) {
        try {
            File file = Utils.prepareFile(filename);
            Files.write(toString(reflections), file, Charset.defaultCharset());
            return file;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString(Reflections reflections) {
        System.err.println("reflections.toString: "+reflections.toString());
        System.err.println("reflections.getStore: "+reflections.getStore());
        System.err.println("reflections.getStore.getKeysCount: "+reflections.getStore().getKeysCount());
        Yaml yaml = new Yaml();
//        String ret = yaml.dumpAsMap(reflections.getStore());
//        String ret = yaml.dumpAsMap(
//        StringBuilder sb = new StringBuilder();
//        DumperOptions dumperOptions = new DumperOptions();
//        dumperOptions.setIndent(2);
//        Yaml yamlIndented = new Yaml(dumperOptions);
        Map<String, Map<String, Collection<String>>> dumpMap = new HashMap<String, Map<String, Collection<String>>>();
        Map<String, Multimap<String, String>> storeMap = reflections.getStore().getStoreMap();
        for(String key : storeMap.keySet()) {
            dumpMap.put(key, storeMap.get(key).asMap());
//            sb.append(key+":\n");
//            Multimap<String, String> multiMap = storeMap.get(key);
//            sb.append(yamlIndented.dumpAsMap(multiMap.asMap()));
        }
//        String ret = sb.toString();
        String ret = yaml.dump(dumpMap);
        System.err.println("ret: "+ret);
        return ret;
    }
}
