package use_case.create_prediction;
import java.util.Map;


public class CreatePredictionOutputData {
    private final String title;
    private final String description;
    private final Map<String, Integer> votesByOption;
    
    public CreatePredictionOutputData(String title, String description,  Map<String, Integer> votesByOption){
        this.title = title;
        this.description = description;
        this.votesByOption = votesByOption;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getVotesByOption() {
        return votesByOption;
    }
}
