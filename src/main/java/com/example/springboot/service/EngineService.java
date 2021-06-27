package com.example.springboot.service;

import com.example.springboot.entities.Engine;
import com.example.springboot.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EngineService {
    List<Engine> getAll();
    Optional<Engine> create(Engine engine);
    ResponseEntity<Engine> getById(Long id) throws ResourceNotFoundException;
    ResponseEntity<Engine> update(Long id, Engine engineDetails) throws ResourceNotFoundException;
    Map<String, Boolean> delete(Long id) throws ResourceNotFoundException;
}
