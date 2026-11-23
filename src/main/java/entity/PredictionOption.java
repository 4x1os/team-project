package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * A single choice within a Prediction, tracking which users voted for it.
 */
public class PredictionOption {
    private final String text;
    private final Set<String> voterIds = new HashSet<>();

    /**
     * Creates a new option with the given non-empty text.
     * @param text the option text
     * @throws IllegalArgumentException if text is null or blank
     */
    public PredictionOption(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Option text cannot be empty");
        }
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getVoteCount() {
        return voterIds.size();
    }

    /**
     * @return true if the vote was recorded, false if this user already voted for this option
     */
    public boolean addVote(String userId) {
        return voterIds.add(userId);
    }

    public void removeVote(String userId) {
        voterIds.remove(userId);
    }

    public boolean hasVoted(String userId) {
        return voterIds.contains(userId);
    }
}
