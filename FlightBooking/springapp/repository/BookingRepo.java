package com.examly.springapp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Integer>{
    @Query("select b from Booking b where b.user.userId=?1")
    List<Booking> getAllBookingForUser(int userId);
    
    @Query("select b from Booking b where b.flight.flightNumber=?2 and b.bookingDate=?1")
    List<Booking> getAllBookingsByDate(String journeyDate,String flightNumber);

    Booking findByBookingDate(String bookingDate);
}
