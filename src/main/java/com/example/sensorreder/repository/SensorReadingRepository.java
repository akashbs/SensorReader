package com.example.sensorreder.repository;

import com.example.sensorreder.models.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorReadingRepository extends JpaRepository<SensorReading, Long>, CustomSensorReadingRepository {
}