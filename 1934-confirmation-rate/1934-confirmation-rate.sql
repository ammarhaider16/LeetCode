# Write your MySQL query statement below

# first need to get all the actions / user

WITH confirmation_stats AS (
    SELECT user_id, time_stamp, action, 
        CASE
            WHEN action = 'timeout' THEN 0
            WHEN action = 'confirmed' THEN 1
        END AS action_value
FROM Confirmations
)
SELECT s.user_id, ROUND(COALESCE(SUM(cs.action_value)/COUNT(cs.action_value), 0),2) AS confirmation_rate
FROM Signups s LEFT JOIN confirmation_stats cs ON s.user_id = cs.user_id
GROUP BY s.user_id;


