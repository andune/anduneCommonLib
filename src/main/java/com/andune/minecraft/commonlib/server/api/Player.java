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


/**
 * @author andune
 *
 */
public interface Player extends CommandSender, OfflinePlayer {
    /**
     * Determine if this player is a newly joined player (just logged in for the first time ever).
     * 
     * @return true if the player is new
     */
    public boolean isNewPlayer();
    
    /**
     *  Return the name of this player. Note this is the actual, proper-case name the the player
     *  logs into Minecraft with, not their display name which can be changed by plugins later.
     *  
     * @return the players name
     */
    public String getName();
    
    /**
     * Return the current Location of this player object
     * 
     * @return the current location
     */
    public Location getLocation();
    
    /**
     * Gets the current world this player resides in
     *
     * @return World
     */
    public World getWorld();
    
    /**
     * Determine if the player has the specified permission.
     * 
     * @param permission the permission to check
     * 
     * @return true if the player has the permission
     */
    public boolean hasPermission(String permission);
    
    /**
     * Gets the Location where the player will spawn at their bed, null if they have not slept
     * in one or their current bed spawn is invalid.
     *
     * @return Bed Spawn Location if bed exists, otherwise null.
     */
    public Location getBedSpawnLocation();
    
    /**
     * Sets the Location where the player will spawn at their bed.
     *
     * @param location where to set the respawn location
     */
    public void setBedSpawnLocation(Location location);
    
    /**
     * Send a player to a location.
     * 
     * @param location
     */
    public void teleport(Location location);

    /**
     * Returns if the player is in sneak mode
     *
     * @return true if player is in sneak mode
     */
    public boolean isSneaking();
}
