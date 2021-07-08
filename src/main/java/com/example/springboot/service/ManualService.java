package com.example.springboot.service;

import com.example.springboot.entities.Manual;
import com.example.springboot.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ManualService {
    List<Manual> getAll();
    Optional<Manual> create(Manual manual);
    ResponseEntity<Manual> getById(Long id) throws ResourceNotFoundException;
    ResponseEntity<Manual> update(Long id, Manual manualDetails) throws ResourceNotFoundException;
    Map<String, Boolean> delete(Long id) throws ResourceNotFoundException;
}
