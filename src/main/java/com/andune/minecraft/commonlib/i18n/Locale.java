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
