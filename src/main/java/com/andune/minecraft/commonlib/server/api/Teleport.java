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


/** Interface for handling safe teleports.
 * 
 * @author andune
 *
 */
public interface Teleport {
    
    /**
     *  Given a location, return the nearest safe location that a player could teleport
     *  to.
     *  
     * @param location the starting location
     * 
     * @return the safe location
     */
    public Location safeLocation(Location location);
    
    /**
     *  Given a location, return the nearest safe location that a player could teleport
     *  to.
     *  
     * @param location the starting location
     * @param options options that modify the operation of the safe search algorithm
     * 
     * @return the safe location
     */
    public Location safeLocation(Location location, TeleportOptions options);
    
    /**
     *  Teleport a player, using the safe teleport algorithm to find a safe location
     *  based on the given location
     *  
     * @param player the player to teleport
     * @param location the starting location
     */
    public void safeTeleport(Player player, Location location);

    /**
     * Teleport a player to a location, with optional TeleportOptions. Uses
     * safeTeleport algorithm if safeTeleport is enabled.
     * 
     * @param p the player to teleport
     * @param l the location to teleport to
     * @param options optional TeleportOptions (can be null)
     */
    public void teleport(Player p, Location l, TeleportOptions options);


    /** Given a min and max (that define a square cube "region"), randomly pick
     * a location in between them, and then find a "safe spawn" point based on
     * that location (ie. that won't suffocate or be right above lava, etc).
     * 
     * @param min
     * @param max
     * @return the random safe Location, or null if one couldn't be located
     */
    public Location findRandomSafeLocation(Location min, Location max, TeleportOptions options);
}
