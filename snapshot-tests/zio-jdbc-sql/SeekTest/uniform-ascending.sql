select "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text from production.product product0 WHERE ((product0.name,product0.weight,product0.listprice) > (?::"public"."Name",?::numeric,?::numeric)) ORDER BY product0.name ASC , product0.weight ASC , product0.listprice ASC 