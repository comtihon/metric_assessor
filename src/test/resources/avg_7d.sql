insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m1', 's1', NOW(), 1.0);
insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m2', 's1', DATEADD(DAY, -1, GETDATE()), 1.0);
insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m3', 's1', DATEADD(DAY, -2, GETDATE()), 1.0);
insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m4', 's1', DATEADD(DAY, -3, GETDATE()), 1.0);
insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m5', 's1', DATEADD(DAY, -4, GETDATE()), 1.0);
insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m6', 's1', DATEADD(DAY, -5, GETDATE()), 1.0);
insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m7', 's1', DATEADD(DAY, -6, GETDATE()), 6.0);
insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m8', 's1', DATEADD(DAY, -7, GETDATE()), 8.0);
insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m9', 's1', DATEADD(DAY, -8, GETDATE()), 9.0);
insert into metrics (metric_id, sensor_uuid, at, temperature) values ('m10', 's2', NOW(), 100);