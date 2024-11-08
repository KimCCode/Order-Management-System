package ordering_system.Services;

import java.sql.Connection;
import java.sql.SQLException;

import ordering_system.Dao.CustomerDao;
import ordering_system.Dao.OrderDao;
import ordering_system.Dao.ProductDao;
import ordering_system.Dao.SizeDao;
import ordering_system.Database.DataBaseConnection;

public class OrderService {
    private final OrderDao orderDao;
    private final CustomerDao customerDao;
    private final ProductDao productDao;
    private final SizeDao sizeDao;

    public OrderService(OrderDao orderDao, CustomerDao customerDao, ProductDao productDao, SizeDao sizeDao) {
        this.orderDao = orderDao;
        this.customerDao = customerDao;
        this.productDao = productDao;
        this.sizeDao = sizeDao;
    }
    public void placeOrder(String customerName, String phone, String deliveryDate, String size, String flavour, int qty) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            try {
                connection.setAutoCommit(false);
                Integer customerId = customerDao.customerNameToId(connection, customerName);
                if (customerId == null) {
                    // Create new customer
                    customerId = customerDao.insertCustomer(connection, customerName, phone);
                    if (customerId == -1) {
                        throw new SQLException("Failed to insert customer: No ID generated.");
                    }
                }
                Integer sizeId = sizeDao.sizeToId(connection, size);
                Integer productId = productDao.flavourToId(connection, flavour);
                orderDao.insertOrder(connection, customerId, productId, sizeId, qty, deliveryDate);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
