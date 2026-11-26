package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import entity.User;
import interface_adapter.friend_system.FriendlistController;

public class FriendsListView extends JPanel {
    private final JTextField searchName;
    private final JButton searchButton;
    private JList friendslist;
    // private ... TODO: sort friends alphabetically by username, and by date added
    private final FriendlistController friendslistcontroller;

    public FriendsListView(FriendlistController friendslistcontroller) {
        this.friendslistcontroller = friendslistcontroller;

        JTextField searchField = createSearchField(...);


        searchName = new JTextField();

        searchButton = new JButton("Search");

    }

    public static JTextField createSearchField(List<String> friends) {
        JTextField searchField = new JTextField(20);
        JPopupMenu drop = new JPopupMenu();
        drop.setFocusable(false);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> suggestedFriends = new JList<>(listModel);
        suggestedFriends.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        suggestedFriends.setFocusable(false);

        JScrollPane scroll = new JScrollPane(suggestedFriends);
        scroll.setBorder(null);
        drop.add(scroll);

        Runnable commitSelection

    }

}
