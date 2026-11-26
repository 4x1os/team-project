package interface_adapter.create_prediction;

import use_case.create_prediction.CreatePredictionInputData;
import use_case.create_prediction.CreatePredictionOutputBoundary;
import use_case.create_prediction.CreatePredictionOutputData;

public class CreatePredictionPresenter implements CreatePredictionOutputBoundary {

    private final CreatePredictionViewModel createPredictionViewModel;

    public CreatePredictionPresenter(CreatePredictionViewModel createPredictionViewModel){
        this.createPredictionViewModel = createPredictionViewModel;

    }

    @Override
    public void prepareSuccessView(CreatePredictionOutputData outputData){
        System.out.println(outputData.getTitle());
        System.out.println(outputData.getDescription());
    }

    @Override
    public void prepareFailView(String errorMessage){
        System.out.println("big fails");
    }
}
