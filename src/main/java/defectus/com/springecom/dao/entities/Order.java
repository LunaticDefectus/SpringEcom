package defectus.com.springecom.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateCmd;
    private int totalPrice;

    @ManyToOne
    private Admin admin;

    @ManyToOne
    private Client client;

    @ManyToMany
    private List<Product> products;

}
