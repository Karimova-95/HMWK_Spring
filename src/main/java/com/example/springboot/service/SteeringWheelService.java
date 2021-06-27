package com.example.springboot.service;

import com.example.springboot.entities.Car;
import com.example.springboot.entities.SteeringWheel;
import com.example.springboot.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SteeringWheelService {
    List<SteeringWheel> getAll();
    Optional<SteeringWheel> create(SteeringWheel steeringWheel);
    ResponseEntity<SteeringWheel> getById(Long id) throws ResourceNotFoundException;
    ResponseEntity<SteeringWheel> update(Long id, SteeringWheel steeringWheelDetails) throws ResourceNotFoundException;
    Map<String, Boolean> delete(Long id) throws ResourceNotFoundException;
}
