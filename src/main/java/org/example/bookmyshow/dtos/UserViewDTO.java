package org.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserViewDTO implements Serializable {

    private long userId;
    private String name;
    private String email;
    private String userType;
    private ResponseStatus responseStatus;

}
