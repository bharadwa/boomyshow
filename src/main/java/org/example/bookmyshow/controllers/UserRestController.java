package org.example.bookmyshow.controllers;

import jakarta.websocket.server.PathParam;
import org.example.bookmyshow.dtos.*;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
