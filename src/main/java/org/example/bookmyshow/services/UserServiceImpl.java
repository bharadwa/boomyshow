package org.example.bookmyshow.services;

import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.models.UserType;
import org.example.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final BCryptPasswordEncoder passwordEncoder;

    private final UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public User signUp(String name,String email, String password, String userType) {
        Optional<User> optionalUser = this.userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            throw new RuntimeException("User with this email already exists");
        }

        UserType type=UserType.fromString(userType);
        if(type==null){
            throw new RuntimeException("Invalid user type");
        }

        User user = new User();
        user.setName(name);
        user.setUserType(type);
        user.setEmail(email);
        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(password));

        // Save the user to the database
        return userRepository.save(user);
    }


    @Override
    public boolean loginUser(String email, String password) {
        User user = this.userRepository.findByEmail(email).orElseThrow( () -> new RuntimeException("User Not Found please register"));
        // Check the hashed password
        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public User getUserById(long userId) throws UserNotFoundException {
        return this.userRepository.findById(userId).orElseThrow( () -> new UserNotFoundException("User not found"));
    }
}
