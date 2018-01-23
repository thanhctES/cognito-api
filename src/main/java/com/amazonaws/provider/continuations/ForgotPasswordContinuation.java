package com.amazonaws.provider.continuations;

import com.amazonaws.provider.CognitoUser;
import com.amazonaws.provider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.provider.handlers.ForgotPasswordHandler;

/**
 * This is a Continuation to set the password in the forgot password processing.
 */
public class ForgotPasswordContinuation implements CognitoIdentityProviderContinuation<CognitoUserCodeDeliveryDetails> {

    // Boolean constants used to indicate where this continuation will run.
    /**
     * Run in background.
     */
    public static final boolean RUN_IN_BACKGROUND = true;
    /**
     * Run on current thread.
     */
    public static final boolean RUN_IN_CURRENT = false;

    private final ForgotPasswordHandler callback;
    private final CognitoUser user;
    private final CognitoUserCodeDeliveryDetails parameters;
    private final boolean runInBackground;

    private String password = null;
    private String verificationCode = null;

    /**
     * Constructs a new Continuation for forgot password process.
     *
     * @param user REQUIRED: Reference to the {@link CognitoUser} object.
     * @param parameters REQUIRED: Contains information about the medium and destination of the verification code.
     * @param runInBackground REQUIRED: Represents where this continuation has to run.
     * @param callback REQUIRED: Callback to interact with the app.
     */
    public ForgotPasswordContinuation(CognitoUser user,
                                      CognitoUserCodeDeliveryDetails parameters,
                                      boolean runInBackground,
                                      ForgotPasswordHandler callback) {
        this.callback = callback;
        this.user = user;
        this.parameters = parameters;
        this.runInBackground = runInBackground;
    }

    /**
     * Returns Continuation parameters.
     * @return
     */
    @Override
    public CognitoUserCodeDeliveryDetails getParameters() {
        return parameters;
    }

    /**
     * Call this method to continue with the forgot password processing.s
     */
    @Override
    public void continueTask() {
        if (runInBackground) {
            user.confirmPasswordInBackground(verificationCode, password, callback);
        } else {
            user.confirmPassword(verificationCode, password, callback);
        }
    }

    /**
     * Set the new password.
     *
     * @param password REQUIRED: The new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Set the verification code for this processing.
     *
     * @param verificationCode REQUIRED: The verification code to set a new password.
     */
    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
