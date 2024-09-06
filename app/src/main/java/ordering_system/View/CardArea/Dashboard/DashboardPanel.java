package ordering_system.View.CardArea.Dashboard;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class DashboardPanel extends JPanel {
    public DashboardPanel() {
        initialisePanel();
    }

    private void initialisePanel() {
        setBackground(new Color(0xfefae0));
        setLayout(new BorderLayout());
        add(new MetricCardsPanel(), BorderLayout.NORTH);
        add(new ChartsPanel(), BorderLayout.CENTER);
    }
}
