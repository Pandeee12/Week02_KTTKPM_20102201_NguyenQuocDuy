package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private double price;
    @OneToOne
    private User user;

    public Product( String name, double price) {

        this.name = name;
        this.price = price;
    }
}
