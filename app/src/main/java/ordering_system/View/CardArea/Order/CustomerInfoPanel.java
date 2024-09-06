package ordering_system.View.CardArea.Order;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CustomerInfoPanel extends JPanel {
    private String[] infos = {"Name", "Phone", "Date"};
    public CustomerInfoPanel() {
        initialisePanel();
    }

    private void initialisePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new LineBorder(Color.GRAY, 1));
        setPreferredSize(new Dimension(200, 120));
        add(Box.createVerticalGlue());
        for (String info : infos) {
            JTextField field = new JTextField(10);
            field.setBorder(new LineBorder(Color.BLACK, 1));
            add(new InfoPanel(info, field));
        }
        add(Box.createVerticalGlue());
    }
}
