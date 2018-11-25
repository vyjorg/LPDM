CREATE TABLE public.ordered_product
(
    quantity integer,
    order_id integer NOT NULL,
    product_id integer NOT NULL,
    CONSTRAINT ordered_product_pkey PRIMARY KEY (order_id, product_id),
    CONSTRAINT fk684l0g7wdvypylqnc39jfjkld FOREIGN KEY (order_id) REFERENCES public."order" (id),
    CONSTRAINT fkcbk8xvg3o4s3ard6hv25p4jqc FOREIGN KEY (product_id) REFERENCES public.product (id)
);
INSERT INTO public.ordered_product (quantity, order_id, product_id) VALUES (4, 1, 1);