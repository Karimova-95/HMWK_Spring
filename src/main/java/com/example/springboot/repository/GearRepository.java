package com.example.springboot.repository;

import com.example.springboot.entities.Gear;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GearRepository extends CrudRepository<Gear, Long> {
}
