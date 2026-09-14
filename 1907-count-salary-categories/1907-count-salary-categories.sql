# Write your MySQL query statement below
WITH salary_categories AS
(
    SELECT 'Low Salary' AS category UNION ALL
    SELECT 'Average Salary' UNION ALL
    SELECT 'High Salary'  
), bucketed_accounts AS
(
    SELECT account_id, 
    CASE 
        WHEN income < 20000 THEN 'Low Salary'
        WHEN income BETWEEN 20000 AND 50000 THEN 'Average Salary'
        ELSE 'High Salary' 
    END AS category
    FROM Accounts
)
SELECT S.category, COALESCE(COUNT(B.account_id), 0) as accounts_count
FROM salary_categories S
LEFT JOIN bucketed_accounts B ON S.category = B.category
GROUP BY S.category;

