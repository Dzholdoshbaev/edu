package dzholdoshbaev.laboratory.repository;

import dzholdoshbaev.laboratory.model.Dishes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DishesRepository extends JpaRepository<Dishes, Long> {
    Page<Dishes> findByRestaurantsId(Long restaurantsId, Pageable pageable);
}
