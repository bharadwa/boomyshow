package org.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.bookmyshow.models.Show;

import java.io.Serializable;

@Setter
@Getter
public class CreateShowResponseDTO implements Serializable {
    private Show show;
    private ResponseStatus responseStatus;

}
