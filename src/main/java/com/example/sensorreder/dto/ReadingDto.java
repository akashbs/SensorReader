package com.example.allianhw.dto;

import java.util.Date;

public class ReadingDto {

    private String districtName;
    private Long sensorId;
    private Float carbonReading;
    private Date timestamp;

    public ReadingDto(String districtName, Long sensorId, Float carbonReading, Date timestamp) {
        this.districtName = districtName;
        this.sensorId = sensorId;
        this.carbonReading = carbonReading;
        this.timestamp = timestamp;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public Float getCarbonReading() {
        return carbonReading;
    }

    public void setCarbonReading(Float carbonReading) {
        this.carbonReading = carbonReading;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
