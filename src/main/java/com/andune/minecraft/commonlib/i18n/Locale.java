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
package com.andune.minecraft.commonlib.i18n;

import java.io.IOException;


/**
 * @author morganm
 *
 */
public interface Locale {
    /**
     * Do any loading required to ready this object for use, based on the config
     * parameters passed in. By contract, this method must be invoked prior to
     * the first call to getMessage().
     */
    public void load(LocaleConfig config) throws IOException;

	/** Return a message from the Locale object, optionally doing string replacement
	 * on the given args (depending on the underlying implementation).
	 * 
	 * @param key the key value to retrieve from the resource bundle
	 * @param args key,value pairs of replacements: ie. "id",123,"playerName",player.getName()
	 * @return the localized string
	 */
	public String getMessage(String key, Object... args);
	
	/** Return the Locale string this object represents.
	 * 
	 * @return
	 */
	public String getLocale();
}
