package use_case.create_prediction;
import entity.Prediction;

/**
 * DAO interface for the Prediction Use Case.
 */
public interface CreatePredictionDataAccessInterface {

    /**
     * Checks if the given prediction exists.
     * @param title the title to look for
     * @return true if a user with the given title exists; false otherwise
     */
    boolean existsByTitle(String title);

    /**
     * Saves the prediction
     * @param prediction the prediction to save
     */
    void save(Prediction prediction);
}
