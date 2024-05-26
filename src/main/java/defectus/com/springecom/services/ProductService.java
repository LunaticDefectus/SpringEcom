package defectus.com.springecom.services;


import defectus.com.springecom.dao.entities.Product;
import defectus.com.springecom.dao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductManager {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {

        try{
            return  productRepository.save(product);
        }catch (Exception exception){
            System.out.println(exception.getMessage()); //Logger
            return null;
        }
    }
    @Override
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);

    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }
    @Override
    public Page<Product> getAllProduits(int page, int taille) {
        return productRepository.findAll(PageRequest.of(page, taille));
    }


}
