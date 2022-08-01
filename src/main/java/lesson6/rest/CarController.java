package lesson6.rest;


import lesson6.data.entity.User;
import lesson6.repo.CarRepository;
import lesson6.services.CarService;
import lesson6.data.entity.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    private final CarRepository carRepository;

    private final CarService carService;
    private List<Car> List;

    public CarController(CarRepository carRepository, CarService carService) {
        this.carRepository = carRepository;
        this.carService = carService;
    }

    /**
     * @return all cars
     */

    @GetMapping(value = "cars")
    public List<Car> findAll() {
        return carService.getCars();
    }

    /**
     * @param id
     * @return car by Id
     */
    @GetMapping(value = "cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Integer id) {
        Optional<Car> car = carService.getCarById(id);

        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    /**
     * @param car create new car
     */
    @PostMapping(value = "/cars")
    public void createCar(@RequestBody Car car) {
        carService.save(car);
    }

    /**
     * delete car
     */
    @DeleteMapping(value = "/cars/{id}")
    public void delete(@PathVariable Integer id) {
        carService.delete(id);
    }


    /**
     * @param id
     * @param car
     * @return edited car
     */
    @PutMapping(value = "/cars/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer id,
                                           @RequestBody Car car) {
        if (!carRepository.existsById(id)) {
            return ResponseEntity.badRequest().build();
        } else {
            car.setId(id);
            carService.save(car);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


    @GetMapping("/cars/filter")
    public ResponseEntity<List<Car>> listOfBrach(@RequestParam("brandName") String query) {
        return ResponseEntity.ok(carService.listOfBrand(query));
    }

}
