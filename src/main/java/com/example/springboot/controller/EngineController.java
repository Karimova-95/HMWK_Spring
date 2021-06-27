package com.example.springboot.controller;


import com.example.springboot.entities.Engine;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.service.EngineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/engine/")
public class EngineController {

    @Autowired
    private EngineServiceImpl service;

    @GetMapping(value = "read")
    public List<Engine> getAll() {
        return service.getAll();
    }

    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Engine> create(@RequestBody Engine engine) {
        return  service.create(engine);
    }

    @GetMapping(value = "read/{id}")
    public ResponseEntity<Engine> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return service.getById(id);
    }

    @PostMapping(value = "update/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Engine> update(@PathVariable(value = "id") Long id,
                                      @Validated @RequestBody Engine engineDetails) throws ResourceNotFoundException {
        return service.update(id, engineDetails);
    }

    @PostMapping("delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return service.delete(id);
    }
}
