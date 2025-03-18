SELECT l.landprogress, COUNT(l.land_sold) AS total_land_bought
FROM land l
LEFT JOIN sales s ON l.land_id = s.land_id
WHERE l.land_sold IS TRUE AND s.sale_date BETWEEN '2019-03-13' AND '2023-03-19'
GROUP BY l.landprogress WITH ROLLUP;