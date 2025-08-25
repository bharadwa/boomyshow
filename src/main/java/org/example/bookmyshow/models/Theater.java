package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity(name="theaters")
public class Theater extends BaseModel {

    private String name;

    private String address;

    @OneToMany(mappedBy = "theater", fetch = FetchType.LAZY)
    private List<Screen> screenList;

    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;

}
