package interface_adapter.create_prediction;

import use_case.create_prediction.CreatePredictionInputBoundary;
import use_case.create_prediction.CreatePredictionInputData;

import java.util.List;

public class CreatePredictionController {
    private final CreatePredictionInputBoundary createPredictionInteractor;

    public CreatePredictionController(CreatePredictionInputBoundary createPredictionInteractor){
        this.createPredictionInteractor = createPredictionInteractor;
    }

    public void execute(String title, String description, List<String> predictionOptions) {
        final CreatePredictionInputData createPredictionInputData = new CreatePredictionInputData(title, description, predictionOptions);
        createPredictionInteractor.execute(createPredictionInputData);
    }
}
