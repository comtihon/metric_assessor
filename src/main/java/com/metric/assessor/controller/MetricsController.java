package com.metric.assessor.controller;

import com.metric.assessor.data.dto.SensorDTO;
import com.metric.assessor.data.dto.StatisticsDTO;
import com.metric.assessor.service.AssessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

@RestController
public class MetricsController {

    private static final MediaType CONTENT_TYPE = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            StandardCharsets.UTF_8);

    @Autowired
    private AssessorService assessorService;

    @RequestMapping(path = "/api/v1/sensors/{uuid}/events", method = RequestMethod.GET)
    public CompletableFuture<ResponseEntity<?>> getEvents(@PathVariable("uuid") String uuid) {
        CompletableFuture<SensorDTO> saved = assessorService.getEvents(uuid);
        return saved.thenApply(this::returnResult);
    }

    @RequestMapping(path = "/api/v1/sensors/{uuid}/measurements", method = RequestMethod.GET)
    public CompletableFuture<ResponseEntity<?>> getMetrics(@PathVariable("uuid") String uuid) {
        CompletableFuture<StatisticsDTO> saved = assessorService.getStatistics(uuid);
        return saved.thenApply(this::returnResult);
    }

    private ResponseEntity<?> returnResult(Object result) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(CONTENT_TYPE);
        if (result != null)
            return new ResponseEntity<>(result, headers, HttpStatus.OK);
        return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
    }
}
