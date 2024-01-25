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
    @Column(name="product_id")
    private long id;
    @Column(name="product_name")
    private String name;
    private double price;

    @OneToOne
    private User user;



}
