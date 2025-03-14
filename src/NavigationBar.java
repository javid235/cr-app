import javax.swing.*;
import java.awt.*;

public class NavigationBar extends JPanel {
    private AppWindow appWindow;
    private JButton homeBtn, coursesBtn, loginBtn, signupBtn, dashboardBtn, aboutBtn, contactBtn, logoutBtn;
    private JPanel leftPanel, rightPanel;

    public NavigationBar(AppWindow appWindow) {
        this.appWindow = appWindow;
        setLayout(new BorderLayout());
        setBackground(new Color(51, 51, 51));

        leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        leftPanel.setBackground(new Color(51, 51, 51));

        rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        rightPanel.setBackground(new Color(51, 51, 51));

        initializeButtons();
        addButtons();

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }

    private void initializeButtons() {
        homeBtn = createNavButton("Home", "home");
        coursesBtn = createNavButton("Courses", "courses");
        loginBtn = createNavButton("Login", "login");
        signupBtn = createNavButton("Sign Up", "signup");
        dashboardBtn = createNavButton("Dashboard", "dashboard");
        aboutBtn = createNavButton("About", "about");
        contactBtn = createNavButton("Contact", "contact");
        logoutBtn = createNavButton("Logout", "");

        logoutBtn.addActionListener(e -> {
            appWindow.getUserDatabase().logout();
            appWindow.navigateTo("home");
            updateButtons();
        });
    }

    private JButton createNavButton(String text, String page) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(51, 51, 51));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        
        if (!page.isEmpty()) {
            button.addActionListener(e -> appWindow.navigateTo(page));
        }
        
        return button;
    }

    private void addButtons() {
        leftPanel.add(homeBtn);
        leftPanel.add(coursesBtn);
        leftPanel.add(aboutBtn);
        leftPanel.add(contactBtn);
        updateButtons();
    }

    public void updateButtons() {
        rightPanel.removeAll();
        if (appWindow.getUserDatabase().isLoggedIn()) {
            rightPanel.add(dashboardBtn);
            rightPanel.add(logoutBtn);
        } else {
            rightPanel.add(loginBtn);
            rightPanel.add(signupBtn);
        }
        rightPanel.revalidate();
        rightPanel.repaint();
    }
}