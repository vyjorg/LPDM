CREATE TABLE public."order"
(
    id integer DEFAULT nextval('order_id_seq'::regclass) PRIMARY KEY NOT NULL,
    customer_id integer,
    order_date timestamp,
    paid boolean DEFAULT false NOT NULL,
    payment varchar(20),
    status varchar(20),
    store_id integer,
    total double precision
);
INSERT INTO public."order" (id, customer_id, order_date, paid, payment, status, store_id, total) VALUES (1, 1, '2018-11-25 10:41:38.676000', false, 'PAYPAL', 'READY', 1, 23);