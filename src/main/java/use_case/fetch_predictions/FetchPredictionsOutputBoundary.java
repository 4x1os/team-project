package use_case.fetch_predictions;

public interface FetchPredictionsOutputBoundary {

    void prepareSuccessView(FetchPredictionsOutputData outputData);

    void prepareFailView(String errorMessage);
}
