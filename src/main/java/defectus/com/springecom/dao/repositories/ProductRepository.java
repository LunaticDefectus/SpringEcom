package defectus.com.springecom.dao.repositories;

import defectus.com.springecom.dao.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
