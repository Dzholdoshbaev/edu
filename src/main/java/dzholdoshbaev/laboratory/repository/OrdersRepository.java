package dzholdoshbaev.laboratory.repository;

import dzholdoshbaev.laboratory.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
