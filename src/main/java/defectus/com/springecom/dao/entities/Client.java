package defectus.com.springecom.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    @OneToOne
    private Cart cart;

    @OneToMany(mappedBy = "client")
    private List<Order> orders;

    private String role = "ROLE_CLIENT";  // Default role for clients
}
