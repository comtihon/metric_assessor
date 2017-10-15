package com.metric.assessor.data.dao;

import com.metric.assessor.data.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventDaoService {

    @Autowired
    private EventDao eventDao;

    public List<Event> findByUuid(String uuid) {
        return eventDao.findBySensorUuid(uuid);
    }
}
