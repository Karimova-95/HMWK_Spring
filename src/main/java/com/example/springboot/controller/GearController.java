package com.example.springboot.controller;

import com.example.springboot.entities.Gear;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.service.GearServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/gear/")
public class GearController {

    @Autowired
    private GearServiceImpl service;

    @GetMapping(value = "read")
    public List<Gear> getAll() {
        return service.getAll();
    }

    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Gear> create(@RequestBody Gear gear) {
        return  service.create(gear);
    }

    @GetMapping(value = "read/{id}")
    public ResponseEntity<Gear> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return service.getById(id);
    }

    @PostMapping(value = "update/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Gear> update(@PathVariable(value = "id") Long id,
                                         @Validated @RequestBody Gear gearDetails) throws ResourceNotFoundException {
        return service.update(id, gearDetails);
    }

    @PostMapping("delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return service.delete(id);
    }
}
