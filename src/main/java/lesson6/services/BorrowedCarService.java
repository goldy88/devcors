package lesson6.services;

import lesson6.data.entity.BorrowedCar;
import lesson6.repo.BorrowedCarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedCarService {

    private final BorrowedCarRepository borrowedCarRepository;

    public BorrowedCarService(BorrowedCarRepository borrowedCarRepository) {
        this.borrowedCarRepository = borrowedCarRepository;
    }

    public List<BorrowedCar> getBorowedCars() {
        return borrowedCarRepository.findAll();
    }



    public void save(BorrowedCar borrowedCar) {
        borrowedCarRepository.save(borrowedCar);
    }




}
