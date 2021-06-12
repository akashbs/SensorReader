package com.example.allianhw.repository;

import com.example.allianhw.models.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorReadingRepository extends JpaRepository<SensorReading, Long>, CustomSensorReadingRepository {
}