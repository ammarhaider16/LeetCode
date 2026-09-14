# Write your MySQL query statement below

WITH people AS (
    SELECT requester_id AS id FROM RequestAccepted UNION ALL
    SELECT accepter_id as id FROM RequestAccepted
)
SELECT A.id, COUNT(*) as num
FROM people A
GROUP BY A.id
ORDER BY COUNT(*) DESC
LIMIT 1;
