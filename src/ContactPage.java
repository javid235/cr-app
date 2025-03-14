import javax.swing.*;
import java.awt.*;

public class ContactPage extends JPanel {
    public ContactPage() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(51, 51, 51));
        headerPanel.setPreferredSize(new Dimension(getWidth(), 100));

        JLabel titleLabel = new JLabel("Contact Us");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        // Name Field
        gbc.gridy = 0;
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(nameLabel, gbc);

        gbc.gridy = 1;
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(600, 30));
        formPanel.add(nameField, gbc);

        // Email Field
        gbc.gridy = 2;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(emailLabel, gbc);

        gbc.gridy = 3;
        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(600, 30));
        formPanel.add(emailField, gbc);

        // Message Field
        gbc.gridy = 4;
        JLabel messageLabel = new JLabel("Message:");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(messageLabel, gbc);

        gbc.gridy = 5;
        JTextArea messageArea = new JTextArea();
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        messageArea.setPreferredSize(new Dimension(600, 150));
        JScrollPane messageScroll = new JScrollPane(messageArea);
        formPanel.add(messageScroll, gbc);

        // Submit Button
        gbc.gridy = 6;
        gbc.insets = new Insets(20, 0, 0, 0);
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(0, 82, 255));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setPreferredSize(new Dimension(600, 40));
        submitButton.addActionListener(e -> {
            if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || messageArea.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Please fill in all fields",
                    "Incomplete Form",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this,
                "Thank you for your message! We will get back to you soon.",
                "Message Sent",
                JOptionPane.INFORMATION_MESSAGE);
            nameField.setText("");
            emailField.setText("");
            messageArea.setText("");
        });
        formPanel.add(submitButton, gbc);

        add(headerPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
    }
}