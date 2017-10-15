package com.metric.assessor;

import com.metric.assessor.data.dto.SensorDTO;
import com.metric.assessor.data.dto.StatisticsDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StatisticsTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:event_stat.sql")
    public void getEventStatistics() {
        Map dto = this.restTemplate.getForObject(
                "http://localhost:" + port + "/api/v1/sensors/s1/events", Map.class);
        Assert.assertEquals("s1", dto.get("sensorUuid"));
        List<Map> events = (List<Map>) dto.get("events");
        Assert.assertEquals(1, (Double) events.get(0).get("temperature"), 0.01);
        Assert.assertEquals(2, (Double) events.get(1).get("temperature"), 0.01);
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
