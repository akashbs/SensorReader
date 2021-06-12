package com.example.allianhw.repository;

import com.example.allianhw.result.SensorReadingResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface CustomSensorReadingRepository {

    Page<SensorReadingResult> findAllByCityDistrictStartTimestampAndEndTimestamp(String cityName, String districtName, Date startTime, Date endTime, Pageable pageable);
}