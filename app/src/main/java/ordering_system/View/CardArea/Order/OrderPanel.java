package ordering_system.View.CardArea.Order;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class OrderPanel extends JPanel {
    public OrderPanel() {
        initialisePanel();
    }

    private void initialisePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalStrut(50));
        add(new OrderPanelMainArea());
        add(new OrderPanelBottom());
    }

}
