package com.example.allianhw.repository;

import com.example.allianhw.result.SensorReadingResult;

import java.util.Date;
import java.util.List;

public interface CustomSensorReadingRepository {

    List<SensorReadingResult> findAllByCityDistrictStartTimestampAndEndTimestamp(String cityName, String districtName,
                                                                                 Date startTime, Date endTime);
}