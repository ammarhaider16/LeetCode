# Write your MySQL query statement below

WITH weights AS
(
    SELECT A.person_id, A.person_name, A.turn, 
        (SELECT SUM(B.weight) FROM Queue B WHERE B.turn <= A.turn) as weight_after_boarding
    FROM Queue A
)
SELECT person_name 
FROM weights 
WHERE weight_after_boarding <= 1000
ORDER BY turn DESC
LIMIT 1;