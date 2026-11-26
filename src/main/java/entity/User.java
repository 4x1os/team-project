package entity;
import entity.FriendManager;

public class User {
    private String username;
    private String password;
    private String email;
    private boolean admin = false;
    private int points = 0;
    private FriendManager friend;
    // Need to add Stats of success, bets, profit, and rating

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.friend = new FriendManager(this);
    }

    public String getUsername() { return this.username; }

    public FriendManager getFriendManager() { return this.friend; }
}
