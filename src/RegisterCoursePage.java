import javax.swing.*;
import java.awt.*;

public class RegisterCoursePage extends JPanel {
    private AppWindow appWindow;

    public RegisterCoursePage(AppWindow appWindow) {
        this.appWindow = appWindow;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(51, 51, 51));
        headerPanel.setPreferredSize(new Dimension(getWidth(), 100));

        JLabel titleLabel = new JLabel("Course Registration");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        // Course Selection
        JLabel courseLabel = new JLabel("Select Course:");
        courseLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(courseLabel, gbc);

        JComboBox<String> courseComboBox = new JComboBox<>();
        for (Course course : appWindow.getCourseData().getAllCourses()) {
            courseComboBox.addItem(course.getCourseId() + " - " + course.getTitle());
        }
        formPanel.add(courseComboBox, gbc);

        // Payment Information
        JLabel paymentLabel = new JLabel("Payment Information");
        paymentLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.insets = new Insets(20, 0, 10, 0);
        formPanel.add(paymentLabel, gbc);

        // Card Number
        gbc.insets = new Insets(10, 0, 5, 0);
        JLabel cardLabel = new JLabel("Card Number:");
        cardLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(cardLabel, gbc);

        JTextField cardField = new JTextField();
        cardField.setPreferredSize(new Dimension(300, 35));
        formPanel.add(cardField, gbc);

        // Expiry Date
        JLabel expiryLabel = new JLabel("Expiry Date (MM/YY):");
        expiryLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(expiryLabel, gbc);

        JTextField expiryField = new JTextField();
        expiryField.setPreferredSize(new Dimension(300, 35));
        formPanel.add(expiryField, gbc);

        // CVV
        JLabel cvvLabel = new JLabel("CVV:");
        cvvLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(cvvLabel, gbc);

        JTextField cvvField = new JTextField();
        cvvField.setPreferredSize(new Dimension(300, 35));
        formPanel.add(cvvField, gbc);

        // Register Button
        JButton registerButton = new JButton("Complete Registration");
        registerButton.setBackground(new Color(51, 51, 51));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setPreferredSize(new Dimension(300, 40));
        gbc.insets = new Insets(20, 0, 0, 0);
        formPanel.add(registerButton, gbc);

        // Add action listener
        registerButton.addActionListener(e -> {
            if (cardField.getText().isEmpty() || expiryField.getText().isEmpty() || cvvField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Please fill in all payment details",
                    "Registration Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            String selectedCourseId = ((String) courseComboBox.getSelectedItem()).split(" - ")[0];
            Course selectedCourse = appWindow.getCourseData().getCourseById(selectedCourseId);

            if (selectedCourse != null && selectedCourse.hasAvailableSeats()) {
                User currentUser = appWindow.getUserDatabase().getCurrentUser();
                currentUser.registerCourse(selectedCourse);
                selectedCourse.incrementEnrolled();

                JOptionPane.showMessageDialog(this,
                    "Course registration successful!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                
                cardField.setText("");
                expiryField.setText("");
                cvvField.setText("");
                appWindow.refreshDashboard();
                appWindow.navigateTo("dashboard");
            } else {
                JOptionPane.showMessageDialog(this,
                    "Course is full or not available",
                    "Registration Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        add(headerPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
    }
}