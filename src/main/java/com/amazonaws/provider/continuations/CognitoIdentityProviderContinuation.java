package com.amazonaws.provider.continuations;

/**
 * <b>Introduction to "Continuations".</b>
 * <p>
 *     "Continuation"s provide a simple technique to continue with a task whenever it is interrupted
 *     and when it is required to continue with the task at a different time.
 *     For example, when authentication requires user parameters or if user is required to input MFA
 *     code to get tokens the authentication task is stopped at those points. This is to allow the
 *     application interact with user's and wait for events such as adding delivery of MFA code.
 *     One "Continuation" type is defined for each place in the processing where continuation is needed.
 *     All session tokens and data required to continue with the task are encapsulated by the "Continuation"
 *     object.
 *     See the specific "Continuation" for more details about it.
 * </p>
 */

/**
 * Defined general interface for "Continuations".
 * 
 * @param <T> the continuation type.
 */
public interface CognitoIdentityProviderContinuation<T> {

    /**
     * This method will provide details for the "Continuation". The return type is defined by the
     * continuation type.
     *
     * @return parameters specific to the continuation.
     */
    public T getParameters();

    /**
     * Call this method to continue with the processing.
     */
    public void continueTask();
}
