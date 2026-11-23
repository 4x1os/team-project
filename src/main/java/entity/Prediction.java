package entity;
import java.util.List;
/**
 * Entity of a prediction. Predictions hold a list of predictionoptions which track user votes.
 */
public class Prediction {

    private final String title;
    private final String description;
    private final List<PredictionOption> options;

    /**
     * Creates a new user with the given non-empty name and non-empty password.
     * @param title the title of the prediction
     * @param description the description of the prediction
     * @param options the list of selectable predictions
     * @throws IllegalArgumentException if the password or name are empty
     */
    public Prediction(String title, String description, List<PredictionOption> options) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        if (options.size() < 2){
            throw new IllegalArgumentException("Must have at least 2 predictions");
        }

        this.title = title;
        this.description = description;
        this.options = options;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public List<PredictionOption> getOptions(){
        return options;
    }
}
