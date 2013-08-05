package com.andune.minecraft.commonlib.log;

import com.andune.minecraft.commonlib.LoggerFactory;

/**
 * @author andune
 */
public class LogUtilSlf4j implements LogUtil {
    private final com.andune.minecraft.commonlib.Logger log = LoggerFactory.getLogger(LogUtil.class);

    @Override
    public void enableDebug(final String baseLogger) {
        log.warn("enableDebug called for Slf4j logger, but method not implemented. No debug messages will be logged.");
    }

    @Override
    public void disableDebug() {
        log.warn("disableDebug called for Slf4j logger, but method not implemented.");
    }
}
