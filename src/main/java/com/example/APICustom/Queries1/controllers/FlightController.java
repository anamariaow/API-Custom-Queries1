package com.example.APICustom.Queries1.controllers;

import com.example.APICustom.Queries1.entities.Flight;
import com.example.APICustom.Queries1.enums.StatusEnum;
import com.example.APICustom.Queries1.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/provisionflights")
    public ResponseEntity<List<Flight>> provisionFlights(){
        List<Flight> flightList = flightService.provisionFlights();
        return ResponseEntity.ok().body(flightList);
    }
    //localhost:8080/flight/provisionflights

    @GetMapping("/allflights")
    public ResponseEntity<List<Flight>> selectAllFlights(){
        List<Flight> flightList = flightService.getAllFlights();
        return ResponseEntity.ok().body(flightList);
    }
    //localhost:8080/flight/allflights


    //CRUD
    @PostMapping("/createflight")
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.addFlight(flight));
    }
    //localhost:8080/flight/createflight

    @GetMapping("/findflights/{id}")
    public ResponseEntity<Optional<Flight>> findFlightById(@RequestParam Long id) {
        Optional<Flight> flightOptional = flightService.getFlightById(id);
        if (flightOptional.isPresent()) {
            return ResponseEntity.ok(flightOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //localhost:8080/flight/findflights/{id}?id=1

    @PutMapping("/updateflight")
    public ResponseEntity<Flight> modifyFlight(@PathVariable Long id, @RequestBody Flight flight) {
        Optional<Flight> flightOptional = flightService.updateFlight(id, flight);
        if (flightOptional.isPresent()) {
            return ResponseEntity.ok(flightOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //localhost:8080/flight/updateflight

    @PutMapping("/updatemeetsstatus")
    public ResponseEntity<Flight> updateFlightStatus(@PathVariable Long id, @RequestBody StatusEnum statusEnum) {
        Optional<Flight> flightOptional = flightService.updateFlightStatus(id, statusEnum);
        if (flightOptional.isPresent()) {
            return ResponseEntity.ok(flightOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //localhost:8080/flight/updatemeetsstatus

    @DeleteMapping("/deleteflight")
    public ResponseEntity<Flight> deleteFlight(Long id) {
        Optional<Flight> flightOptional = flightService.deleteFlight(id);
        if (flightOptional.isPresent()) {
            return ResponseEntity.ok(flightOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //localhost:8080/flight/deleteflight?id=2
}
