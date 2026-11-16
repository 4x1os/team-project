package use_case.create_prediction;

/**
 * Input Boundary for actions which are related to creating predictions
 */
public interface CreatePredictionInputBoundary {

    /**
     * Executes the create prediction use case.
     * @param CreatePredictionInputData the input data
     */
    void execute(CreatePredictionInputData createPredictionInputData);

}
