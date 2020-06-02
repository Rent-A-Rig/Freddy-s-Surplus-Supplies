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

INSERT INTO inventory (PRODUCT_ID, PRODUCT_NAME, CATEGORY, STOCK)  
VALUES (
'ROGSTRIXGL12', 
'ROG Strix GL12 Gaming Desktop',
'Gamingrigs, desktop',
200
),

(
'ABSMAGEM',
'ABS Mage M Gaming Desktop',
'Gamingrigs, desktop',
200
),

(
'MSI_Trident_XPlus',
'MSI Trident X Plus 9SD-461US Gaming Desktop',
'Gamingrigs, desktop',
200
),

(
'ASUS_VG245H',
'ASUS VG245H 24" Gaming Monitor',
'Gamingrigs, monitors',
200
),

(
'ACER_Z1_Z321QU',
'Acer Predator Z1 Z321QU bmiphzx 31.5',
'Gamingrigs, monitors',
200
),

(
'ASUS_XG32VQ',
'ASUS ROG Strix XG32VQ 32',
'Gamingrigs, monitors',
200
),

(
'Roswell_Fusion_C40',
'Rosewill Fusion C40 Gaming Keyboard and Mouse Combo',
'Gamingrigs, accessories',
200
),

(
'CM_Devastator_3',
'Cooler Master Devastator 3 Gaming Combo',
'Gamingrigs, accessories',
200
),

(
'CM_Storm_Devastator',
'CM Storm Devastator',
'Gamingrigs, accessories',
200
),

(
'MSI_9SF-240',
'MSI GP Series GP65 Leopard 9SF-240 15.6',
'portable, gaminglaptops',
200
),

(
'ASUS_ROG_Zephyrus_S',
'ASUS ROG Zephyrus S Ultra Slim Gaming PC Laptop, 15.6',
'portable, gaminglaptops',
200
),

(
'Acer_PH315',
'Acer Predator Helios 300 PH315-52-71RT 15.6',
'portable, gaminglaptops',
200
),

(
'Microsoft_Surface_JKX-00001',
'Microsoft Laptop Surface Laptop JKX-00001',
'portable, thinandlight',
200
),

(
'MacBook_Air',
'Apple Laptop MacBook Air MJVE2LLA',
'portable, thinandlight',
200
),

(
'Lenovo_ThinkPad',
'Lenovo Laptop ThinkPad T480s (20L7002HUS)',
'portable, thinandlight',
200
),

(
'Microsoft_Surface_Pro_4',
'Microsoft Surface Pro 4',
'portable, tablets',
200
),

(
'Apple_iPad_Air',
'Apple iPad Air MD788LL/A',
'portable, tablets',
200
),

(
'Lenovo_yoga_tab_3',
'Lenovo YOGA Tab 3 8 ZA090094US',
'portable, tablets',
200
);

DROP TABLE IF EXISTS requestedInventory;
CREATE TABLE requestedInventory (

REQUEST_ID INT NOT NULL auto_increment,
PRODUCT_NAME VARCHAR(255) NOT NULL,
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



select * from inventory;
