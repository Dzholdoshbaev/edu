package dzholdoshbaev.laboratory.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "total_price")
    private Long totalPrice;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dishes dishes;
}
