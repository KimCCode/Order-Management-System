package ordering_system.View.CardArea.Dashboard;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class MetricCardsPanel extends JPanel {
    private MetricCard inventoryMetric;
    private MetricCard salesMetric;
    private MetricCard profitMetric;
    public MetricCardsPanel() {
        initialisePanel();
        initialiseMetricCards();
    }

    private void initialiseMetricCards() {
        inventoryMetric= new MetricCard("/images/inventory.png", "Stock left");
        add(inventoryMetric);
        salesMetric = new MetricCard("/images/sales.png", "Orders");
        add(salesMetric);
        profitMetric = new MetricCard("/images/profit.png", "Gross Profit");
        add(profitMetric);
    }

    private void initialisePanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
        setPreferredSize(new Dimension(0, 170));
    }
    public void setProfit(int value) {
        profitMetric.setValue(value);
    }
    public void setSales(int value) {
        salesMetric.setValue(value);
    }
    public void setInventory(int value) {
        inventoryMetric.setValue(value);
    }
}
