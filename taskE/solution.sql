SELECT
    date(stat.date,'start of month') AS monthDate,
    stat.description AS description,
    stat.name AS item_name,
    brands.name AS category_name,
    categories.name AS brand_name,
    SUM(stat.shows) AS sum_shows,
    SUM(stat.clicks) AS sum_clicks,
    SUM(stat.orders) AS sum_orders,
    SUM(stat.gmv) AS sum_gmv
FROM
    statistic as stat
    JOIN brands ON brands.id = stat.brand_id
    JOIN categories ON categories.id = stat.category_id
WHERE
    (stat.shows >= stat.clicks)
  AND (stat.clicks >= stat.orders)
  AND (stat.date BETWEEN date('2021-04-01', 'start of day','-1 days') AND date('2021-07-31', 'start of day','+1 days'))
  AND (categories.name NOT IN ('Варочные панели', 'Садовые измельчители'))
  AND (brands.name NOT IN ('Apple', 'Samsung'))
GROUP BY
    strftime('%Y-%m', stat.date),
    stat.description,
    stat.name,
    brands.name,
    categories.name
ORDER BY
    monthDate ASC,
    sum_gmv DESC
    LIMIT 100;