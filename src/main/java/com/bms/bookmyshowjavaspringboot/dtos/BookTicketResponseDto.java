package com.bms.bookmyshowjavaspringboot.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketResponseDto {
    private int amount;
    private Long ticketId;
    private List<Long> seatsId;
    private ResponseStatus status;
}
