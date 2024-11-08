package ordering_system.View.CardArea.Order;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class OrderPanelMainArea extends JPanel {
    OrderInfoPanel orderInfoPanel;
    CustomerInfoPanel customerInfoPanel;
    public OrderPanelMainArea() {
        initialisePanel();
    }

    private void initialisePanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        setPreferredSize(new Dimension(2300, 150));
        setMaximumSize(new Dimension(2300, 150));
        customerInfoPanel = new CustomerInfoPanel();
        add(customerInfoPanel);
        orderInfoPanel = new OrderInfoPanel();
        add(orderInfoPanel);
        add(new OrderTable());
        add(new SummaryPanel());
    }

    public OrderInfoPanel getOrderInfoPanel() {
        return orderInfoPanel;
    }

    public CustomerInfoPanel getCustomerInfoPanel() {
        return customerInfoPanel;
    }
}
