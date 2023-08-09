package com.bms.bookmyshowjavaspringboot.services;

import com.bms.bookmyshowjavaspringboot.exceptions.InvalidArgumentException;
import com.bms.bookmyshowjavaspringboot.models.*;
import com.bms.bookmyshowjavaspringboot.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class TicketService {
    private final UserRepository userRepository;
    private final SeatRepository seatRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(UserRepository userRepository,
                         SeatRepository seatRepository,
                         ShowRepository showRepository,
                         ShowSeatRepository showSeatRepository,
                         TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.seatRepository = seatRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket bookTicket(Long showId, Long userId, List<Long> seatIds) throws InvalidArgumentException {
        /*
            1.get user, seats object
            2.get all the showseat objects
                1.take db lock on the seat rows
                2.check if all the seats are available then blocked them, also update last-updated
                3.if any of the seats is unavailable remove the lock and return
            3.get show object
            4.create ticket object
            5.save ticket in db
        */
        Optional<User> userOptional = this.userRepository.findById(userId);
        if (userOptional.isEmpty()){
            throw new InvalidArgumentException();
        }
        User user = userOptional.get();

        List<Seat> seats = this.seatRepository.findAllById(seatIds);

        Optional<Show> showOptional = this.showRepository.findById(showId);
        if (showOptional.isEmpty()){
            throw new InvalidArgumentException();
        }
        Show show = showOptional.get();

        this.getShowSeatsAndSetBlockedIfAvailable(seats, show);

        Ticket ticket = new Ticket();
        ticket.setBookedBy(user);
        ticket.setTicketStatus(TicketStatus.PROCESSING);
        ticket.setShow(show);
        ticket.setSeats(seats);
        ticket.setAmount(0);
        ticket.setCreatedAt(new Date());
        ticket.setLastUpdatedAt(new Date());
        ticket.setTimeOfBooking(new Date());

        return this.ticketRepository.save(ticket);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, timeout = 2)
    public void getShowSeatsAndSetBlockedIfAvailable(List<Seat> seats, Show show) throws InvalidArgumentException {
        List<ShowSeat> showSeats = this.showSeatRepository.findAllBySeatInAndShow(seats, show);
        for (ShowSeat showSeat : showSeats){
            boolean blocked = showSeat.getSeatStatus().equals(SeatStatus.BLOCKED) && TimeUnit.MILLISECONDS.toMinutes(new Date().getTime() - showSeat.getLockedAt().getTime())<15;
            if (!showSeat.getSeatStatus().equals(SeatStatus.EMPTY) || blocked){
                throw new InvalidArgumentException();
            }
        }
        for (ShowSeat showSeat : showSeats){
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
            showSeat.setLockedAt(new Date());
            this.showSeatRepository.save(showSeat);
        }
    }

}
