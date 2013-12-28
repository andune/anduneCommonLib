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
package com.andune.minecraft.commonlib;

/**
 * Exception thrown to indicate a given feature has not yet been implemented.
 * @author andune
 *
 */
public class FeatureNotImplemented extends RuntimeException {
    private static final long serialVersionUID = 412533526968395832L;

    /**
     * 
     */
    public FeatureNotImplemented() {
    }

    /**
     * @param message
     */
    public FeatureNotImplemented(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public FeatureNotImplemented(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public FeatureNotImplemented(String message, Throwable cause) {
        super(message, cause);
    }

}
