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
        ), 2) AS average_amount,
        ROW_NUMBER() OVER(ORDER BY visited_on) AS rn
    FROM daily_spending
    ORDER BY visited_on
)
SELECT visited_on, amount, average_amount FROM moving_averages
WHERE rn >= 7;