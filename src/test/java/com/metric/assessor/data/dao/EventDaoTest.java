package com.metric.assessor.data.dao;

import com.metric.assessor.data.entity.Event;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class EventDaoTest {
    @Autowired
    private EventDao eventDao;

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:events.sql")
    public void findByUuid() {
        Iterable<Event> itr = eventDao.findBySensorUuid("sensor1");
        List<Event> events = new ArrayList<>((Collection<Event>) itr);
        Assert.assertEquals(5, events.size());
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals("e" + (1 + i), events.get(i).getEventId());
            Assert.assertEquals(i + 1, events.get(i).getTemperature(), 0.1);
        }
    }
}