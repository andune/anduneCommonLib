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

/**
 * Interface for classes to implement if they need initialization
 * on plugin startup.
 * 
 * Any class under com.andune.minecraft.hsp implementing this
 * interface will be automatically picked up and initialized after
 * IoC injection is finished. 
 * 
 * @author andune
 *
 */
public interface Initializable {
    /**
     * This method is invoked when it is time to initialize and
     * should do whatever this object needs done to become ready
     * for use.
     * 
     * @throws Exception any thrown Exception will stop the
     * entire initialization process.
     */
    public void init() throws Exception;

    /**
     * That which can be started up can also be shutdown. This
     * is called when the plugin is disabled so the object can
     * do any necessary cleanup.
     * 
     * @throws Exception any thrown Exception will be printed
     * to the console and then ignored
     */
    public void shutdown() throws Exception;

    /**
     * Initialization priority, this should be a number where
     * 0 is the highest priority. Negative numbers are equivalent
     * to 0. Objects are loaded in order of priority.
     * 
     * Recommended values:
     * 0-4 reserved for Config objects
     * 5-9 reserved for ordered early initialization objects
     * 10+ general use priority
     * 
     * @return
     */
    public int getInitPriority();
}
