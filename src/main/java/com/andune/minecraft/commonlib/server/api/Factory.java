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


/** Factory for creating various implementation-specific objects. These
 * objects will be created by the specific server implementation as well
 * as be fully injected by the IoC container.
 * 
 * @author andune
 *
 */
public interface Factory {
    /**
     * Factory method for creating a new Location object
     * 
     * @param worldName the name of the world the Location is on
     * @param x the x coordinates
     * @param y the y coordinates
     * @param z the z coordinates
     * @param yaw the yaw (360-degree horizontal view angle)
     * @param pitch the pitch (360-degree verticle view angle)
     * 
     * @return the new Location object
     */
    public Location newLocation(String worldName, double x, double y, double z, float yaw, float pitch);
    
    /**
     * Factory method for creating a new TeleportOptions object
     * 
     * @return the new TeleportOptions object
     */
    public TeleportOptions newTeleportOptions();
    
    /**
     * Factory method for creating a new YamlFile
     * 
     * @return the new YamlFile object
     */
    public YamlFile newYamlFile();
}
