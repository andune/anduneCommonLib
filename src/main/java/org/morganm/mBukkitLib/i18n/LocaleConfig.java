/**
 * 
 */
package org.morganm.mBukkitLib.i18n;

import java.io.File;

/**
 * @author morganm
 *
 */
public final class LocaleConfig {
	private final String locale;
	private final File dataFolder;
	private final File jarFile;
	private final String pluginBaseName;
	private final Colors colors;
	
	/**
	 * 
	 * @param locale the locale, such as "en" or "en_us"
	 * @param plugin the Bukkit JavaPlugin object
	 * @param pluginBaseName plugin base name, such as "hsp" or "lwc"
	 * @param jarFile the jar file for this plugin
	 * @param logger the plugin's java.util.logging.Logger log. can be null 
	 * @param colors color object for replacing colors 
	 */
	public LocaleConfig(final String locale, final File dataFolder,
			final String pluginBaseName, final File jarFile,
			final Colors colors) {
		this.locale = locale;
		this.dataFolder = dataFolder;
		this.pluginBaseName = pluginBaseName;
		this.jarFile = jarFile;
		if( colors != null )
			this.colors = colors;
		else
			this.colors = new Colors();
	}

	public File getJarFile() {
		return jarFile;
	}
	
	public File getDataFolder() {
		return dataFolder;
	}

	public String getPluginBaseName() {
		return pluginBaseName;
	}

	public String getLocale() {
		return locale;
	}
	
	public Colors getColors() {
		return colors;
	}
}
