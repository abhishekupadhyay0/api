# api
Order API to take orders and show order summary

# database design
Spring boot h2 in memory database is used for this api.

schema.sql
------------------------
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

# data loaded for items in products table (data.sql)

SELECT * FROM PRODUCTS;
-------------------------------------
ITEM_NAME  	ITEM_OFFER  	ITEM_PRICE  
APPLE	      1:2	          50
ORANGE	    2:3	          75


# Requests

1. POST add item to existing order or create order if does not exist
URL http://localhost:9001/order
Request:
{
    "orderId": 1,
    "items": [{
    		"itemId" : 1,
    		"itemName": "APPLE",
    		"itemCategory": "FRUIT",
    		"quantity": 9
    	}]
    
}

Response:

{
    "itemSummary": [
        {
            "orderItems": {
                "itemId": 1,
                "itemName": "APPLE",
                "itemCategory": "FRUIT",
                "quantity": 9
            },
            "price": 2,
            "offerApplied": "1:2"
        }
    ],
    "totalPrice": 2
}

2. GET get order summary of all the items added to the order

URL: http://localhost:9001/ordersummary/{orderId}

Response:

{
    "itemSummary": [
        {
            "orderItems": {
                "itemId": 1,
                "itemName": "APPLE",
                "itemCategory": "FRUIT",
                "quantity": 9
            },
            "price": 2,
            "offerApplied": "1:2"
        },
        {
            "orderItems": {
                "itemId": 2,
                "itemName": "ORANGE",
                "itemCategory": "FRUIT",
                "quantity": 9
            },
            "price": 4.5,
            "offerApplied": "2:3"
        }
    ],
    "totalPrice": 6.5
}


