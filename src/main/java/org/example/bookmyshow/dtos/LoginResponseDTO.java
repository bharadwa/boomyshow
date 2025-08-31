package org.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class LoginResponseDTO implements Serializable {

    private boolean isLoginSuccess;

    private ResponseStatus responseStatus;

    private String errorMessage;
}
