package com.metric.assessor;

import com.metric.assessor.data.dto.SensorDTO;
import com.metric.assessor.data.dto.StatisticsDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StatisticsTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:event_stat.sql")
    public void getEventStatistics() {
        SensorDTO dto = this.restTemplate.getForObject(
                "http://localhost:" + port + "/api/v1/sensors/s1/events", SensorDTO.class);
        System.out.println(dto);
        Assert.assertEquals("s1", dto.getSensorUuid());
        Assert.assertEquals(1, dto.getEvents().get(0).getTemperature(), 0.01);
        Assert.assertEquals(2, dto.getEvents().get(1).getTemperature(), 0.01);
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:metric_stat.sql")
    public void getMetricStatistics() {
        StatisticsDTO dto = this.restTemplate.getForObject(
                "http://localhost:" + port + "/api/v1/sensors/s1/measurements", StatisticsDTO.class);
        Assert.assertEquals("s1", dto.getSensorUuid());
        Assert.assertEquals(2.0, dto.getAverageLastHour(), 0.01);
        Assert.assertEquals(1.75, dto.getAverageLast7Days(), 0.01);
        Assert.assertEquals(4.0, dto.getMaxLast30Days(), 0.01);
    }
}
