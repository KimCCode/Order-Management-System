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
    JComboBox<String> sizeComboBox;
    JComboBox<String> flavourComboBox;
    JSpinner qtySpinner;

    public OrderInfoPanel() {
        initialisePanel();
    }

    private void initialisePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new LineBorder(Color.GRAY, 1));
        setPreferredSize(new Dimension(200, 120));
        add(Box.createVerticalGlue());
        sizeComboBox = new JComboBox<>(sizes);
        flavourComboBox = new JComboBox<>(flavours);
        add(new InfoPanel("Size", sizeComboBox));
        add(new InfoPanel("Flavour", flavourComboBox));
        qtySpinner = new JSpinner();
        qtySpinner.setPreferredSize(new Dimension(50, 20));
        add(new InfoPanel("Qty", qtySpinner));
        add(Box.createVerticalGlue());
    }

    public String getMooncakeSize() {
        return (String) sizeComboBox.getSelectedItem();
    }

    public String getFlavour() {
        return (String) flavourComboBox.getSelectedItem();
    }

    public int getQty() {
        return (Integer) qtySpinner.getValue();
    }
}
