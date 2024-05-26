package defectus.com.springecom.dao.repositories;

import defectus.com.springecom.dao.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
