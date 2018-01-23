package com.amazonaws.provider.continuations;


import com.amazonaws.provider.CognitoUser;
import com.amazonaws.provider.handlers.AuthenticationHandler;

/**
 * Defines Continuation for authentication. This Continuation is used when user log-in details
 * are required to continue to authenticate the user and get tokens.
 */
public class AuthenticationContinuation implements CognitoIdentityProviderContinuation<String> {

    // Boolean constants used to indicate where this continuation will run.
    /**
     * Run in background.
     */
    public static final boolean RUN_IN_BACKGROUND = true;
    /**
     * Run on current thread.
     */
    public static final boolean RUN_IN_CURRENT = false;

    // Data required to continue with the authentication process.
    private final CognitoUser user;
    private final Context context;
    private final AuthenticationHandler callback;
    private final boolean runInBackground;

    private AuthenticationDetails authenticationDetails = null;

    /**
     * Constructs a new continuation in the authentication process.
     *
     * @param user
     * @param runInBackground
     * @param callback
     */
    /**
     * Constructs a new continuation in the authentication process.
     *
     * @param user                  REQUIRED: Reference to the {@link CognitoUser} object.
     * @param context               REQUIRED: Application context to manage threads.
     * @param runInBackground       REQUIRED: Represents where this continuation has to run.
     * @param callback              REQUIRED: Callback to interact with the app.
     */
    public AuthenticationContinuation(CognitoUser user,
                                      Context context,
                                      boolean runInBackground,
                                      AuthenticationHandler callback) {
        this.user = user;
        this.context = context;
        this.runInBackground = runInBackground;
        this.callback = callback;
    }

    /**
     * Returns the parameters required for this continuation.
     *
     * @return
     */
    @Override
    public String getParameters() {
        return "AuthenticationDetails";
    }

    /**
     * Continues the authentications process by responding to the "PASSWORD_VERIFIER" challenge with
     * username and password. Depending upon the initial call, the response call is name in the current
     * or the background thread.
     *
     */
    @Override
    public void continueTask() {
        if (runInBackground) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final Handler handler = new Handler(context.getMainLooper());
                    Runnable nextStep;
                    try {
                        nextStep = user.initiateUserAuthentication(authenticationDetails, callback, RUN_IN_BACKGROUND);
                    } catch (final Exception e) {
                        nextStep = new Runnable() {
                            @Override
                            public void run() {
                                callback.onFailure(e);
                            }
                        };
                    }
                    handler.post(nextStep);
                }
            }).start();
        } else {
            Runnable nextStep;
            try {
                nextStep = user.initiateUserAuthentication(authenticationDetails, callback, RUN_IN_CURRENT);
            } catch (final Exception e) {
                nextStep = new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(e);
                    }
                };
            }
            nextStep.run();
        }
    }

    /**
     * Set details required to continue with this authentication.
     *
     * @param authenticationDetails @see {@link AuthenticationDetails}
     */
    public void setAuthenticationDetails(AuthenticationDetails authenticationDetails) {
        this.authenticationDetails = authenticationDetails;
    }
}
