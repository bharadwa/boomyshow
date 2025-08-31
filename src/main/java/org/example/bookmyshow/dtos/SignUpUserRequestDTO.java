package org.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class SignUpUserRequestDTO implements Serializable {

    private String name;

    private String email;

    private String userType;

    private String password;

}
