package entity;
import java.util.List;

public class PredictionFactory {
    public Prediction create(String title, String description, List<PredictionOption> predictionOptions) {
        return new Prediction(title, description, predictionOptions);
    }
}
