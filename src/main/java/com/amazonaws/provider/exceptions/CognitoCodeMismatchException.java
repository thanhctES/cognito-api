package com.amazonaws.provider.exceptions;

/**
 * This exception indicates that a code used for verification did not match with
 * the excepted value.
 */
public class CognitoCodeMismatchException extends CognitoIdentityProviderException {
    private static final long serialVersionUID = -267743909862371391L;

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     * @param throwable The underlying cause of this exception.
     */
    public CognitoCodeMismatchException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     */
    public CognitoCodeMismatchException(String message) {
        super(message);
    }
}
