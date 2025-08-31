package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="screens")
public class Screen extends BaseModel {

    private int screenNumber;

    @OneToMany(mappedBy = "screen", fetch = FetchType.LAZY)
    private List<Seat> seats;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = FormatType.class, fetch = FetchType.LAZY)
    private List<FormatType> screenFeatures;

    @ManyToOne(fetch = FetchType.LAZY)
    private Theater theater;
}
