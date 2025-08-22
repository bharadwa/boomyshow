package org.example.bookmyshow.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name="users")
public class User extends BaseModel {

    private String email;

    private String password;

    private String phoneNumber;

    private String address;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Booking> bookingList;
}
