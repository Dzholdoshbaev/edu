package dzholdoshbaev.laboratory.repository;

import dzholdoshbaev.laboratory.model.Restaurants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurants,Long> {
    Page<Restaurants> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
