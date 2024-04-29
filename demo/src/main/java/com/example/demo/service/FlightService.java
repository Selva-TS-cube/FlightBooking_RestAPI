package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Flight;
import com.example.demo.repository.FlightRepository;

@Service
public class FlightService {
    @Autowired
    private FlightRepository personRepository;

    public Flight createFlight(Flight person) {
        return personRepository.save(person);
    }

    public List<Flight> getAllFlights() {
        return personRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        return personRepository.findById(id);
    }

    public void updateFlight(Long id, Flight personDetails) {
        Flight person = new Flight();
        person.setId(id);
        person.setName(personDetails.getName());
        person.setFlightClass(personDetails.getFlightClass());
        person.setFromLocation(personDetails.getFromLocation());
        person.setToLocation(personDetails.getToLocation());
        person.setTravelDate(personDetails.getTravelDate());
        person.setPhone(personDetails.getPhone());
        person.setEmail(personDetails.getEmail());
        person.setAge(personDetails.getAge());
        person.setGender(personDetails.getGender());
        
        // Set the additional fields
        
    
        personRepository.save(person);
    }
    

    public void deleteFlight(Long id) {
        personRepository.deleteById(id);
    }
}
