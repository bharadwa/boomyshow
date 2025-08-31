package org.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpUserResponseDTO {


    private String email;

    private String name;

    private String userType;

    private ResponseStatus responseStatus;

    private long userId;

}
