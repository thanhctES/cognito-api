package com.amazonaws.provider.exceptions;

/**
 * Authentication failure exception
 */
public class CognitoAuthenticationFailedException extends CognitoIdentityProviderException {
    private static final long serialVersionUID = 8165822545734303030L;

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     * @param throwable The underlying cause of this exception.
     */
    public CognitoAuthenticationFailedException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     */
    public CognitoAuthenticationFailedException(String message) {
        super(message);
    }
}
