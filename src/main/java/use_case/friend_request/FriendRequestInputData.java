package use_case.friend_request;

public class FriendRequestInputData {
    private final String senderUsername;
    private final String receiverUsername;
//    private final String senderNote;

    public FriendRequestInputData(String senderUsername, String receiverUsername, String senderNote) {
        this.senderUsername = senderUsername;
        this.receiverUsername = receiverUsername;
//        this.senderNote = senderNote;
    }

    public String getSenderUsername() { return this.senderUsername; }

    public String getReceiverUsername() { return this.receiverUsername; }

//    public String getSenderNote() { return this.senderNote; }

}
