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
 * Modeled after slf4j methods, this is a simplified interface. This allows
 * us to map directly to slf4j those who want speed or want to use one of
 * slf4j's other logging backends, but while maintaining an extremely thin
 * footprint for plugins using this logging interface.
 * 
 * @author morganm
 */
public interface Logger {
    public abstract boolean isDebugEnabled();
    
    public abstract void info(String msg);
    public abstract void info(String format, Object obj1);
    public abstract void info(String format, Object obj1, Object obj2);
    public abstract void info(String format, Object...args);
    
    public abstract void warn(String msg);
    public abstract void warn(String format, Object obj1);
    public abstract void warn(String format, Object obj1, Object obj2);
    public abstract void warn(String format, Object...args);
    
    public abstract void warn(String msg, Throwable t);
	
    public abstract void error(String msg);
    public abstract void error(String format, Object obj1);
    public abstract void error(String format, Object obj1, Object obj2);
    public abstract void error(String format, Object...args);
    
    public abstract void error(String msg, Throwable t);
    
    public abstract void debug(String msg);
    public abstract void debug(String format, Object obj1);
    public abstract void debug(String format, Object obj1, Object obj2);
    public abstract void debug(String format, Object...args);
}
