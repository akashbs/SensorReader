package com.example.sensorreder.repository.impl;

import com.example.sensorreder.result.SensorReadingResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomSensorReadingRepositoryImplTest {

    private static final String clientToken = "token1";
    private static final String cityName = "Barcelona";
    private static final String districtName = "Gràcia";
    @Autowired
    CustomSensorReadingRepositoryImpl customSensorReadingRepositoryImpl;
    @Autowired
    private EntityManager entityManager;

    @Test
    public void testFindAllByCityDistrictStartTimestampAndEndTimestamp() {

        List<SensorReadingResult> results = customSensorReadingRepositoryImpl.findAllByCityDistrictStartTimestampAndEndTimestamp(
                cityName,
                districtName,
                Date.from(LocalDate.now().minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant())
        );
        assertEquals(2, results.size());
        SensorReadingResult result = results.stream().filter(city -> city.getCityName().equals(cityName)).findAny().orElse(null);
        assertEquals(cityName, result.getCityName());
        assertEquals(districtName, result.getDistrictName());
    }
}