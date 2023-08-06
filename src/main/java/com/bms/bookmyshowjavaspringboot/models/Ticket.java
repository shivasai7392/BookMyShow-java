package com.bms.bookmyshowjavaspringboot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;

    @OneToMany
    private List<Payment> payments;

    private Date timeOfBooking;

    @ManyToOne
    private Show show;

    @ManyToOne
    private User bookedBy;

    @ManyToMany
    private List<Seat> seats;
}
