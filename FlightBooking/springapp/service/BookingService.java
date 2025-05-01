package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.exception.FlightNotFoundException;
import com.examly.springapp.exception.SeatsExceededException;
import com.examly.springapp.exception.UpdateException;
import com.examly.springapp.exception.UserNotFoundException;
import com.examly.springapp.model.Booking;
@Service
public interface BookingService {
    public Booking createBooking(Booking booking) throws UserNotFoundException, FlightNotFoundException, SeatsExceededException;
    public Booking getBookingById(int bookingId);
    public List<Booking> getAllBookings();
    public Booking updateBooking(int id,Booking booking) throws UpdateException;
    public List<Booking> getAllBookingByUser(int userId);
}
