package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.CreateShowRequestDTO;
import org.example.bookmyshow.dtos.CreateShowResponseDTO;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.services.ShowService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/shows")
@RestController
public class ShowRestController {

    private final ShowService showService;

    public ShowRestController(ShowService showService) {
        this.showService = showService;
    }

    @PostMapping
    public CreateShowResponseDTO createShow(@RequestBody  CreateShowRequestDTO createShowRequestDTO) {
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
