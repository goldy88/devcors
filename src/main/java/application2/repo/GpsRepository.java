package application2.repo;

import application1.lesson6.data.entity.BorrowedCar;
import application2.data.CarLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GpsRepository extends JpaRepository<CarLocation,Long> {

       List<CarLocation> findCarsByCarId(Long carId);


}
