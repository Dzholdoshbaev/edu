package dzholdoshbaev.laboratory.service;

import dzholdoshbaev.laboratory.model.Dishes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DishesService {
    Page<Dishes> findAllRestaurantDishes(Long restaurantId, Pageable pageable);
}
