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
package com.andune.minecraft.commonlib;

import org.apache.logging.log4j.LogManager;

/**
 * Performance Implementation note: All of the prefix null checks will be
 * optimized away by a good JIT compiler since the prefix variable is final.
 *
 * @author andune
 */
public class LoggerLog4j implements Logger {
    private final org.apache.logging.log4j.Logger log;
    private final String prefix;

    public LoggerLog4j(org.apache.logging.log4j.Logger log) {
        this.log = log;
        prefix = null;
    }

    public LoggerLog4j(String name, String prefix) {
        this.log = LogManager.getLogger(name);
        this.prefix = prefix;
    }

    @Override
    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    @Override
    public void info(String msg) {
        if (prefix != null)
            log.info(prefix + msg);
        else
            log.info(msg);
    }

    @Override
    public void info(String format, Object obj1) {
        if (prefix != null)
            log.info(prefix + format, obj1);
        else
            log.info(format, obj1);
    }

    @Override
    public void info(String format, Object obj1, Object obj2) {
        if (prefix != null)
            log.info(prefix + format, obj1, obj2);
        else
            log.info(format, obj1, obj2);
    }

    @Override
    public void info(String format, Object... args) {
        if (prefix != null)
            log.info(prefix + format, args);
        else
            log.info(format, args);
    }

    @Override
    public void warn(String msg) {
        if (prefix != null)
            log.warn(prefix + msg);
        else
            log.warn(msg);
    }

    @Override
    public void warn(String format, Object obj1) {
        if (prefix != null)
            log.warn(prefix + format, obj1);
        else
            log.warn(format, obj1);
    }

    @Override
    public void warn(String format, Object obj1, Object obj2) {
        if (prefix != null)
            log.warn(prefix + format, obj1, obj2);
        else
            log.warn(format, obj1, obj2);
    }

    @Override
    public void warn(String format, Object... args) {
        if (prefix != null)
            log.warn(prefix + format, args);
        else
            log.warn(format, args);
    }

    @Override
    public void warn(String msg, Throwable t) {
        if (prefix != null)
            log.warn(prefix + msg, t);
        else
            log.warn(msg, t);
    }

    @Override
    public void error(String msg) {
        if (prefix != null)
            log.error(prefix + msg);
        else
            log.error(msg);
    }

    @Override
    public void error(String format, Object obj1) {
        if (prefix != null)
            log.error(prefix + format, obj1);
        else
            log.error(format, obj1);
    }

    @Override
    public void error(String format, Object obj1, Object obj2) {
        if (prefix != null)
            log.error(prefix + format, obj1, obj2);
        else
            log.error(format, obj1, obj2);
    }

    @Override
    public void error(String format, Object... args) {
        if (prefix != null)
            log.error(prefix + format, args);
        else
            log.error(format, args);
    }

    @Override
    public void error(String msg, Throwable t) {
        if (prefix != null)
            log.error(prefix + msg, t);
        else
            log.error(msg, t);
    }

    @Override
    public void debug(String msg) {
        if (prefix != null)
            log.debug(prefix + msg);
        else
            log.debug(msg);
    }

    @Override
    public void debug(String format, Object obj1) {
        if (prefix != null)
            log.debug(prefix + format, obj1);
        else
            log.debug(format, obj1);
    }

    @Override
    public void debug(String format, Object obj1, Object obj2) {
        if (prefix != null)
            log.debug(prefix + format, obj1, obj2);
        else
            log.debug(format, obj1, obj2);

    }

    @Override
    public void debug(String format, Object... args) {
        if (prefix != null)
            log.debug(prefix + format, args);
        else
            log.debug(format, args);
    }
}
