package com.amazonaws.provider.exceptions;

/**
 * Throttle exception.
 */
public class CognitoLimitExceeded extends CognitoIdentityProviderException {
    private static final long serialVersionUID = -6536154083710077612L;

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     * @param throwable The underlying cause of this exception.
     */
    public CognitoLimitExceeded(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructor.
     *
     * @param message An error message describing why this exception was thrown.
     */
    public CognitoLimitExceeded(String message) {
        super(message);
    }
}
