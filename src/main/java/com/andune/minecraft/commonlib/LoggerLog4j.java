package com.andune.minecraft.commonlib;

import org.apache.log4j.LogManager;
import org.apache.log4j.LogSF;

/**
 * Performance Implementation note: All of the prefix null checks will be
 * optimized away by a good JIT compiler since the prefix variable is final.
 *
 * @author andune
 */
public class LoggerLog4j implements Logger {
    private final org.apache.log4j.Logger log;
    private final String prefix;

    public LoggerLog4j(org.apache.log4j.Logger log) {
        this.log = log;
        prefix = null;
    }

    public LoggerLog4j(String name, String prefix) {
        this.log = LogManager.getLogger(name);
        this.prefix = prefix;
    }

    @Override
    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    @Override
    public void info(String msg) {
        if( prefix != null )
            log.info(prefix + msg);
        else
            log.info(msg);
    }

    @Override
    public void info(String format, Object obj1) {
        if( prefix != null )
            LogSF.info(log, prefix + format, obj1);
        else
            LogSF.info(log, format, obj1);
    }

    @Override
    public void info(String format, Object obj1, Object obj2) {
        if( prefix != null )
            LogSF.info(log, prefix + format, obj1, obj2);
        else
            LogSF.info(log, format, obj1, obj2);
    }

    @Override
    public void info(String format, Object... args) {
        if( prefix != null )
            LogSF.info(log, prefix + format, args);
        else
            LogSF.info(log, format, args);
    }

    @Override
    public void warn(String msg) {
        if( prefix != null )
            log.warn(prefix + msg);
        else
            log.warn(msg);
    }

    @Override
    public void warn(String format, Object obj1) {
        if( prefix != null )
            LogSF.warn(log, prefix + format, obj1);
        else
            LogSF.warn(log, format, obj1);
    }

    @Override
    public void warn(String format, Object obj1, Object obj2) {
        if( prefix != null )
            LogSF.warn(log, prefix + format, obj1, obj2);
        else
            LogSF.warn(log, format, obj1, obj2);
    }

    @Override
    public void warn(String format, Object... args) {
        if( prefix != null )
            LogSF.warn(log, prefix + format, args);
        else
            LogSF.warn(log, format, args);
    }

    @Override
    public void warn(String msg, Throwable t) {
        if( prefix != null )
            log.warn(prefix + msg, t);
        else
            log.warn(msg, t);
    }

    @Override
    public void error(String msg) {
        if( prefix != null )
            log.error(prefix + msg);
        else
            log.error(msg);
    }

    /**
     * LogSF doesn't provide efficient single and double argument versions
     * for error, but in practice this shouldn't matter at all since errors
     * aren't being called often enough to have any significant performance
     * impact anyway.
     *
     * @param format
     * @param obj1
     */
    @Override
    public void error(String format, Object obj1) {
        if( prefix != null )
            LogSF.error(log, prefix + format, new Object[] { obj1 });
        else
            LogSF.error(log, format, new Object[] { obj1 });
    }

    @Override
    public void error(String format, Object obj1, Object obj2) {
        if( prefix != null )
            LogSF.error(log, prefix + format, new Object[] { obj1, obj2 });
        else
            LogSF.error(log, format, new Object[] { obj1, obj2 });
    }

    @Override
    public void error(String format, Object... args) {
        if( prefix != null )
            LogSF.error(log, prefix + format, args);
        else
            LogSF.error(log, format, args);
    }

    @Override
    public void error(String msg, Throwable t) {
        if( prefix != null )
            log.error(prefix + msg, t);
        else
            log.error(msg, t);
    }

    @Override
    public void debug(String msg) {
        if( prefix != null )
            log.debug(prefix + msg);
        else
            log.debug(msg);
    }

    @Override
    public void debug(String format, Object obj1) {
        if( prefix != null )
            LogSF.debug(log, prefix + format, obj1);
        else
            LogSF.debug(log, format, obj1);
    }

    @Override
    public void debug(String format, Object obj1, Object obj2) {
        if( prefix != null )
            LogSF.debug(log, prefix + format, obj1, obj2);
        else
            LogSF.debug(log, format, obj1, obj2);

    }

    @Override
    public void debug(String format, Object... args) {
        if( prefix != null )
            LogSF.debug(log, prefix + format, args);
        else
            LogSF.debug(log, format, args);
    }
}
