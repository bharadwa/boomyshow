package org.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;

import java.io.Serializable;

@Getter
@Setter
public class LoginRequestDTO implements Serializable {


   private String email;

   private String password;
}
