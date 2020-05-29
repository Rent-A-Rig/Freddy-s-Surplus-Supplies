DROP DATABASE IF EXISTS FreddySurplusSupplies;
CREATE DATABASE FreddySurplusSupplies;
USE FreddySurplusSupplies;

DROP TABLE IF EXISTS inventory;
CREATE TABLE inventory (

PRODUCT_ID VARCHAR(30) NOT NULL,
PRODUCT_NAME VARCHAR(255) NOT NULL,
CATEGORY VARCHAR(255) NOT NULL,
STOCK INT NOT NULL,
PRIMARY KEY (PRODUCT_ID));

DROP TABLE IF EXISTS requestedInventory;
CREATE TABLE requestedInventory (

REQUEST_ID INT NOT NULL auto_increment,
PRODUCT_ID varchar(30) NOT NULL references inventory (PRODUCT_ID),
REQUEST_QTY INT NOT NULL,
REQUEST_DATE DATE NOT NULL,
FULFILLED BOOLEAN NOT NULL,
Primary Key (REQUEST_ID));

INSERT INTO inventory (product_id, product_name, category, stock)  
VALUES 

('111', 'freddy','crust',100),

('222', 'justin','crust', 100),

('333', 'romy','crust', 100);


INSERT INTO requestedInventory (request_id, product_id, request_qty, request_date, fulfilled)  
VALUES 
(request_id, '111', 50, '2020-03-06', 1),

(request_id, '222', 50, '2020-06-10', 0),

(request_id, '333', 50, '2020-02-01', 1);



