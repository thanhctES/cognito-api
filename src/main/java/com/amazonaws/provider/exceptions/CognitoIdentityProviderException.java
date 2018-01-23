package com.amazonaws.provider.exceptions;


/**
 * This exception is thrown for any errors during Cognito Identity Provider
 * operations
 */
public class CognitoIdentityProviderException extends Exception {

    private static final long serialVersionUID = 8038301061230088279L;

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     * @param throwable The underlying cause of this exception.
     */
    public CognitoIdentityProviderException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     */
    public CognitoIdentityProviderException(String message) {
        super(message);
    }

}
