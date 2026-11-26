import entity.Prediction;

public interface SignupDataAccessInterface {
    
    /**
     * Checks if the given user exists.
     * @param username the username to look for
     * @return true if a user with the given title exists; false otherwise
     */
    boolean existsByUsername(String username);

    /**
     * Saves the prediction
     * @param prediction the prediction to save
     */
    void save(Prediction prediction);
}