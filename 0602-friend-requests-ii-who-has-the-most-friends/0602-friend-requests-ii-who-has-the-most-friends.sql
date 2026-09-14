# Write your MySQL query statement below

WITH people AS (
    SELECT requester_id AS id FROM RequestAccepted UNION
    SELECT accepter_id as id FROM RequestAccepted
)
SELECT A.id, (
    SELECT COUNT(*) FROM RequestAccepted B 
    WHERE B.requester_id = A.id OR B.accepter_id = A.id
) as num
FROM people A
ORDER BY num DESC
LIMIT 1;
