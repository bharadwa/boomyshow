package org.example.bookmyshow.models;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="regions")
public class Region extends BaseModel{

   private String name;

   private String description;

   @OneToMany(mappedBy ="region",fetch = FetchType.LAZY)
   private List<Theater> theaterList;


}
