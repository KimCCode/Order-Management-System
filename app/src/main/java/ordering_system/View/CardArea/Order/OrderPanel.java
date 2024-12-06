package ordering_system.View.CardArea.Order;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class OrderPanel extends JPanel {
    private OrderPanelBottom orderPanelBottom;
    private OrderPanelMainArea orderPanelMainArea;

    public OrderPanel() {
        initialisePanel();
    }

    private void initialisePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(0xf5f5f5));
        add(Box.createVerticalStrut(50));
        orderPanelMainArea = new OrderPanelMainArea();
        add(orderPanelMainArea);
        orderPanelBottom = new OrderPanelBottom();
        add(orderPanelBottom);
    }
    public OrderPanelBottom getOrderPanelBottom() {
        return orderPanelBottom;
    }
    public OrderInfoPanel getOrderInfoPanel() {
        return orderPanelMainArea.getOrderInfoPanel();
    }
    public CustomerInfoPanel getCustomerInfoPanel() {
        return orderPanelMainArea.getCustomerInfoPanel();
    }
    public OrderTable getOrderTable() {
        return orderPanelMainArea.getOrderTable();
    }
}
