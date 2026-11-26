package use_case.delete_prediction;

/**
 * The Output Data for the Delete Prediction Use Case.
 */
public class DeletePredictionOutputData {
    private final String title;

    public DeletePredictionOutputData(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
