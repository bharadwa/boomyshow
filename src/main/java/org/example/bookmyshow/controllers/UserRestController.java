package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.LoginRequestDTO;
import org.example.bookmyshow.dtos.LoginResponseDTO;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.dtos.SignUpUserRequestDTO;
import org.example.bookmyshow.dtos.SignUpUserResponseDTO;
import org.example.bookmyshow.dtos.UserViewDTO;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public SignUpUserResponseDTO signUp(@RequestBody  SignUpUserRequestDTO userRequestDTO) {
        SignUpUserResponseDTO response = new SignUpUserResponseDTO();
        try {
            User user = this.userService.signUp(userRequestDTO.getName(), userRequestDTO.getEmail(), userRequestDTO.getPassword(), userRequestDTO.getUserType());
            response.setName(user.getName());
            response.setEmail(user.getEmail());
            response.setUserType(user.getUserType().name());
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setUserId(user.getId());
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody  LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO response = new LoginResponseDTO();

        try {
            response.setLoginSuccess(this.userService.loginUser(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.FAILURE);

        }
        return response;

    }

    @GetMapping("/{userId}")
    public UserViewDTO getUserById(@PathVariable("userId") long userId) {
        UserViewDTO response = new UserViewDTO();
        try {
            User user = this.userService.getUserById(userId);
            response.setName(user.getName());
            response.setEmail(user.getEmail());
            response.setUserType(user.getUserType().name());
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setUserId(user.getId());
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
