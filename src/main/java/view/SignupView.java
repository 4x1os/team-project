
package view;

import javax.swing.*;
import java.awt.*;
import interface_adapter.signup.SignupController;

public class SignupView extends JPanel {
    private final JTextField usernameField;
    private final JTextField emailField;
    private final JPasswordField passwordField;
    private final JPasswordField passwordConfirm;
    private final JButton submit;
    private final JButton login;
    private final SignupController signupController;

    public SignupView(SignupController signupController) {
        this.signupController = signupController;

        setLayout(new BorderLayout());
        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));

        usernameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        passwordConfirm = new JPasswordField(20);
        submit = new JButton("Sign up");
        login = new JButton("Have an account? Login here");

        // Add listener to Submit button
        submit.addActionListener(event -> {
            signupController.execute(
                    usernameField.getText(),
                    emailField.getText(),
                    new String (passwordField.getPassword()),
                    new String (passwordConfirm.getPassword())
            );
        });

        // Add listener to "Have an account? Login here"


        // UofT Market logo resized and inserted below sign up form
        ImageIcon logo = new ImageIcon(getClass().getResource("/UoftMarket.png"));
        // Resized image
        Image resizedLogo = logo.getImage().getScaledInstance(
                300, 210, Image.SCALE_SMOOTH);
        JLabel imageLogo = new JLabel(new ImageIcon(resizedLogo));

        //Sign-up fields
        form.add(new JLabel("Username:"));
        form.add(usernameField);

        form.add(new JLabel("Email:"));
        form.add(emailField);

        form.add(new JLabel("Password:"));
        form.add(passwordField);

        form.add(new JLabel("Password Confirm:"));
        form.add(passwordConfirm);

        form.add(login);
        form.add(submit);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(form);
        add(topPanel, BorderLayout.NORTH);

        add(imageLogo, BorderLayout.CENTER);
    }
}
