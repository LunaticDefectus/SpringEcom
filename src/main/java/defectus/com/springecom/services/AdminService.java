package defectus.com.springecom.services;

import defectus.com.springecom.dao.entities.Admin;
import defectus.com.springecom.dao.entities.Order;
import defectus.com.springecom.dao.entities.Product;
import defectus.com.springecom.dao.repositories.AdminRepository;
import defectus.com.springecom.dao.repositories.OrderRepository;
import defectus.com.springecom.dao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService implements AdminManager {

    @Autowired
    private  OrderRepository orderRepository;
    @Autowired
    private  ProductRepository productRepository;
    @Autowired
    private  AdminRepository adminRepository;



    @Override
    public Admin Save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public boolean deleteOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            orderRepository.delete(order);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateOrder(Order updatedOrder) {
        boolean isUpdated = false;
        Optional<Order> optionalExistingOrder = orderRepository.findById((Integer) updatedOrder.getId());
        if (optionalExistingOrder.isPresent()) {
            Order existingOrder = optionalExistingOrder.get();
            existingOrder.setClient(updatedOrder.getClient());
            existingOrder.getProducts().clear();
            existingOrder.getProducts().addAll(updatedOrder.getProducts());
            existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
            orderRepository.save(existingOrder);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(Integer productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            productRepository.delete(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product updatedProduct) {
        Product existingProduct = productRepository.findById(updatedProduct.getId()).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            productRepository.save(existingProduct);
            return true;
        }
        return false;

    }
}
