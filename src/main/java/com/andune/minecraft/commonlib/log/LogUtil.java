package com.andune.minecraft.commonlib.log;

/**
 * This is a programmatic abstraction over the logging system, which allows
 * to do some broad things (such as enable/disable debugging) if the backing
 * log system allows it.
 *
 * @author andune
 */
public interface LogUtil {
    /**
     * Enable debugging, using the given baseLogName.
     * @param baseLogName the base log name to enable debubbing, ie. "com.andune.someplugin"
     */
    void enableDebug(String baseLogName);

    /**
     * Disable debugging at the previously assigned baseLogName.
     */
    void disableDebug();
}
