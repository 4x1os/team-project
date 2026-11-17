package use_case.create_prediction;
import java.util.List;
/**
 * The Input Data for the Signup Use Case.
 */


public class CreatePredictionInputData {

    private final String title;
    private final String description;
    private final List<String> predictionOptions;

    public CreatePredictionInputData(String title, String description, List<String> predictionOptions) {
        this.title = title;
        this.description = description;
        this.predictionOptions = predictionOptions;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getPredictionOptions() {
        return predictionOptions;
    }
}
