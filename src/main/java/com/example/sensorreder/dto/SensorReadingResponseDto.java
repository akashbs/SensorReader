package com.example.sensorreder.dto;

import java.util.List;

public class SensorReadingResponseDto {

    private String cityName;
    private List<ReadingDto> readings;

    public SensorReadingResponseDto(String cityName, List<ReadingDto> readings) {
        this.cityName = cityName;
        this.readings = readings;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    public List<ReadingDto> getReadings() {
        return readings;
    }

    public void setReadings(List<ReadingDto> readings) {
        this.readings = readings;
    }
}
