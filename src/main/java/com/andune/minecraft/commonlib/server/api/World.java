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

import java.util.Collection;


/**
 * @author andune
 *
 */
public interface World {
    /**
     *  Get the name of this world.
     *  
     * @return the name of the world
     */
    public String getName();

    /**
     * Sets the spawn location of the world
     *
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     * @return True if it was successfully set.
     */
    public boolean setSpawnLocation(int x, int y, int z);

    /**
     * Gets the default spawn {@link Location} of this world
     *
     * @return The spawn location of this world
     */
    public Location getSpawnLocation();
    
    /**
     * Gets the maximum height of this world.
     * <p />
     * If the max height is 100, there are only blocks from y=0 to y=99.
     *
     * @return Maximum height of the world
     */
    public int getMaxHeight();
    
    /**
     * Get any child worlds. For example, for a world named "world", this would
     * return the worlds "world_nether" and "world_the_end".
     * 
     * @return any child worlds. The result is guaranteed not to be null,
     *         though it may be empty.
     */
    public Collection<World> getChildWorlds();
    
    /**
     * Get the parent world, if any. For example, for a world named
     * "world_nether", this would return the world "world".
     * 
     * @return the parent world, or possibly null
     */
    public World getParentWorld();
}
