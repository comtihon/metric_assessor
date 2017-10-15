package com.metric.assessor.data.dao;

import com.metric.assessor.data.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventDao extends CrudRepository<Event, String> {
    List<Event> findBySensorUuid(String uuid);
}
