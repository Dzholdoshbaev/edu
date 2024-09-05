package dzholdoshbaev.laboratory.controller;

import dzholdoshbaev.laboratory.model.Restaurants;
import dzholdoshbaev.laboratory.service.RestaurantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    private final RestaurantsService restaurantsService;

    @GetMapping
    public String getAllRestaurants(
            @RequestParam(value = "search", required = false, defaultValue = "") String search,
            @PageableDefault(size = 5, sort = "name") Pageable pageable,
            Model model) {

        Page<Restaurants> restaurants;
        if (search != null && !search.isEmpty()) {
            restaurants = restaurantsService.findByName(search, pageable);
        } else {
            restaurants = restaurantsService.getAllRestaurants(pageable);
        }

        model.addAttribute("restaurants", restaurants);
        model.addAttribute("search", search); // Добавляем параметр поиска для отображения в форме

        return "main";
    }
}
