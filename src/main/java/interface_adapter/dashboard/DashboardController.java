package interface_adapter.dashboard;


import use_case.fetch_predictions.FetchPredictionsInputBoundary;
import use_case.fetch_predictions.FetchPredictionsInputData;

import java.util.List;

public class DashboardController {
    private final FetchPredictionsInputBoundary fetchPredictionsInteractor;

    public DashboardController(FetchPredictionsInputBoundary fetchPredictionsInteractor){
        this.fetchPredictionsInteractor = fetchPredictionsInteractor;
    }

    public void execute(){
        final FetchPredictionsInputData inputData = new FetchPredictionsInputData();
        fetchPredictionsInteractor.execute(inputData);
    }

}
