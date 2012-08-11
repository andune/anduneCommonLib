/**
 * 
 */
package org.morganm.mBukkitLib;

import java.util.logging.Level;

import javax.inject.Inject;

import org.bukkit.plugin.Plugin;

/**
 * @author morganm
 *
 */
public class LoggerImpl implements Logger {
	// class version: 3

	private final java.util.logging.Logger log = java.util.logging.Logger.getLogger(LoggerImpl.class.toString());
	private final Debug debug;
	private String logPrefix;
	
	@Inject
	public LoggerImpl(Plugin plugin, Debug debug) {
		String prefix = plugin.getDescription().getPrefix();
		if( prefix == null )
			prefix = "["+plugin.getDescription().getName()+"] ";
		setLogPrefix(prefix);

		this.debug = debug;
	}
	
	public void setLogPrefix(String logPrefix) {
		if( !logPrefix.endsWith(" ") )
			logPrefix = logPrefix + " ";
		this.logPrefix = logPrefix;
	}

	private String concatStrings(StringBuilder sb, Object...msgs) {
		for(Object o : msgs) {
			sb.append(o);
		}
		return sb.toString();
	}
	
	@Override
	public void info(Object... msg) {
		if( log.isLoggable(Level.INFO) ) {
			log.info(concatStrings(new StringBuilder(logPrefix), msg));
		}
	}

	@Override
	public void warn(Object... msg) {
		if( log.isLoggable(Level.WARNING) ) {
			log.warning(concatStrings(new StringBuilder(logPrefix), msg));
		}
	}
	@Override
	public void warn(Throwable t, Object... msg) {
		if( log.isLoggable(Level.WARNING) ) {
			log.log(Level.WARNING, concatStrings(new StringBuilder(logPrefix), msg), t);
		}
	}
	

	@Override
	public void severe(Object... msg) {
		if( log.isLoggable(Level.SEVERE) ) {
			log.severe(concatStrings(new StringBuilder(logPrefix), msg));
		}
	}
	@Override
	public void severe(Throwable t, Object... msg) {
		if( log.isLoggable(Level.SEVERE) ) {
			log.log(Level.SEVERE, concatStrings(new StringBuilder(logPrefix), msg), t);
		}
	}

	@Override
	public void debug(Object... msg) {
		debug.debug(msg);
	}

	@Override
	public void devDebug(Object... msg) {
		debug.devDebug(msg);
	}

}
