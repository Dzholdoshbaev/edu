package dzholdoshbaev.laboratory.repository;

import dzholdoshbaev.laboratory.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
}
