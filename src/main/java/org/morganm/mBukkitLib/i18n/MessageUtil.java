/**
 * 
 */
package org.morganm.mBukkitLib.i18n;

import javax.inject.Inject;

import org.bukkit.command.CommandSender;

/**
 * @author morganm
 *
 */
public class MessageUtil {
	private final Locale locale;
	
	@Inject
	public MessageUtil(Locale locale) {
		this.locale = locale;
	}
	
	public void sendLocalizedMessage(CommandSender target, String msgKey, Object...args) {
	    target.sendMessage(locale.getMessage(msgKey, args));
	  }
}
