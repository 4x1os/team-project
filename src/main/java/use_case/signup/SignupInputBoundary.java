package use_case.signup;

/**
 *  Any class that IMPLEMENTS SignupInputBoundary interface must provide an
 *  implementation of execute(SignupInputData inputData)
 */
public interface SignupInputBoundary {

    void execute (SignupInputData inputData);
}
