package org.example.bookmyshow.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @Convert(converter = LanguageTypeListConverter.class)
    private List<LanguageType>  languagesSupported;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<FormatType> features;


}
