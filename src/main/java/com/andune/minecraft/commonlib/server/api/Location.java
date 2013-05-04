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



/** API for handling Location objects.
 * 
 * @author andune
 *
 */
public interface Location {
    /**
     * Get the World for this location
     * 
     * @return the World represented by this location
     */
    public World getWorld();

    /**
     * Gets the block at the represented location
     *
     * @return Block at the represented location
     */
    public Block getBlock();

    /**
     * Set the x-coordinate of this location
     *
     * @param x x-coordinate
     */
    public void setX(double x);

    /**
     * Gets the x-coordinate of this location
     *
     * @return x-coordinate
     */
    public double getX();

    /**
     * Gets the floored value of the X component, indicating the block that
     * this location is contained with.
     *
     * @return block X
     */
    public int getBlockX();

    /**
     * Set the y-coordinate of this location
     *
     * @param y y-coordinate
     */
    public void setY(double y);

    /**
     * Gets the y-coordinate of this location
     *
     * @return y-coordinate
     */
    public double getY();

    /**
     * Gets the floored value of the Y component, indicating the block that
     * this location is contained with.
     *
     * @return block y
     */
    public int getBlockY();

    /**
     * Set the z-coordinate of this location
     *
     * @param z z-coordinate
     */
    public void setZ(double z);

    /**
     * Gets the z-coordinate of this location
     *
     * @return z-coordinate
     */
    public double getZ();

    /**
     * Gets the floored value of the Z component, indicating the block that
     * this location is contained with.
     *
     * @return block z
     */
    public int getBlockZ();

    /**
     * Sets the yaw of this location
     *
     * @param yaw New yaw
     */
    public void setYaw(float yaw);

    /**
     * Gets the yaw of this location
     *
     * @return Yaw
     */
    public float getYaw();

    /**
     * Sets the pitch of this location
     *
     * @param pitch New pitch
     */
    public void setPitch(float pitch);

    /**
     * Gets the pitch of this location
     *
     * @return Pitch
     */
    public float getPitch();

    /**
     * Get the distance between this location and another.
     *
     * @param o The other location
     * @return the distance
     * @throws IllegalArgumentException for differing worlds
     */
    public double distance(Location o);
    
    /**
     * Return an abbreviated location string, of the form: world,x,y,z
     * Note the x,y,z will be whole integer block coordinates.
     * 
     * Example return value:  world,366,72,-244
     * 
     * @return the location string
     */
    public String shortLocationString();
}
