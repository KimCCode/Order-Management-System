package ordering_system.View.CardArea.Dashboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class MetricCard extends RoundedPanel {
    private String imageLocation;
    private String text;
    private String value;

    public MetricCard(String imageLocation, String text, String value) {
        super(new Dimension(150, 150), new Color(0x133a94));
        this.imageLocation = imageLocation;
        this.text = text;
        this.value = value;
        initialiseCard();
        initialiseContent();
    }
    
    private void initialiseCard() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void initialiseContent() {
        add(Box.createVerticalStrut(40));
        JLabel iconLabel = new JLabel("", new ImageIcon(getClass().getResource(imageLocation)), JLabel.CENTER);
        iconLabel.setBorder(new EmptyBorder(0, 20, 0, 0));
        JLabel textLabel = new JLabel(text);
        textLabel.setBorder(new EmptyBorder(10, 20, 0, 0));
        textLabel.setFont(new Font("Arial", Font.BOLD, 18));
        textLabel.setForeground(Color.WHITE);
        JLabel valueLabel = new JLabel(value);
        valueLabel.setBorder(new EmptyBorder(10, 20, 0, 0));
        valueLabel.setFont(new Font("Arial", Font.BOLD, 18));
        valueLabel.setForeground(Color.WHITE);
        add(iconLabel);
        add(textLabel);
        add(valueLabel);
    }
}
