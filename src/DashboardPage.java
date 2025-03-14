import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DashboardPage extends JPanel {
    private AppWindow appWindow;
    private JPanel contentPanel;

    public DashboardPage(AppWindow appWindow) {
        this.appWindow = appWindow;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        refreshContent();
    }

    public void refreshContent() {
        removeAll();
        User currentUser = appWindow.getUserDatabase().getCurrentUser();
        if (currentUser == null) {
            appWindow.navigateTo("login");
            return;
        }

        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(51, 51, 51));
        headerPanel.setPreferredSize(new Dimension(getWidth(), 100));

        JLabel welcomeLabel = new JLabel("Welcome, " + currentUser.getFullName() + "!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        headerPanel.add(welcomeLabel, BorderLayout.CENTER);

        // Main Content Panel
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        // User Info Panel
        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setLayout(new BoxLayout(userInfoPanel, BoxLayout.Y_AXIS));
        userInfoPanel.setBackground(Color.WHITE);
        userInfoPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        userInfoPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));

        JLabel profileTitle = new JLabel("Profile Information");
        profileTitle.setFont(new Font("Arial", Font.BOLD, 20));
        profileTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel infoGrid = new JPanel(new GridLayout(3, 1, 5, 5));
        infoGrid.setBackground(Color.WHITE);
        infoGrid.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel nameLabel = new JLabel("Name: " + currentUser.getFullName());
        JLabel emailLabel = new JLabel("Email: " + currentUser.getEmail());
        JLabel usernameLabel = new JLabel("Username: " + currentUser.getUsername());

        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        infoGrid.add(nameLabel);
        infoGrid.add(emailLabel);
        infoGrid.add(usernameLabel);

        userInfoPanel.add(profileTitle);
        userInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        userInfoPanel.add(infoGrid);

        // Registered Courses Panel
        JPanel coursesPanel = new JPanel();
        coursesPanel.setLayout(new BoxLayout(coursesPanel, BoxLayout.Y_AXIS));
        coursesPanel.setBackground(Color.WHITE);
        coursesPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JLabel coursesTitle = new JLabel("Registered Courses");
        coursesTitle.setFont(new Font("Arial", Font.BOLD, 20));
        coursesTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        coursesPanel.add(coursesTitle);
        coursesPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        List<Course> registeredCourses = currentUser.getRegisteredCourses();
        if (registeredCourses.isEmpty()) {
            JLabel noCoursesLabel = new JLabel("No courses registered yet");
            noCoursesLabel.setFont(new Font("Arial", Font.ITALIC, 14));
            noCoursesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            coursesPanel.add(noCoursesLabel);
        } else {
            JPanel coursesGrid = new JPanel(new GridLayout(0, 1, 10, 10));
            coursesGrid.setBackground(Color.WHITE);
            coursesGrid.setAlignmentX(Component.LEFT_ALIGNMENT);

            for (Course course : registeredCourses) {
                coursesGrid.add(createCoursePanel(course));
            }

            JScrollPane scrollPane = new JScrollPane(coursesGrid);
            scrollPane.setBorder(null);
            scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
            coursesPanel.add(scrollPane);
        }

        contentPanel.add(userInfoPanel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        contentPanel.add(coursesPanel);

        add(headerPanel, BorderLayout.NORTH);
        add(new JScrollPane(contentPanel), BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private JPanel createCoursePanel(Course course) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));

        JLabel courseIdLabel = new JLabel(course.getCourseId() + " - " + course.getTitle());
        courseIdLabel.setFont(new Font("Arial", Font.BOLD, 14));
        courseIdLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel instructorLabel = new JLabel("Instructor: " + course.getInstructor());
        instructorLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        instructorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel creditsLabel = new JLabel("Credits: " + course.getCredits());
        creditsLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        creditsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(courseIdLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(instructorLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(creditsLabel);

        return panel;
    }
}