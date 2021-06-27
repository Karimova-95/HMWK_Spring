package com.example.springboot.service;

import com.example.springboot.entities.SteeringWheel;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.repository.SteeringWheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SteeringWheelImpl implements SteeringWheelService {

    @Autowired
    private SteeringWheelRepository repository;

    @Override
    public List<SteeringWheel> getAll() {
        return (List<SteeringWheel>) this.repository.findAll();
    }

    @Override
    public Optional<SteeringWheel> create(SteeringWheel steeringWheel) {
        repository.save(steeringWheel);
        return  repository.findById(steeringWheel.getId());
    }

    @Override
    public ResponseEntity<SteeringWheel> getById(Long id) throws ResourceNotFoundException {
        SteeringWheel steeringWheel = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Steering Wheel not found for id = " + id));

        return ResponseEntity.ok().body(steeringWheel);
    }

    @Override
    public ResponseEntity<SteeringWheel> update(Long id, SteeringWheel steeringWheelDetails) throws ResourceNotFoundException {
        SteeringWheel steeringWheel = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Steering Wheel not found for id = " + id));
        steeringWheel.setType(steeringWheelDetails.getType());
        return ResponseEntity.ok(this.repository.save(steeringWheel));
    }

    @Override
    public Map<String, Boolean> delete(Long id) throws ResourceNotFoundException {
        SteeringWheel steeringWheel = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Steering Wheel not found for id = " + id));
        this.repository.delete(steeringWheel);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
