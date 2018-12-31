INSERT INTO sellers (seller_id, email, first_name, last_name)
  VALUES (1, 'beckham.david@mu.com', 'Beckham', 'David');
INSERT INTO sellers (seller_id, email, first_name, last_name)
  VALUES (2, 'mona.lisa@gmail.com', 'Mona', 'Lisa');
INSERT INTO sellers (seller_id, email, first_name, last_name)
  VALUES (3, 'leonardo.dicaprio@movie.com', 'Leonardo', 'Di Caprio');
INSERT INTO sellers (seller_id, email, first_name, last_name)
  VALUES (4, 'lionel.messi@barca.es', 'Lionel', 'Messi');
INSERT INTO sellers (seller_id, email, first_name, last_name)
  VALUES (5, 'sebastian.vettel@ferrari.it', 'Sebastian', 'Vettel');


INSERT INTO products(product_id, name, description, price, category, seller_id, stock)
  VALUES (1, 'Lego', 'Lego helicopter', 1000, 'TOY', 1, 25);
INSERT INTO products(product_id, name, description, price, category, seller_id, stock)
  VALUES (2, 'Coca Cola', 'Coca Cola light 1.75L', 5, 'BEVERAGE', 2, 500);
INSERT INTO products(product_id, name, description, price, category, seller_id, stock)
  VALUES (3, 'Carrot', 'Carrot /kg', 2, 'VEGETABLE', 2, 15);
INSERT INTO products(product_id, name, description, price, category, seller_id, stock)
  VALUES (4, 'Potato', 'Potato /kg', 3, 'VEGETABLE', 3, 6);
INSERT INTO products(product_id, name, description, price, category, seller_id, stock)
  VALUES (5, 'Chicken breast', 'chicken breast /kg', 8, 'MEAT', 5, 20);


INSERT INTO rates (rate_id, rating, comment, seller_id)
  VALUES (1, 5, 'The item has arrived successfully', 1);
INSERT INTO rates (rate_id, rating, comment, seller_id)
  VALUES (2, 4, 'The serving was quite polite.', 3);
INSERT INTO rates (rate_id, rating, comment, seller_id)
  VALUES (3, 5, 'I am really satisfied with the product.', 5);
INSERT INTO rates (rate_id, rating, comment, seller_id)
  VALUES (4, 3, 'Bearish seller', 3);
INSERT INTO rates (rate_id, rating, comment, seller_id)
  VALUES (5, 2, 'I am not going to buy anything from her.', 2);


INSERT INTO sales (sale_id, product_id, unit, value, create_date)
  VALUES (1, 3, 10, 20, NOW());
INSERT INTO sales (sale_id, product_id, unit, value, create_date)
  VALUES (2, 2, 15, 75, NOW());
INSERT INTO sales (sale_id, product_id, unit, value, create_date)
  VALUES (3, 5, 1, 8, NOW());
INSERT INTO sales (sale_id, product_id, unit, value, create_date)
  VALUES (4, 2, 2, 4, NOW());
INSERT INTO sales (sale_id, product_id, unit, value, create_date)
  VALUES (5, 1, 5, 5000, NOW());