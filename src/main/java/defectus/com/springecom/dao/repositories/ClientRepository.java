package defectus.com.springecom.dao.repositories;

import defectus.com.springecom.dao.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findByUsername(String username);
}
