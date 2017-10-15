insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m1', 's1', NOW(), 1.0);
insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m2', 's2', NOW(), 100);
insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m3', 's1', DATEADD(DAY, -5, GETDATE()), 1.0);
insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m4', 's1', DATEADD(DAY, -10, GETDATE()), 2.0);
insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m5', 's1', DATEADD(DAY, -15, GETDATE()), 3.0);
insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m6', 's1', DATEADD(DAY, -20, GETDATE()), 4.0);
insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m7', 's1', DATEADD(DAY, -25, GETDATE()), 5.0);
insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m8', 's1', DATEADD(DAY, -30, GETDATE()), 6.0);
