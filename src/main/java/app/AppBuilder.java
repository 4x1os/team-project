package app;

import javax.swing.*;
// WILL HAVE TO EVENTUALLY REPLACE application.add(signupView); with viewManager
import view.SignupView;
import interface_adapter.signup.SignupController;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;

public class AppBuilder {
    public JFrame startup() {
        final JFrame application = new JFrame("UofT Polymarket - Sign up");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Creates sign up interactor, controller to the interactor, view to the controller
        SignupInteractor signupInteractor = new SignupInteractor();
        SignupController signupController = new SignupController(signupInteractor);
        SignupView signupView = new SignupView(signupController);

        application.add(signupView);
        application.setSize(550, 250);
        application.setLocation(0,0);
        //application.setLocationRelativeTo(null);
        return application;
    }
}
