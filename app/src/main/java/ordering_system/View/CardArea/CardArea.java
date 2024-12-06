package ordering_system.View.CardArea;

import java.awt.CardLayout;

import javax.swing.JPanel;

import ordering_system.View.CardArea.Dashboard.DashboardPanel;
import ordering_system.View.CardArea.Order.OrderPanel;
import ordering_system.View.CardArea.Recipe.RecipePanel;
import ordering_system.View.CardArea.ViewOrder.ViewOrderPanel;

public class CardArea extends JPanel {
    private CardLayout cl;
    private DashboardPanel dashboardPanel;
    private OrderPanel orderPanel;
    private ViewOrderPanel viewOrderPanel;

    public CardArea() {
        cl = new CardLayout();
        setLayout(cl);
        initialiseCards();
        cl.show(this, "OrderPanel");
    }

    public CardLayout getCardLayout() {
        return cl;
    }

    public void initialiseCards() {
        dashboardPanel = new DashboardPanel();
        add(dashboardPanel, "DashboardPanel");
        orderPanel = new OrderPanel();
        add(orderPanel, "OrderPanel");
        viewOrderPanel = new ViewOrderPanel();
        add(viewOrderPanel, "ViewOrderPanel");
        add(new RecipePanel(), "RecipePanel");
    }

    public void switchToCard(String cardName) {
        cl.show(this, cardName);
    }

    public DashboardPanel getDashboardPanel() {
        return dashboardPanel;
    }

    public OrderPanel getOrderPanel() {
        return orderPanel;
    }

    public ViewOrderPanel getViewOrderPanel() {
        return viewOrderPanel;
    }
}
