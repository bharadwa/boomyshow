package org.example.bookmyshow.models;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity(name="regions")
public class Region extends BaseModel{

   private String name;

   private String description;

   @OneToMany(mappedBy ="region",fetch = FetchType.LAZY)
   private List<Theater> theaterList;


}
