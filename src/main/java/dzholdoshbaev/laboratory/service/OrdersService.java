package dzholdoshbaev.laboratory.service;

import dzholdoshbaev.laboratory.model.Orders;
import dzholdoshbaev.laboratory.model.Users;

import java.util.List;

public interface OrdersService {
    void createdOrder(String name, List<Long> orderIds);

    List<Orders> getAllOrdersByUser(Users user);
}
