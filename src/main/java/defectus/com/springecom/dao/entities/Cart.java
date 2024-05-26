package defectus.com.springecom.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="Cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    private List<Product> products;

    @OneToOne(mappedBy = "cart")
    private Client client;

    public boolean removeProduct(Product product) {
        return products.remove(product);
    }

    public boolean addProduct(Product product) {
        return products.add(product);
    }
}
