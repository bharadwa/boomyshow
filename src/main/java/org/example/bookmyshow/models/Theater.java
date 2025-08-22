package org.example.bookmyshow.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity(name="theaters")
public class Theater extends BaseModel {

    private String name;

    private String address;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<Screen> screenList;

}
