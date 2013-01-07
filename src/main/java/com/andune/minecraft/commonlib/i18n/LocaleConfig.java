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
package com.andune.minecraft.commonlib.i18n;

import java.io.File;

/**
 * @author morganm
 *
 */
public final class LocaleConfig {
	private final String locale;
	private final File dataFolder;
	private final File jarFile;
	private final String pluginBaseName;
	private final Colors colors;
	
	/**
	 * 
	 * @param locale the locale, such as "en" or "en_us"
	 * @param plugin the Bukkit JavaPlugin object
	 * @param pluginBaseName plugin base name, such as "hsp" or "lwc"
	 * @param jarFile the jar file for this plugin
	 * @param logger the plugin's java.util.logging.Logger log. can be null 
	 * @param colors color object for replacing colors 
	 */
	public LocaleConfig(final String locale, final File dataFolder,
			final String pluginBaseName, final File jarFile,
			final Colors colors) {
		this.locale = locale;
		this.dataFolder = dataFolder;
		this.pluginBaseName = pluginBaseName;
		this.jarFile = jarFile;
		if( colors != null )
			this.colors = colors;
		else
			this.colors = new Colors();
	}

	public File getJarFile() {
		return jarFile;
	}
	
	public File getDataFolder() {
		return dataFolder;
	}

	public String getPluginBaseName() {
		return pluginBaseName;
	}

	public String getLocale() {
		return locale;
	}
	
	public Colors getColors() {
		return colors;
	}
}
