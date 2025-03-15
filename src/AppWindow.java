import javax.swing.*;
import java.awt.*;

public class AppWindow extends JFrame {
    private CardLayout cardLayout;
    private JPanel contentPanel;
    private NavigationBar navigationBar;
    private UserDatabase userDatabase;
    private CourseData courseData;
    private RegisterCoursePage registerPage;
    
    public AppWindow() {
        setTitle("Course Registration System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(800, 600));

        // Initialize data
        userDatabase = new UserDatabase();
        courseData = new CourseData();

        // Setup layout
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        
        // Initialize navigation bar
        navigationBar = new NavigationBar(this);
        // Set initial visibility based on home page
        navigationBar.setVisible(true);
        
        // Setup main layout
        setLayout(new BorderLayout());
        add(navigationBar, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);

        // Add pages
        contentPanel.add(new HomePage(this), "home");
        contentPanel.add(new CoursesPage(this), "courses");
        contentPanel.add(new LoginPage(this), "login");
        contentPanel.add(new SignupPage(this), "signup");
        contentPanel.add(new DashboardPage(this), "dashboard");
        contentPanel.add(new AboutPage(), "about");
        contentPanel.add(new ContactPage(), "contact");
        registerPage = new RegisterCoursePage(this);
        contentPanel.add(registerPage, "register");

        // Show home page by default and update navigation bar visibility
        navigateTo("home");
    }

    public void navigateTo(String page) {
        navigateTo(page, null);
    }

    public void navigateTo(String page, String param) {
        cardLayout.show(contentPanel, page);
        if (page.equals("register") && param != null) {
            contentPanel.remove(registerPage);
            registerPage = new RegisterCoursePage(this, param);
            contentPanel.add(registerPage, "register");
            cardLayout.show(contentPanel, "register");
        }
        // Show navigation bar for all pages except login and signup
        navigationBar.setVisible(!page.equals("login") && !page.equals("signup"));
    }

    public UserDatabase getUserDatabase() {
        return userDatabase;
    }

    public CourseData getCourseData() {
        return courseData;
    }

    public void updateNavigationBar() {
        navigationBar.updateButtons();
    }

    public DashboardPage getDashboardPage() {
        return (DashboardPage) contentPanel.getComponent(4);
    }

    public void refreshDashboard() {
        if (userDatabase.isLoggedIn()) {
            getDashboardPage().refreshContent();
        }
    }
}