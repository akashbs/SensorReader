package com.example.sensorreder.repository.impl;

import com.example.sensorreder.models.City;
import com.example.sensorreder.models.District;
import com.example.sensorreder.models.Sensor;
import com.example.sensorreder.models.SensorReading;
import com.example.sensorreder.repository.CustomSensorReadingRepository;
import com.example.sensorreder.result.SensorReadingResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CustomSensorReadingRepositoryImpl implements CustomSensorReadingRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<SensorReadingResult> findAllByCityDistrictStartTimestampAndEndTimestamp(
            String cityName,
            String districtName,
            Date startTime,
            Date endTime
    ) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SensorReadingResult> dataQuery = builder.createQuery(SensorReadingResult.class);

        Root<SensorReading> sensorReading = dataQuery.from(SensorReading.class);
        Root<Sensor> sensor = dataQuery.from(Sensor.class);
        Root<District> district = dataQuery.from(District.class);
        Root<City> city = dataQuery.from(City.class);

        List<Predicate> conditions = new ArrayList<>();

        conditions.add(builder.equal(sensorReading.get("sensor"), sensor));
        conditions.add(builder.equal(sensor.get("district"), district));
        conditions.add(builder.equal(district.get("city"), city));

        conditions.add(builder.equal(city.get("name"), cityName));

        if (StringUtils.isNotEmpty(districtName)) {
            conditions.add(builder.equal(district.get("name"), districtName));
        }

        if (null != startTime) {
            conditions.add(builder.greaterThanOrEqualTo(sensorReading.get("timestamp"), startTime));
        }

        if (null != endTime) {
            conditions.add(builder.lessThanOrEqualTo(sensorReading.get("timestamp"), endTime));
        }

        TypedQuery<SensorReadingResult> typedQuery = entityManager.createQuery(
                dataQuery.select(
                        builder.construct(
                                SensorReadingResult.class,
                                city.get("name"),
                                district.get("name"),
                                sensor.get("id"),
                                sensorReading.get("carbonReading"),
                                sensorReading.get("timestamp")
                        )
                ).where(conditions.toArray(new Predicate[]{}))
        );

        return typedQuery.getResultList();
    }
}
