package com.amazonaws.provider.exceptions;

/**
 * Client exception for using an expired code.
 */
public class CognitoCodeExpiredException extends CognitoIdentityProviderException {
    private static final long serialVersionUID = 2414443500383441666L;

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     * @param throwable The underlying cause of this exception.
     */
    public CognitoCodeExpiredException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     */
    public CognitoCodeExpiredException(String message) {
        super(message);
    }
}
