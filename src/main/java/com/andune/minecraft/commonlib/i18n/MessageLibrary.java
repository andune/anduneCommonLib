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
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.jar.JarFile;

import com.andune.minecraft.commonlib.Logger;
import com.andune.minecraft.commonlib.LoggerFactory;

/** Message Library for localization. Responsible for loading the resource bundle.
 * 
 * @author morganm
 *
 */
public class MessageLibrary {
    private static final Logger log = LoggerFactory.getLogger(MessageLibrary.class);
    
	private final LocaleConfig config;
	private boolean loaded = false;
	private PluginResourceBundle locale;
	
	/** Default visibility is package-only. Correct way to instantiate this class is
	 * via the MessageFactory static factory methods.
	 * 
	 * @param local
	 */
	MessageLibrary(final LocaleConfig config) {
		this.config = config;
	}
	
	/** Called to load any resources associated with this library. package visibility.
	 */
	public void load() throws IOException {
		if( loaded )
			return;
		
		// located in plugins/LWC/locale/, values in that overrides the ones in the default :-)
		ResourceBundle optionalBundle = null;

		try {
			final JarFile file = new JarFile(config.getJarFile());

			// Attempt to load the default locale (en)
			final ResourceBundle defaultBundle = new PropertyResourceBundle(new InputStreamReader(
					file.getInputStream(file.getJarEntry("lang/"+config.getPluginBaseName()+"_en.properties")), "UTF-8"));
			locale = new PluginResourceBundle(defaultBundle);

			// attempt to load admin override resource bundle, ie: "lwc.properties"
			try {
				optionalBundle = ResourceBundle.getBundle(config.getPluginBaseName(),
						new Locale(config.getLocale()), new LocaleClassLoader(config), new UTF8Control());
			} catch (MissingResourceException e) {
			}

			if (optionalBundle != null) {
				locale.addExtensionBundle(optionalBundle);
			}

			int overrides = optionalBundle != null ? optionalBundle.keySet().size() : 0;
			log("Loaded " + locale.keySet().size() + " locale strings (" + overrides + " overrides)");

			// and now check if a bundled locale the same as the server's locale exists. So if "fr"
			// is the defined locale, the being looked for in the JAR is: lang/lwc_fr.properties
			try {
				optionalBundle = new PropertyResourceBundle(new InputStreamReader(file.getInputStream(
							file.getJarEntry("lang/"+config.getPluginBaseName()+ "_" + config.getLocale() + ".properties")), "UTF-8"));
			} catch (MissingResourceException e) {
			} catch (NullPointerException e) {
				// file wasn't found :p - that's ok
			}

			// ensure both bundles aren't the same
			if (defaultBundle == optionalBundle) {
				optionalBundle = null;
			}

			if (optionalBundle != null) {
				locale.addExtensionBundle(optionalBundle);
			}
		} catch (MissingResourceException e) {
			log("We are missing the default locale in "+config.getJarFile().toString()+".. What happened to it? :-(");
			throw e;
		} catch (IOException e) {
			log("Uh-oh: " + e.getMessage());
			return;
		}

		loaded = true;
	}
	
	public PluginResourceBundle getResourceBundle() { return locale; }
	
	private void log(final String msg) {
		log.info(msg);
	}
}
