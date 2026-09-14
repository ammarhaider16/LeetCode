# Write your MySQL query statement below
WITH new_ids AS (
    SELECT id as current_id,
    student, 
    CASE
        WHEN id % 2 = 0 THEN id - 1
        WHEN id = (SELECT MAX(id) as id FROM Seat) THEN id
        ELSE id+1 
    END AS new_id
    FROM Seat
)
SELECT A.current_id as id, B.student
FROM new_ids A 
JOIN Seat b ON A.new_id = B.id
ORDER BY A.current_id ASC;