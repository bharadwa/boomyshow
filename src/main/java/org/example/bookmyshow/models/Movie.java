package org.example.bookmyshow.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="movies")
public class Movie extends BaseModel {

    private String name;

    private String description;

    private String director;

    private String title;

    private float runTime;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Actor> actors;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.LAZY)
    private List<LanguageType>  languagesSupported;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.LAZY)
    private List<FormatType> features;

}
