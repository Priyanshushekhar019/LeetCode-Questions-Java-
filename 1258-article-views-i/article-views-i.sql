# Write your MySQL query statement below
select distinct author_id AS id
From Views
Where author_id=viewer_id
order by id asc;