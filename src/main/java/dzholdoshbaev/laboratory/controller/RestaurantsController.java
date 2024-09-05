package dzholdoshbaev.laboratory.controller;

import dzholdoshbaev.laboratory.model.Dishes;
import dzholdoshbaev.laboratory.model.Restaurants;
import dzholdoshbaev.laboratory.service.DishesService;
import dzholdoshbaev.laboratory.service.RestaurantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantsController {
    private final RestaurantsService restaurantsService;
    private final DishesService dishesService;

    @GetMapping("/{restaurantsId}")
    public String restaurantsById(@PathVariable Long restaurantsId, Model model, @PageableDefault(size = 10, sort = "name") Pageable pageable) {
        Restaurants restaurant = restaurantsService.getRestaurantById(restaurantsId);
        if (restaurant == null) {
            throw new NoSuchElementException("No such restaurant found");
        }
        model.addAttribute("restaurants", restaurant);
        model.addAttribute("restaurantDishes", dishesService.findAllRestaurantDishes(restaurantsId, pageable));
        return "restaurants/restaurants";
    }



}
