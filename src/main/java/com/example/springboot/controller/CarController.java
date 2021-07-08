package com.example.springboot.controller;

import com.example.springboot.entities.Car;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/car/")
public class CarController {

    @Autowired
    private CarServiceImpl service;

    //get cars
    @GetMapping(value = "read", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public List<Car> getAll() {
        return service.getAll();
    }

    //save car
    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Car> create(@RequestBody Car car) {
        return  service.create(car);
    }

    //get car by id
    @GetMapping(value = "read/{id}")
    public ResponseEntity<Car> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return service.getById(id);
    }

    //update car by id
    @PostMapping(value = "update/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Car> update(@PathVariable(value = "id") Long id,
        @Validated @RequestBody Car carDetails) throws ResourceNotFoundException {
        return service.update(id, carDetails);
    }

    //delete car by id
    @PostMapping("delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return service.delete(id);
    }
}
