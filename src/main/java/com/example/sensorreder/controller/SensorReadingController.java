package com.example.sensorreder.controller;


import com.example.sensorreder.excpetion.UnauthorisedException;
import com.example.sensorreder.service.ClientService;
import com.example.sensorreder.service.SensorReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("api")
public class SensorReadingController {

    @Autowired
    private SensorReadingService sensorReadingService;

    @Autowired
    private ClientService clientService;


    @GetMapping(value = "/sensor_data/{city}", produces = "application/json")
    @ResponseBody
    public ResponseEntity getSensorReadings(
            @PathVariable(value = "city") String cityName,
            @RequestParam(value = "district", required = false) String districtName,
            @RequestParam(value = "startTime", required = false) Date startTime,
            @RequestParam(value = "endTime", required = false) Date endTime,
            @RequestHeader HttpHeaders headers
    ) {
        String clientToken = headers.getFirst(HttpHeaders.AUTHORIZATION);

        try {
            clientService.authenticateRequestByToken(clientToken, cityName);
        } catch (UnauthorisedException unauthorisedException) {
            return new ResponseEntity<String>(unauthorisedException.getMessage(), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity(sensorReadingService.fetchSensorReadingResponse(cityName, districtName, startTime, endTime), HttpStatus.OK);
    }

}
