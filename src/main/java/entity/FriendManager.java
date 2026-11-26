//import use_case.friend_request.FriendRequestInterface;
import java.util.ArrayList;

public class FriendManager {
    private final User user;
    private ArrayList<User> friends;
    private ArrayList<User> pendingRequests;
    private ArrayList<User> incomingRequests;

    public FriendManager (User user) {
        this.user = user;
        this.friends = new ArrayList<>();
        this.pendingRequests = new ArrayList<>();
        this.incomingRequests = new ArrayList<>();
    }

    public ArrayList<User> getFriends() { return this.friends; }

    public ArrayList<User> getPendingRequests() { return this.pendingRequests; }

    public ArrayList<User> getIncomingRequests() { return this.incomingRequests; }

    public boolean checkFriendExists(User name) {
        for (User u : this.friends) {
            if (u.getUsername().equals(name.getUsername())) {
                return true;
            }}
            return false;
        }



}
