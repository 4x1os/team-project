package use_case.vote_prediction;

/**
 * Input Boundary for actions which are related to voting on predictions
 */
public interface VotePredictionInputBoundary {

    /**
     * Executes the vote prediction use case.
     * @param votePredictionInputData the input data
     */
    void execute(VotePredictionInputData votePredictionInputData);

}
