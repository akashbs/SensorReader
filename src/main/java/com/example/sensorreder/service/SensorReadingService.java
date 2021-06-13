package com.example.sensorreder.service;

import com.example.sensorreder.dto.SensorReadingResponseDto;

import java.util.Date;

public interface SensorReadingService {
    SensorReadingResponseDto fetchSensorReadingResponse(String cityName, String districtName, Date startTime, Date endTime);
}
