package com.bms.bookmyshowjavaspringboot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String name;

    @OneToMany
    @JoinColumn(name = "auditorium_id")
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
