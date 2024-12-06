package ordering_system.View.CardArea.ViewOrder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ordering_system.View.CardArea.Order.OrderTable;

public class ViewOrderPanel extends JPanel {
    private JTextField searchField;
    private JTextField startDate;
    private JTextField endDate;
    private JButton searchButton;
    private OrderTable ordersTable;
    private DefaultTableModel tableModel;

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

        // Optional: Action listener for search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText();
                filterTable(searchTerm); // Call a method to filter the table based on search term
            }
        });
    }

    // Method to filter table (for demonstration; you can implement this based on your requirements)
    private void filterTable(String searchTerm) {
        // Example: Clear the table and populate based on the search term
        // For real implementation, you might re-query the database or filter the table model
        System.out.println("Filter with search term: " + searchTerm);
    }

    public void setOrdersTableModel(DefaultTableModel tableModel) {
        ordersTable.setOrdersTableModel(tableModel);
    }
}