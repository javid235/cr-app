import javax.swing.*;
import java.awt.*;

public class SignupPage extends JPanel {
    private AppWindow appWindow;

    public SignupPage(AppWindow appWindow) {
        this.appWindow = appWindow;
        setLayout(new GridLayout(1, 2));
        setBackground(Color.WHITE);

        // Left Panel (Image)
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(new Color(51, 51, 51));
        JLabel imageLabel = new JLabel("College Image"); // Replace with actual image
        imageLabel.setForeground(Color.WHITE);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        // Right Panel (Signup Form)
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 20, 5, 20);
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        // Title
        JLabel titleLabel = new JLabel("Sign Up");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.insets = new Insets(0, 20, 20, 20);
        formPanel.add(titleLabel, gbc);

        // Full Name Field
        JLabel fullNameLabel = new JLabel("Full Name");
        fullNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.insets = new Insets(5, 20, 5, 20);
        formPanel.add(fullNameLabel, gbc);

        JTextField fullNameField = new JTextField();
        fullNameField.setPreferredSize(new Dimension(300, 35));
        formPanel.add(fullNameField, gbc);

        // Email Field
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(emailLabel, gbc);

        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(300, 35));
        formPanel.add(emailField, gbc);

        // Username Field
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(300, 35));
        formPanel.add(usernameField, gbc);

        // Password Field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(300, 35));
        formPanel.add(passwordField, gbc);

        // Confirm Password Field
        JLabel confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(confirmPasswordLabel, gbc);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setPreferredSize(new Dimension(300, 35));
        formPanel.add(confirmPasswordField, gbc);

        // Sign Up Button
        JButton signupButton = new JButton("Sign Up");
        signupButton.setBackground(new Color(0, 82, 255));
        signupButton.setForeground(Color.WHITE);
        signupButton.setFocusPainted(false);
        signupButton.setPreferredSize(new Dimension(300, 40));
        gbc.insets = new Insets(20, 20, 5, 20);
        formPanel.add(signupButton, gbc);

        // Login Link
        JButton loginLink = new JButton("Already have an account? Login");
        loginLink.setBorderPainted(false);
        loginLink.setContentAreaFilled(false);
        loginLink.setForeground(new Color(51, 51, 51));
        loginLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.insets = new Insets(5, 20, 5, 20);
        formPanel.add(loginLink, gbc);

        // Add action listeners
        signupButton.addActionListener(e -> {
            String fullName = fullNameField.getText();
            String email = emailField.getText();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (fullName.isEmpty() || email.isEmpty() || username.isEmpty() || 
                password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Please fill in all fields",
                    "Registration Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this,
                    "Passwords do not match",
                    "Registration Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (appWindow.getUserDatabase().registerUser(username, password, email, fullName)) {
                JOptionPane.showMessageDialog(this,
                    "Registration successful! Please login.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                appWindow.navigateTo("login");
                fullNameField.setText("");
                emailField.setText("");
                usernameField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
            } else {
                JOptionPane.showMessageDialog(this,
                    "Username already exists",
                    "Registration Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        loginLink.addActionListener(e -> appWindow.navigateTo("login"));

        // Left Panel (Welcome Message)
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(new Color(0, 82, 255));
        
        JPanel welcomeTextPanel = new JPanel(new GridBagLayout());
        welcomeTextPanel.setBackground(new Color(0, 82, 255));
        GridBagConstraints welcomeGbc = new GridBagConstraints();
        welcomeGbc.gridwidth = GridBagConstraints.REMAINDER;
        welcomeGbc.anchor = GridBagConstraints.CENTER;
        
        JLabel welcomeLabel = new JLabel("Welcome to");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        
        JLabel collegeLabel = new JLabel("Jamal Mohamed College");
        collegeLabel.setForeground(Color.WHITE);
        collegeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        
        JLabel taglineLabel = new JLabel("<html><div style='text-align: center;'>Empowering students with<br>knowledge and skills for a<br>brighter future.</div></html>");
        taglineLabel.setForeground(Color.WHITE);
        taglineLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        
        welcomeTextPanel.add(welcomeLabel, welcomeGbc);
        welcomeTextPanel.add(collegeLabel, welcomeGbc);
        welcomeGbc.insets = new Insets(20, 0, 0, 0);
        welcomeTextPanel.add(taglineLabel, welcomeGbc);
        
        leftPanel.add(welcomeTextPanel, BorderLayout.CENTER);
        
        // Update the layout
        add(leftPanel);
        add(formPanel);
    }
}