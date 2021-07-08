package com.example.springboot.service;

import com.example.springboot.entities.Gear;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.repository.GearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GearServiceImpl implements GearService{

    @Autowired
    private GearRepository repository;

    @Override
    public List<Gear> getAll() {
        return (List<Gear>) this.repository.findAll();
    }

    @Override
    public Optional<Gear> create(Gear gear) {
        repository.save(gear);
        return  repository.findById(gear.getId());
    }

    @Override
    public ResponseEntity<Gear> getById(Long id) throws ResourceNotFoundException {
        Gear gear = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gear not found for id = " + id));
        return ResponseEntity.ok().body(gear);
    }

    @Override
    public ResponseEntity<Gear> update(Long id, Gear gearDetails) throws ResourceNotFoundException {
        Gear gear = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gear not found for id = " + id));
        gear.setGearSize(gearDetails.getGearSize());
        return ResponseEntity.ok(this.repository.save(gear));
    }

    @Override
    public Map<String, Boolean> delete(Long id) throws ResourceNotFoundException {
        Gear gear = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gear not found for id = " + id));
        this.repository.delete(gear);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
