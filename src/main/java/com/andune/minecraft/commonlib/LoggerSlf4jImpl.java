/**
 * 
 */
package com.andune.minecraft.commonlib;

import org.slf4j.LoggerFactory;


/**
 * @author andune
 *
 */
public class LoggerSlf4jImpl implements Logger {
    private final org.slf4j.Logger log;

    protected LoggerSlf4jImpl(org.slf4j.Logger log) {
        this.log = log;
    }
    protected LoggerSlf4jImpl(String name) {
        this.log = LoggerFactory.getLogger(name);
    }
    
    @Override
    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    @Override
    public void info(String msg) {
        log.info(msg);
    }

    @Override
    public void info(String format, Object obj1) {
        log.info(format, obj1);
    }

    @Override
    public void info(String format, Object obj1, Object obj2) {
        log.info(format, obj1, obj2);
    }

    @Override
    public void info(String format, Object...args) {
        log.info(format, args);
    }

    @Override
    public void warn(String msg) {
        log.warn(msg);
    }

    @Override
    public void warn(String format, Object obj1) {
        log.warn(format, obj1);
    }

    @Override
    public void warn(String format, Object obj1, Object obj2) {
        log.warn(format, obj1, obj2);
    }

    @Override
    public void warn(String format, Object...args) {
        log.warn(format, args);
    }

    @Override
    public void warn(String msg, Throwable t) {
        log.warn(msg, t);
    }

    @Override
    public void error(String msg) {
        log.error(msg);
    }

    @Override
    public void error(String format, Object obj1) {
        log.error(format, obj1);
    }

    @Override
    public void error(String format, Object obj1, Object obj2) {
        log.error(format, obj1, obj2);
    }

    @Override
    public void error(String format, Object...args) {
        log.error(format, args);
    }

    @Override
    public void error(String msg, Throwable t) {
        log.error(msg, t);
    }

    @Override
    public void debug(String msg) {
        log.debug(msg);
    }

    @Override
    public void debug(String format, Object obj1) {
        log.debug(format, obj1);
    }

    @Override
    public void debug(String format, Object obj1, Object obj2) {
        log.debug(format, obj1, obj2);
    }

    @Override
    public void debug(String format, Object...args) {
        log.debug(format, args);
    }

}
