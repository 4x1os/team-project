package entity;
import java.util.List;
/**
 * Entity of a prediction. Predictions hold a list of predictionoptions which track user votes.
 */
public class Prediction {

    private final String title;
    private final String description;
    private final List<PredictionOption> predictions;

    /**
     * Creates a new user with the given non-empty name and non-empty password.
     * @param title the title of the prediction
     * @param description the description of the prediction
     * @param predictions the list of selectable predictions
     * @throws IllegalArgumentException if the password or name are empty
     */
    public Prediction(String title, String description, List<PredictionOption> predictions) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        if (predictions.size() < 2){
            throw new IllegalArgumentException("Must have at least 2 predictions");
        }

        this.title = title;
        this.description = description;
        this.predictions = predictions;
    }

    public String getName() {
        return title;
    }

    public String getPassword() {
        return description;
    }
    public List<PredictionOption> getPredictions(){
        return predictions;
    }
}
