package ordering_system.View.CardArea.Order;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OrderTable extends JScrollPane {
    private String[] columnHeaders = {"Size", "Flavour", "Price", "Qty", "Total"};
    private Object[][] data = {{"1", "John", "25", "3", "2"}};
    public OrderTable() {
        initialiseOrderTable();
    }

    private void initialiseOrderTable() {
        JTable table = new JTable(data, columnHeaders);
        setViewportView(table);
        setPreferredSize(new Dimension(350, 120));
    }
}
