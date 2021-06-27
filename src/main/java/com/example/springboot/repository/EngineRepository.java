package com.example.springboot.repository;

import com.example.springboot.entities.Engine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends CrudRepository<Engine, Long> {
}
