package lesson6.data.Services;

import lesson6.data.entity.Car;
import lesson6.data.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;


    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars(){
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Integer carId){
        return carRepository.findById(carId);
    }

}
