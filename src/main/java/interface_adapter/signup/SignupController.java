package interface_adapter.signup;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;


/**
 * Handles signup requests by passing user information to the signup use case
 */
public class SignupController {
    /**
     * SignupController needs to remember which interactor to send the signup information to
     */
    private final SignupInputBoundary signupInteractor;

    /**
     * Constructs a SignupController with the provided signup input boundary
     *
     * @param signupInteractor the input boundary used to execute the signup use case
     */
    public  SignupController(SignupInputBoundary signupInteractor) {
        this.signupInteractor = signupInteractor;
    }

    /**
     * execute(...) method is where the Controller actually sends the signup
     * information to the Interactor
     */
    public void execute(String username, String email, String password,
                        String repeatPassword) {
        // Package the user's signup information into an InputData's object
        SignupInputData inputData = new SignupInputData(username, email, password, repeatPassword);
        // Send to interactor
        signupInteractor.execute(inputData);
    }
}
