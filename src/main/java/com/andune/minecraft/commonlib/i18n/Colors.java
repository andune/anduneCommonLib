/*
 * Copyright 2011 Tyler Blair. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ''AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and contributors and should not be interpreted as representing official policies,
 * either expressed or implied, of anybody else.
 */

package com.andune.minecraft.commonlib.i18n;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/** Code borrowed from Hidendra's LWC.
 * 
 * @author morganm
 *
 */
public class Colors {
    // contains colors for locales
    private final Map<String, String> colorStrings = new HashMap<String, String>();
    private final Map<String, Pattern> regexPatterns = new HashMap<String, Pattern>();
    private String defaultColor;

    public Colors() {
    	String key = "%black%";
    	colorStrings.put(key, ChatColor.BLACK.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    	key = "%navy%";
    	colorStrings.put(key, ChatColor.BLUE.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    	key = "%green%";
    	colorStrings.put(key, ChatColor.DARK_GREEN.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    	key = "%blue%";
    	colorStrings.put(key, ChatColor.DARK_AQUA.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    	key = "%red%";
    	colorStrings.put(key, ChatColor.DARK_RED.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    	key = "%purple%";
    	colorStrings.put(key, ChatColor.DARK_PURPLE.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    	key = "%gold%";
    	colorStrings.put(key, ChatColor.GOLD.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    	key = "%lightgray%";
    	colorStrings.put(key, ChatColor.GRAY.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    	key = "%gray%";
    	colorStrings.put(key, ChatColor.DARK_GRAY.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    	key = "%darkpurple%";
    	colorStrings.put(key, ChatColor.BLUE.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    	key = "%lightgreen%";
    	colorStrings.put(key, ChatColor.GREEN.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    	key = "%lightblue%";
    	colorStrings.put(key, ChatColor.AQUA.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    	key = "%rose%";
    	colorStrings.put(key, ChatColor.RED.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    	key = "%lightpurple%";
    	colorStrings.put(key, ChatColor.LIGHT_PURPLE.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    	key = "%yellow%";
    	colorStrings.put(key, ChatColor.YELLOW.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    	key = "%white%";
    	colorStrings.put(key, ChatColor.WHITE.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    	
    	key = "%default_color%";
    	colorStrings.put(key, ChatColor.WHITE.toString());
    	regexPatterns.put(key, Pattern.compile(key));
    }
    
    /** Apply colors to a given string, returning the new string
     * with Bukkit colors in place of their Colors substitutes.
     * 
     * @param s
     */
    public String applyColors(String s) {
        // simple optimization: if no % symbol is present at all in the value
        // string, then we can skip color/arg replacement entirely. -morganm
        if( s.indexOf('%') != -1 )
        	return s;
        
        for (Entry<String, Pattern> e : regexPatterns.entrySet()) {
        	String colorKey = e.getKey();		// key we're replacing, ie. "%red%
        	Pattern pattern = e.getValue();		// precompiled pattern for replacement string
        	String colorValue = colorStrings.get(colorKey);	// value we're replacing it to
        	
        	s = pattern.matcher(s).replaceAll(colorValue);
        }
        return s;
    }
    
    /**
     * Given a color code such as "%white%" return the color code string, which
     * in this example would be "\u00A7F".
     * 
     * @param s the color key string, eg. "%white%"
     * @return the color coded string
     */
    public String getColorString(String s) {
        return colorStrings.get(s);
    }

    /** Set the default color. Argument must be of color pattern form, such
     * as "%red%" or "%yellow%", etc.
     * 
     * @param defaultColor
     */
    public void setDefaultColor(final String defaultColor) throws InvalidColorException {
        if( defaultColor == null )
            return;
        
    	String colorString = colorStrings.get(defaultColor.toString());
    	if( colorString != null ) {
    		this.defaultColor = defaultColor;
    		colorStrings.put("%default_color%", colorString);
    	}
    	else
    		throw new InvalidColorException("Invalid color: "+defaultColor);
    }
    public String getDefaultColor() { return defaultColor; }
}
