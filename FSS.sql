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
PRODUCT_NAME VARCHAR(30) NOT NULL,
PRODUCT_ID varchar(30) NOT NULL references inventory (PRODUCT_ID),
REQUEST_QTY INT NOT NULL,
REQUEST_DATE DATE NOT NULL,
FULFILLED BOOLEAN NOT NULL,
Primary Key (REQUEST_ID));

DROP TABLE IF EXISTS adminLogin;
Create table adminLogin (
uname varchar(10),
pword varchar(15),
primary key(uname));

insert into adminLogin(uname, pword)
values 
('admin', 'admin');

