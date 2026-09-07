# Write your MySQL query statement below

#select * from Activity group by machine_id, process_id;

#select machine_id, case when activity_type='start' then timestamp end as start_time, case when activity_type='end' then timestamp end as end_time from Activity group by machine_id, process_id;

#select machine_id, max(case when activity_type='start' then timestamp end) as start_time, max(case when activity_type='end' then timestamp end) as end_time from Activity group by machine_id, process_id;

#correct query 1
with temp as (select machine_id, max(case when activity_type='start' then timestamp end) as start_time, max(case when activity_type='end' then timestamp end) as end_time from Activity group by machine_id, process_id) 
select machine_id, round(avg(end_time-start_time),3) as processing_time from temp group by machine_id;

#correct query 2
/*
SELECT machine_id,
       AVG(end_time - start_time) AS processing_time
FROM
(
    SELECT 
        machine_id,
        process_id,
        MAX(CASE WHEN activity_type = 'start' THEN timestamp END) AS start_time,
        MAX(CASE WHEN activity_type = 'end' THEN timestamp END) AS end_time
    FROM Activity
    GROUP BY machine_id, process_id
) x
GROUP BY machine_id;
*/