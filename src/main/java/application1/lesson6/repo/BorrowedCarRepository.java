package application1.lesson6.repo;

import application1.lesson6.data.entity.BorrowedCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BorrowedCarRepository extends JpaRepository<BorrowedCar, Integer> {


    BorrowedCar findByUserIdAndCarId(Integer userId, Integer carId);

    List<BorrowedCar> findBorrowedCarsByUserId(Integer userId);
}
