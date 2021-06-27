package com.example.springboot.controller;

import com.example.springboot.entities.SteeringWheel;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.repository.SteeringWheelRepository;
import com.example.springboot.service.SteeringWheelImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/steeringwheel/")
public class SteeringWheelController {
    @Autowired
    private SteeringWheelImpl service;

    //get steeringWheel
    @GetMapping(value = "read")
    public List<SteeringWheel> getAllSteeringWheel() {
        return service.getAll();
    }

    //save steeringWheel
    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<SteeringWheel> createSteeringWheel(@RequestBody SteeringWheel steeringWheel) {
        return service.create(steeringWheel);
    }

    //get steeringWheel by id
    @GetMapping(value = "read/{id}")
    public ResponseEntity<SteeringWheel> getSteeringWheelById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return service.getById(id);
    }

    //update steeringWheel by id
    @PostMapping(value = "update/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SteeringWheel> updateSteeringWheel(@PathVariable(value = "id") Long id,
                                         @Validated @RequestBody SteeringWheel steeringWheelDetails) throws ResourceNotFoundException {
        return  service.update(id, steeringWheelDetails);
    }

    //delite steering Wheel by id
    @PostMapping("delete/{id}")
    public Map<String, Boolean> deleteSteeringWheel(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return service.delete(id);
    }
}
