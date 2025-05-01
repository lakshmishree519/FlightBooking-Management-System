package com.examly.springapp.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.DeleteException;
import com.examly.springapp.exception.UpdateException;
import com.examly.springapp.exception.UserNotFoundException;
import com.examly.springapp.model.Flight;
import com.examly.springapp.repository.FlightRepo;
import com.examly.springapp.service.FlightService;
@Service
public class FlightServiceImpl implements FlightService{
    @Autowired
    FlightRepo flightRepo;
    public Flight addFlight(Flight flight) throws UserNotFoundException{
        Flight searchedFlight = flightRepo.findByFlightNumber(flight.getFlightNumber());
        if(searchedFlight != null)
            throw new UserNotFoundException("Model : Flight with same number exists");
        searchedFlight = flightRepo.save(flight);
        return searchedFlight;
    }
    public Flight getFlightById(long flightId){
        return flightRepo.findById(flightId).orElse(null);
    }
    public Flight updateFlightById(long flightId, Flight flight) throws UpdateException{
        Flight toBeUpdated = flightRepo.findById(flightId).orElse(null);
        if(toBeUpdated == null)
            throw new UpdateException("User with same id already exists");
        toBeUpdated.setFlightId(flightId);
        toBeUpdated= flightRepo.save(flight);
        return toBeUpdated;
    }
    public void deleteFlightById(long flightId) throws DeleteException{
        Flight toBeDeleted = flightRepo.findById(flightId).orElse(null);
        if(toBeDeleted == null)
            throw new DeleteException("Not found to be deleted");
        flightRepo.deleteById(flightId);
    }
    public List<Flight> getAllFlights(){
        return flightRepo.findAll();
    }
}
