package com.example.onlineshopagain.serive;

import com.example.onlineshopagain.domain.User;
import com.example.onlineshopagain.dto.SaveUserRequest;
import com.example.onlineshopagain.persistance.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User createUSer(SaveUserRequest saveUserRequest) {
        LOGGER.info("Creating User: First Name: {}, Last Name: {}", saveUserRequest.getFirstName(), saveUserRequest.getLastName());

        User user = new User();
        user.setFirstName(saveUserRequest.getFirstName());
        user.setLastName(saveUserRequest.getLastName());

//        if (user.getFirstName().isEmpty() || user.getFirstName().isBlank()) {
//            throw new RuntimeException("First Name cannot be empty.");
//        } else if (user.getLastName().isEmpty() || user.getLastName().isBlank()) {
//            throw new RuntimeException("Last Name cannot be empty.");
//        } else {
            return userRepository.save(user);
//        }
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }





}
