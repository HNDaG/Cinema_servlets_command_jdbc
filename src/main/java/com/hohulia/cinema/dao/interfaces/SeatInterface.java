package com.hohulia.cinema.dao.interfaces;

import com.hohulia.cinema.entities.Seat;

import java.util.List;

public interface SeatInterface {
    List<Seat> findByBookingId(long id);
    List<Seat> findByShowId(long id);
    void addSeat(Seat seat);
    void addSeat(List <Seat> seats);
    void deleteByBookingId(long id);

}
