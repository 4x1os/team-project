package interface_adapter.dashboard;

import use_case.fetch_predictions.FetchPredictionsOutputBoundary;
import use_case.fetch_predictions.FetchPredictionsOutputData;
import view.DashboardView;

public class DashboardPresenter implements FetchPredictionsOutputBoundary {

    private final DashboardViewModel dashboardViewModel;

    public DashboardPresenter(DashboardViewModel dashboardViewModel){
        this.dashboardViewModel = dashboardViewModel;
    }

    @Override
    public void prepareSuccessView(FetchPredictionsOutputData outputData){
        System.out.println("yeah that did something");
    }

    @Override
    public void prepareFailView(String errorMessage){ System.out.println("error?");}
}
