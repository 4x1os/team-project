/**
 * Handles friend request logic. Uses FriendRequestInputData.
 */
package entity;
import use_case.friend_request.FriendRequestInputBoundary;
import use_case.friend_request.FriendRequestInputData;

import java.util.ArrayList;

public class FriendManager implements FriendRequestInputBoundary {
    private final User user;
    private ArrayList<User> friends;
    private ArrayList<FriendRequestInputData> pendingRequests;
    private ArrayList<FriendRequestInputData> incomingRequests;

    /**
    Initialise FriendManager for given user.
     */
    public FriendManager (User user) {
        this.user = user;
        this.friends = new ArrayList<>();
        this.pendingRequests = new ArrayList<>();
        this.incomingRequests = new ArrayList<>();
    }

    public ArrayList<User> getFriendList() { return this.friends; }

    public ArrayList<FriendRequestInputData> getPendingRequests() { return this.pendingRequests; }

    public ArrayList<FriendRequestInputData> getIncomingRequests() { return this.incomingRequests; }

    /**
     * Add the user as a friend.
     */
    public void addFriend(User name) { this.friends.add(name); }

    /**
     * Remove an existing friend.
     * Throw an exception if friend does not exist.
     */
    public void removeFriend(User name) {
        boolean cond_a = false;
        int ind_a = 0;
        boolean cond_b = false;
        int ind_b = 0;

        for (int i = 0; i < this.friends.size(); i++) {
            if (this.friends.get(i).equals(name)) {
                cond_a = true;
                ind_a = i;
                break;
            }
        }
        for (int j = 0; j < name.getFriendManager().friends.size(); j++) {
            if (name.getFriendManager().friends.get(j).equals(this.user)) {
                cond_b = true;
                ind_b = j;
                break;
            }
        }
        if (cond_a && cond_b) {
            this.friends.remove(ind_a);
            name.getFriendManager().friends.remove(ind_b);
        } else {// friend not found in friend list
            throw new IllegalArgumentException("This user does not exist in the friends list.");

        }
    }

    /**
     * Sends friend request from self to user.
     * Do not send request if users are already friends.
     * Do not send request if there is already one created.
     */
    public void sendFriendRequest(User name) {
        if (this.checkFriendExists(name)) {
            throw new IllegalArgumentException("User is already friends with this person.");
        } else if (this.checkPendingRequestExists(name)) {
            throw new IllegalArgumentException("A friend request sent to this user already exists.");
        } else {
            FriendRequestInputData request = new FriendRequestInputData(this.user, name);
            this.addPendingRequest(request);
            name.getFriendManager().addIncomingRequest(request);

            // TODO: something that updates viewers for both
        }
    }

    /**
     * Accepts an existing friend request from user to self.
     * Do not accept if users are already friends.
     * Do not accept if the request does not exist.
     */
    public void acceptFriendRequest(User name) {
        if (this.checkFriendExists(name)) {
            throw new IllegalArgumentException("User is already friends with this person.");
        } else if (!this.checkIncomingRequestExists(name)) {
            throw new IllegalArgumentException("A friend request sent by this user does not exist.");
        } else {
            this.addFriend(name);
            name.getFriendManager().addFriend(this.user);
            this.deleteIncomingRequest(name);
            name.getFriendManager().deletePendingRequest(this.user);
        }
    }

    /**
     * Rejects an existing friend request from user to self.
     * Do not reject if users are friends.
     * Do not reject if the request does not exist.
     */
    public void rejectFriendRequest(User name) {
        if (this.checkFriendExists(name)) {
            throw new IllegalArgumentException("User is already friends with this person.");
        } else if (!this.checkIncomingRequestExists(name)) {
            throw new IllegalArgumentException("A friend request sent by this user does not exists.");
        } else {
            this.deleteIncomingRequest(name);
            name.getFriendManager().deletePendingRequest(this.user);
        }
    }

    /**
     * Checks whether User name exists in the friend list.
     */
    public boolean checkFriendExists(User name) {
        for (User u : this.friends) {
            if (u.getUsername().equals(name.getUsername())) {
                return true;
            }}
            return false;
        }

    /**
     * Check if there is an existing pending friend request to name.
     */
    public boolean checkPendingRequestExists(User name) {
        for (FriendRequestInputData r : this.pendingRequests) {
            if (r.getReceiver() == name) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if there is an existing incoming friend request from name.
     */
    public boolean checkIncomingRequestExists(User name) {
        for (FriendRequestInputData r : this.incomingRequests) {
            if (r.getSender() == name) {
                return true;
            }
        }
        return false;
    }

    public void addPendingRequest(FriendRequestInputData pending) { this.pendingRequests.add(pending); };

    public void deletePendingRequest(User name) {
        for (int i = 0; i < this.pendingRequests.size(); i++) {
            if (this.pendingRequests.get(i).getSender() == name) {
                this.pendingRequests.remove(i);
                return;
            }
        }
    }

    public void addIncomingRequest(FriendRequestInputData incoming) { this.incomingRequests.add(incoming); };

    public void deleteIncomingRequest(User name) {
        for (int i = 0; i < this.incomingRequests.size(); i++) {
            if (this.incomingRequests.get(i).getSender() == name) {
                this.incomingRequests.remove(i);
                return;
            }
        }

    }

}
