# Write your MySQL query statement below

WITH daily_spending AS (
    SELECT visited_on, SUM(amount) as amount
    FROM Customer
    GROUP BY visited_on
), moving_averages AS
(
    SELECT visited_on, 
        SUM(amount) OVER (
            ORDER BY visited_on 
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ) AS amount,
        ROUND(AVG(amount) OVER(
            ORDER BY visited_on 
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ), 2) AS average_amount
    FROM daily_spending
    ORDER BY visited_on
)
SELECT * FROM moving_averages
WHERE visited_on >= (SELECT MIN(visited_on) FROM Customer)+6;