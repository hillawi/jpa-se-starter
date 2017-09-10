select c.f_name || ' ' || c.l_name, p.dsc, o.order_id, o.creation_date, o.modification_date, o.status
from product p, cart_order o, order_product op, customer c
where op.order_id = o.order_id
and op.product_id = p.product_id
and o.customer_id = c.customer_id;

select * from customer;

select * from SMART_PHONE;
