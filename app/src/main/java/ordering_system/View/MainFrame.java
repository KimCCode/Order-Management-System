package ordering_system.View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;

import ordering_system.View.CardArea.CardArea;
import ordering_system.View.CardArea.Order.OrderPanel;
import ordering_system.View.Sidebar.SideBar;

public class MainFrame extends JFrame {
    CardLayout cl;
    CardArea cardArea;
 
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

    public OrderPanel getOrderPanel() {
        return cardArea.getOrderPanel();
    }
}
