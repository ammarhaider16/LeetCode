# Write your MySQL query statement below

WITH valid_tiv_2015 AS (
    SELECT tiv_2015, COUNT(*) as counts 
    FROM Insurance 
    GROUP BY tiv_2015
    HAVING COUNT(*) > 1
), valid_lat_lons AS (
    SELECT lat, lon, COUNT(*) AS counts
    FROM Insurance
    GROUP BY lat, lon
    HAVING COUNT(*) < 2
)
SELECT ROUND(SUM(A.tiv_2016), 2) as tiv_2016
FROM Insurance A 
WHERE 
    tiv_2015 IN (SELECT tiv_2015 FROM valid_tiv_2015)
    AND (lat, lon) IN (SELECT lat, lon FROM valid_lat_lons);
