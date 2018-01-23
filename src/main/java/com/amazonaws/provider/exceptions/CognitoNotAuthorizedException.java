package com.amazonaws.provider.exceptions;

/**
 * Client exception when user is not authenticated for an operation.
 */
public class CognitoNotAuthorizedException extends CognitoIdentityProviderException {
    private static final long serialVersionUID = -4496852554085318906L;

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     * @param throwable The underlying cause of this exception.
     */
    public CognitoNotAuthorizedException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     */
    public CognitoNotAuthorizedException(String message) {
        super(message);
    }
}
