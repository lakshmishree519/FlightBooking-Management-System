package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.exception.DeleteException;
import com.examly.springapp.exception.UpdateException;
import com.examly.springapp.exception.UserNotFoundException;
import com.examly.springapp.model.Flight;
import com.examly.springapp.service.FlightService;
import com.examly.springapp.service.serviceImpl.FlightServiceImpl;

@RestController
@CrossOrigin
public class FlightController {
    @Autowired
    FlightService flightService;
    @PostMapping("/api/flights")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) throws UserNotFoundException{
        return ResponseEntity.status(200).body(flightService.addFlight(flight));
    }
    @PutMapping("/api/flight/{flightId}")
    public ResponseEntity<Flight> updateFlight(@PathVariable long flightId, @RequestBody Flight flight) throws UpdateException{
        return ResponseEntity.status(200).body(flightService.updateFlightById(flightId, flight));
    }
    @GetMapping("/api/flights")
    public ResponseEntity<List<Flight>> getFlights(){
        return ResponseEntity.status(200).body(flightService.getAllFlights());
    }
    @GetMapping("/api/flights/{flightId}")
    public ResponseEntity<Flight> getById(@PathVariable long flightId){
        return ResponseEntity.status(200).body(flightService.getFlightById(flightId));
    }
    @DeleteMapping("/api/flights/{flightId}")
    public ResponseEntity<Boolean> deleteByid(@PathVariable long flightId) throws DeleteException{
        flightService.deleteFlightById(flightId);
        return ResponseEntity.status(200).body(true);
    }
}
