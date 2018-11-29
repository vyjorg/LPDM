CREATE SEQUENCE public.store_id_seq;
CREATE TABLE public.store
(
    id integer DEFAULT nextval('store_id_seq'::regclass) PRIMARY KEY NOT NULL,
    address_id integer,
    name varchar(50)
);
INSERT INTO public.store (id, address_id, name) VALUES (1, 1, 'Chez Paulette');
INSERT INTO public.store (id, address_id, name) VALUES (2, 2, 'Chez Josette');