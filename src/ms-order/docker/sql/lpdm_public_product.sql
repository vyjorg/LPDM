CREATE TABLE public.product
(
    id integer PRIMARY KEY NOT NULL,
    cotegory_id integer NOT NULL,
    label varchar(255),
    name varchar(255),
    picture varchar(255),
    price double precision NOT NULL,
    producer_id integer NOT NULL,
    stock_id integer NOT NULL
);
INSERT INTO public.product (id, cotegory_id, label, name, picture, price, producer_id, stock_id) VALUES (1, 1, 'un label', 'un nom', 'une image', 15, 6, 8);