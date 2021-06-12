package com.example.allianhw.controller;


import com.example.allianhw.dto.SensorReadingResponseDto;
import com.example.allianhw.service.SensorReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("api")
public class SensorReadingController {

    @Autowired
    private SensorReadingService sensorReadingService;


    @GetMapping(value = "/sensor_data/{city}", produces = "application/json")
    @ResponseBody
    public SensorReadingResponseDto getSensorReadings(
            @PathVariable(value = "city") String city_name,
            @RequestParam(value = "district", required = false) String district_name,
            @RequestParam(value = "start_time", required = false) Date start_time,
            @RequestParam(value = "end_time", required = false) Date end_time
    ) {

        return sensorReadingService.fetchSensorReadingResponse(city_name, district_name, start_time, end_time, Pageable.unpaged());
    }

}
