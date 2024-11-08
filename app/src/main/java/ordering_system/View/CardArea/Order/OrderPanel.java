package ordering_system.View.CardArea.Order;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class OrderPanel extends JPanel {
    OrderPanelBottom orderPanelBottom;
    OrderPanelMainArea orderPanelMainArea;

    public OrderPanel() {
        initialisePanel();
    }

    private void initialisePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
}
