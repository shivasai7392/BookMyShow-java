package com.bms.bookmyshowjavaspringboot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeatType extends BaseModel{
    private Show show;
    private SeatType seatType;
    private int amount;
}
