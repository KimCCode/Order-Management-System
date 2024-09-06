package ordering_system.View.CardArea.Order;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;

public class OrderInfoPanel extends JPanel {
    private String[] sizes = {"Small", "Medium", "Large", "Combo"};
    private String[] flavours = {"Rainbow", "Taro", "Mungbean", "Durian"};

    public OrderInfoPanel() {
        initialisePanel();
    }

    private void initialisePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new LineBorder(Color.GRAY, 1));
        setPreferredSize(new Dimension(200, 120));
        add(Box.createVerticalGlue());
        add(new InfoPanel("Size", new JComboBox<String>(sizes)));
        add(new InfoPanel("Flavour", new JComboBox<String>(flavours)));
        JSpinner jSpinner = new JSpinner();
        jSpinner.setPreferredSize(new Dimension(50, 20));
        add(new InfoPanel("Qty", jSpinner));
        add(Box.createVerticalGlue());
    }
}
