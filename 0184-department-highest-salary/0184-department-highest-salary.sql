# Write your MySQL query statement below
WITH ranked_salaries AS (
    SELECT name, salary, departmentId, 
        RANK() OVER(PARTITION BY departmentId ORDER BY salary DESC) as salary_rank
    FROM Employee
)
SELECT D.name AS Department, R.name AS Employee, R.salary as Salary
FROM ranked_salaries R
LEFT JOIN Department D on R.departmentId = D.id
WHERE R.salary_rank = 1
