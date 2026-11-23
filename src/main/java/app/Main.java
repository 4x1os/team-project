package app;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppBuilder app = new AppBuilder();
            JFrame application = app.startup();
            application.setVisible(true);
        });
    }
}