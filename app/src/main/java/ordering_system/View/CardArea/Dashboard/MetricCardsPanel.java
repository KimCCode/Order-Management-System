package ordering_system.View.CardArea.Dashboard;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import ordering_system.Services.OrderServiceObserver;

public class MetricCardsPanel extends JPanel implements OrderServiceObserver {
    private MetricCard inventoryMetric;
    private SalesMetric salesMetric;
    private ProfitMetric profitMetric;
    public MetricCardsPanel() {
        initialisePanel();
        initialiseMetricCards();
    }

    private void initialiseMetricCards() {
        inventoryMetric= new MetricCard("/images/inventory.png", "Stock left");
        add(inventoryMetric);
        salesMetric = new SalesMetric("/images/sales.png", "Orders");
        add(salesMetric);
        profitMetric = new ProfitMetric("/images/profit.png", "Gross Profit");
        add(profitMetric);
    }

    public void update(int totalProfit, int totalOrders) {
        profitMetric.setValue(totalProfit);
        salesMetric.setValue(totalOrders);
    }

    private void initialisePanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
        setPreferredSize(new Dimension(0, 170));
    }

    public void setProfitMetric(int value) {
        profitMetric.setValue(value);
    }

    public void setSalesMetric(int value) {
        salesMetric.setValue(value);
    }
}
