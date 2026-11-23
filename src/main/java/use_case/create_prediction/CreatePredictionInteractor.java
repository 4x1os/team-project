package use_case.create_prediction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Prediction;
import entity.PredictionFactory;
import entity.PredictionOption;

public class CreatePredictionInteractor implements CreatePredictionInputBoundary{
    private final PredictionFactory predictionFactory;
    private final CreatePredictionOutputBoundary createPredictionPresenter;
    private final CreatePredictionDataAccessInterface createPredictionDataAccessObject;

    public CreatePredictionInteractor(PredictionFactory predictionFactory, CreatePredictionOutputBoundary createPredictionPresenter, CreatePredictionDataAccessInterface createPredictionDataAccessObject){
        this.predictionFactory = predictionFactory;
        this.createPredictionPresenter = createPredictionPresenter;
        this.createPredictionDataAccessObject = createPredictionDataAccessObject;
    }

    @Override 
    public void execute(CreatePredictionInputData createPredictionInputData){
        final String title = createPredictionInputData.getTitle();
        final String description = createPredictionInputData.getDescription();
        final List<String> options = createPredictionInputData.getPredictionOptions();
        if (options == null || options.size() < 2){
            createPredictionPresenter.prepareFailView("You need at least 2 prediction options");
        } else if (title == null || title.isBlank()){
            createPredictionPresenter.prepareFailView("Please fill in the prediction title");
        } else if (description == null || description.isBlank()){
            createPredictionPresenter.prepareFailView("Please fill in the prediction description");
        } else if (createPredictionDataAccessObject.existsByTitle(title)){
            createPredictionPresenter.prepareFailView("Prediction already exists!");
        } else {
            List<PredictionOption> predictionOptions = new ArrayList<>();
            for (String option : options){
                if (option == null || option.isBlank()){
                    createPredictionPresenter.prepareFailView("Some prediction options are left blank");
                    return;
                }
                PredictionOption predictionOption = new PredictionOption(option);
                predictionOptions.add(predictionOption);
            }
            Prediction prediction = predictionFactory.create(title, description, predictionOptions);
            createPredictionDataAccessObject.save(prediction);
            
            Map<String, Integer> optionsToVotes = new HashMap<>();
            for (PredictionOption option : prediction.getOptions()){
                optionsToVotes.put(option.getText(), option.getVoteCount());
            }
            CreatePredictionOutputData outputData = new CreatePredictionOutputData(title, description, optionsToVotes);
            createPredictionPresenter.prepareSuccessView(outputData);

        }

    }

}
