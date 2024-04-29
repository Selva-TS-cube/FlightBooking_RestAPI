package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Flight;
import com.example.demo.service.FlightService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/flight")
public class FlightController {
    @Autowired
    private FlightService personService;

    @PostMapping
    public Flight createFlight(@RequestBody Flight person) {
        return personService.createFlight(person);
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return personService.getAllFlights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable(value = "id") Long id) {
        java.util.Optional<Flight> person = personService.getFlightById(id);
        if (person.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(person.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable(value = "id") Long id,  @RequestBody Flight personDetails) {
        personService.updateFlight(id, personDetails);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable(value = "id") Long id) {
        personService.deleteFlight(id);
        return ResponseEntity.ok().build();
    }
}
