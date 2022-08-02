package lesson6.services;


import lesson6.data.entity.User;
import lesson6.data.enums.UserRole;
import lesson6.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    @PostConstruct
    public void postConstruct() {
        User user = User.builder().username("admin")
                .firstname("Daniel")
                .lastname("Goldmann")
                .address("BRNO123")
                .email("godmann@gmail.com")
                .password(passwordEncoder.encode("admin"))
                .role(UserRole.ADMIN).build();
        userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
