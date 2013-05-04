package com.andune.minecraft.commonlib.server.api.impl;
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


/**
 * @author andune
 *
 */
public class TeleportOptionsImpl implements com.andune.minecraft.commonlib.server.api.TeleportOptions {
    private int minY = 1;
    private int maxY = 255;
    private int maxRange = 10;
    
    private boolean isNoTeleportOverWater = false;
    private boolean isNoTeleportOverIce = false;
    private boolean isNoTeleportOverLeaves = false;
    private boolean isNoTeleportOverLilyPad = false;
    
    @Override
    public int getMinY() {
        return minY;
    }

    @Override
    public void setMinY(int minY) {
        if( minY < 0 )
            minY = 0;
        this.minY = minY;
    }

    @Override
    public int getMaxY() {
        return maxY;
    }

    @Override
    public void setMaxY(int maxY) {
        if( maxY > 255 )
            maxY = 255;
        this.maxY = maxY;
    }

    @Override
    public int getMaxRange() {
        return maxRange;
    }

    @Override
    public void setMaxRange(int range) {
        this.maxRange = range;
    }

    @Override
    public boolean isNoTeleportOverWater() {
        return isNoTeleportOverWater;
    }

    @Override
    public void setNoTeleportOverWater(boolean flag) {
        this.isNoTeleportOverWater = flag;
    }

    @Override
    public boolean isNoTeleportOverIce() {
        return isNoTeleportOverIce;
    }

    @Override
    public void setNoTeleportOverIce(boolean flag) {
        this.isNoTeleportOverIce = flag;
    }

    @Override
    public boolean isNoTeleportOverLeaves() {
        return isNoTeleportOverLeaves;
    }

    @Override
    public void setNoTeleportOverLeaves(boolean flag) {
        this.isNoTeleportOverLeaves = flag;
    }

    @Override
    public boolean isNoTeleportOverLilyPad() {
        return isNoTeleportOverLilyPad;
    }

    @Override
    public void setNoTeleportOverLilyPad(boolean flag) {
        this.isNoTeleportOverLilyPad = flag;
    }
}
