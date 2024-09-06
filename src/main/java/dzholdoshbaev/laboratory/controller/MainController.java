package dzholdoshbaev.laboratory.controller;

import dzholdoshbaev.laboratory.model.Dishes;
import dzholdoshbaev.laboratory.model.Restaurants;
import dzholdoshbaev.laboratory.service.DishesService;
import dzholdoshbaev.laboratory.service.RestaurantsService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    private final RestaurantsService restaurantsService;
    private final DishesService dishesService;

    @GetMapping
    public String getAllRestaurants(
            @RequestParam(value = "search", required = false, defaultValue = "") String search,
            @PageableDefault(size = 5, sort = "name") Pageable pageable, HttpSession session,
            Model model) {

        Page<Restaurants> restaurants;
        if (search != null && !search.isEmpty()) {
            restaurants = restaurantsService.findByName(search, pageable);
        } else {
            restaurants = restaurantsService.getAllRestaurants(pageable);
        }
        List<Long> orderIds = (List<Long>) session.getAttribute("orderIds");
        if (orderIds == null) {
            orderIds = new ArrayList<>();
        }
        List<Dishes> dishes = dishesService.findDishesByIds(orderIds);
        int count = dishes.size();
        model.addAttribute("count", count);

        model.addAttribute("restaurants", restaurants);
        model.addAttribute("search", search);

        return "main";
    }
}
