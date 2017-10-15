insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m1', 's1', NOW(), 1.0);
insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m2', 's2', NOW(), 100);
insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m3', 's1', current_date - interval '10 minutes', 1.0);
insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m4', 's1', current_date - interval '20 minutes', 4.0);
insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m5', 's1', current_date - interval '5 days', 1.0);
insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m6', 's1', current_date - interval '10 days', 2.0);
insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m7', 's1', current_date - interval '15 days', 3.0);
insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m8', 's1', current_date - interval '30 days', 53.0);