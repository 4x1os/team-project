package use_case.delete_prediction;

public interface DeletePredictionOutputBoundary {

    /**
     * Prepares the success view for the Delete Prediction Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(DeletePredictionOutputData outputData);

    /**
     * Prepares the failure view for the Delete Prediction Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

}
