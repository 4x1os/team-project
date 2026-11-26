package use_case.vote_prediction;

import java.util.Map;

/**
 * The Output Data for the Vote Prediction Use Case.
 */
public class VotePredictionOutputData {
    private final String title;
    private final String description;
    private final Map<String, Integer> votesByOption;

    public VotePredictionOutputData(String title, String description, Map<String, Integer> votesByOption) {
        this.title = title;
        this.description = description;
        this.votesByOption = votesByOption;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getVotesByOption() {
        return votesByOption;
    }
}
