package com.example.allianhw.service.impl;

import com.example.allianhw.dto.ReadingDto;
import com.example.allianhw.dto.SensorReadingResponseDto;
import com.example.allianhw.repository.SensorReadingRepository;
import com.example.allianhw.result.SensorReadingResult;
import com.example.allianhw.service.SensorReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorReadingServiceImpl implements SensorReadingService {

    @Autowired
    SensorReadingRepository sensorReadingRepository;

    @Override
    public SensorReadingResponseDto fetchSensorReadingResponse(String cityName, String districtName, Date startTime, Date endTime, Pageable pageable) {
        Page<SensorReadingResult> resultPage = sensorReadingRepository.findAllByCityDistrictStartTimestampAndEndTimestamp(cityName, districtName, startTime, endTime, pageable);
        List<SensorReadingResult> resultList = resultPage.stream().collect(Collectors.toList());
        return new SensorReadingResponseDto(
                resultList.get(0).getCityName(),
                resultList.stream().map(result -> new ReadingDto(result.getDistrictName(), result.getSensorId(), result.getCarbonReading(), result.getTimestamp()))
                .collect(Collectors.toList())
                );
    }
}
