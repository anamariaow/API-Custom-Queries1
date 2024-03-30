package com.example.APICustom.Queries1.services;

import com.example.APICustom.Queries1.entities.Flight;
import com.example.APICustom.Queries1.enums.StatusEnum;
import com.example.APICustom.Queries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    /**
     * this method finds a List of 50 Flights where all the string values
     * are randomly generated and the default status is ONTIME
     * @return List of Flight
     * @author anamariaow
     */
    public List<Flight> provisionFlights() {
        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight();
            flight.setDescription("Flight " + i);
            flight.setFromAirport("Airport " + i);
            flight.setToAirport("Airport " + (i + 1));
            flight.setStatusEnum(StatusEnum.ONTIME);
            flightRepository.save(flight);
        }
        return flightRepository.findAll();
    }

    /**
     * this method finds the list of Flight
     * @return List of Flight
     */
    public List<Flight> getAllFlights() {
        List<Flight> flightList = flightRepository.findAll();
        return flightList;
    }


    //CRUD
    /**
     * this method creates a new Flight
     * @param flight
     * @return Flight
     */
    public Flight addFlight(Flight flight) {
        Flight addedFlight = flightRepository.save(flight);
        return addedFlight;
    }

    /**
     * this method gets a Flight from its id
     * @param id
     * @return the Flight, if present, otherwise it returns nothing
     */
    public Optional<Flight> getFlightById(Long id) {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        if (flightOptional.isPresent()) {
            return flightOptional;
        } else {
            return Optional.empty();
        }
    }

    /**
     * this method gets a Flight from its id and updates the selected fields
     * @param id
     * @param flight
     * @return the updated Flight, if present, otherwise it returns nothing
     */
    public Optional<Flight> updateFlight(Long id, Flight flight) {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        if (flightOptional.isPresent()) {
            flightOptional.get().setDescription(flight.getDescription());
            flightOptional.get().setFromAirport(flight.getFromAirport());
            flightOptional.get().setToAirport(flight.getToAirport());
            flightOptional.get().setStatusEnum(flight.getStatusEnum());
            Flight savedFlight = flightRepository.save(flightOptional.get());
            return Optional.of(savedFlight);
        } else {
            return Optional.empty();
        }
    }

    /**
     * this method gets a Flight from its id and updates its status
     * @param id
     * @param statusEnum
     * @return the Flight with an updated status, if present, otherwise it returns nothing
     */
    public Optional<Flight> updateFlightStatus(Long id, StatusEnum statusEnum) {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        if (flightOptional.isPresent()) {
            flightOptional.get().setStatusEnum(statusEnum);
            Flight savedFlight = flightRepository.save(flightOptional.get());
            return Optional.of(savedFlight);
        } else {
            return Optional.empty();
        }
    }

    /**
     * this method deletes a Flight, from its id
     * @param id
     * @return the Flight just deleted, if present, otherwise it returns nothing
     */
    public Optional<Flight> deleteFlight(Long id) {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        if (flightOptional.isPresent()) {
            flightRepository.deleteById(flightOptional.get().getId());
            return Optional.of(flightOptional.get());
        } else {
            return Optional.empty();
        }
    }
}
