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
package com.andune.minecraft.commonlib.server.api.event;

import com.andune.minecraft.commonlib.server.api.events.*;

/** API for HSP to implement in order to receive event callbacks from
 * the server implementation.
 *
 * @author andune
 *
 */
public interface EventListener {
    public void playerJoin(PlayerJoinEvent event);
    public void playerRespawn(PlayerRespawnEvent event);
    public void playerTeleport(PlayerTeleportEvent event);
    public void playerQuit(PlayerQuitEvent event);
    public void playerKick(PlayerKickEvent event);
    public void playerDamage(PlayerDamageEvent event);
    public void playerDeath(PlayerDeathEvent event);

    /**
     * Called when a player right-clicks a bed.
     * @param event
     */
    public void bedRightClick(PlayerBedRightClickEvent event);

    /**
     * Called when a player is about to sleep in a bed at night.
     * @param event
     */
    public void bedEvent(PlayerBedEnterEvent event);

    /**
     * A player Teleport event that is at an observe priority
     * (such as Bukkit MONITOR priority)
     *
     * @param event
     */
    public void observePlayerTeleport(PlayerTeleportEvent event);

    /**
     * A player Respawn event that is at an observe priority
     * (such as Bukkit MONITOR priority)
     *
     * @param event
     */
    public void observeRespawn(PlayerRespawnEvent event);

    /**
     * Called when a player is detected falling through the world. If the
     * event is cancelled, the player will not receive damage from the event.
     *
     * @param event
     */
    public void playerFallThroughWorld(PlayerFallThroughWorldEvent event);
}
