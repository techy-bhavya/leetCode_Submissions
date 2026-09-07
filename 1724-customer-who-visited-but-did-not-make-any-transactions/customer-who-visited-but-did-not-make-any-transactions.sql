# Write your MySQL query statement below
/*
count mein * hi hona chahiye, group by customer_id karne k baad, coz count(attribute) will ignore null values while counting
*/
#incorrect
#select customer_id, count(transaction_id) as count_no_trans from Visits v left join Transactions t on v.visit_id = t.visit_id where transaction_id is null group by customer_id;

select customer_id, count(*) as count_no_trans from Visits v left join Transactions t on v.visit_id = t.visit_id where transaction_id is null group by customer_id;
