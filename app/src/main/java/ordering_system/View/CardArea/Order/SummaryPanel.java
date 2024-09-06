package ordering_system.View.CardArea.Order;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class SummaryPanel extends JPanel {
    public SummaryPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(160, 120));
        setBorder(new LineBorder(Color.GRAY, 1));
        JTextField totalField = new JTextField(5);
        totalField.setBorder(new LineBorder(Color.BLACK, 1));

        JTextField taxField = new JTextField(5);
        taxField.setBorder(new LineBorder(Color.BLACK, 1));
        add(Box.createVerticalGlue());
        add(new InfoPanel("Total", totalField));
        add(new InfoPanel("Tax", taxField));
        add(Box.createVerticalGlue());
    }
}
