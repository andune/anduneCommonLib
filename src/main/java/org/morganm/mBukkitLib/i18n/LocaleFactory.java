/**
 * 
 */
package org.morganm.mBukkitLib.i18n;

import java.io.IOException;


/** Factory for getting a message object for a given localization.
 * 
 * @author morganm
 *
 */
public class LocaleFactory {
	/** Return a MessageLibrary object matching the given config requirements.
	 *  
	 * Simple implementation for now, but factory pattern allows this interface
	 * to change to meet more complex requirements if needed.
	 * 
	 * @param config
	 * @return
	 * @throws IOException
	 */
	public static Locale getLocale(final LocaleConfig config) throws IOException {
		MessageLibrary msgLib = new MessageLibrary(config);
		msgLib.load();
		
		return new LocaleStringReplacerImpl(msgLib, config.getLocale(), config.getColors());
	}
}
