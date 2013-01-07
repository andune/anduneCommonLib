/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (c) 2013 Andune (andune.alleria@gmail.com)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */
/**
 * 
 */
package com.andune.minecraft.commonlib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.slf4j.LoggerFactory;

/**
 * @author morganm
 *
 */
public class JarUtils {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(JarUtils.class);
    
	private final File dataFolder;
	private final File jarFile;
	
	public JarUtils(File dataFolder, File jarFile) {
		this.dataFolder = dataFolder;
		this.jarFile = jarFile;
	}
	
	/** Code adapted from Puckerpluck's MultiInv plugin.
	 * 
	 * @param string
	 * @return
	 */
    public void copyConfigFromJar(String fileName, File outfile) throws FileNotFoundException, IOException {
        File file = new File(dataFolder, fileName);
        
        if (!outfile.canRead()) {
//            try {
            	JarFile jar = new JarFile(jarFile);
            	
                file.getParentFile().mkdirs();
                JarEntry entry = jar.getJarEntry(fileName);
                if( entry == null )
                    throw new FileNotFoundException("Couldn't locate file "+fileName+" in jar file "+jar.getName());
                
                InputStream is = jar.getInputStream(entry);
                FileOutputStream os = new FileOutputStream(outfile);
                byte[] buf = new byte[(int) entry.getSize()];
                is.read(buf, 0, (int) entry.getSize());
                os.write(buf);
                os.close();
//            } catch (Exception e) {
//                log.warning("Could not copy config file "+fileName+" to default location");
//            }
        }
    }
    
    public int getBuildNumber() {
    	int buildNum = -1;
    	
        try {
        	JarFile jar = new JarFile(jarFile);
        	
            JarEntry entry = jar.getJarEntry("build.number");
            InputStream is = jar.getInputStream(entry);
        	Properties props = new Properties();
        	props.load(is);
        	is.close();
        	Object o = props.get("build.number");
        	if( o instanceof Integer )
        		buildNum = ((Integer) o).intValue();
        	else if( o instanceof String )
        		buildNum = Integer.parseInt((String) o);
        } catch (Exception e) {
            log.warn("Could not load build number from JAR");
        }
        
        return buildNum;
    }
    
    /** Given a packageName, return all classes that are in this jar file that are part
     * of that package or sub packages.
     * 
     * @param packageName
     * @return
     */
    public Class<?>[] getClasses(final String packageName) {
		ArrayList<Class<?>> classList = new ArrayList<Class<?>>();
		
    	try {
    		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    		assert classLoader != null;
    		String path = packageName.replace('.', '/');
    		JarFile jar = new JarFile(jarFile);
    		Enumeration<JarEntry> entries = jar.entries();
    		for(; entries.hasMoreElements();) {
    			final JarEntry entry = entries.nextElement();
    			final String entryName = entry.getName();
    			
//    			Debug.getInstance().devDebug("entry name=",entryName,", path=",path);
    			if( entryName.endsWith(".class") && entryName.startsWith(path) ) {
    				String className = entryName.replace("/", ".");
    				className = className.substring(0, className.length()-6);
//        			Debug.getInstance().devDebug("className=",className);
        			
    				try {
    					Class<?> clazz = Class.forName(className);
        				classList.add(clazz);
//        				Debug.getInstance().devDebug("added class: ",clazz);
    				}
    				catch(ClassNotFoundException e) {
    		    		e.printStackTrace();
    				}
    			}
    		}
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
		return classList.toArray(new Class<?>[] {});
    }
}
