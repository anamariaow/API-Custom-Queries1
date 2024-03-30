package com.example.APICustom.Queries1.repositories;

import com.example.APICustom.Queries1.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("SELECT f FROM Flight f WHERE statusEnum = 'ONTIME'")
    List<Flight> findAllFlights();
}
