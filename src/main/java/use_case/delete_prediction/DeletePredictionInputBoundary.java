package use_case.delete_prediction;

/**
 * Input Boundary for actions which are related to deleting predictions
 */
public interface DeletePredictionInputBoundary {

    /**
     * Executes the delete prediction use case.
     * @param deletePredictionInputData the input data
     */
    void execute(DeletePredictionInputData deletePredictionInputData);

}
