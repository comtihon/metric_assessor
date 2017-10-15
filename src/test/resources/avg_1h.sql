insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m1', 's1', current_date, 1.0);
insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m2', 's1', current_date - interval '10 minutes', 1.0);
insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m3', 's1', current_date - interval '20 minutes', 1.0);
insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m4', 's1', current_date - interval '30 minutes', 1.0);
insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m5', 's1', current_date - interval '40 minutes', 1.0);
insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m6', 's1', current_date - interval '50 minutes', 5.0);
insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m7', 's1', current_date - interval '60 minutes', 7.0);
insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m8', 's1', current_date - interval '70 minutes', 8.0);
insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m9', 's1', current_date - interval '80 minutes', 9.0);
insert into metrics (metric_id, sensor_uuid, at, temperature)
values ('m10', 's2', current_date, 100);