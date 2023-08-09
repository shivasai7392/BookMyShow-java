package com.bms.bookmyshowjavaspringboot.services;

import com.bms.bookmyshowjavaspringboot.models.User;
import com.bms.bookmyshowjavaspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(int age, String name, String phoneNumer, String password, String email){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumer);
        user.setPassword(encoder.encode(password));

        return this.userRepository.save(user);
    }
}
