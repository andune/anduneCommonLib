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
import java.util.HashMap;
import java.util.Map;

/** Implementation of locale strings that includes Bukkit color and string
 * parameter replacement.
 * 
 * Code heavily borrowed from Hidendra's LWC.
 * 
 * @author morganm
 *
 */
public class LocaleStringReplacerImpl implements Locale {
	private static final Map<String, String> predefinedReplacements = new HashMap<String,String>();
	static {
		// newline didn't work like I'd hoped.  So no predefinedReplacements for now ..
//		predefinedReplacements.put("%newline%", "\n");
	}
	
	private MessageLibrary msgLib;
	private String localeString;
	private Colors colors;
	
	public LocaleStringReplacerImpl() {
	}
	
    @Override
    public void load(LocaleConfig config) throws IOException {
        this.localeString = config.getLocale();
        this.colors = config.getColors();
        this.msgLib = new MessageLibrary(config);
        this.msgLib.load();
    }

	@Override
	public String getLocale() {
		return localeString;
	}
	
	@Override
	public String getMessage(String key, final Object... args) {
        if (!msgLib.getResourceBundle().containsKey(key)) {
            return "UNKNOWN_LOCALE_" + key;
        }

        Map<String, Object> bind = parseBinds(args);
        String value = msgLib.getResourceBundle().getString(key);
        
        if( value == null )
        	throw new NullPointerException("localized string for key "+key+" is null");

        value = colors.applyColors(value);
        
        if( value.indexOf('%') != -1 ) {
	        // apply any predefined replacements
	        for (Map.Entry<String, String> entry : predefinedReplacements.entrySet()) {
	            if (value.contains(entry.getKey())) {
	                value = value.replaceAll(entry.getKey(), entry.getValue());
	            }
	        }

	        // apply binds
	        for (String bindKey : bind.keySet()) {
	        	if( bindKey == null )
	        		throw new NullPointerException("bindKey for localized string "+key+" is null, localized string = "+value);
	        	
	            Object object = bind.get(bindKey);
	            String bindVal = (object != null ? object.toString() : "null");
	
	            value = value.replaceAll("%" + bindKey + "%", bindVal);
	        }
        }

        return value;
	}

    /**
     * Convert an even-lengthed argument array to a map containing String keys
     * i.e parseBinds("Test", null, "Test2", obj) = Map().put("test", null).put("test2", obj)
     * 
     * (code borrowed from LWC)
     *
     * @author Hidendra
     * @param args
     * @return
     */
    private Map<String, Object> parseBinds(final Object... args) {
        Map<String, Object> bind = new HashMap<String, Object>(args.length/2);

        if (args == null || args.length < 2) {
            return bind;
        }

        int size = args.length;
        for (int index = 0; index < args.length; index += 2) {
            if ((index + 2) > size) {
                break;
            }

            String key = args[index].toString();
            Object object = args[index + 1];

            bind.put(key, object);
        }

        return bind;
    }
}
