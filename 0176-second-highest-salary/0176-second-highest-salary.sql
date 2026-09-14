# Write your MySQL query statement below
WITH ranked_salaries AS (
    SELECT salary, DENSE_RANK() OVER(ORDER BY salary DESC) as salary_rank
    FROM Employee 
    UNION
    SELECT NULL AS salary, 2 AS salary_rank
)
SELECT salary AS SecondHighestSalary
FROM ranked_salaries
WHERE salary_rank = 2
LIMIT 1