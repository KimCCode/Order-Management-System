package ordering_system.View.CardArea.Order;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CustomerInfoPanel extends JPanel {
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField dateField;

    public CustomerInfoPanel() {
        initialisePanel();
    }

    private void initialisePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new LineBorder(Color.GRAY, 1));
        setPreferredSize(new Dimension(200, 120));
        add(Box.createVerticalGlue());
        
        nameField = new JTextField(10);
        nameField.setBorder(new LineBorder(Color.BLACK, 1));
        add(new InfoPanel("Name", nameField));

        phoneField = new JTextField(10);
        phoneField.setBorder(new LineBorder(Color.BLACK, 1));
        add(new InfoPanel("Phone", phoneField));

        dateField = new JTextField(10);
        dateField.setBorder(new LineBorder(Color.BLACK, 1));
        add(new InfoPanel("Date", dateField));
        
        add(Box.createVerticalGlue());
    }

    public String getNameField() {
        return nameField.getText();
    }

    public String getPhoneField() {
        return phoneField.getText();
    }

    public String getDateField() {
        return dateField.getText();
    }
}
