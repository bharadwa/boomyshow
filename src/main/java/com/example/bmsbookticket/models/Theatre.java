package com.example.bmsbookticket.models;


import lombok.Data;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Data
public class Theatre extends BaseModel{

    private String name;

    private String address;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "theatre")
    private List<Screen> screens;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

}
