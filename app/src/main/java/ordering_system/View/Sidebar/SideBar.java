package ordering_system.View.Sidebar;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;

import ordering_system.View.GradientPanel;
import ordering_system.View.CardArea.CardArea;

public class SideBar extends GradientPanel {
    CardArea cardArea;

    public SideBar(CardArea cardArea) {
        super(new Color(0x4dc9e6), new Color(0x210cae));
        this.cardArea = cardArea;
        initialiseSideBar();
        initialiseSideBarItems();
    }

    private void initialiseSideBarItems() {
        add(Box.createVerticalStrut(50));
        add(new SideBarItem("Dashboard", cardArea, "DashboardPanel", "/images/home.png"));
        add(new SideBarItem("Create order", cardArea, "OrderPanel", "/images/create.png"));
        add(new SideBarItem("View orders", cardArea, "ViewOrderPanel", "/images/view.png"));
        add(new SideBarItem("View recipes", cardArea, "RecipePanel", "/images/recipe.png")); 
    }

    private void initialiseSideBar() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(180, 800));
    }


}
