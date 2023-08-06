package com.bms.bookmyshowjavaspringboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "seats")
public class Seat extends BaseModel{
    private String seatNumber;

    private int rowNo;

    private int colNo;

    @ManyToOne
    private SeatType seatType;
}
