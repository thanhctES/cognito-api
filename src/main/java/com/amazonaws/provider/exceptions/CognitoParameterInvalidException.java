package com.amazonaws.provider.exceptions;

/**
 * Client exception issue when a parameter assigned an illegal value.
 */
public class CognitoParameterInvalidException extends CognitoIdentityProviderException {
    private static final long serialVersionUID = -551253513463692597L;

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     * @param throwable The underlying cause of this exception.
     */
    public CognitoParameterInvalidException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     */
    public CognitoParameterInvalidException(String message) {
        super(message);
    }
}
