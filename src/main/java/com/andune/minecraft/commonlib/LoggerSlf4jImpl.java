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

import org.slf4j.LoggerFactory;


/**
 * @author andune
 *
 */
public class LoggerSlf4jImpl implements Logger {
    private final org.slf4j.Logger log;

    protected LoggerSlf4jImpl(org.slf4j.Logger log) {
        this.log = log;
    }
    protected LoggerSlf4jImpl(String name) {
        this.log = LoggerFactory.getLogger(name);
    }
    
    @Override
    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    @Override
    public void info(String msg) {
        log.info(msg);
    }

    @Override
    public void info(String format, Object obj1) {
        log.info(format, obj1);
    }

    @Override
    public void info(String format, Object obj1, Object obj2) {
        log.info(format, obj1, obj2);
    }

    @Override
    public void info(String format, Object...args) {
        log.info(format, args);
    }

    @Override
    public void warn(String msg) {
        log.warn(msg);
    }

    @Override
    public void warn(String format, Object obj1) {
        log.warn(format, obj1);
    }

    @Override
    public void warn(String format, Object obj1, Object obj2) {
        log.warn(format, obj1, obj2);
    }

    @Override
    public void warn(String format, Object...args) {
        log.warn(format, args);
    }

    @Override
    public void warn(String msg, Throwable t) {
        log.warn(msg, t);
    }

    @Override
    public void error(String msg) {
        log.error(msg);
    }

    @Override
    public void error(String format, Object obj1) {
        log.error(format, obj1);
    }

    @Override
    public void error(String format, Object obj1, Object obj2) {
        log.error(format, obj1, obj2);
    }

    @Override
    public void error(String format, Object...args) {
        log.error(format, args);
    }

    @Override
    public void error(String msg, Throwable t) {
        log.error(msg, t);
    }

    @Override
    public void debug(String msg) {
        log.debug(msg);
    }

    @Override
    public void debug(String format, Object obj1) {
        log.debug(format, obj1);
    }

    @Override
    public void debug(String format, Object obj1, Object obj2) {
        log.debug(format, obj1, obj2);
    }

    @Override
    public void debug(String format, Object...args) {
        log.debug(format, args);
    }

}
