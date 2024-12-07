package ordering_system.Controller;

import javax.swing.table.DefaultTableModel;

import ordering_system.Services.OrderService;
import ordering_system.View.CardArea.ViewOrder.ViewOrderPanel;

public class ViewOrderController {
    private ViewOrderPanel viewOrderPanel;
    private OrderService orderService;

    public ViewOrderController(ViewOrderPanel viewOrderPanel, OrderService orderService) {
        this.viewOrderPanel = viewOrderPanel;
        this.orderService = orderService;
        viewOrderPanel.setSearchAction(e -> displayOrdersByName());
        viewOrderPanel.setOrdersTableModel(orderService.displayOrders());

    }

    public void displayOrdersByName() {
        DefaultTableModel tableModel = orderService.displayOrdersByName(viewOrderPanel.getSearchField());
        viewOrderPanel.setOrdersTableModel(tableModel);
    }
}
