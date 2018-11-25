CREATE TABLE public.ordered_product
(
    product_id integer NOT NULL,
    quantity integer,
    order_id integer NOT NULL,
    CONSTRAINT ordered_product_pkey PRIMARY KEY (order_id, product_id),
    CONSTRAINT fk684l0g7wdvypylqnc39jfjkld FOREIGN KEY (order_id) REFERENCES public."order" (id)
);