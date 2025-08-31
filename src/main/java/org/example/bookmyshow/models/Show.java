package org.example.bookmyshow.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="shows")
public class Show extends BaseModel {


    @ManyToOne(fetch = FetchType.EAGER)
    private Movie movie;

    @ManyToOne(fetch = FetchType.EAGER)
    private Theater theater;

    @ManyToOne(fetch = FetchType.EAGER)
    private Screen screen;

    private Date startTime;

    private Date endTime;

    @OneToMany(mappedBy = "show",fetch = FetchType.LAZY)
    private List<ShowSeat> showSeatList;

    @OneToMany(mappedBy = "show",fetch = FetchType.LAZY)
    private List<ShowSeatPrice> showSeatPriceList;

    @Enumerated(EnumType.STRING)
    private LanguageType language;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<FormatType> formatType;


}
