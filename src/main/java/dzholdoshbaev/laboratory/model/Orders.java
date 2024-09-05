package dzholdoshbaev.laboratory.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "total_amount")
    private Long totalAmount;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "status")
    private String status;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;
    @Column(name = "session_id")
    private String sessionId;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "orders")
    private List<OrderItems> orderItemsList;
}
