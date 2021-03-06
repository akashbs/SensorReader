package com.example.sensorreder.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Table(name = "SENSOR")
@Entity
public class Sensor {
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "district_id", nullable = false)
    public District district;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}