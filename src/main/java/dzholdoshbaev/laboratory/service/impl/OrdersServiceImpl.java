package dzholdoshbaev.laboratory.service.impl;

import dzholdoshbaev.laboratory.constant.Status;
import dzholdoshbaev.laboratory.model.Dishes;
import dzholdoshbaev.laboratory.model.OrderItems;
import dzholdoshbaev.laboratory.model.Orders;
import dzholdoshbaev.laboratory.model.Users;
import dzholdoshbaev.laboratory.repository.OrderItemsRepository;
import dzholdoshbaev.laboratory.repository.OrdersRepository;
import dzholdoshbaev.laboratory.service.DishesService;
import dzholdoshbaev.laboratory.service.OrdersService;
import dzholdoshbaev.laboratory.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;
    private final DishesService dishesService;
    private final UsersService usersService;
    private final OrderItemsRepository orderItemsRepository;


    @Override
    public void createdOrder(String username, List<Long> orderIds) {
        Users user = usersService.getUserByEmail(username);
        List<Dishes> dishes = dishesService.findDishesByIds(orderIds);

        Long totalPrice = dishes.stream().mapToLong(Dishes::getPrice).sum();
        Orders order = new Orders();
        order.setUsers(user);
        order.setTotalAmount(totalPrice);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(Status.ORDERED.getAuthority());
        ordersRepository.save(order);

        for (Dishes dish : dishes) {
            OrderItems orderItems = new OrderItems();
            orderItems.setOrders(order);
            orderItems.setDishes(dish);
            orderItems.setQuantity(1L);
            orderItems.setTotalPrice(dish.getPrice());
            orderItemsRepository.save(orderItems);
        }

    }

    @Override
    public List<Orders> getAllOrdersByUser(Users user) {
        log.info("Get all orders by user {}", user);
       return ordersRepository.findAllByUserId(user.getId());
    }
}
