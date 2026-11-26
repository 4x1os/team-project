package use_case.friend_request;

// Defines operations users can request (via controller)

public interface FriendRequestInputBoundary {
    void sendFriendRequest(FriendRequestInputData input);
    void cancelFriendRequest(FriendRequestInputData input);
    void acceptFriendRequest(FriendRequestInputData input);
    void rejectFriendRequest(FriendRequestInputData input);
}
