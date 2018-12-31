drop table if exists sales;
drop table if exists rates;
drop table if exists products;
drop table if exists sellers;


CREATE TABLE sellers (
    seller_id INT AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL UNIQUE ,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    PRIMARY KEY (seller_id)
);

CREATE TABLE products (
    product_id INT AUTO_INCREMENT,
    name varchar (255),
    description VARCHAR(255),
    price INT,
    category varchar (255),
    seller_id INT,
    stock INT,
    query_count INT default 0,
    PRIMARY KEY (product_id),
    FOREIGN KEY (seller_id) REFERENCES sellers(seller_id)
);

CREATE TABLE rates (
    rate_id INT AUTO_INCREMENT,
    rating INT,
    comment varchar (255),
    seller_id INT,
    PRIMARY KEY (rate_id),
    FOREIGN KEY (seller_id) REFERENCES sellers(seller_id)
);

CREATE TABLE sales (
    sale_id INT AUTO_INCREMENT,
    product_id INT,
    unit INT,
    value INT,
    create_date TIMESTAMP,
    PRIMARY KEY (sale_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);