package com.amazonaws.provider.exceptions;

/**
 * Client exception for incorrect password.
 */
public class CognitoPasswordInvalidException extends CognitoIdentityProviderException {
    private static final long serialVersionUID = 8828738916097130105L;

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     * @param throwable The underlying cause of this exception.
     */
    public CognitoPasswordInvalidException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     */
    public CognitoPasswordInvalidException(String message) {
        super(message);
    }
}
