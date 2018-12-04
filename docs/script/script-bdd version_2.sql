
CREATE SEQUENCE public.payment_id_seq;

CREATE TABLE public.payment (
                id INTEGER NOT NULL DEFAULT nextval('public.payment_id_seq'),
                payment_type VARCHAR NOT NULL,
                CONSTRAINT payment_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.payment_id_seq OWNED BY public.payment.id;

CREATE SEQUENCE public.order_status_id_seq;

CREATE TABLE public.order_status (
                id INTEGER NOT NULL DEFAULT nextval('public.order_status_id_seq'),
                name VARCHAR NOT NULL,
                CONSTRAINT order_status_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.order_status_id_seq OWNED BY public.order_status.id;

CREATE SEQUENCE public.stock_id_seq;

CREATE TABLE public.stock (
                id INTEGER NOT NULL DEFAULT nextval('public.stock_id_seq'),
                quantity INTEGER NOT NULL,
                expire_date DATE NOT NULL,
                packaging VARCHAR NOT NULL,
                unit_by_package INTEGER NOT NULL,
                CONSTRAINT stock_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.stock_id_seq OWNED BY public.stock.id;

CREATE SEQUENCE public.category_id_seq;

CREATE TABLE public.category (
                id INTEGER NOT NULL DEFAULT nextval('public.category_id_seq'),
                name VARCHAR NOT NULL,
                CONSTRAINT category_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.category_id_seq OWNED BY public.category.id;

CREATE SEQUENCE public.region_id_seq;

CREATE TABLE public.region (
                id INTEGER NOT NULL DEFAULT nextval('public.region_id_seq'),
                name VARCHAR NOT NULL,
                CONSTRAINT region_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.region_id_seq OWNED BY public.region.id;

CREATE SEQUENCE public.department_id_seq;

CREATE TABLE public.department (
                id INTEGER NOT NULL DEFAULT nextval('public.department_id_seq'),
                name VARCHAR NOT NULL,
                region_id INTEGER NOT NULL,
                CONSTRAINT department_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.department_id_seq OWNED BY public.department.id;

CREATE SEQUENCE public.city_id_seq;

CREATE TABLE public.city (
                id INTEGER NOT NULL DEFAULT nextval('public.city_id_seq'),
                name VARCHAR NOT NULL,
                postal_code INTEGER NOT NULL,
                department_id INTEGER NOT NULL,
                CONSTRAINT city_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.city_id_seq OWNED BY public.city.id;

CREATE SEQUENCE public.adress_id_seq;

CREATE TABLE public.adress (
                id INTEGER NOT NULL DEFAULT nextval('public.adress_id_seq'),
                street_name VARCHAR NOT NULL,
                street_number VARCHAR NOT NULL,
                complement VARCHAR NOT NULL,
                city_id INTEGER NOT NULL,
                CONSTRAINT adress_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.adress_id_seq OWNED BY public.adress.id;

CREATE SEQUENCE public.store_id_seq;

CREATE TABLE public.store (
                id INTEGER NOT NULL DEFAULT nextval('public.store_id_seq'),
                name VARCHAR NOT NULL,
                adress_id INTEGER NOT NULL,
                CONSTRAINT store_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.store_id_seq OWNED BY public.store.id;

CREATE SEQUENCE public.customer_type_id_seq;

CREATE TABLE public.customer_type (
                id INTEGER NOT NULL DEFAULT nextval('public.customer_type_id_seq'),
                type VARCHAR NOT NULL,
                CONSTRAINT customer_type_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.customer_type_id_seq OWNED BY public.customer_type.id;

CREATE SEQUENCE public.customer_id_seq;

CREATE TABLE public.customer (
                id INTEGER NOT NULL DEFAULT nextval('public.customer_id_seq'),
                first_name VARCHAR NOT NULL,
                last_name VARCHAR NOT NULL,
                mail VARCHAR NOT NULL,
                password VARCHAR NOT NULL,
                phone_number INTEGER NOT NULL,
                birthday DATE NOT NULL,
                registration_date DATE NOT NULL,
                customer_type_id INTEGER NOT NULL,
                adress_id INTEGER NOT NULL,
                CONSTRAINT customer_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.customer_id_seq OWNED BY public.customer.id;

CREATE SEQUENCE public.command_id_seq;

CREATE TABLE public.command (
                id INTEGER NOT NULL DEFAULT nextval('public.command_id_seq'),
                total DOUBLE PRECISION NOT NULL,
                date_of_order DATE NOT NULL,
                status_id INTEGER NOT NULL,
                payment_id INTEGER NOT NULL,
                store_id INTEGER NOT NULL,
                customer_id INTEGER NOT NULL,
                CONSTRAINT ocommand_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.command_id_seq OWNED BY public.command.id;

CREATE SEQUENCE public.product_id_seq;

CREATE TABLE public.product (
                id INTEGER NOT NULL DEFAULT nextval('public.product_id_seq'),
                name VARCHAR NOT NULL,
                category_id INTEGER NOT NULL,
                label VARCHAR NOT NULL,
                price DOUBLE PRECISION NOT NULL,
                stock_id INTEGER NOT NULL,
                productor_id INTEGER NOT NULL,
                picture VARCHAR NOT NULL,
                CONSTRAINT product_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.product_id_seq OWNED BY public.product.id;

CREATE TABLE public.ordered_product (
                order_id INTEGER NOT NULL,
                product_id INTEGER NOT NULL,
                quantity INTEGER NOT NULL,
                CONSTRAINT ordered_product_pk PRIMARY KEY (order_id, product_id)
);


ALTER TABLE public.command ADD CONSTRAINT payment_order_fk
FOREIGN KEY (payment_id)
REFERENCES public.payment (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.command ADD CONSTRAINT order_status_order_fk
FOREIGN KEY (status_id)
REFERENCES public.order_status (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.product ADD CONSTRAINT stock_product_fk
FOREIGN KEY (stock_id)
REFERENCES public.stock (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.product ADD CONSTRAINT category_product_fk
FOREIGN KEY (category_id)
REFERENCES public.category (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.department ADD CONSTRAINT region_department_fk
FOREIGN KEY (region_id)
REFERENCES public.region (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.city ADD CONSTRAINT department_city_fk
FOREIGN KEY (department_id)
REFERENCES public.department (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.adress ADD CONSTRAINT city_adress_fk
FOREIGN KEY (city_id)
REFERENCES public.city (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.customer ADD CONSTRAINT adress_user_fk
FOREIGN KEY (adress_id)
REFERENCES public.adress (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.store ADD CONSTRAINT adress_store_fk
FOREIGN KEY (adress_id)
REFERENCES public.adress (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.command ADD CONSTRAINT store_order_fk
FOREIGN KEY (store_id)
REFERENCES public.store (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.customer ADD CONSTRAINT user_type_user_fk
FOREIGN KEY (customer_type_id)
REFERENCES public.customer_type (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.product ADD CONSTRAINT user_product_fk
FOREIGN KEY (productor_id)
REFERENCES public.customer (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.command ADD CONSTRAINT user_order_fk
FOREIGN KEY (customer_id)
REFERENCES public.customer (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.ordered_product ADD CONSTRAINT order_ordered_product_fk
FOREIGN KEY (order_id)
REFERENCES public.command (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.ordered_product ADD CONSTRAINT product_ordered_product_fk
FOREIGN KEY (product_id)
REFERENCES public.product (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
