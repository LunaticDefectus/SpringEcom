package defectus.com.springecom.services;

import defectus.com.springecom.dao.entities.Order;
import defectus.com.springecom.dao.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService implements OrderManager{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }




    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }
}
