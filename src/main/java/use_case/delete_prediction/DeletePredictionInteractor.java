package use_case.delete_prediction;

public class DeletePredictionInteractor implements DeletePredictionInputBoundary {
    final DeletePredictionOutputBoundary deletePredictionOutputObject;


    public DeletePredictionInteractor(DeletePredictionOutputBoundary deletePredictionOutputBoundary){
        this.deletePredictionOutputObject = deletePredictionOutputBoundary;
    }

    @Override 
    public void execute(DeletePredictionInputData deletePredictionInputData){
        final String title = deletePredictionInputData.getTitle();
    }
}
