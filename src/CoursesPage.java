import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CoursesPage extends JPanel {
    private AppWindow appWindow;

    public CoursesPage(AppWindow appWindow) {
        this.appWindow = appWindow;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(51, 51, 51));
        headerPanel.setPreferredSize(new Dimension(getWidth(), 100));

        JLabel titleLabel = new JLabel("Available Courses");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        // Courses Panel
        JPanel coursesPanel = new JPanel(new GridLayout(0, 2, 20, 20));
        coursesPanel.setBackground(Color.WHITE);
        coursesPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add course cards
        List<Course> courses = appWindow.getCourseData().getAllCourses();
        for (Course course : courses) {
            coursesPanel.add(createCourseCard(course));
        }

        // Wrap coursesPanel in a container for proper sizing
        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.setBackground(Color.WHITE);
        containerPanel.add(coursesPanel, BorderLayout.NORTH);

        // Scroll Pane for courses
        JScrollPane scrollPane = new JScrollPane(containerPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);

        add(headerPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createCourseCard(Course course) {
        JPanel card = new JPanel(new BorderLayout(15, 15));
        card.setBackground(new Color(240, 240, 240));
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        ));
        card.setPreferredSize(new Dimension(500, 250));
        card.setMaximumSize(new Dimension(600, 300));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));

        // Left content panel
        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.setBackground(new Color(240, 240, 240));

        // Course name and description
        JPanel courseInfoPanel = new JPanel(new BorderLayout(5, 5));
        courseInfoPanel.setBackground(new Color(240, 240, 240));

        JLabel nameLabel = new JLabel(course.getTitle());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JTextArea descriptionArea = new JTextArea(course.getDescription());
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setBackground(new Color(240, 240, 240));

        courseInfoPanel.add(nameLabel, BorderLayout.NORTH);
        courseInfoPanel.add(descriptionArea, BorderLayout.CENTER);

        contentPanel.add(courseInfoPanel, BorderLayout.CENTER);

        // Right panel for slot availability, price and register button
        JPanel rightPanel = new JPanel(new BorderLayout(10, 10));
        rightPanel.setBackground(new Color(240, 240, 240));
        rightPanel.setPreferredSize(new Dimension(200, 0));

        // Slot availability
        JLabel slotLabel = new JLabel(String.format("%d slots available", 
            course.getCapacity() - course.getEnrolled()));
        slotLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        slotLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Price and register button panel
        JPanel priceRegisterPanel = new JPanel(new BorderLayout(5, 5));
        priceRegisterPanel.setBackground(new Color(240, 240, 240));

        JLabel priceLabel = new JLabel(String.format("Rs %.2f", course.getFee()));
        priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JButton registerButton = new JButton("Register");
        registerButton.setBackground(new Color(0, 102, 255));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.addActionListener(e -> {
            if (!appWindow.getUserDatabase().isLoggedIn()) {
                JOptionPane.showMessageDialog(this,
                    "Please log in to register for courses",
                    "Login Required",
                    JOptionPane.INFORMATION_MESSAGE);
                appWindow.navigateTo("login");
                return;
            }
            if (!course.hasAvailableSeats()) {
                JOptionPane.showMessageDialog(this,
                    "Sorry, this course is full",
                    "Course Full",
                    JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            appWindow.navigateTo("register");
        });

        priceRegisterPanel.add(priceLabel, BorderLayout.NORTH);
        priceRegisterPanel.add(registerButton, BorderLayout.CENTER);

        rightPanel.add(slotLabel, BorderLayout.NORTH);
        rightPanel.add(priceRegisterPanel, BorderLayout.SOUTH);

        // Add panels to card
        card.add(contentPanel, BorderLayout.CENTER);
        card.add(rightPanel, BorderLayout.EAST);

        return card;
    }
}