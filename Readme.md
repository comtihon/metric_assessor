# Metrics Assessor [![Build Status](https://travis-ci.org/comtihon/metric_assessor.svg?branch=master)](https://travis-ci.org/comtihon/metric_assessor)
Service for accessing devices metrics and events.

## Run
Ensure that [PostgreSql](https://www.postgresql.org/) is accessible before running the service.  
Postrges access url is specified in application.properties for `spring.datasource.url`

### In docker

    sudo ./gradlew build buildDocker
    sudo docker run -p 8080:8080 -t com.metric.assessor

### In OS
    
    ./gradlew bootRun
    
## Testing

    ./gradlew check

## Protocol
GET __/api/v1/sensors/{uuid}/events__ to get all events of the sensor.  
Where:  
`uuid` is the sensor's uuid.  
Reply:

    {
        "sensorUuid" : "<uuid>",
        "events" : 
        [
            {
                "type" : "<Type>",
                "at" : "<Date>",
                "temperature" : <Temperature>
            }
        ]
    }
Where:  
`uuid` is sensor's uuid String.  
`Type` is the event's type String (_TEMPERATURE_EXCEEDED_).  
`at` is a date of event in ISO_OFFSET_DATE_TIME format.  
`temperature` is the temperature on the moment event was fired. It is double.  

GET __/api/v1/sensors/{uuid}/measurements__ to get sensor's statistics.  
Where:  
`uuid` is the sensor's uuid.  
Reply:

    {
        "sensorUuid" : "<uuid>",
        "averageLastHour" : <avg1h>
        "averageLast7Days" : <avg7d>
        "maxLast30Days" : <max30d>
    }
Where:  
`uuid` is sensor's uuid String.  
`avg1h` is an average temperature for last hour.  
`avg7d` is an average temperature for last 7 days.  
`max30d` is a maximum temperature for last 30 days.  