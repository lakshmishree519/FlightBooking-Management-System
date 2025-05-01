package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.service.FlightService;

@RestController
public class TestController{
    @Autowired
    FlightService flightService;
    @GetMapping("/api/test/welcome")
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<>("Welcome to the Flight Booking Application",HttpStatus.OK);
    }
    @GetMapping("api/test/flights")
    public ResponseEntity<?> getAllFlights(){
        return ResponseEntity.status(200).body(flightService.getAllFlights());
    }
}