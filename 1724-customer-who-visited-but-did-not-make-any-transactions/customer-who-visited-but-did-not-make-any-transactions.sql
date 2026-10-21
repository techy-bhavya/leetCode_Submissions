# Write your MySQL query statement below
# counting no of visits when no transaction happened
select customer_id, count(v.visit_id) as count_no_trans from Visits v left join Transactions t  on v.visit_id = t.visit_id where transaction_id is null group by customer_id;