package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.CreateShowRequestDTO;
import org.example.bookmyshow.dtos.CreateShowResponseDTO;
import org.example.bookmyshow.dtos.ResponseStatus;

import org.example.bookmyshow.services.ShowService;
import org.springframework.stereotype.Controller;

@Controller
public class ShowController {

   private final ShowService showService;

   public ShowController(ShowService showService) {
        this.showService = showService;
    }

    public CreateShowResponseDTO createShow(CreateShowRequestDTO createShowRequestDTO) {
        CreateShowResponseDTO responseDTO= new CreateShowResponseDTO();
        try {
            this.showService.createShow(createShowRequestDTO.getUserId(), createShowRequestDTO.getMovieId(),
                    createShowRequestDTO.getScreenId(), createShowRequestDTO.getStartTime(), createShowRequestDTO.getEndTime(),
                    createShowRequestDTO.getPricingConfig(), createShowRequestDTO.getFormatSupported(), createShowRequestDTO.getLanguageType());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }

}
