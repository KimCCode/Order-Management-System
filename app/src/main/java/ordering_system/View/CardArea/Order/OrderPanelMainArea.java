package ordering_system.View.CardArea.Order;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class OrderPanelMainArea extends JPanel {
    private OrderInfoPanel orderInfoPanel;
    private CustomerInfoPanel customerInfoPanel;
    private OrderTable orderTable;
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
        orderTable = new OrderTable(350, 120);
        add(orderTable);
        add(new SummaryPanel());
    }

    public OrderInfoPanel getOrderInfoPanel() {
        return orderInfoPanel;
    }

    public CustomerInfoPanel getCustomerInfoPanel() {
        return customerInfoPanel;
    }

    public OrderTable getOrderTable() {
        return orderTable;
    }
}
