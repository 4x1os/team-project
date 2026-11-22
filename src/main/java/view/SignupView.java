
package view;

import javax.swing.*;
import java.awt.*;

public class SignupView extends JPanel {
    private final JTextField usernameField;
    private final JTextField emailField;
    private final JPasswordField passwordField;
    private final JPasswordField passwordConfirm;
    private final JButton submit;
    private final JButton login;

    public SignupView() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));

        usernameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        passwordConfirm = new JPasswordField(20);
        submit = new JButton("Sign up");
        login = new JButton("Have an account? Login here");

        // Taken image from resources
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
