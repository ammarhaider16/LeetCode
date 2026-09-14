# Write your MySQL query statement below

WITH salaries AS (
    SELECT salary, departmentId,
    DENSE_RANK() OVER(PARTITION BY departmentId ORDER BY salary DESC) AS department_rank
    FROM Employee
)
SELECT D.name as Department, E.name as Employee, E.salary as Salary
FROM Employee E
LEFT JOIN Department D ON E.departmentID = D.id
WHERE E.salary IN (
    SELECT U.salary
    FROM salaries U
    WHERE U.departmentId = E.departmentID
    AND U.department_rank <= 3 
)
