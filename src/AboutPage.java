import javax.swing.*;
import java.awt.*;

public class AboutPage extends JPanel {
    public AboutPage() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Hero Section
        JPanel heroPanel = new JPanel(new BorderLayout());
        heroPanel.setBackground(new Color(0, 82, 255));
        heroPanel.setPreferredSize(new Dimension(getWidth(), 300));

        JPanel heroContent = new JPanel(new GridBagLayout());
        heroContent.setBackground(new Color(0, 82, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 40, 0, 40);

        JLabel titleLabel = new JLabel("About Our College");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitleLabel = new JLabel("Shaping Tomorrow's Leaders Since 1990");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        subtitleLabel.setForeground(Color.WHITE);
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        heroContent.add(titleLabel, gbc);
        gbc.insets = new Insets(10, 40, 0, 40);
        heroContent.add(subtitleLabel, gbc);

        heroPanel.add(heroContent, BorderLayout.CENTER);

        // Content Panel
        JPanel contentPanel = new JPanel(new BorderLayout(0, 30));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));

        // Mission Panel
        JPanel missionPanel = createInfoCard(
            "🎯",
            "Our Mission",
            "To empower students with knowledge, skills, and values that enable them to " +
            "excel in their chosen fields and contribute positively to society."
        );

        // History Panel
        JPanel historyPanel = createInfoCard(
            "📚",
            "Our History",
            "Founded in 1990, our college has been at the forefront of academic excellence " +
            "and innovation for over three decades. We are committed to providing quality " +
            "education that prepares our students for successful careers and meaningful lives."
        );

        // Features Panel
        JPanel featuresPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        featuresPanel.setBackground(Color.WHITE);
        featuresPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        featuresPanel.add(createFeatureCard(
            "🏛️",
            "Modern Facilities",
            "State-of-the-art infrastructure and learning resources"
        ));

        featuresPanel.add(createFeatureCard(
            "👨‍🏫",
            "Expert Faculty",
            "Highly qualified and experienced teaching staff"
        ));

        featuresPanel.add(createFeatureCard(
            "🤝",
            "Industry Connect",
            "Strong partnerships with leading companies"
        ));

        // Combine all panels
        JPanel mainContent = new JPanel(new BorderLayout(0, 30));
        mainContent.setBackground(Color.WHITE);
        mainContent.add(missionPanel, BorderLayout.NORTH);
        mainContent.add(historyPanel, BorderLayout.CENTER);
        mainContent.add(featuresPanel, BorderLayout.SOUTH);

        // Add scroll capability
        JScrollPane scrollPane = new JScrollPane(mainContent);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Add all sections to main panel
        add(heroPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }

    private JPanel createInfoCard(String icon, String title, String content) {
        JPanel card = new JPanel(new BorderLayout(0, 15));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            BorderFactory.createEmptyBorder(25, 30, 25, 30)
        ));

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 36));
        iconLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(51, 51, 51));

        JTextArea contentLabel = new JTextArea(content);
        contentLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        contentLabel.setLineWrap(true);
        contentLabel.setWrapStyleWord(true);
        contentLabel.setEditable(false);
        contentLabel.setBackground(Color.WHITE);
        contentLabel.setForeground(new Color(100, 100, 100));

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(iconLabel);
        headerPanel.add(titleLabel);

        card.add(headerPanel, BorderLayout.NORTH);
        card.add(contentLabel, BorderLayout.CENTER);

        return card;
    }

    private JPanel createFeatureCard(String icon, String title, String description) {
        JPanel card = new JPanel(new BorderLayout(0, 10));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 32));
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel descLabel = new JLabel("<html><div style='text-align: center;'>"+description+"</div></html>");
        descLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descLabel.setForeground(new Color(100, 100, 100));
        descLabel.setHorizontalAlignment(SwingConstants.CENTER);

        card.add(iconLabel, BorderLayout.NORTH);
        card.add(titleLabel, BorderLayout.CENTER);
        card.add(descLabel, BorderLayout.SOUTH);

        return card;
    }
}