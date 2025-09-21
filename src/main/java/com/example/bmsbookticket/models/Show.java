package com.example.bmsbookticket.models;

import lombok.Data;

import java.util.Date;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
@Entity
@Data
public class Show extends BaseModel{
    private Date startTime;
    private Date endTime;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Feature> features;

    @ManyToOne
    private Screen screen;
}
