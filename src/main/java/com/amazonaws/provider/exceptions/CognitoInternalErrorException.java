package com.amazonaws.provider.exceptions;

/**
 * Exception indicating an internal error.
 */
public class CognitoInternalErrorException extends CognitoIdentityProviderException {
    private static final long serialVersionUID = 1591505124709311863L;

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     * @param throwable The underlying cause of this exception.
     */
    public CognitoInternalErrorException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     */
    public CognitoInternalErrorException(String message) {
        super(message);
    }
}
