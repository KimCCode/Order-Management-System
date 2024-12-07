package ordering_system.View.CardArea.ViewOrder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ordering_system.View.CardArea.Order.OrderTable;

public class ViewOrderPanel extends JPanel {
    private JTextField searchField;
    private JTextField startDate;
    private JTextField endDate;
    private JButton searchButton;
    private OrderTable ordersTable;

    public ViewOrderPanel() {
        // Set up the main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        
        // Create the search/filter bar panel
        JPanel filterPanelContainer = new JPanel(new BorderLayout(10, 0));

        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // Create search field and button
        searchField = new JTextField(20); // Text field for entering search terms
        searchButton = new JButton("Search"); // Button to trigger search
        filterPanel.add(new JLabel("Search:"));
        filterPanel.add(searchField);
        filterPanel.add(searchButton);

        JPanel dateFilterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        startDate = new JTextField(7); // Text field for entering search terms
        endDate = new JTextField(7); // Text field for entering search terms
        dateFilterPanel.add(new JLabel("Start:"));
        dateFilterPanel.add(startDate);
        dateFilterPanel.add(new JLabel("End:"));
        dateFilterPanel.add(endDate);
        
        filterPanelContainer.add(filterPanel, BorderLayout.NORTH);
        filterPanelContainer.add(dateFilterPanel, BorderLayout.CENTER);
        
        // Add filterPanel to the North region of mainPanel
        mainPanel.add(filterPanelContainer, BorderLayout.NORTH);
        ordersTable = new OrderTable(800, 500);
        mainPanel.add(ordersTable, BorderLayout.CENTER); // Add table to Center region
        
        // Set up the frame
        add(mainPanel); // Add mainPanel to the frame
        setSize(800, 500);
    }
    
    public void setSearchAction(ActionListener actionListener) {
        searchButton.addActionListener(actionListener);
    }

    public void setOrdersTableModel(DefaultTableModel tableModel) {
        ordersTable.setOrdersTableModel(tableModel);
    }

    public String getSearchField() {
        return searchField.getText();
    }
}