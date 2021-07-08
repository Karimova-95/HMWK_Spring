package com.example.springboot.service;

import com.example.springboot.entities.Car;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository repository;



    @Override
    public List<Car> getAll() {
        return (List<Car>) this.repository.findAll();
    }

    @Override
    public Optional<Car> create(Car car) {
        repository.save(car);
        return  repository.findById(car.getId());
    }

    @Override
    public ResponseEntity<Car> getById(Long id) throws ResourceNotFoundException {
        Car car = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found for id = " + id));

        return ResponseEntity.ok().body(car);
    }

    @Override
    public ResponseEntity<Car> update(Long id, Car carDetails) throws ResourceNotFoundException {
        Car car = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found for id = " + id));
        car.setMnfModel(carDetails.getMnfModel());
        car.setModelName(carDetails.getModelName());
        car.setSteeringWheel(carDetails.getSteeringWheel());
        car.setEngine(carDetails.getEngine());
        car.setEngine(carDetails.getEngine());
        return ResponseEntity.ok(this.repository.save(car));
    }

    @Override
    public Map<String, Boolean> delete(Long id) throws ResourceNotFoundException {
        Car car = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found for id = " + id));
        this.repository.delete(car);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }

}
