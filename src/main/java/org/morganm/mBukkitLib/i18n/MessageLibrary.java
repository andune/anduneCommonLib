/**
 * 
 */
package org.morganm.mBukkitLib.i18n;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.jar.JarFile;

import org.slf4j.LoggerFactory;

/** Message Library for localization. Responsible for loading the resource bundle.
 * 
 * @author morganm
 *
 */
public class MessageLibrary {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(MessageLibrary.class);
    
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
