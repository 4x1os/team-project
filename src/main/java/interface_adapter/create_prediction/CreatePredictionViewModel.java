package interface_adapter.create_prediction;

public class CreatePredictionViewModel {

    private CreatePredictionState state = new CreatePredictionState();

    public CreatePredictionState getState() { return this.state; }

    public void setState(CreatePredictionState state){ this.state = state; }


}
