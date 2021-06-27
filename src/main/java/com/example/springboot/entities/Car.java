package com.example.springboot.entities;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.repository.SteeringWheelRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mnfModel;
    private String modelName;


//    @OneToOne(cascade = CascadeType.ALL)
//    private Engine engine;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ENGINE_ID")
    private Engine engine;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STWH_ID")
    private SteeringWheel steeringWheel;

    public Car(String mnfModel, String modelName) {
        this.mnfModel = mnfModel;
        this.modelName = modelName;
    }

    public String toString() {
        return String.join(" ", mnfModel, modelName);
    }
}
