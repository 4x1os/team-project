package use_case.friend_request;
import entity.FriendManager;
import entity.User;

public class FriendRequest {
    private final User sender;
    private final User receiver;
    private boolean accepted;

    public FriendRequest(User requester, User requestee) {
        this.sender = requester;
        this.receiver = requestee;
        this.accepted = false;
    }

    public User getSender() { return this.sender; }

    public User getReceiver() { return this.receiver; }

    public void updateFriendRequest(boolean status) {
        this.accepted = status;
    }
}