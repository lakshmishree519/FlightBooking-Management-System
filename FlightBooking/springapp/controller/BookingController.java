package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.service.BookingService;
import com.examly.springapp.exception.FlightNotFoundException;
import com.examly.springapp.exception.SeatsExceededException;
import com.examly.springapp.exception.UpdateException;
import com.examly.springapp.exception.UserNotFoundException;
import com.examly.springapp.model.Booking;
@RestController
@CrossOrigin
public class BookingController {
    @Autowired
    BookingService bookingService;
    @PostMapping("/api/bookings")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) throws UserNotFoundException,FlightNotFoundException,SeatsExceededException{
        return ResponseEntity.status(201).body(bookingService.createBooking(booking));
    }
    @GetMapping("/api/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return ResponseEntity.status(200).body(bookingService.getAllBookings());
    }
    @GetMapping("/api/bookings/user/{userId}")
    public ResponseEntity<List<Booking>> getAllBookingByUser(@PathVariable int userId){
        return ResponseEntity.status(200).body(bookingService.getAllBookingByUser(userId));
    } 
    @GetMapping("/api/bookings/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable int id){
        return ResponseEntity.status(200).body(bookingService.getBookingById(id));
    }
    @PutMapping("/api/bookings/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable int id,@RequestBody Booking booking) throws UpdateException{
        return ResponseEntity.status(200).body(bookingService.updateBooking(id, booking));
    }
}
