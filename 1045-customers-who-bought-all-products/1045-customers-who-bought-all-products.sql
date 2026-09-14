# Write your MySQL query statement below
WITH distinct_purchases as (
SELECT DISTINCT customer_id, product_key
FROM Customer
), 
customer_purchases as (
SELECT customer_id, COUNT(*) as products_purchased
FROM distinct_purchases
GROUP BY customer_id
)
SELECT customer_id 
FROM customer_purchases
WHERE products_purchased = (SELECT COUNT(DISTINCT product_key) FROM product);
