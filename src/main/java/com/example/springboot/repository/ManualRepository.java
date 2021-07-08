package com.example.springboot.repository;

import com.example.springboot.entities.Manual;
import org.springframework.data.repository.CrudRepository;

public interface ManualRepository extends CrudRepository<Manual, Long> {
}
