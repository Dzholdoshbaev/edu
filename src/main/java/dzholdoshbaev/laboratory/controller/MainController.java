package dzholdoshbaev.laboratory.controller;

import dzholdoshbaev.laboratory.service.RestaurantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    private final RestaurantsService restaurantsService;

    @GetMapping
    public String getAllRestaurants(Model model ,  @PageableDefault(size = 5, sort = "name") Pageable pageable) {
        model.addAttribute("restaurants",restaurantsService.getAllRestaurants(pageable));
        return "main";
    }
}
