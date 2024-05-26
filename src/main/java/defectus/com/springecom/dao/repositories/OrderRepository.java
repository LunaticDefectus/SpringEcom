package defectus.com.springecom.dao.repositories;

import defectus.com.springecom.dao.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
