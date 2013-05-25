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

/**
 * @author andune
 *
 */
public interface Server {
    /**
     * Find the given world
     *   
     * @param worldName the world to find
     * @return the World object or null if no World was found
     */
    public World getWorld(String worldName);
    
    /**
     * Gets a list of all worlds on this server
     *
     * @return A list of worlds
     */
    public List<World> getWorlds();

    /**
     * Schedule a teleport to happen at the next possible time on the
     * main thread. This can be used to safely teleport a player on an async
     * thread or to safely teleport them in events where it is otherwise not
     * safe to teleport them directly (such as onJoinEvent).
     * 
     * @param player the player to teleport
     * @param location the Location to teleport the player to
     */
    public void delayedTeleport(Player player, Location location);
    
    /**
     * Given a localized key value and optional arguments, return a localized
     * message.
     * 
     * At some point this method should be phased out in favor of a better i18n
     * system like Google gettext-commons, where the key values are unecessary
     * and the text can be embedded and translated directly in the original code.
     *
     * @param key the key value, @see {@link com.andune.minecraft.hsp.HSPMessages}
     * @param args varargs key-value pairs, ie. {"player", "fluffybunny", "amount", 42}
     * @return
     */
    public String getLocalizedMessage(String key, final Object...args);
    
    /**
     * Given a localized key value and optional arguments, send a localized
     * message to a given player or console.
     *
     * @param sender the player to send the message to
     * @param key the key value, @see {@link com.andune.minecraft.hsp.HSPMessages}
     * @param args varargs key-value pairs, ie. {"player", "fluffybunny", "amount", 42}
     * @return
     */
    public void sendLocalizedMessage(CommandSender sender, String key, final Object...args);

    /**
     * Given a player name, return the corresponding Player object (if any).
     * 
     * @param playerName the playerName to look for
     * 
     * @return the player object
     */
    public Player getPlayer(String playerName);

    /**
     * Gets the player by the given name, regardless if they are offline or online.
     * <p>
     * This will return an object even if the player does not exist. To this method, all players will exist.
     *
     * @param name Name of the player to retrieve
     * @return OfflinePlayer object
     */
    public OfflinePlayer getOfflinePlayer(String name);
    
    /** Given a string, look for the best possible player match. Returned
     * object could be of subclass Player (if the player is online).
     * 
     * @param playerName the playerName to look for
     * @return the found OfflinePlayer object (possibly class Player) or null
     */
    public OfflinePlayer getBestMatchPlayer(String playerName);

    /**
     * Gets every player that has ever played on this server.
     *
     * @return Array containing all players
     */
    public OfflinePlayer[] getOfflinePlayers();

    /**
     * Gets a list of all currently logged in players
     *
     * @return An array of Players that are currently online
     */
    public Player[] getOnlinePlayers();

    /**
     * Translates color codes in a string using the '&' character code. For example,
     * "&F" represents WHITE on Bukkit. All instances of color codes found in the
     * string will be translated.
     * 
     * @param stringToTranslate String to be color translated. 
     * @return Text containing the ChatColor.COLOR_CODE color code characters.
     */
    public String translateColorCodes(String stringToTranslate);
}
