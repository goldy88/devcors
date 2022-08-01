package lesson6.services;

import lesson6.data.entity.Car;
import lesson6.repo.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {


    private final CarRepository carRepository;


    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Integer carId) {
        return carRepository.findById(carId);
    }

    public void save(Car car) {
        carRepository.save(car);
    }

    public void delete(Integer id) {
        carRepository.deleteById(id);
    }

    public List<Car> getCarByBrand(String brand) {
        return carRepository.findAll();
    }

    public List<Car> listOfBrand(String query) {
        List<Car> cars = carRepository.findByBrand(query);
        return cars;
    }


}
