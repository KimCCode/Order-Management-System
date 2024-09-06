package ordering_system.View.CardArea.Dashboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class MetricCardsPanel extends JPanel {
    public MetricCardsPanel() {
        initialisePanel();
        initialiseMetricCards();
    }

    private void initialiseMetricCards() {
        add(new MetricCard("/images/inventory.png", "Stock left", "300"));
        add(new MetricCard("/images/sales.png", "Orders", "500"));
        add(new MetricCard("/images/profit.png", "Gross Profit", "$1000"));
    }

    private void initialisePanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
        setPreferredSize(new Dimension(0, 170));
    }
}
