package defectus.com.springecom.services;

import defectus.com.springecom.dao.entities.Admin;
import defectus.com.springecom.dao.entities.Order;
import defectus.com.springecom.dao.entities.Product;

public interface AdminManager {
    boolean deleteOrder(Integer orderId);


    boolean updateOrder(Order updatedOrder);

    Product addProduct(Product product);

    boolean deleteProduct(Integer productId);

    boolean updateProduct(Product updatedProduct);

    Admin Save(Admin admin);
}

