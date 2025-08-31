package org.example.bookmyshow.services;

import org.example.bookmyshow.dtos.Pair;
import org.example.bookmyshow.models.FormatType;
import org.example.bookmyshow.models.LanguageType;
import org.example.bookmyshow.models.SeatType;
import org.example.bookmyshow.models.Show;

import java.util.Date;
import java.util.List;

public interface ShowService {


    Show createShow(long userId, long movieId, long screenId, Date startTime,
                    Date endTime, List<Pair<SeatType,
                    Double>> seatPrices, List<FormatType> formatTypes, LanguageType languageType) throws Exception;
}
