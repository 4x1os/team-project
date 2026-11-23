package use_case.signup;

/**
 * Holds information needed for signup use case
 */
public class SignupInputData {
    private final String username;
    private final String email;
    private final String password;
    private final String repeatPassword;

    /**
     * Constructor, a SignupInputData object with user's signup information
     *
     * @param username
     * @param email
     * @param password
     * @param repeatPassword
     */
    public SignupInputData(String username, String email, String password,
                           String repeatPassword) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    // We need these getter methods because SignupInteractor needs a way to read information
    // stored inside SignupInputData, as the attributes are private as well..
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
