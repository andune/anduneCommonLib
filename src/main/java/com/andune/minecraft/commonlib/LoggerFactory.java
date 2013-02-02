/**
 * 
 */
package com.andune.minecraft.commonlib;

/**
 * @author andune
 *
 */
public class LoggerFactory {
    private static Class<?> loggerImpl = LoggerJUL.class;  // default to JUL
    
    public static void setLoggerImpl(Class<?> clazz) {
        loggerImpl = clazz;
    }

    public static Logger getLogger(String name) {
        if( LoggerSlf4jImpl.class.equals(loggerImpl) ) {
            return new LoggerSlf4jImpl(name);
        }
        // JUL is default, we use it if nothing else we know is specified
        else {
            return new LoggerJUL(name);
        }
    }
    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }
}
