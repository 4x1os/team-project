import entity.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FriendTest {
    User u1 = new User("u1", "u1pw", "u1email");
    User u2 = new User("u2", "u2pw", "u2email");
    @Test
    public void testSendFriendRequesttoStranger() {
        u1.getFriendManager().sendFriendRequest(u2);
        assertTrue(u1.getFriendManager().checkPendingRequestExists(u2));
        assertTrue(u2.getFriendManager().checkIncomingRequestExists(u1));
        assertFalse(u1.getFriendManager().getPendingRequest(u2).getStatus());
    }
    @Test
    public void testSendFriendRequestTwice() {
        u1.getFriendManager().sendFriendRequest(u2);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    u1.getFriendManager().sendFriendRequest(u2);
                });
    }
    @Test
    public void testSendFriendRequesttoFriend() {
        u1.getFriendManager().addFriend(u2);
        u2.getFriendManager().addFriend(u1);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> {u1.getFriendManager().sendFriendRequest(u2);
                });
        }
    @Test
    public void testCancelFriendRequest() {
        u1.getFriendManager().sendFriendRequest(u2);
        u1.getFriendManager().cancelFriendRequest(u2);
        assertFalse(u1.getFriendManager().checkPendingRequestExists(u2));
        assertFalse(u2.getFriendManager().checkIncomingRequestExists(u1));
    }
    @Test
    public void testRejectExistingFriendRequest() {
        u1.getFriendManager().sendFriendRequest(u2);
        u2.getFriendManager().rejectFriendRequest(u1);
        assertFalse(u1.getFriendManager().checkFriendExists(u2));
        assertFalse(u2.getFriendManager().checkFriendExists(u1));
        assertFalse(u1.getFriendManager().checkPendingRequestExists(u2));
        assertFalse(u2.getFriendManager().checkIncomingRequestExists(u1));
    }
    @Test
    public void testAcceptExistingFriendRequest() {
        u1.getFriendManager().sendFriendRequest(u2);
        u2.getFriendManager().acceptFriendRequest(u1);
        assertTrue(u1.getFriendManager().checkFriendExists(u2));
        assertTrue(u2.getFriendManager().checkFriendExists(u1));
        assertFalse(u1.getFriendManager().checkPendingRequestExists(u2));
        assertFalse(u2.getFriendManager().checkIncomingRequestExists(u1));
    }
    @Test
    public void testAcceptNonExistentFriendRequest() {
        assertThrows(IllegalArgumentException.class, () -> {
                    u1.getFriendManager().acceptFriendRequest(u2);
                });
    }
    @Test
    public void testRejectNonExistentFriendRequest() {
        assertThrows(IllegalArgumentException.class, () -> {
                    u1.getFriendManager().rejectFriendRequest(u2);
                });
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
// view friend requests
