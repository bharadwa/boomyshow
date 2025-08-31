package org.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bookmyshow.models.FormatType;
import org.example.bookmyshow.models.LanguageType;
import org.example.bookmyshow.models.SeatType;
import org.example.bookmyshow.models.Show;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class CreateShowRequestDTO implements Serializable {


    private long userId;
    private long movieId;
    private long screenId;
    private Date startTime;
    private Date endTime;
    private List<FormatType> formatSupported;
    private List<Pair<SeatType, Double>> pricingConfig;
    private LanguageType languageType;

}
