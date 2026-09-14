# Write your MySQL query statement below

SELECT DISTINCT A.num as ConsecutiveNums
FROM Logs A
LEFT JOIN Logs B on A.id = (B.id + 1)
LEFT JOIN Logs C on A.id = (C.id + 2)
WHERE A.num = COALESCE(B.num, -1) AND A.num = COALESCE(C.num, -1);