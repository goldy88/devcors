package lesson6.data.rest;


import lesson6.data.Services.CarService;
import lesson6.data.entity.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {


    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "cars")
    public List<Car> findAll() {
        return carService.getCars();
    }

    @RequestMapping(value = "cars/{id}")
    public ResponseEntity<Car> getCarId(@PathVariable("id") Integer id) {
        Optional<Car> car = carService.getCarById(id);

        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
}

