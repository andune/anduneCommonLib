/**
 * 
 */
package org.morganm.mBukkitLib.i18n;


/**
 * @author morganm
 *
 */
public interface Locale {
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
