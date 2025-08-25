package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name="actors")
public class Actor extends BaseModel {

    private String name;

    private String phoneNumber;

    private String email;

    private String address;
}
