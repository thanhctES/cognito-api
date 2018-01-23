package com.amazonaws.provider.exceptions;

/**
 * Client exception.
 */
public class CognitoResourceNotFoundException extends CognitoIdentityProviderException {
    private static final long serialVersionUID = -7875174258893803243L;

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     * @param throwable The underlying cause of this exception.
     */
    public CognitoResourceNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     */
    public CognitoResourceNotFoundException(String message) {
        super(message);
    }
}
