package com.metric.assessor.data.dao;

import com.metric.assessor.data.entity.Metric;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricDao extends CrudRepository<Metric, String> {
    @Query(value = "SELECT AVG(temperature) as temperature " +
            " FROM metrics " +
            " WHERE sensor_uuid = ?1 " +
            " AND at > current_date - interval '1 hour';", nativeQuery = true)
    double averageLastHour(String uuid);

    @Query(value = "SELECT AVG(temperature) as temperature " +
            " FROM metrics " +
            " WHERE sensor_uuid = ?1 " +
            " AND at > current_date - interval '7 days';", nativeQuery = true)
    double averageLast7Days(String uuid);

    @Query(value = "SELECT MAX(temperature) as temperature " +
            " FROM metrics " +
            " WHERE sensor_uuid = ?1 " +
            " AND at > current_date - interval '30 days';", nativeQuery = true)
    double max30Days(String uuid);
}
