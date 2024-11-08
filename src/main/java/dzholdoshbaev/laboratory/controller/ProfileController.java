package dzholdoshbaev.laboratory.controller;



import dzholdoshbaev.laboratory.dto.UsersDto;
import dzholdoshbaev.laboratory.model.Dishes;
import dzholdoshbaev.laboratory.model.Orders;
import dzholdoshbaev.laboratory.model.Users;
import dzholdoshbaev.laboratory.service.AuthoritiesService;
import dzholdoshbaev.laboratory.service.DishesService;
import dzholdoshbaev.laboratory.service.OrdersService;
import dzholdoshbaev.laboratory.service.UsersService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final UsersService usersService;
    private final AuthoritiesService authoritiesService;
    private final OrdersService ordersService;
    private final DishesService dishesService;


    @GetMapping
    public String profile(HttpSession session, Model model, Principal principal) {
        String username = principal.getName();
        Users user = usersService.getUserByEmail(username);
        List<Orders> ordersList = ordersService.getAllOrdersByUser(user);
        List<Long> orderIds = (List<Long>) session.getAttribute("orderIds");
        if (orderIds == null) {
            orderIds = new ArrayList<>();
        }
        List<Dishes> dishes = dishesService.findDishesByIds(orderIds);
        int count = dishes.size();
        model.addAttribute("count", count);
        model.addAttribute("orders" , ordersList);
        model.addAttribute("userDto", user);
        return "auth/profile";
    }


    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute @Valid UsersDto usersDto,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "auth/register";
        }

        usersService.createUser(usersDto);
        return "redirect:/auth/login";
    }


    @GetMapping("/register")
    public String create(Model model) {
        model.addAttribute("usersDto", new UsersDto());
        return "auth/register";
    }


}
