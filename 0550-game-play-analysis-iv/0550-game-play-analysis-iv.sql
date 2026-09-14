# Write your MySQL query statement below

WITH repeated_players AS (
    SELECT A.player_id
    FROM Activity A 
    JOIN Activity B ON 
        A.player_id = B.player_id 
        AND DATEDIFF(B.event_date, A.event_date) = 1
        AND A.event_date = (
            SELECT MIN(event_date) as event_date
            FROM Activity C
            WHERE C.player_id = A.player_id
        )
)
SELECT  
    ROUND((SELECT COUNT(DISTINCT player_id) FROM repeated_players) / COUNT(DISTINCT player_id), 2) AS fraction
    FROM Activity;