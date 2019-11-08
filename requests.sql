CREATE TABLE  products (
    id INTEGER PRIMARY KEY AUTOINCREMENT ,
    name TEXT NOT NULL ,
    category TEXT NOT NULL ,
    quantity INTEGER NOT NULL CHECK ( quantity >= 0 ) DEFAULT 0,
    status INTEGER NOT NULL CHECK ( status = 1 OR status = 0) DEFAULT 1,
    price INTEGER NOT NULL CHECK ( price > 0 )
);

DROP TABLE IF EXISTS products;

INSERT INTO products (name, category, quantity, status, price) VALUES ('IPhone', 'smartPhones', 10, 1, 65950);
INSERT INTO products (name, category, quantity, status, price) VALUES ('Lenovo', 'noteBooks', 5, 1, 27990);
INSERT INTO products (name, category, quantity, status, price) VALUES ('Samsung', 'TVs', 3, 0, 8690);
INSERT INTO products (name, category, quantity, status, price) VALUES ('Gorenje', 'kettles', 50, 1, 1250);
INSERT INTO products (name, category, quantity, status, price) VALUES ('Meizu', 'smartPhones', 14, 1, 14500);

--

CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT ,
    login TEXT NOT NULL DEFAULT 'USER',
    name TEXT NOT NULL DEFAULT 'NONAME'
);

DROP TABLE IF EXISTS users;

INSERT INTO users (login, name) VALUES ('vasya123', 'Vasya');
INSERT INTO users (login, name) VALUES ('petya123', 'Petya');
INSERT INTO users (login, name) VALUES ('sasha123', 'Sasha');
INSERT INTO users DEFAULT VALUES ;

CREATE TABLE orders (
    id INTEGER PRIMARY KEY AUTOINCREMENT ,
    quantity INTEGER NOT NULL CHECK ( quantity > 0 ),
    product_name TEXT REFERENCES  products NOT NULL ,
    product_price INTEGER REFERENCES products NOT NULL
);

DROP TABLE IF EXISTS orders;

INSERT INTO orders (quantity, product_name, product_price) VALUES (2, 'IPhone', 65950),
                                                                          (3, 'Lenovo', 27990),
                                                                          (1, 'Meizu', 14500);

INSERT INTO orders (quantity, product_name, product_price) VALUES (1, 'Samsung', 8690),
                                                                          (1, 'Gorenje', 1250);

CREATE TABLE sales (
    id INTEGER PRIMARY KEY AUTOINCREMENT ,
    order_id INTEGER REFERENCES orders,
    status INTEGER NOT NULL CHECK ( status = 1 OR status = 0) DEFAULT 1
);

DROP TABLE IF EXISTS sales;

INSERT INTO sales (order_id, status) VALUES (1, 1),
                                            (2, 1),
                                            (3, 1);

INSERT INTO sales (order_id, status) VALUES (4, 0),
                                            (5, 0);

SELECT o.id, (o.product_price * o.quantity), s.status
FROM orders o INNER JOIN sales s on o.id = s.order_id;