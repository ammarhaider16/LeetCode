# Write your MySQL query statement below

WITH salaries AS (
    SELECT id, name, salary, departmentId,
    DENSE_RANK() OVER(PARTITION BY departmentId ORDER BY salary DESC) AS department_rank
    FROM Employee
)
SELECT D.name as Department, S.name as Employee, S.salary as Salary
FROM salaries S
LEFT JOIN Department D ON S.departmentID = D.id
WHERE S.department_rank <=3;
