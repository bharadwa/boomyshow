package org.example.bookmyshow.services;

import org.example.bookmyshow.dtos.Pair;
import org.example.bookmyshow.exceptions.*;
import org.example.bookmyshow.models.*;
import org.example.bookmyshow.repositories.*;
import org.example.bookmyshow.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShowServiceImpl  implements ShowService {

    private final ShowRepository showRepository;
    private final UserRepository userRepository;
    private final ShowSeatRepository showSeatRepository;
    private final ScreenRepository screenRepository;
    private final ShowSeatTypeRepository showSeatTypeRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public ShowServiceImpl(ShowRepository showRepository,
                           UserRepository userRepository,
                           ShowSeatRepository showSeatRepository,
                           ScreenRepository screenRepository,
                           ShowSeatTypeRepository showSeatTypeRepository,
                           MovieRepository movieRepository) {
        this.showRepository = showRepository;
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.screenRepository = screenRepository;
        this.showSeatTypeRepository = showSeatTypeRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    @Transactional
    public Show createShow(long userId,long movieId, long screenId, Date startTime,
                           Date endTime, List<Pair<SeatType, Double>> pricingConfig ,
                           List<FormatType> formatSupported,LanguageType languageType) throws Exception {
         User user= this.userRepository.findById(screenId).orElseThrow(()->new UserNotFoundException("User id not found"));
         if(user.getUserType()!=UserType.ADMIN) {
             throw new UnAuthorizedAccessException("Only admin can create show");
         }

         Screen screen= this.screenRepository.findById(screenId).orElseThrow(()->new ScreenNotFoundException("Screen not found"));
         Movie movie =this.movieRepository.findById(movieId).orElseThrow(()->new MovieNotFoundException("Movie not found"));
         if(screen.getScreenFeatures().containsAll(formatSupported)==false) {
             throw new FeatureNotSupportedByScreen("Screen does not support all format types");
         }

         if(!DateUtils.isValidShowtimings(startTime,endTime)) {
             throw new InvalidDateException("Invalid show timings");
         }
         Show show =new Show();
         show.setScreen(screen);
         show.setMovie(movie);
         show.setStartTime(startTime);
         show.setEndTime(endTime);
         show.setFormatType(formatSupported);
         show.setLanguage(languageType);
         show.setTheater(screen.getTheater());
        Show savedShow= showRepository.save(show);
         List<Seat> seats = screen.getSeats();

         if(!CollectionUtils.isEmpty(seats)) {
             List<ShowSeat> showSeats=new ArrayList<>();
             seats.stream().forEach(seat -> {
                 ShowSeat showSeat=new ShowSeat();
                 showSeat.setSeatStatus(SeatStatus.AVAILABLE);
                 showSeat.setShow(savedShow);
                 showSeat.setCreateAt(new Date());
                 showSeats.add(showSeat);
             });
             showSeatRepository.saveAll(showSeats);
         }
            if(!CollectionUtils.isEmpty(pricingConfig)) {
                List<ShowSeatType> showSeatPrices=new ArrayList<>();
                pricingConfig.stream().forEach( pair -> {
                    ShowSeatType showSeatPrice=new ShowSeatType();
                    showSeatPrice.setSeatType(pair.getFirst());
                    showSeatPrice.setPrice(pair.getSecond());
                    showSeatPrice.setShow(savedShow);
                    showSeatPrice.setCreateAt(new Date());
                    showSeatPrices.add(showSeatPrice);
                });
                showSeatTypeRepository.saveAll(showSeatPrices);
            }

         return savedShow;
    }
}
