package com.example.sensorreder.repository;

import com.example.sensorreder.result.SensorReadingResult;

import java.util.Date;
import java.util.List;

public interface CustomSensorReadingRepository {

    List<SensorReadingResult> findAllByCityDistrictStartTimestampAndEndTimestamp(String cityName, String districtName,
                                                                                 Date startTime, Date endTime);
}