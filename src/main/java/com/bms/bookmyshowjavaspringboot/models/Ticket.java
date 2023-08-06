package com.bms.bookmyshowjavaspringboot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Ticket extends BaseModel{
    private int amount;
    private TicketStatus ticketStatus;
    private List<Payment> payments;
    private Date timeOfBooking;
    private Show show;
    private User bookedBy;
    private List<Seat> seats;
}
