package com.metric.assessor.service;

import com.metric.assessor.data.dao.EventDaoService;
import com.metric.assessor.data.dao.MetricDaoService;
import com.metric.assessor.data.dto.EventDTO;
import com.metric.assessor.data.dto.SensorDTO;
import com.metric.assessor.data.dto.StatisticsDTO;
import com.metric.assessor.data.entity.Event;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AssessorService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EventDaoService eventDaoService;

    @Autowired
    private MetricDaoService metricDaoService;

    @Async
    public CompletableFuture<SensorDTO> getEvents(String uuid) {
        List<Event> events = eventDaoService.findByUuid(uuid);
        Type listType = new TypeToken<List<EventDTO>>() {
        }.getType();
        List<EventDTO> dtos = modelMapper.map(events, listType);
        return CompletableFuture.completedFuture(new SensorDTO(uuid, dtos));
    }

    @Async
    public CompletableFuture<StatisticsDTO> getStatistics(String uuid) {
        return CompletableFuture.completedFuture(metricDaoService.getStatistics(uuid));
    }
}
