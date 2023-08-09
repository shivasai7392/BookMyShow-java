package com.bms.bookmyshowjavaspringboot.controllers;

import com.bms.bookmyshowjavaspringboot.dtos.BookTicketRequestDto;
import com.bms.bookmyshowjavaspringboot.dtos.BookTicketResponseDto;
import com.bms.bookmyshowjavaspringboot.dtos.ResponseStatus;
import com.bms.bookmyshowjavaspringboot.exceptions.InvalidArgumentException;
import com.bms.bookmyshowjavaspringboot.models.Ticket;
import com.bms.bookmyshowjavaspringboot.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto BookTicket(BookTicketRequestDto requestDto){

        BookTicketResponseDto bookTicketResponseDto = new BookTicketResponseDto();
        Ticket ticket;

        Long userId = requestDto.getUserId();
        Long showId = requestDto.getShowId();
        List<Long> seatIds = requestDto.getSeatIds();

        try {
            ticket = this.ticketService.bookTicket(showId, userId, seatIds);
        }
        catch (InvalidArgumentException e){
            System.out.println(e.getMessage());
            bookTicketResponseDto.setStatus(ResponseStatus.FAILURE);
            return bookTicketResponseDto;
        }

        bookTicketResponseDto.setTicketId(ticket.getId());
        bookTicketResponseDto.setAmount(ticket.getAmount());
        bookTicketResponseDto.setStatus(ResponseStatus.SUCCESS);

        return bookTicketResponseDto;
    }
}
