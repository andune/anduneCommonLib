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
public interface OfflinePlayer {
    /**
     * Returns the name of this player
     *
     * @return Player name
     */
    public String getName();

    /**
     * Return the UUID of this player
     *
     * @return the players UUID
     */
    public java.util.UUID getUUID();

    /**
     * True if this player is online, false if offline.
     * 
     * @return
     */
    public boolean isOnline();

    /**
     * Checks if this player has played on this server before.
     *
     * @return True if the player has played before, otherwise false
     */
    public boolean hasPlayedBefore();
    
    /**
     * Gets the last date and time that this player was witnessed on this server.
     * <p>
     * If the player has never played before, this will return 0. Otherwise, it will be
     * the amount of milliseconds since midnight, January 1, 1970 UTC.
     *
     * @return Date of last log-in for this player, or 0
     */
    public long getLastPlayed();
}
