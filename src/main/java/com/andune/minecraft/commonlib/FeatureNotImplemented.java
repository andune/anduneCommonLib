/**
 * 
 */
package com.andune.minecraft.commonlib;

/**
 * Exception thrown to indicate a given feature has not yet been implemented.
 * @author andune
 *
 */
public class FeatureNotImplemented extends RuntimeException {
    private static final long serialVersionUID = 412533526968395832L;

    /**
     * 
     */
    public FeatureNotImplemented() {
    }

    /**
     * @param message
     */
    public FeatureNotImplemented(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public FeatureNotImplemented(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public FeatureNotImplemented(String message, Throwable cause) {
        super(message, cause);
    }

}
