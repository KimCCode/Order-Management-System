package ordering_system.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import ordering_system.Dao.OrderDao;
import ordering_system.View.CardArea.Dashboard.DashboardPanel;

public class DashboardController {
    private DashboardPanel dashboardPanel;
    private OrderDao orderDao;

    public DashboardController(DashboardPanel dashboardPanel, OrderDao orderDao) {
        this.dashboardPanel = dashboardPanel;
        this.orderDao = orderDao;
    }
}
