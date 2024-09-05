package dzholdoshbaev.laboratory.service.impl;

import dzholdoshbaev.laboratory.model.Dishes;
import dzholdoshbaev.laboratory.repository.DishesRepository;
import dzholdoshbaev.laboratory.service.DishesService;
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
public class DishesServiceImpl implements DishesService {
    private final DishesRepository dishesRepository;


    @Override
   public Page<Dishes> findAllRestaurantDishes(Long restaurantId, Pageable pageable) {
        Page<Dishes> dishesPage = dishesRepository.findByRestaurantsId(restaurantId,pageable);
        List<Dishes> dishes = dishesPage.getContent();
        return new PageImpl<>(dishes, pageable, dishesPage.getTotalElements());
   }
}
