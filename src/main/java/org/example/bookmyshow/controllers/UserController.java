package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.*;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    public SignUpUserResponseDTO signUp(SignUpUserRequestDTO userRequestDTO) {
        SignUpUserResponseDTO response = new SignUpUserResponseDTO();
        try {
            User user = this.userService.signUp(userRequestDTO.getName(), userRequestDTO.getEmail(), userRequestDTO.getPassword(), userRequestDTO.getUserType());
            response.setName(user.getName());
            response.setEmail(user.getEmail());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO response = new LoginResponseDTO();

        try {
            response.setLoginSuccess(this.userService.loginUser(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.FAILURE);

        }
        return response;

    }


}
