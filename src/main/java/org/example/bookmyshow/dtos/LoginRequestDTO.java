package org.example.bookmyshow.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO implements Serializable {


   private String email;

   private String password;
}
