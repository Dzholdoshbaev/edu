package dzholdoshbaev.laboratory.service.impl;

import dzholdoshbaev.laboratory.model.Dishes;
import dzholdoshbaev.laboratory.model.Restaurants;
import dzholdoshbaev.laboratory.repository.DishesRepository;
import dzholdoshbaev.laboratory.service.DishesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.NoSuchElementException;

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

   @Override
   public Dishes findById(Long id) {
        log.debug("Request to get Dishes : {}", id);
        return dishesRepository.findById(id).orElseThrow(NoSuchElementException::new);
   }


   @Override
  public Restaurants findRestaurantIdByDishes(Long dishesId) {
        log.info("findRestaurantIdByDishes {}", dishesId);
        Dishes dishes = dishesRepository.findById(dishesId).orElseThrow(() -> new NoSuchElementException("Dishes not found"));
        return dishes.getRestaurants();
  }

    @Override
    public List<Dishes> findDishesByIds(List<Long> orderIds) {
        log.info("findDishesByIds {}", orderIds);
        return dishesRepository.findAllById(orderIds);
    }

}
