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
 * @author andune
 *
 */
public class LoggerFactory {
    private static Class<?> loggerImpl = LoggerJUL.class;  // default to JUL
    private static String prefix = null;
    
    public static void setLoggerImpl(Class<?> clazz) {
        loggerImpl = clazz;
    }

    /**
     * Since the intent of this logger is to be used as a replacement for
     * Minecraft server logging (such as Bukkit), we allow a single call
     * to set the prefix for all future loggers. This keeps the .getLogger()
     * call simple but still allows us to put something like a plugin
     * prefix ahead of all log messages.
     * 
     * @param prefix
     * @return
     */
    public static void setLoggerPrefix(String prefix) {
    	LoggerFactory.prefix = prefix;
    }

    public static Logger getLogger(String name) {
        if( LoggerSlf4jImpl.class.equals(loggerImpl) ) {
            return new LoggerSlf4jImpl(name, prefix);
        }
        // JUL is default, we use it if nothing else we know is specified
        else {
            return new LoggerJUL(name, prefix);
        }
    }
    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }
}
