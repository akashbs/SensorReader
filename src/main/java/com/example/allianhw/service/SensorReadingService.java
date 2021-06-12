package com.example.allianhw.service;

import com.example.allianhw.dto.SensorReadingResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface SensorReadingService {
    public SensorReadingResponseDto fetchSensorReadingResponse(String cityName, String districtName, Date startTime, Date endTime, Pageable pageable);
}
