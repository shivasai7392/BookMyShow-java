package com.bms.bookmyshowjavaspringboot.repositories;

import com.bms.bookmyshowjavaspringboot.models.Seat;
import com.bms.bookmyshowjavaspringboot.models.Show;
import com.bms.bookmyshowjavaspringboot.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Seat> {

    //@Query("select * from show_seats where {condition} FOR UPDATE")
    @Lock(LockModeType.PESSIMISTIC_WRITE)//this annotation is adding "for update" command at the end of the query.
    List<ShowSeat> findAllBySeatInAndShow(List<Seat> seats, Show show);

    ShowSeat save(ShowSeat showSeat);

}
