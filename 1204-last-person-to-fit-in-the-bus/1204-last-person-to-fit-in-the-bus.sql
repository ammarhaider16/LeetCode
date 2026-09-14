# Write your MySQL query statement below

WITH weights AS
(
    SELECT person_name, turn,
        SUM(weight) OVER (ORDER BY turn) AS weight_after_boarding
    FROM Queue
)
SELECT person_name 
FROM weights 
WHERE weight_after_boarding <= 1000
ORDER BY turn DESC
LIMIT 1;