package com.example.bmsbookticket.models;


import lombok.Data;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
@Data
public class City extends BaseModel {
    private String name;
    @OneToMany(fetch = FetchType.LAZY,mappedBy="city")
    private List<Theatre> theatres;
}
