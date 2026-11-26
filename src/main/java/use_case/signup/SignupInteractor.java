package use_case.signup;

public class SignupInteractor implements SignupInputBoundary{
    @Override
    // execute() method is where signup use case starts running its business logic
    public void execute(SignupInputData inputData) {
        String username = inputData.getUsername();
        String email = inputData.getEmail();
        String password = inputData.getPassword();
        String repeatPassword = inputData.getRepeatPassword();
    }


}
