package ordering_system.View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;

import ordering_system.View.CardArea.CardArea;
import ordering_system.View.CardArea.Dashboard.MetricCardsPanel;
import ordering_system.View.CardArea.Order.OrderPanel;
import ordering_system.View.CardArea.ViewOrder.ViewOrderPanel;
import ordering_system.View.Sidebar.SideBar;

public class MainFrame extends JFrame {
    private CardLayout cl;
    private CardArea cardArea;
 
    public MainFrame() {
        initialiseMainFrame();
    }

    private void initialiseMainFrame() {
        setLayout(new BorderLayout());
        setSize(2560, 1600);
        cardArea = new CardArea();
        add(cardArea, BorderLayout.CENTER);
        add(new SideBar(cardArea), BorderLayout.WEST);
        // setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public MetricCardsPanel getMetricCardsPanel() {
        return cardArea.getMetricCardsPanel();
    }
    public OrderPanel getOrderPanel() {
        return cardArea.getOrderPanel();
    }

    public ViewOrderPanel getViewOrderPanel() {
        return cardArea.getViewOrderPanel();
    }
}
