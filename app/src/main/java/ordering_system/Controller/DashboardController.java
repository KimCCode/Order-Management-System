package ordering_system.Controller;

import ordering_system.Dao.OrderDao;
import ordering_system.Services.OrderService;
import ordering_system.View.CardArea.Dashboard.MetricCardsPanel;

public class DashboardController {
    private MetricCardsPanel metricCardsPanel;
    private OrderDao orderDao;

    public DashboardController(MetricCardsPanel metricCardsPanel, OrderDao orderDao, OrderService orderService) {
        this.metricCardsPanel = metricCardsPanel;
        this.orderDao = orderDao;
        orderService.subscribe(metricCardsPanel);
        int a[] = orderDao.getProfitAndOrders();
        metricCardsPanel.setProfitMetric(a[0]);
        metricCardsPanel.setSalesMetric(a[1]);
    }
}
