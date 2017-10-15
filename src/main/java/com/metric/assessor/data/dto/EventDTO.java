package com.metric.assessor.data.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.metric.assessor.data.EventType;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;

public class EventDTO {
    @JsonIgnore
    private String sensorUuid;
    private double temperature;
    private Date at = new Date();
    private EventType type = EventType.TEMPERATURE_EXCEEDED;

    public EventDTO() {
    }

    public EventDTO(String sensorUuid, double temperature) {
        this.sensorUuid = sensorUuid;
        this.temperature = temperature;
    }

    public String getSensorUuid() {
        return sensorUuid;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getAt() {
        return ZonedDateTime.ofInstant(at.toInstant(),
                ZoneId.systemDefault()).format(ISO_OFFSET_DATE_TIME);
    }

    public void setSensorUuid(String sensorUuid) {
        this.sensorUuid = sensorUuid;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setAt(Date at) {
        this.at = at;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "sensorUuid='" + sensorUuid + '\'' +
                ", temperature=" + temperature +
                ", at=" + getAt() +
                ", type=" + type +
                '}';
    }
}
