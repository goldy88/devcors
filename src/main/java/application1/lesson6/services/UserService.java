package application1.lesson6.services;

import application1.lesson6.data.entity.User;
import application1.lesson6.repo.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(HttpStatus ok) {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public void save(User user) {
        userRepository.save(user);
    }


    public void delete(Long id) {
        userRepository.deleteById(id);
    }





}

