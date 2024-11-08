package ordering_system.View.CardArea.Order;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class OrderPanelMainArea extends JPanel {
    public OrderPanelMainArea() {
        initialisePanel();
    }

    private void initialisePanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        setPreferredSize(new Dimension(2300, 150));
        setMaximumSize(new Dimension(2300, 150));
        add(new CustomerInfoPanel());
        add(new OrderInfoPanel());
        add(new OrderTable());
        add(new SummaryPanel());
    }
}
