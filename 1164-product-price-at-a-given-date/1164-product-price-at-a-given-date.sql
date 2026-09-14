# Write your MySQL query statement below
WITH latest_prices AS (
    SELECT product_id, new_price as price, 
    ROW_NUMBER() OVER(PARTITION BY product_id ORDER BY change_date DESC) AS change_seq_inv
    FROM Products
    WHERE DATEDIFF('2019-08-16', change_date) >= 0
)
SELECT DISTINCT P.product_id, COALESCE(L.price, 10) as price 
FROM Products P
LEFT JOIN latest_prices L ON P.product_id = L.product_id
    AND L.change_seq_inv = 1;
