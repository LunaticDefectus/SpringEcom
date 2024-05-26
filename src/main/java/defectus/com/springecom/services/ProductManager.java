package defectus.com.springecom.services;

import defectus.com.springecom.dao.entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductManager {
    Product addProduct(Product product);


    void deleteProductById(Integer id);

    List<Product> getAllProduct();

    Product getProductById(Integer id);


    Page<Product> getAllProduits(int page, int taille);
}

