package com.example.springboot.controller;


import com.example.springboot.entities.Manual;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.service.ManualServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/manual/car/")
public class ManualController {

    @Autowired
    private ManualServiceImpl service;

    @GetMapping(value = "read")
    public List<Manual> getAll() {
        return service.getAll();
    }

    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Manual> create(@RequestBody Manual manual) {
        return  service.create(manual);
    }

    @GetMapping(value = "read/{id}")
    public ResponseEntity<Manual> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return service.getById(id);
    }

    @PostMapping(value = "update/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Manual> update(@PathVariable(value = "id") Long id,
                                         @Validated @RequestBody Manual manualDetails) throws ResourceNotFoundException {
        return service.update(id, manualDetails);
    }

    @PostMapping("delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return service.delete(id);
    }
}
