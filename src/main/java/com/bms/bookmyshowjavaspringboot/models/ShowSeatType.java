package com.bms.bookmyshowjavaspringboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Show show;

    @ManyToOne
    private SeatType seatType;

    private int amount;
}
