package com.example.bmsbookticket.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name="users")
@Data
public class User extends BaseModel{

    private String name;
    private String email;
    private String password;
}
