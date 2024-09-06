package ordering_system.View.CardArea.Order;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OrderPanelBottom extends JPanel {
    public OrderPanelBottom() {
        initialisePanel();
        initialiseChildren();
    }

    private void initialisePanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        setPreferredSize(new Dimension(2300, 50));
        setMaximumSize(new Dimension(2300, 50));
    }

    private void initialiseChildren() {
        add(createButton("Add"));
        add(createButton("Print Invoice"));
        add(createButton("Reset"));
    }

    private Component createButton(String string) {
        JButton button = new JButton(string);
        return button;
    }
}
