package com.example.springboot.service;

import com.example.springboot.entities.Engine;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.repository.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EngineServiceImpl implements EngineService{

    @Autowired
    private EngineRepository repository;

    @Override
    public List<Engine> getAll() {
        return (List<Engine>) this.repository.findAll();
    }

    @Override
    public Optional<Engine> create(Engine engine) {
        repository.save(engine);
        return  repository.findById(engine.getId());
    }

    @Override
    public ResponseEntity<Engine> getById(Long id) throws ResourceNotFoundException {
        Engine engine = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Engine not found for id = " + id));
        return ResponseEntity.ok().body(engine);
    }

    @Override
    public ResponseEntity<Engine> update(Long id, Engine engineDetails) throws ResourceNotFoundException {
        Engine engine = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Engine not found for id = " + id));
        engine.setType(engineDetails.getType());
        engine.setGears(engineDetails.getGears());
        return ResponseEntity.ok(this.repository.save(engine));
    }

    @Override
    public Map<String, Boolean> delete(Long id) throws ResourceNotFoundException {
        Engine engine = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Engine not found for id = " + id));
        this.repository.delete(engine);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
