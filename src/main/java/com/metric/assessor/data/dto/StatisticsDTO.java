package com.metric.assessor.data.dto;

public class StatisticsDTO {
    private String sensorUuid;
    private double averageLastHour;
    private double averageLast7Days;
    private double maxLast30Days;

    public StatisticsDTO() {
    }

    public StatisticsDTO(String sensorUuid) {
        this.sensorUuid = sensorUuid;
    }

    public double getAverageLastHour() {
        return averageLastHour;
    }

    public void setAverageLastHour(double averageLastHour) {
        this.averageLastHour = averageLastHour;
    }

    public double getAverageLast7Days() {
        return averageLast7Days;
    }

    public void setAverageLast7Days(double averageLast7Days) {
        this.averageLast7Days = averageLast7Days;
    }

    public double getMaxLast30Days() {
        return maxLast30Days;
    }

    public void setMaxLast30Days(double maxLast30Days) {
        this.maxLast30Days = maxLast30Days;
    }

    public String getSensorUuid() {
        return sensorUuid;
    }
}
