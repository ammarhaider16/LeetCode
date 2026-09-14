# Write your MySQL query statement below

WITH top_user_rating AS (
    SELECT MR.user_id, U.name, COUNT(MR.movie_id) as ratings
    FROM MovieRating MR LEFT JOIN Users U on MR.user_id = U.user_id
    GROUP BY MR.user_id, U.name
    ORDER BY COUNT(MR.movie_id) DESC, U.name
    LIMIT 1
), top_rated_movie AS (
    SELECT MR.movie_id, M.title, AVG(MR.rating)
    FROM MovieRating MR LEFT JOIN Movies M on MR.movie_id = M.movie_id
    WHERE MR.created_at BETWEEN '2020-02-01' AND '2020-02-29'
    GROUP BY MR.movie_id, M.title
    ORDER BY AVG(MR.rating) DESC, M.title
    LIMIT 1
)
SELECT name AS results from top_user_rating UNION ALL
SELECT title AS results from top_rated_movie;


