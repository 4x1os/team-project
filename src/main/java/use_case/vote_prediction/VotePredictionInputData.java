package use_case.vote_prediction;

/**
 * The Input Data for the Vote Prediction Use Case.
 */
public class VotePredictionInputData {

    private final String title;
    private final String optionText;
    private final String userId;

    public VotePredictionInputData(String title, String optionText, String userId) {
        this.title = title;
        this.optionText = optionText;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public String getOptionText() {
        return optionText;
    }

    public String getUserId() {
        return userId;
    }
}
