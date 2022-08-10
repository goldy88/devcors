package application1.lesson6.rest;


import application1.lesson6.data.entity.CarLocation;
import application1.lesson6.data.entity.User;
import application1.lesson6.repo.CarRepository;
import application1.lesson6.services.CarService;
import application1.lesson6.data.entity.Car;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    private final CarRepository carRepository;
    private final RestTemplate restTemplate;
    private final CarService carService;


    public CarController(CarRepository carRepository, RestTemplate restTemplate, CarService carService) {
        this.carRepository = carRepository;
        this.restTemplate = restTemplate;
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

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Integer id) {
        Optional<Car> car = carService.getCarById(id);

        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    /**
     * @param car create new car
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/cars")
    public void createCar(@RequestBody Car car) {
        carService.save(car);
    }

    /**
     * delete car
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value = "/cars/{id}")
    public void delete(@PathVariable Integer id) {
        carService.delete(id);
    }


    /**
     * @param id
     * @param car
     * @return edited car
     */
    @PreAuthorize("hasAuthority('ADMIN')")
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


    @GetMapping("/cars/gps/{carId}")
    public List<CarLocation> getLocation(@PathVariable Integer carId) {
        return restTemplate.exchange("http://localhost:8084/gps/" + carId,
                HttpMethod.GET, null
                , List.class).getBody();

    }


}
