package dzholdoshbaev.laboratory.controller;

import dzholdoshbaev.laboratory.model.Dishes;
import dzholdoshbaev.laboratory.model.Restaurants;
import dzholdoshbaev.laboratory.model.Users;
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
import java.util.List;


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

        List<Dishes> dishes = dishesService.findDishesByIds(orderIds);
        Double totalAmount = dishes.stream()
                .mapToDouble(Dishes::getPrice)
                .sum();

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
        List<Dishes> dishes = dishesService.findDishesByIds(orderIds);

        Double totalAmount = dishes.stream()
                .mapToDouble(Dishes::getPrice)
                .sum();

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
