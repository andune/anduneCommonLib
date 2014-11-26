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
package com.andune.minecraft.commonlib.server.api;

import java.util.List;
import java.util.Set;

/** Modeled after the Bukkit object of the same name.
 * 
 * @author andune
 *
 */
public interface ConfigurationSection {
    /**
     * Gets a set containing all keys in this section.
     * 
     * @return Set of keys contained within this ConfigurationSection.
     */
    public Set<String> getKeys();

    /**
     * Gets a set containing all keys in this section.
     *
     * If deep is set to true, then this will contain all the keys within any
     * child {@link ConfigurationSection}s (and their children, etc). These
     * will be in a valid path notation for you to use.
     * <p>
     * If deep is set to false, then this will contain only the keys of any
     * direct children, and not their own children.
     *
     * @return Set of keys contained within this ConfigurationSection.
     */
    public Set<String> getKeys(boolean deep);

    /**
     * Gets a set containing all keys in the specified path.
     * 
     * @return Set of keys contained within the specified path
     */
    public Set<String> getKeys(String path);

    /**
     * Gets the requested ConfigurationSection by path.
     *
     * @param path Path of the ConfigurationSection to get.
     * @return Requested ConfigurationSection.
     */
    public ConfigurationSection getConfigurationSection(String path);

    public boolean contains(String path);
    public Object get(String path);
    public boolean getBoolean(String path);
    public int getInt(String path);
    public Integer getInteger(String path);
    public double getDouble(String path);
    public String getString(String path);
    public List<String> getStringList(String path);
}
