package defectus.com.springecom.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int price;
    private String description;
    private String imageFileName;

    @ManyToMany(mappedBy = "products")
    private List<Cart> carts;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

}