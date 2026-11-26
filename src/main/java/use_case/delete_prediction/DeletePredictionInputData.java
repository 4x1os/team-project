package use_case.delete_prediction;

/**
 * The Input Data for the Delete Prediction Use Case.
 */
public class DeletePredictionInputData {

    private final String title;

    public DeletePredictionInputData(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
