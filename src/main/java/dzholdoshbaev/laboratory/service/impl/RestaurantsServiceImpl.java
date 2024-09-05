package dzholdoshbaev.laboratory.service.impl;

import dzholdoshbaev.laboratory.model.Restaurants;
import dzholdoshbaev.laboratory.repository.RestaurantsRepository;
import dzholdoshbaev.laboratory.service.RestaurantsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class RestaurantsServiceImpl implements RestaurantsService {
    private final RestaurantsRepository restaurantsRepository;

    @Override
    public Page<Restaurants> getAllRestaurants(Pageable pageable) {
        Page<Restaurants> restaurantsPage = restaurantsRepository.findAll(pageable);
        List<Restaurants> restaurants = restaurantsPage.getContent();
        log.info("return all restaurants");
        return new PageImpl<>(restaurants, pageable, restaurantsPage.getTotalElements());
    }

    @Override
    public Restaurants getRestaurantById(Long id) {
        log.info("getRestaurantById");
        return restaurantsRepository.findById(id).orElse(null);
    }
}
