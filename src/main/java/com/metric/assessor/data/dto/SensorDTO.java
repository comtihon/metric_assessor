package com.metric.assessor.data.dto;

import java.util.List;

public class SensorDTO {
    private String sensorUuid;
    private List<EventDTO> events;

    public SensorDTO() {
    }

    public SensorDTO(String sensorUuid, List<EventDTO> events) {
        this.sensorUuid = sensorUuid;
        this.events = events;
    }

    public String getSensorUuid() {
        return sensorUuid;
    }

    public List<EventDTO> getEvents() {
        return events;
    }

    @Override
    public String toString() {
        return "SensorDTO{" +
                "sensorUuid='" + sensorUuid + '\'' +
                ", events=" + events +
                '}';
    }
}
