package defectus.com.springecom.services;


import defectus.com.springecom.dao.entities.Order;

import java.util.List;

public interface OrderManager {

    List<Order> getAllOrders();

    Order getOrderById(Integer id);
}
