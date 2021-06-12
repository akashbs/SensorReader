package com.example.allianhw.repository.impl;

import com.example.allianhw.models.City;
import com.example.allianhw.models.District;
import com.example.allianhw.models.Sensor;
import com.example.allianhw.models.SensorReading;
import com.example.allianhw.repository.CustomSensorReadingRepository;
import com.example.allianhw.result.SensorReadingResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CustomSensorReadingRepositoryImpl implements CustomSensorReadingRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Page<SensorReadingResult> findAllByCityDistrictStartTimestampAndEndTimestamp(String cityName, String districtName, Date startTime, Date endTime, Pageable pageable) {

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

        typedQuery.setFirstResult(1 * 10);
        typedQuery.setMaxResults(10);
        return new PageImpl<>(typedQuery.getResultList(), pageable, getAllCount(cityName, districtName, startTime, endTime));
    }

    private Long getAllCount(String cityName, String districtName, Date startTime, Date endTime) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);

        Root<SensorReading> sensorReading = countQuery.from(SensorReading.class);
        Join<SensorReading, Sensor> sensor = sensorReading.join("sensor");
        Join<Sensor, District> district = sensor.join("district");
        Join<District, City> city = district.join("city");


        List<Predicate> conditions = new ArrayList<>();
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
        countQuery.select(builder.count(sensorReading)).where(builder.and(conditions.toArray(new Predicate[]{})));
        return entityManager.createQuery(countQuery).getSingleResult();
    }
}
