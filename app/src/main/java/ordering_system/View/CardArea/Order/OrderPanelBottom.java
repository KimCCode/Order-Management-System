package ordering_system.View.CardArea.Order;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OrderPanelBottom extends JPanel {
    JButton placeOrderButton;

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
        placeOrderButton = new JButton("Add");
        add(placeOrderButton);
        add(createButton("Print Invoice"));
        add(createButton("Reset"));
    }

    private Component createButton(String string) {
        JButton button = new JButton(string);
        return button;
    }

    public void setPlaceOrderAction(ActionListener actionListener) {
        placeOrderButton.addActionListener(actionListener);
    }

    public void showSuccessMessage() {
        JOptionPane.showMessageDialog(this, "Order placed successfully!");
    }

    public void showErrorMessage() {
        JOptionPane.showMessageDialog(this, "Unable to place order!");
    }
}
