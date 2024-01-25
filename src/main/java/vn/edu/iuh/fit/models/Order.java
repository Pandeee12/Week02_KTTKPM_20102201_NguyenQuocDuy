package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name="Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_id")
    private long id;
    @Column(name = "Order_id_name")
    private String name;
    @Column(name = "product_quanity")
    private int quantity;

    @OneToOne
    private Product product;

    public Order(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
