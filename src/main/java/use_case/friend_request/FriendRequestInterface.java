package use_case.friend_request;
import entity.User;

import java.util.ArrayList;

public interface SendFriendRequestInterface {
    public ArrayList<User> getFriends();
    public ArrayList<User> getPendingRequests();
    public ArrayList<User> getIncomingRequests();
    public boolean checkFriendExists(User name)

}
