package dzholdoshbaev.laboratory.service;

import dzholdoshbaev.laboratory.model.Restaurants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RestaurantsService {
    Page<Restaurants> getAllRestaurants(Pageable pageable);

    Restaurants getRestaurantById(Long id);
}
