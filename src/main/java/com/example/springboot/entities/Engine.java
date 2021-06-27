package com.example.springboot.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;



@Entity
@Data
@NoArgsConstructor
public class Engine {

    @Id
    @GeneratedValue
    private Long id;

    private String type;

    // в случае с bidirectional отношением, можно сослатся на название поля джава класса
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "engine")

    // иначе указываем названия полей в таблице, если вообще ничего не указать - сгенерируется само
    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "ENGINE_ID", referencedColumnName = "ID")
//    private List<Gear> gears;

//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Manual> manuals;

    public Engine(String engineType) {
        this.type = engineType;
//        this.gears = new LinkedList<>();
//        this.manuals = new LinkedList<>();
    }

    public String toString() {
        return type;
    }

}