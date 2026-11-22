package app;

import view.SignupView;
import javax.swing.*;

public class AppBuilder {
    public JFrame startup() {
        final JFrame application = new JFrame("UofT Polymarket - Sign up");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        SignupView signupView = new SignupView();
        application.add(signupView);
        application.setSize(550, 250);
        application.setLocation(0,0);
        //application.setLocationRelativeTo(null);
        return application;
    }
}
