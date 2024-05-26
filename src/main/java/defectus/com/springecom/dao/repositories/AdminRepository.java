package defectus.com.springecom.dao.repositories;

import defectus.com.springecom.dao.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findByUsername(String username);

}
