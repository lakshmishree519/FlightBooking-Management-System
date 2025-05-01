package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.DeleteException;
import com.examly.springapp.exception.UpdateException;
import com.examly.springapp.exception.UserNotFoundException;
import com.examly.springapp.model.Flight;
import com.examly.springapp.repository.FlightRepo;

public interface FlightService {

    public Flight addFlight(Flight flight) throws UserNotFoundException;

    public Flight getFlightById(long flightId);

    public Flight updateFlightById(long flightId, Flight flight) throws UpdateException;

    public void deleteFlightById(long flightId) throws DeleteException;

    public List<Flight> getAllFlights();
}
