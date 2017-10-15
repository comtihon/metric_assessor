package com.metric.assessor.data.dao;

import com.metric.assessor.data.dto.StatisticsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricDaoService {
    @Autowired
    private MetricDao metricDao;

    public StatisticsDTO getStatistics(String uuid) {
        double max30d = metricDao.max30Days(uuid);
        double avg1h = metricDao.averageLastHour(uuid);
        double avg7d = metricDao.averageLast7Days(uuid);
        StatisticsDTO statisticsDTO = new StatisticsDTO(uuid);
        statisticsDTO.setAverageLast7Days(avg7d);
        statisticsDTO.setAverageLastHour(avg1h);
        statisticsDTO.setMaxLast30Days(max30d);
        return statisticsDTO;
    }
}
