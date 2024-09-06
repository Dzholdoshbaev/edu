package dzholdoshbaev.laboratory.service;

import dzholdoshbaev.laboratory.model.Dishes;
import dzholdoshbaev.laboratory.model.Restaurants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DishesService {
    Page<Dishes> findAllRestaurantDishes(Long restaurantId, Pageable pageable);

    Dishes findById(Long id);

    Restaurants  findRestaurantIdByDishes(Long dishesId);

    List<Dishes> findDishesByIds(List<Long> orderIds);
}
