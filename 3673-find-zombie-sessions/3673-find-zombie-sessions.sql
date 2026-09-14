# Write your MySQL query statement below
-- Clean analytics
WITH stats AS (
    SELECT
        A.session_id, 
        A.user_id, 
        SUM(CASE WHEN A.event_type = 'scroll' THEN 1 ELSE 0 END) AS num_scrolls,
        SUM(CASE WHEN A.event_type = 'click' THEN 1 ELSE 0 END) AS num_clicks,
        SUM(CASE WHEN A.event_type = 'purchase' THEN 1 ELSE 0 END) AS num_purchases,
        TIMESTAMPDIFF(
            MINUTE, 
            (
                SELECT B.event_timestamp 
                FROM app_events B 
                WHERE A.session_id = B.session_id AND A.user_id = B.user_id AND 
                B.event_type = 'app_open'
            ), 
            (
                SELECT B.event_timestamp 
                FROM app_events B 
                WHERE A.session_id = B.session_id AND A.user_id = B.user_id AND 
                B.event_type = 'app_close'
            )
        ) AS session_duration_minutes
    FROM app_events A
    GROUP BY A.session_id, A.user_id
)
-- Do filters by combining clean analytics
SELECT 
    session_id, user_id, session_duration_minutes, num_scrolls AS scroll_count
FROM 
    stats
WHERE  
    session_duration_minutes > 30
    AND num_scrolls >= 5
    AND (num_clicks / num_scrolls) < 0.2
    AND num_purchases = 0
ORDER BY 
    num_scrolls DESC, session_id ASC;