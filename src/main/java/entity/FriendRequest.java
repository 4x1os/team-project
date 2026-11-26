package entity;

public class FriendRequest {
    private final User sender;
    private final User receiver;
//    private final String senderNote;
    private boolean accepted;

    public FriendRequest(User requester, User requestee) {
        this.sender = requester;
        this.receiver = requestee;
//        this.senderNote = senderNote;
        this.accepted = false;
    }

    public User getSender() { return this.sender; }

    public User getReceiver() { return this.receiver; }

    public boolean getStatus() { return this.accepted; }

//    public String getSenderNote() { return this.senderNote; }

    public void updateFriendRequest(boolean status) {
        this.accepted = status;
    }
}