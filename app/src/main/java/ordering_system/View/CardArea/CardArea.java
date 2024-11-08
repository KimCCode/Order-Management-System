package ordering_system.View.CardArea;

import java.awt.CardLayout;

import javax.swing.JPanel;

import ordering_system.View.CardArea.Dashboard.DashboardPanel;
import ordering_system.View.CardArea.Order.OrderPanel;
import ordering_system.View.CardArea.Recipe.RecipePanel;
import ordering_system.View.CardArea.ViewOrder.ViewOrderPanel;

public class CardArea extends JPanel {
    CardLayout cl;
    OrderPanel orderPanel;

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
        add(new DashboardPanel(), "DashboardPanel");
        orderPanel = new OrderPanel();
        add(orderPanel, "OrderPanel");
        add(new ViewOrderPanel(), "ViewOrderPanel");
        add(new RecipePanel(), "RecipePanel");
    }

    public void switchToCard(String cardName) {
        cl.show(this, cardName);
    }

    public OrderPanel getOrderPanel() {
        return orderPanel;
    }
}
