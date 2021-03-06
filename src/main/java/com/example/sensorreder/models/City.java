package com.example.sensorreder.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Table(name = "CITY")
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String cityName) {
        this.name = cityName;
    }
}