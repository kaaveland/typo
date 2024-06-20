select product0.productid, product0.name, product0.productnumber, product0.makeflag, product0.finishedgoodsflag, product0.color, product0.safetystocklevel, product0.reorderpoint, product0.standardcost, product0.listprice, product0.size, product0.sizeunitmeasurecode, product0.weightunitmeasurecode, product0.weight, product0.daystomanufacture, product0.productline, product0.class, product0.style, product0.productsubcategoryid, product0.productmodelid, product0.sellstartdate, product0.sellenddate, product0.discontinueddate, product0.rowguid, product0.modifieddate, productmodel0.productmodelid, productmodel0.name, productmodel0.catalogdescription, productmodel0.instructions, productmodel0.rowguid, productmodel0.modifieddate, productsubcategory0.productsubcategoryid, productsubcategory0.productcategoryid, productsubcategory0.name, productsubcategory0.rowguid, productsubcategory0.modifieddate, productcategory0.productcategoryid, productcategory0.name, productcategory0.rowguid, productcategory0.modifieddate
from (
  select "productid","name","productnumber","makeflag","finishedgoodsflag","color","safetystocklevel","reorderpoint","standardcost","listprice","size","sizeunitmeasurecode","weightunitmeasurecode","weight","daystomanufacture","productline","class","style","productsubcategoryid","productmodelid","sellstartdate"::text,"sellenddate"::text,"discontinueddate"::text,"rowguid","modifieddate"::text from production.product product0
) product0
join (
  select "productmodelid","name","catalogdescription","instructions","rowguid","modifieddate"::text from production.productmodel productmodel0
) productmodel0 on (product0.productmodelid = productmodel0.productmodelid)
join (
  select "productsubcategoryid","productcategoryid","name","rowguid","modifieddate"::text from production.productsubcategory productsubcategory0
) productsubcategory0 on (product0.productsubcategoryid = productsubcategory0.productsubcategoryid)
join (
  select "productcategoryid","name","rowguid","modifieddate"::text from production.productcategory productcategory0
) productcategory0 on (productsubcategory0.productcategoryid = productcategory0.productcategoryid)
