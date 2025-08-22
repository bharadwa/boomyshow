package org.example.bookmyshow.models;

import jakarta.persistence.Entity;

@Entity(name="actors")
public class Actor extends BaseModel {

    private String name;

    private String phoneNumber;
}
