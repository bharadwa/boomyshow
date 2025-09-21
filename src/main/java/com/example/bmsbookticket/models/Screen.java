package com.example.bmsbookticket.models;

import lombok.Data;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Data
public class Screen extends BaseModel{
    private String name;
    @OneToMany(fetch = FetchType.LAZY,mappedBy ="screen")
    private List<Seat> seats;

    @Enumerated(EnumType.STRING)
    private ScreenStatus status;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Feature> features;

    @ManyToOne(fetch=FetchType.LAZY)
    private Theatre theatre;
}
