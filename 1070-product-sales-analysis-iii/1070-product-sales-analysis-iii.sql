# Write your MySQL query statement below

-- Get the sales per year and add a row number based on product partition
WITH product_sales as (
    SELECT product_id, year, quantity, price, 
        RANK() OVER(PARTITION BY product_id ORDER BY year ASC) AS rnk
    FROM Sales
)
SELECT product_id, year as first_year, quantity, price
FROM product_sales
WHERE rnk = 1