package org.example.bookmyshow.dtos;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pair <T,U>{
    T first;
    U Second;
}
