import javax.swing.*;
import java.awt.*;

public class AboutPage extends JPanel {
    public AboutPage() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(51, 51, 51));
        headerPanel.setPreferredSize(new Dimension(getWidth(), 100));

        JLabel titleLabel = new JLabel("About Our College");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        // Content Panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        // About Text
        JTextArea aboutText = new JTextArea();
        aboutText.setFont(new Font("Arial", Font.PLAIN, 16));
        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);
        aboutText.setEditable(false);
        aboutText.setBackground(Color.WHITE);
        aboutText.setText(
            "Welcome to our prestigious institution of higher learning! \n\n" +
            "Founded in 1990, our college has been at the forefront of academic excellence " +
            "and innovation for over three decades. We are committed to providing quality " +
            "education that prepares our students for successful careers and meaningful lives.\n\n" +
            "Our Mission:\n" +
            "To empower students with knowledge, skills, and values that enable them to " +
            "excel in their chosen fields and contribute positively to society.\n\n" +
            "Key Features:\n" +
            "• State-of-the-art facilities and modern infrastructure\n" +
            "• Highly qualified and experienced faculty members\n" +
            "• Industry-aligned curriculum\n" +
            "• Strong industry partnerships\n" +
            "• Excellent placement record\n" +
            "• Vibrant campus life\n\n" +
            "We offer a wide range of undergraduate and graduate programs across various " +
            "disciplines, ensuring that our students receive a well-rounded education that " +
            "prepares them for the challenges of tomorrow."
        );

        // Scroll Pane for content
        JScrollPane scrollPane = new JScrollPane(aboutText);
        scrollPane.setBorder(null);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }
}