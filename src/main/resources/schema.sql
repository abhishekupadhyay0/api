  
  
CREATE TABLE ORDERS
(
   order_id INT not null,
   order_date DATE,
   primary key (order_id)
);


CREATE TABLE ITEMS (
  item_id INT AUTO_INCREMENT,
  order_id INT NOT NULL,
  quantity INT NOT NULL,
  item_name VARCHAR(100) not null,
  item_desc VARCHAR(100),
  price DOUBLE NOT NULL,
  FOREIGN KEY (order_id) REFERENCES ORDERS (order_id),
  primary key (item_id)
);

CREATE TABLE PRODUCTS (
  item_name VARCHAR(100) NOT NULL,
  item_price INT NOT NULL,
  item_offer VARCHAR(10),
  primary key (item_name)
);
