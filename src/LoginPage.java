import javax.swing.*;
import java.awt.*;

public class LoginPage extends JPanel {
    private AppWindow appWindow;

    public LoginPage(AppWindow appWindow) {
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

        // Right Panel (Login Form)
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 20, 5, 20);
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        // Title
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.insets = new Insets(0, 20, 20, 20);
        formPanel.add(titleLabel, gbc);

        // Username Field
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.insets = new Insets(5, 20, 5, 20);
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

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(0, 82, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setPreferredSize(new Dimension(300, 40));
        gbc.insets = new Insets(20, 20, 5, 20);
        formPanel.add(loginButton, gbc);

        // Sign Up Link
        JButton signupLink = new JButton("Don't have an account? Sign Up");
        signupLink.setBorderPainted(false);
        signupLink.setContentAreaFilled(false);
        signupLink.setForeground(new Color(51, 51, 51));
        signupLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.insets = new Insets(5, 20, 5, 20);
        formPanel.add(signupLink, gbc);

        // Add action listeners
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Please fill in all fields",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (appWindow.getUserDatabase().login(username, password)) {
                appWindow.updateNavigationBar();
                appWindow.refreshDashboard();
                appWindow.navigateTo("courses");
                usernameField.setText("");
                passwordField.setText("");
            } else {
                JOptionPane.showMessageDialog(this,
                    "Invalid username or password",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        signupLink.addActionListener(e -> appWindow.navigateTo("signup"));

        // Left Panel (Welcome Message)
        JPanel leftPanel = new JPanel(new BorderLayout());        leftPanel.setBackground(new Color(0, 82, 255));
        
        JPanel welcomeTextPanel = new JPanel(new GridBagLayout());
        welcomeTextPanel.setBackground(new Color(0, 82, 255));
        GridBagConstraints welcomeGbc = new GridBagConstraints();
        welcomeGbc.gridwidth = GridBagConstraints.REMAINDER;
        welcomeGbc.anchor = GridBagConstraints.WEST;
        welcomeGbc.insets = new Insets(0, 40, 0, 40);
        
        JLabel welcomeLabel = new JLabel("Welcome to");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        
        JLabel collegeLabel = new JLabel("Jamal Mohamed College");
        collegeLabel.setForeground(Color.WHITE);
        collegeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        
        JLabel taglineLabel = new JLabel("<html>Empowering students with<br>knowledge and skills for a<br>brighter future.</html>");
        taglineLabel.setForeground(Color.WHITE);
        taglineLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        
        welcomeTextPanel.add(welcomeLabel, welcomeGbc);
        welcomeTextPanel.add(collegeLabel, welcomeGbc);
        welcomeGbc.insets = new Insets(20, 40, 0, 40);
        welcomeTextPanel.add(taglineLabel, welcomeGbc);
        
        leftPanel.add(welcomeTextPanel, BorderLayout.CENTER);
        
        // Update the layout
        add(leftPanel);
        add(formPanel);
    }
}