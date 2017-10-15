package com.metric.assessor.data.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MetricDaoTest {
    @Autowired
    private MetricDao metricDao;

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:avg_1h.sql")
    public void averageLastHour() throws Exception {
        Assert.assertEquals(1.666, metricDao.averageLastHour("s1"), 0.01);
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:avg_7d.sql")
    public void averageLast7Days() throws Exception {
        Assert.assertEquals(1.714, metricDao.averageLast7Days("s1"), 0.01);
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:max_30d.sql")
    public void max30Days() throws Exception {
        Assert.assertEquals(5.0, metricDao.max30Days("s1"), 0.01);
    }

}