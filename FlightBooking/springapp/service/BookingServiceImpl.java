package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.FlightNotFoundException;
import com.examly.springapp.exception.SeatsExceededException;
import com.examly.springapp.exception.UpdateException;
import com.examly.springapp.exception.UserNotFoundException;
import com.examly.springapp.model.Booking;
import com.examly.springapp.model.Flight;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.BookingRepo;
import com.examly.springapp.repository.FlightRepo;
import com.examly.springapp.repository.UserRepo;
@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    BookingRepo bookingRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    FlightRepo flightRepo;
    @Override
    public Booking createBooking(Booking booking) throws UserNotFoundException, FlightNotFoundException,SeatsExceededException{
        Flight innerFlight = flightRepo.findByFlightNumber(booking.getFlight().getFlightNumber());
        if (innerFlight != null) {
            List<Booking> bookingsDoneNow = bookingRepo.getAllBookingsByDate(booking.getBookingDate(), booking.getFlight().getFlightNumber());
            int totalSeats = 0;
            for(Booking b:bookingsDoneNow){
                totalSeats += b.getNumberOfPassengers();
            }            
            if (innerFlight.getTotalSeats()-totalSeats >= booking.getNumberOfPassengers()){
                booking.setFlight(innerFlight);
                booking.setStatus("Booked");
                booking = bookingRepo.save(booking);
                return booking;
            } else {
                throw new SeatsExceededException("Seats not available");
            }
        } else {
            throw new FlightNotFoundException("Flight not available");
        }

    }
    @Override
    public Booking getBookingById(int bookingId) {
        Booking toBeFoundBooking = bookingRepo.findById(bookingId).orElse(null);
        return toBeFoundBooking;
    }
    @Override
    public List<Booking> getAllBookings() {
       return bookingRepo.findAll();    
    }
    @Override
    public Booking updateBooking(int id, Booking booking) throws UpdateException {
        Booking toBeUpdated = bookingRepo.findById(id).orElse(null);
        if(toBeUpdated == null)
            throw new UpdateException("Booking doesn't exist");
        toBeUpdated = bookingRepo.save(booking); 
        return toBeUpdated;
    }
    @Override
    public List<Booking> getAllBookingByUser(int userId) {
        User user = userRepo.findById(userId).orElse(null);
        if(user!=null){
            List<Booking> bookings = bookingRepo.getAllBookingForUser(userId);
            return bookings;
        }
        return null;
    }
}
