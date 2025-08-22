package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CascadeType;

import java.util.Date;

@Getter
@Setter
@Entity(name ="shows")
public class Show extends BaseModel {


    @OneToOne(fetch = FetchType.EAGER)
    private Movie movie;

    @OneToOne(fetch = FetchType.EAGER)
    private Theater theater;

    @OneToOne(fetch = FetchType.EAGER)
    private Screen screen;

    private Date showTime;

    private LanguageType language;

    private FormatType formatType;


}
