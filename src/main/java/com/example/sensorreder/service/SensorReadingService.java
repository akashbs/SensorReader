package com.example.allianhw.service;

import com.example.allianhw.dto.SensorReadingResponseDto;

import java.util.Date;

public interface SensorReadingService {
    SensorReadingResponseDto fetchSensorReadingResponse(String cityName, String districtName, Date startTime, Date endTime);
}
