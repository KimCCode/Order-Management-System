package ordering_system.Services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ordering_system.Dao.CustomerDao;
import ordering_system.Dao.OrderDao;
import ordering_system.Dao.ProductDao;
import ordering_system.Dao.SizeDao;
import ordering_system.Database.DataBaseConnection;
import ordering_system.Exceptions.OrderProcessingException;

public class OrderService implements OrderServiceObservable {
    private OrderDao orderDao;
    private CustomerDao customerDao;
    private ProductDao productDao;
    private SizeDao sizeDao;
    private List<OrderServiceObserver> observers = new ArrayList<>();;

    public OrderService(OrderDao orderDao, CustomerDao customerDao, ProductDao productDao, SizeDao sizeDao) {
        this.orderDao = orderDao;
        this.customerDao = customerDao;
        this.productDao = productDao;
        this.sizeDao = sizeDao;
    }

    public void notifyObservers(int totalProfit, int totalOrders) {
        for (OrderServiceObserver o : observers) {
            o.update(totalProfit, totalOrders);
        }
    }

    public void subscribe(OrderServiceObserver o) {
        observers.add(o);
    }

    public void placeOrder(String customerName, String phone, String deliveryDate, String size, String flavour, int qty) throws OrderProcessingException {
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
                int a[] = orderDao.getProfitAndOrders(connection);
                notifyObservers(a[0], a[1]);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new OrderProcessingException();
            }
        } catch (SQLException | OrderProcessingException e) {
            e.printStackTrace();
            throw new OrderProcessingException();
        }
    }
}
