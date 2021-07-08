package com.example.springboot.service;

import com.example.springboot.entities.Engine;
import com.example.springboot.entities.Gear;
import com.example.springboot.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GearService {
    List<Gear> getAll();
    Optional<Gear> create(Gear gear);
    ResponseEntity<Gear> getById(Long id) throws ResourceNotFoundException;
    ResponseEntity<Gear> update(Long id, Gear gearDetails) throws ResourceNotFoundException;
    Map<String, Boolean> delete(Long id) throws ResourceNotFoundException;
}
