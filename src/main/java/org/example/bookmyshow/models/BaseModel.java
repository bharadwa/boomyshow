package org.example.bookmyshow.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

import java.io.Serializable;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseModel {

    @Id
    private long id;
    private Date createAt;
    private Date modifiedAt;
}
