# Write your MySQL query statement below

#w2 k recordDate mein 1 day add karne se w1 ka recordDate aata h
#select * from Weather w1 join Weather w2 on w1.recordDate = date_add(w2.recordDate, interval 1 day);

#w2 k recordDate mein 1 day minus karne se w1 ka recordDate aata h
#select * from Weather w1 join Weather w2 on w1.recordDate = date_sub(w2.recordDate, interval 1 day);

select w1.id from Weather w1 join Weather w2 on w1.recordDate = date_add(w2.recordDate, interval 1 day) where w1.temperature>w2.temperature;