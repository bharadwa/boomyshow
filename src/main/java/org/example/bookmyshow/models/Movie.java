package org.example.bookmyshow.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="movies")
public class Movie extends BaseModel {

    private String name;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<Actor> actors;

    private List<LanguageType>  languagesSupported;


}
