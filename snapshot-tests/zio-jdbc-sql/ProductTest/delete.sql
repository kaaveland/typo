DELETE FROM production.product where coalesce((productid = ?::int4), ?::boolean)