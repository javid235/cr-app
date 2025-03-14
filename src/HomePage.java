import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {
    public HomePage() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Welcome Panel
        JPanel welcomePanel = new JPanel(new BorderLayout());
        welcomePanel.setBackground(new Color(51, 51, 51));
        welcomePanel.setPreferredSize(new Dimension(getWidth(), 300));

        JLabel welcomeLabel = new JLabel("Welcome to Our College");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 48));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        JLabel subtitleLabel = new JLabel("Empowering Minds, Shaping Futures");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        subtitleLabel.setForeground(new Color(200, 200, 200));
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        subtitleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        welcomePanel.add(subtitleLabel, BorderLayout.SOUTH);

        // Content Panel
        JPanel contentPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        // Add feature cards
        contentPanel.add(createFeatureCard("Excellence in Education", "Our college offers world-class education with state-of-the-art facilities."));
        contentPanel.add(createFeatureCard("Expert Faculty", "Learn from industry experts and renowned academicians."));
        contentPanel.add(createFeatureCard("Career Support", "Comprehensive career guidance and placement assistance."));
        contentPanel.add(createFeatureCard("Modern Campus", "Experience learning in our modern, tech-enabled campus."));

        add(welcomePanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }

    private JPanel createFeatureCard(String title, String description) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(51, 51, 51));

        JTextArea descLabel = new JTextArea(description);
        descLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descLabel.setForeground(new Color(102, 102, 102));
        descLabel.setLineWrap(true);
        descLabel.setWrapStyleWord(true);
        descLabel.setEditable(false);
        descLabel.setBackground(Color.WHITE);
        descLabel.setBorder(null);

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(descLabel, BorderLayout.CENTER);

        return card;
    }
}