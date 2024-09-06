package dzholdoshbaev.laboratory.controller;

import dzholdoshbaev.laboratory.model.Dishes;
import dzholdoshbaev.laboratory.model.Restaurants;
import dzholdoshbaev.laboratory.service.DishesService;
import dzholdoshbaev.laboratory.service.OrdersService;
import dzholdoshbaev.laboratory.service.UsersService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {
 private final DishesService dishesService;
    private final UsersService usersService;
    private final OrdersService ordersService;



    @GetMapping("delete/{dishId}")
    public String deleteOrder(@PathVariable Long dishId, HttpSession session, Model model) {
        List<Long> orderIds = (List<Long>) session.getAttribute("orderIds");
        if (orderIds == null) {
            orderIds = new ArrayList<>();
        }

        orderIds.remove(dishId);

        session.setAttribute("orderIds", orderIds);

        Map<Dishes, Long> myMap = new HashMap<>();
        int totalAmount = 0;

        for (Long orderId : orderIds) {
            Dishes dishes = dishesService.findById(orderId);
            totalAmount += dishes.getPrice();
            myMap.put(dishes, myMap.getOrDefault(dishes, 0L) + 1L);
        }


        List<Dishes> dishes = dishesService.findDishesByIds(orderIds);

        for (Dishes dish : dishes) {
            for (Map.Entry<Dishes, Long> entry : myMap.entrySet()) {
                if (dish.equals(entry.getKey())) {
                    dish.setAmount(entry.getValue());
                }
            }
        }
        int count = dishes.size();
        model.addAttribute("count", count);
        model.addAttribute("totalAmount" ,totalAmount);
        model.addAttribute("dishes", dishes);

        return "orders/order";
    }


    @GetMapping("/{dishId}")
    public String addDishToOrder(@PathVariable Long dishId,
                                 HttpSession session,
                                 Model model,
                                 @PageableDefault(size = 10, sort = "name") Pageable pageable) {
        session.setMaxInactiveInterval(36000);

        List<Long> orderIds = (List<Long>) session.getAttribute("orderIds");
        if (orderIds == null) {
            orderIds = new ArrayList<>();
        }
        orderIds.add(dishId);
        session.setAttribute("orderIds", orderIds);


        Restaurants restaurant = dishesService.findRestaurantIdByDishes(dishId);
        List<Dishes> dishes = dishesService.findDishesByIds(orderIds);
        int count = dishes.size();
        model.addAttribute("count", count);
        model.addAttribute("restaurants", restaurant);
        model.addAttribute("restaurantDishes", dishesService.findAllRestaurantDishes(restaurant.getId(), pageable));
        return "restaurants/restaurants";
    }

    @GetMapping("/order")
    public String viewOrders(HttpSession session, Model model) {
        List<Long> orderIds = (List<Long>) session.getAttribute("orderIds");
        if (orderIds == null) {
            orderIds = new ArrayList<>();
        }

        Map<Dishes, Long> myMap = new HashMap<>();
        int totalAmount = 0;

        for (Long orderId : orderIds) {
            Dishes dishes = dishesService.findById(orderId);
            totalAmount += dishes.getPrice();
            myMap.put(dishes, myMap.getOrDefault(dishes, 0L) + 1L);
        }


        List<Dishes> dishes = dishesService.findDishesByIds(orderIds);

        for (Dishes dish : dishes) {
            for (Map.Entry<Dishes, Long> entry : myMap.entrySet()) {
                if (dish.equals(entry.getKey())) {
                    dish.setAmount(entry.getValue());
                }
            }
        }
        int count = dishes.size();
        model.addAttribute("count", count);
        model.addAttribute("totalAmount" ,totalAmount);
        model.addAttribute("dishes", dishes);
        return "orders/order";
    }

    @PostMapping("/confirm")
    public String confirmOrder(HttpSession session, Principal principal) {
        List<Long> orderIds = (List<Long>) session.getAttribute("orderIds");
        if (orderIds != null) {

            ordersService.createdOrder(principal.getName(),orderIds);

            session.removeAttribute("orderIds");
            return "redirect:/profile";
        }
        return "redirect:/";
    }



}
