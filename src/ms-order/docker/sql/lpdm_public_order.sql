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