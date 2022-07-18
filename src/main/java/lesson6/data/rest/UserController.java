package lesson6.data.rest;


import lesson6.data.Services.UserService;
import lesson6.data.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users")
    public List<User> findAll() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/users/{id}")
    public ResponseEntity<User> findCustomerById(@PathVariable("id") Long id) {
        Optional<User> user = userService.getUserById(id);

        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

