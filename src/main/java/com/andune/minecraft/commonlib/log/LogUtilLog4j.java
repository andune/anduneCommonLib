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
package com.andune.minecraft.commonlib.log;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

/**
 * @author andune
 */
public class LogUtilLog4j implements LogUtil {
    private String configLogName;
    private Level previousLevel;

    @Override
    public void enableDebug(String baseLogName, String debugFile) {
        // do nothing if debugging is already enabled
        if (configLogName != null)
            return;

        this.configLogName = baseLogName;
        previousLevel = setLogLevel(configLogName, Level.DEBUG);
    }

    @Override
    public void disableDebug() {
        if (configLogName != null) {
            setLogLevel(configLogName, previousLevel);
            configLogName = null;
            previousLevel = null;
        }
    }

    /**
     * Set the Log4j logLevel and return the value of the level before we
     * changed it.
     *
     * @param logName
     * @param level
     * @return
     */
    private Level setLogLevel(String logName, Level level) {
        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration config = ctx.getConfiguration();
        LoggerConfig loggerConfig = config.getLoggerConfig(logName);
        Level previousLevel = loggerConfig.getLevel();
        loggerConfig.setLevel(level);
        ctx.updateLoggers();

        return previousLevel;
    }
}
