package com.example.sensorreder.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;


@Component
@Table(name = "SENSOR_READING")
@Entity
public class SensorReading {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;
    @Column(name = "carbon_reading", nullable = false)
    private Float carbonReading;
    private Date timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Float getCarbonReading() {
        return carbonReading;
    }

    public void setCarbonReading(Float carbonReading) {
        this.carbonReading = carbonReading;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}