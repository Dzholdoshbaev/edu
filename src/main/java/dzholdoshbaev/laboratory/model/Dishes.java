package dzholdoshbaev.laboratory.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "dishes")
public class Dishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Long price;
    @Column(name = "amount")
    private Long amount;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurants restaurants;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "dishes")
    List<OrderItems> orderItemsList;
}
