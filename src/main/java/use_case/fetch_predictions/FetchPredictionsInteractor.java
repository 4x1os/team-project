package use_case.fetch_predictions;



public class FetchPredictionsInteractor implements FetchPredictionsInputBoundary {
    private final FetchPredictionsOutputBoundary dashboardPresenter;


    public FetchPredictionsInteractor(FetchPredictionsOutputBoundary dashboardPresenter){
        this.dashboardPresenter = dashboardPresenter;
    }

    @Override
    public void execute(FetchPredictionsInputData fetchPredictionsInputData){

        //yeah idk its meant to get a list of all the predictions


    }


}
