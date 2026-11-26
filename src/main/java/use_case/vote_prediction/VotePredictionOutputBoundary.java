package use_case.vote_prediction;

public interface VotePredictionOutputBoundary {

    /**
     * Prepares the success view for the Vote Prediction Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(VotePredictionOutputData outputData);

    /**
     * Prepares the failure view for the Vote Prediction Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

}
