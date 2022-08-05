package lesson6.rest;


import lesson6.data.entity.BorrowedCar;
import lesson6.data.entity.Car;
import lesson6.repo.BorrowedCarRepository;
import lesson6.repo.CarRepository;
import lesson6.repo.UserRepository;
import lesson6.services.BorrowedCarService;
import lesson6.services.UserService;
import lesson6.data.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final CarRepository carRepository;
    private final BorrowedCarRepository borrowedCarRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final BorrowedCarService borrowedCarService;

    public UserController(CarRepository carRepository, BorrowedCarRepository borrowedCarRepository, UserRepository userRepository, UserService userService, BorrowedCarService borrowedCarService) {
        this.carRepository = carRepository;
        this.borrowedCarRepository = borrowedCarRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.borrowedCarService = borrowedCarService;
    }

    /**
     * @return all Users
     */
   // @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/users")
    public List<User> findAll() {
        return userService.getUsers(HttpStatus.OK);
    }

    /**
     * @param id
     * @return user by id
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id) {
        Optional<User> user = userService.getUserById(id);

        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * @param user create new user
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/users")
    public void createUser(@RequestBody User user) {
        userService.save(user);
    }


    /**
     * @param id
     * @param user
     * @return edited user
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(value = "/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id,
                                           @RequestBody User user) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.badRequest().build();
        } else {
            user.setId(id);
            userService.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    /**
     * delete user
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value = "/users/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    /**
     *
     * @param userId
     * @param carId
     * @return
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(value = "/users/{userId}/car/borrow/{carId}")
    public ResponseEntity<BorrowedCar> rentCar(@PathVariable(value = "userId") Integer userId,
                                               @PathVariable(value = "carId") Integer carId) {
        BorrowedCar borrowedCar = new BorrowedCar();
        borrowedCar.setCarId(carId);
        borrowedCar.setUserId(userId);
        borrowedCarService.save(borrowedCar);
        return ResponseEntity.ok(borrowedCar);
    }

    /**
     *
     * @param userId
     * @param carId
     * @return
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/users/{userId}/car/return/{carId}")
    public ResponseEntity<HttpStatus> returnCar(@PathVariable Integer userId,
                                                @PathVariable Integer carId) {
        BorrowedCar borrowedCar = borrowedCarRepository.findByUserIdAndCarId(userId, carId);
        if (borrowedCar == null) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            borrowedCarRepository.delete(borrowedCar);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    /**
     *
     * @param userId
     * @return
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users/{userId}/car")
    public ResponseEntity<List<Car>> getBorrowedCars(@PathVariable Integer userId) {
        if (userRepository.existsById(Long.valueOf(userId))) {
            List<Car> borrowedCars = borrowedCarRepository.findBorrowedCarsByUserId(userId)
                    .stream()
                    .map(BorrowedCar::getCarId)
                    .map(carRepository::findById)
                    .flatMap(Optional::stream)
                    .toList();
            return new ResponseEntity<>(borrowedCars, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

