package ordering_system.View.CardArea.Order;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class OrderTable extends JScrollPane {
    private JTable ordersTable;
    private TableRowSorter<DefaultTableModel> sorter;
    public OrderTable() {
        ordersTable = new JTable();
        setViewportView(ordersTable);
    }
    public OrderTable(int width, int height) {
        initialiseOrderTable(width, height);
    }

    private void initialiseOrderTable(int width, int height) {
        DefaultTableModel model = new DefaultTableModel();
        ordersTable = new JTable(model);
        sorter = new TableRowSorter<>(model);
        ordersTable.setRowSorter(sorter);
        setViewportView(ordersTable);
        setPreferredSize(new Dimension(width, height));
    }

    // Method to set the table model from the controller
    public void setOrdersTableModel(DefaultTableModel tableModel) {
        ordersTable.setModel(tableModel);
        // Set font for table cells
        ordersTable.setFont(new Font("Arial", Font.PLAIN, 14));

        // Set font for table header
        ordersTable.getTableHeader().setFont(new Font("Poppins", Font.PLAIN, 16));

        // Adjust row height for larger fonts
        ordersTable.setRowHeight(25);
    }

    public TableRowSorter<DefaultTableModel> getSorter() {
        return sorter;
    }
}
