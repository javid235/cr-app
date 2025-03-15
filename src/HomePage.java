import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {
    private AppWindow appWindow;

    public HomePage(AppWindow appWindow) {
        this.appWindow = appWindow;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Hero Section
        JPanel heroPanel = new JPanel(new BorderLayout());
        heroPanel.setBackground(new Color(0, 82, 255));
        heroPanel.setPreferredSize(new Dimension(getWidth(), 400));
        
        JPanel heroContent = new JPanel(new GridBagLayout());
        heroContent.setBackground(new Color(0, 82, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 40, 0, 40);

        JLabel welcomeLabel = new JLabel("Welcome to");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 48));
        
        JLabel collegeLabel = new JLabel("Jamal Mohamed College");
        collegeLabel.setForeground(Color.WHITE);
        collegeLabel.setFont(new Font("Arial", Font.BOLD, 48));
        
        JLabel taglineLabel = new JLabel("<html>Empowering students with knowledge and<br>skills for a brighter future.</html>");
        taglineLabel.setForeground(Color.WHITE);
        taglineLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        
        JButton exploreButton = new JButton("Explore Courses");
        exploreButton.setFont(new Font("Arial", Font.BOLD, 16));
        exploreButton.setBackground(Color.WHITE);
        exploreButton.setForeground(new Color(0, 82, 255));
        exploreButton.setFocusPainted(false);
        exploreButton.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        exploreButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exploreButton.addActionListener(e -> appWindow.navigateTo("courses"));

        heroContent.add(welcomeLabel, gbc);
        heroContent.add(collegeLabel, gbc);
        gbc.insets = new Insets(20, 40, 30, 40);
        heroContent.add(taglineLabel, gbc);
        gbc.insets = new Insets(10, 40, 0, 40);
        heroContent.add(exploreButton, gbc);

        heroPanel.add(heroContent, BorderLayout.CENTER);

        // Features Section
        JPanel featuresPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        featuresPanel.setBackground(Color.WHITE);
        featuresPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        featuresPanel.add(createFeatureCard(
            "Excellence in Education",
            "Providing high-quality education with modern facilities and experienced faculty.",
            "🎓"
        ));

        featuresPanel.add(createFeatureCard(
            "Industry Connection",
            "Strong ties with industry partners ensuring great career opportunities.",
            "🤝"
        ));

        featuresPanel.add(createFeatureCard(
            "Student Success",
            "Focused on holistic development with excellent placement records.",
            "🌟"
        ));

        // Main Content Panel
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(Color.WHITE);
        mainContent.add(featuresPanel, BorderLayout.NORTH);

        // Add components to main panel
        add(heroPanel, BorderLayout.NORTH);
        add(mainContent, BorderLayout.CENTER);
    }

    private JPanel createFeatureCard(String title, String description, String icon) {
        JPanel card = new JPanel(new BorderLayout(0, 20));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 48));
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JTextArea descLabel = new JTextArea(description);
        descLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descLabel.setLineWrap(true);
        descLabel.setWrapStyleWord(true);
        descLabel.setEditable(false);
        descLabel.setBackground(Color.WHITE);
        descLabel.setForeground(new Color(100, 100, 100));
        descLabel.setHighlighter(null);

        JPanel textPanel = new JPanel(new BorderLayout(0, 10));
        textPanel.setBackground(Color.WHITE);
        textPanel.add(titleLabel, BorderLayout.NORTH);
        textPanel.add(descLabel, BorderLayout.CENTER);

        card.add(iconLabel, BorderLayout.NORTH);
        card.add(textPanel, BorderLayout.CENTER);

        return card;
    }
}