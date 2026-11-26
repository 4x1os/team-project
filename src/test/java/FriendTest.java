import entity.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FriendTest {
    @Test
    public void testSendFriendRequesttoStranger() {
        User u1 = new User("u1", "u1pw", "u1email");
        User u2 = new User("u2", "u2pw", "u2email");
        u1.getFriendManager().sendFriendRequest(u2);
        assertTrue(u1.getFriendManager().checkPendingRequestExists(u2));
        assertTrue(u2.getFriendManager().checkIncomingRequestExists(u1));
    }
    @Test
    public void testSendFriendRequesttoFriend() {
        User u1 = new User("u1", "u1pw", "u1email");
        User u2 = new User("u2", "u2pw", "u2email");
        u1.getFriendManager().addFriend(u2);
        u2.getFriendManager().addFriend(u1);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> {u1.getFriendManager().sendFriendRequest(u2);
                });
        }
    @Test
    public void testRejectExistingFriendRequest() {
        User u1 = new User("u1", "u1pw", "u1email");
        User u2 = new User("u2", "u2pw", "u2email");
        u1.getFriendManager().sendFriendRequest(u2);
        u2.getFriendManager().rejectFriendRequest(u1);
        assertFalse(u1.getFriendManager().checkFriendExists(u2));
        assertFalse(u2.getFriendManager().checkFriendExists(u1));
        assertFalse(u1.getFriendManager().checkPendingRequestExists(u2));
        assertFalse(u2.getFriendManager().checkIncomingRequestExists(u1));
    }
    @Test
    public void testAcceptExistingFriendRequest() {
        User u1 = new User("u1", "u1pw", "u1email");
        User u2 = new User("u2", "u2pw", "u2email");
        u1.getFriendManager().sendFriendRequest(u2);
        u2.getFriendManager().acceptFriendRequest(u1);
        assertTrue(u1.getFriendManager().checkFriendExists(u2));
        assertTrue(u2.getFriendManager().checkFriendExists(u1));
        assertFalse(u1.getFriendManager().checkPendingRequestExists(u2));
        assertFalse(u2.getFriendManager().checkIncomingRequestExists(u1));
    }
    @Test
    public void testAcceptNonExistentFriendRequest() {

    }
    @Test
    public void testRejectNonExistentFriendRequest() {

    }
}

// list of tests to implement:
// FRIEND LIST
// view friend list
// sort friend list alphabetically
// sort friend list in order of oldest to newest (do this in order of indexing list or smth)
// list of recommended users to befriend (based on who has similar predictions as
//     the user) - recommend mutual friends - graph implementation?
// view friends' ranks
//
// REQUESTING
// accept friend request
// reject friend request
// send friend request
// view friend requests
// can't send request twice

// - add to user class -> list of other users as part of friends thing