package dzholdoshbaev.laboratory.repository;

import dzholdoshbaev.laboratory.model.Orders;
import dzholdoshbaev.laboratory.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query("select o from Orders o where o.users.id = :userId")
    List<Orders> findAllByUserId(Long userId);

}
