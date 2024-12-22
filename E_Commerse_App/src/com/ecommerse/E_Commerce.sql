CREATE TABLE product (
    id NUMBER(10) PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    description VARCHAR2(255) NOT NULL,
    price NUMBER(10, 2) NOT NULL, 
    quantity NUMBER(10) NOT NULL 
);


CREATE TABLE Userss (
    username VARCHAR2(50) PRIMARY KEY,
    password VARCHAR2(50) NOT NULL,
    firstName VARCHAR2(50) NOT NULL,
    lastName VARCHAR2(50) NOT NULL,
    email VARCHAR2(100) NOT NULL,
    city VARCHAR2(50) NOT NULL,
    mobileNumber VARCHAR2(15) NOT NULL,
    role VARCHAR2(20) NOT NULL
);


INSERT INTO product (id, name, description, price, quantity) VALUES (101, 'Apple MacBook 2020', '8 GB RAM, 256 SSD', 85000, 5);
INSERT INTO product (id, name, description, price, quantity) VALUES (102, 'One Plus Mobile', '16 GB RAM, 128 GB Storage', 37500, 3);



INSERt INTO Userss(username, password, firstName, lastName, email, city, mobileNumber, role) VALUES ('ajay123', 'ajaypass', 'Ajay', 'Kumar', 'ajay@example.com', 'Delhi', '9876543210', 'customer');
INSERT INTO userss (username, password, firstName, lastName, email, city, mobileNumber, role) VALUES ('admin', 'adminpass', 'Admin', 'User', 'admin@example.com', 'City', '1234567890', 'admin');



CREATE SEQUENCE purchase_history_seq
START WITH 1
INCREMENT BY 1
NOCACHE;


CREATE TABLE purchase_history (
    id NUMBER PRIMARY KEY, 
    username VARCHAR2(50) NOT NULL, 
    product_id NUMBER NOT NULL, 
    quantity NUMBER NOT NULL, 
    CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES userss (username), 
    CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES product (id) 
);




INSERT INTO purchase_history (username, product_id, quantity) VALUES ('ajay123', 101, 1);
INSERT INTO purchase_history (username, product_id, quantity) VALUES ('ajay123', 102, 2);



SPOOL E:\Java_Training\E_Commerce\Application_ECommerse\E_Commerse_App\src\com\ecommerse\output.sql
SELECT * FROM all_tables;
SPOOL OFF;






