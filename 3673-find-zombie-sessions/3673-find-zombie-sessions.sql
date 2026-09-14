# Write your MySQL query statement below
-- Isolate session stats
WITH stats AS (
    SELECT
        session_id, 
        user_id, 
        SUM(CASE WHEN event_type = 'scroll' THEN 1 ELSE 0 END) AS num_scrolls,
        SUM(CASE WHEN event_type = 'click' THEN 1 ELSE 0 END) AS num_clicks,
        SUM(CASE WHEN event_type = 'purchase' THEN 1 ELSE 0 END) AS num_purchases
    FROM app_events
    GROUP BY session_id, user_id
), 
-- Isolate session times
times AS (
    SELECT DISTINCT A.session_id, A.user_id, 
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
)
-- Do filters by combining clean analytics
SELECT 
    S.session_id, S.user_id, T.session_duration_minutes, S.num_scrolls AS scroll_count
FROM 
    stats S
JOIN 
    times T ON  S.session_id = T.session_id AND S.user_id = T.user_id
WHERE  
    T.session_duration_minutes > 30
    AND S.num_scrolls >= 5
    AND (S.num_clicks / S.num_scrolls) < 0.2
    AND S.num_purchases = 0
ORDER BY 
    S.num_scrolls DESC, S.session_id ASC;