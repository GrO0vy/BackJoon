-- 코드를 입력하세요
SELECT DATE_FORMAT(sales_date, "%Y-%m-%d") as salse_date
      ,product_id
      ,user_id
      ,sales_amount 
from ONLINE_SALE
where year(SALES_DATE) = '2022'
and month(SALES_DATE) = '03'
union
SELECT DATE_FORMAT(sales_date, "%Y-%m-%d") as salse_date
      ,product_id
      ,null as user_id
      ,sales_amount 
from OFFLINE_SALE
where year(SALES_DATE) = '2022'
and month(SALES_DATE) = '03'

order by salse_date , product_id ,user_id