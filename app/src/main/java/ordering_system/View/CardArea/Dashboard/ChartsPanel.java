package ordering_system.View.CardArea.Dashboard;

import java.awt.FlowLayout;
import java.awt.ScrollPane;

import javax.swing.JPanel;

public class ChartsPanel extends JPanel {
    public ChartsPanel() {
        initialisePanel();
    }

    private void initialisePanel() {
        // setBackground(Color.RED);
        setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
        // Need to figure out how to add padding to top of charts panel
        add(new BarChart());
        add(new PieChart());
    }
}
