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
 * A list of effects that the server is able to send to players.
 * 
 * @author andune
 *
 */
public enum Effect {
    SMOKE("smoke"),
    POTION_BREAK("potionBreak"),
    ENDER_SIGNAL("enderSignal"),
    MOBSPAWNER_FLAMES("fire"),
    LIGHTNING("lightning");
    
    private String name;
    private Sound sound;
    private Effect(String name) {
        this.name = name;
    }
    private Effect(String name, Sound sound) {
        this.name = name;
        this.sound = sound;
    }
    
    public String getName() {
        return name;
    }

    /**
     * An effect can optionally be associated with a sound that matches that
     * effect. If it is associated, this will return that sound, otherwise
     * null.
     * 
     * @return
     */
    public Sound getSound() {
        return sound;
    }
}
