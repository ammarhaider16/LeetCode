# Write your MySQL query statement below


WITH ranked_customers AS (
    SELECT
        customer_id,
        CASE WHEN DATEDIFF(order_date, customer_pref_delivery_date) = 0 THEN 1 ELSE 0 END AS is_immediate,
        ROW_NUMBER() OVER(PARTITION BY customer_id ORDER BY order_date) as order_number   
    FROM Delivery
)
SELECT 100*ROUND(SUM(is_immediate)/COUNT(*), 4) as immediate_percentage
FROM ranked_customers
WHERE order_number = 1;

