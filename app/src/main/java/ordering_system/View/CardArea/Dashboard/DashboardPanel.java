package ordering_system.View.CardArea.Dashboard;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class DashboardPanel extends JPanel {
    private MetricCardsPanel metricCardsPanel;
    public DashboardPanel() {
        initialisePanel();
    }

    private void initialisePanel() {
        setBackground(new Color(0xfefae0));
        setLayout(new BorderLayout());
        metricCardsPanel = new MetricCardsPanel();
        add(metricCardsPanel, BorderLayout.NORTH);
        add(new ChartsPanel(), BorderLayout.CENTER);
    }

    public void setProfit(int value) {
        metricCardsPanel.setProfit(value);
    }
}
