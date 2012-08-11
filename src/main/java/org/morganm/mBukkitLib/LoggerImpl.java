/*******************************************************************************
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
 * Copyright (c) 2012 Mark Morgan.
 * All rights reserved.
 * 
 * Contributors:
 *     Mark Morgan - initial API and implementation
 ******************************************************************************/
/**
 * 
 */
package org.morganm.mBukkitLib;

import java.util.logging.Level;

import javax.inject.Inject;

import org.bukkit.plugin.Plugin;

/**
 * @author morganm
 *
 */
public class LoggerImpl implements Logger {
	// class version: 3

	private final java.util.logging.Logger log = java.util.logging.Logger.getLogger(LoggerImpl.class.toString());
	private final Debug debug;
	private String logPrefix;
	
	@Inject
	public LoggerImpl(Plugin plugin, Debug debug) {
		String prefix = plugin.getDescription().getPrefix();
		if( prefix == null )
			prefix = "["+plugin.getDescription().getName()+"] ";
		setLogPrefix(prefix);

		this.debug = debug;
	}
	
	public void setLogPrefix(String logPrefix) {
		if( !logPrefix.endsWith(" ") )
			logPrefix = logPrefix + " ";
		this.logPrefix = logPrefix;
	}

	private String concatStrings(StringBuilder sb, Object...msgs) {
		for(Object o : msgs) {
			sb.append(o);
		}
		return sb.toString();
	}
	
	@Override
	public void info(Object... msg) {
		if( log.isLoggable(Level.INFO) ) {
			log.info(concatStrings(new StringBuilder(logPrefix), msg));
		}
	}

	@Override
	public void warn(Object... msg) {
		if( log.isLoggable(Level.WARNING) ) {
			log.warning(concatStrings(new StringBuilder(logPrefix), msg));
		}
	}
	@Override
	public void warn(Throwable t, Object... msg) {
		if( log.isLoggable(Level.WARNING) ) {
			log.log(Level.WARNING, concatStrings(new StringBuilder(logPrefix), msg), t);
		}
	}
	

	@Override
	public void severe(Object... msg) {
		if( log.isLoggable(Level.SEVERE) ) {
			log.severe(concatStrings(new StringBuilder(logPrefix), msg));
		}
	}
	@Override
	public void severe(Throwable t, Object... msg) {
		if( log.isLoggable(Level.SEVERE) ) {
			log.log(Level.SEVERE, concatStrings(new StringBuilder(logPrefix), msg), t);
		}
	}

	@Override
	public void debug(Object... msg) {
		debug.debug(msg);
	}

	@Override
	public void devDebug(Object... msg) {
		debug.devDebug(msg);
	}

}
