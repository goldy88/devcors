package application1.lesson6.repo;

import application1.lesson6.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT c FROM Car c WHERE c.brand like concat('%', :query, '%') ")
    List<Car> findByBrand(String query);



}
