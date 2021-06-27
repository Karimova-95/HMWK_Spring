package com.example.springboot.service;

import com.example.springboot.entities.Car;
import com.example.springboot.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CarService{
    List<Car> getAll();
    Optional<Car> create(Car car);
    ResponseEntity<Car> getById(Long id) throws ResourceNotFoundException;
    ResponseEntity<Car> update(Long id, Car carDetails) throws ResourceNotFoundException;
    Map<String, Boolean> delete(Long id) throws ResourceNotFoundException;
}
