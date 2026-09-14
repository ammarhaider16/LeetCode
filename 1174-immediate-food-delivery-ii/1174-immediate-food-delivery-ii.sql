# Write your MySQL query statement below


WITH immediate_customers AS (
    SELECT 
    A.delivery_id, 
    A.customer_id, 
    (CASE WHEN DATEDIFF(A.order_date, A.customer_pref_delivery_date) = 0 THEN 1 ELSE 0 END) AS is_immediate
FROM Delivery A
WHERE A.order_date = (SELECT MIN(B.order_date) as order_date FROM Delivery B WHERE A.customer_id = B.customer_id)
)
SELECT 100*ROUND(SUM(is_immediate) / COUNT(*), 4) as immediate_percentage
FROM immediate_customers