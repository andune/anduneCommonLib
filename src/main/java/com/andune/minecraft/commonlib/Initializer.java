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

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.reflections.Reflections;

import com.google.inject.Injector;

/** This class is used to initialize all classes within HSP that
 * implement the Initializable interface, in order of priority.
 * 
 * @author andune
 *
 */
@Singleton
public class Initializer {
    protected static final Logger log = LoggerFactory.getLogger(Initializer.class);

    private final Reflections reflections;
    private final Injector injector;
    
    @Inject
    public Initializer(Reflections reflections, Injector injector) {
        this.reflections = reflections;
        this.injector = injector;
        log.debug("Initializer constructor. injector = {}", injector.hashCode());
    }

    /**
     * Initialize all objects in the HSP classpath that implement the
     * Initializable interface.
     * 
     * @throws Exception
     */
    public void initAll() throws Exception {
        long startupBegin = System.currentTimeMillis();
        log.debug("Initializer initAll. injector = {}", injector.hashCode());

        for(Initializable init : getSortedInitObjects()) {
            log.debug("[Startup Timer] starting {} (t+{})", init, System.currentTimeMillis()-startupBegin);
            long startupTimer = System.currentTimeMillis();
            
            init.init();
            
            log.debug("[Startup Timer] {} finished in {}ms", init, System.currentTimeMillis()-startupTimer);
        }
    }
    
    public void shutdownAll()  {
        Collection<Initializable> collection = getSortedInitObjects();
        Initializable[] objects = collection.toArray(new Initializable[] {});

        // shut them down in reverse order of startup
        for(int i = objects.length-1; i >= 0 ; i--) {
            try {
                objects[i].shutdown();
            }
            catch(Exception e) {
                log.error("Caught exception in shutdownAll()", e);
            }
        }
    }

    /**
     * Return all Initializable objects in their proper loading order.
     * @return
     */
    protected Collection<Initializable> getSortedInitObjects() {
        TreeMap<Integer, List<Initializable>> sortedMap = new TreeMap<Integer, List<Initializable>>();
        
        // sort into a TreeMap which will maintain order. Items of same priority
        // are added to a List keyed by that priority
        for(Class<? extends Initializable> initClass : getInitClasses()) {
            Initializable init = injector.getInstance(initClass);
            log.debug("Initializer: injector returned instance for class {} [{}]", initClass, init);
            int priority = init.getInitPriority();
            if( priority < 0 )
                priority = 0;
            List<Initializable> list = sortedMap.get(priority);
            if( list == null ) {
                list = new ArrayList<Initializable>();
                sortedMap.put(priority, list);
            }
            list.add(init);
        }
        
        // Now iterate through the map in order of priority and add them
        // all to a single flat result array that will be all Initializable
        // objects sorted in order of priority
        List<Initializable> result = new ArrayList<Initializable>(10);
        for(List<Initializable> list : sortedMap.values()) {
            result.addAll(list);
        }

        return result;
    }
    
    /**
     * Return all Initializable classes, minus any abstract classes.
     * 
     * @return
     */
    private Set<Class<? extends Initializable>> getInitClasses() {
        Set<Class<? extends Initializable>> initClasses = reflections.getSubTypesOf(Initializable.class);
        for(Iterator<Class<? extends Initializable>> i = initClasses.iterator(); i.hasNext();) {
            Class<? extends Initializable> initClass = i.next();
            // skip any abstract classes
            if( Modifier.isAbstract(initClass.getModifiers()) )
                i.remove();
        }
        return initClasses;
    }
}
