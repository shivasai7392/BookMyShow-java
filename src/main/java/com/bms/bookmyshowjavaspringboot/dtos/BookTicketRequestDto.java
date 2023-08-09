package com.bms.bookmyshowjavaspringboot.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDto {
    private Long showId;
    private Long userId;
    private List<Long> seatIds;
}
