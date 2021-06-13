package com.example.sensorreder.service.impl;

import com.example.sensorreder.dto.ReadingDto;
import com.example.sensorreder.dto.SensorReadingResponseDto;
import com.example.sensorreder.repository.SensorReadingRepository;
import com.example.sensorreder.result.SensorReadingResult;
import com.example.sensorreder.service.SensorReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorReadingServiceImpl implements SensorReadingService {

    @Autowired
    SensorReadingRepository sensorReadingRepository;

    @Override
    public SensorReadingResponseDto fetchSensorReadingResponse(String cityName, String districtName, Date startTime, Date endTime) {
        List<SensorReadingResult> resultList = sensorReadingRepository.findAllByCityDistrictStartTimestampAndEndTimestamp(cityName, districtName, startTime, endTime);
        return new SensorReadingResponseDto(
                resultList.get(0).getCityName(),
                resultList.stream().map(result -> new ReadingDto(result.getDistrictName(), result.getSensorId(), result.getCarbonReading(), result.getTimestamp()))
                        .collect(Collectors.toList())
        );
    }
}
