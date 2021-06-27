package com.example.springboot.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table
public class SteeringWheel {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    String type;

    public SteeringWheel(String type) {
        this.type = type;
    }

}