package com.example.springboot.service;

import com.example.springboot.entities.Manual;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.repository.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ManualServiceImpl implements ManualService{

    @Autowired
    ManualRepository repository;

    public ManualServiceImpl(ManualRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Manual> getAll() {
        return (List<Manual>) this.repository.findAll();
    }

    @Override
    public Optional<Manual> create(Manual manual) {
        repository.save(manual);
        return  repository.findById(manual.getId());
    }

    @Override
    public ResponseEntity<Manual> getById(Long id) throws ResourceNotFoundException {
        Manual manual = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manual not found for id = " + id));

        return ResponseEntity.ok().body(manual);
    }

    @Override
    public ResponseEntity<Manual> update(Long id, Manual manualDetails) throws ResourceNotFoundException {
        Manual manual = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manual not found for id = " + id));
        manual.setType(manualDetails.getType());
        manual.setEngines(manualDetails.getEngines());
        return ResponseEntity.ok(this.repository.save(manual));
    }

    @Override
    public Map<String, Boolean> delete(Long id) throws ResourceNotFoundException {
        Manual manual = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manual not found for id = " + id));
        this.repository.delete(manual);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
