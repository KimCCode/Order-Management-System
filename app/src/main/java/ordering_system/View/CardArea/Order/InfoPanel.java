package ordering_system.View.CardArea.Order;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {
    public InfoPanel(String string, Component component) {
        setOpaque(true);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(string);
        label.setPreferredSize(new Dimension(50, 20));
        add(label);
        add(component);
    }

}
