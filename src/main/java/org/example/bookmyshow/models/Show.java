package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CascadeType;

import java.util.Date;
import java.util.List;

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
