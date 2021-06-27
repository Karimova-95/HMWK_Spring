package com.example.springboot.repository;

import com.example.springboot.entities.SteeringWheel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SteeringWheelRepository extends CrudRepository <SteeringWheel, Long> {
}
