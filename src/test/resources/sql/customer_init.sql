DROP TABLE customer;
CREATE TABLE customer ( id INTEGER PRIMARY KEY, name varchar(255) DEFAULT NULL, contact varchar(255) DEFAULT NULL, telephone varchar(255) DEFAULT NULL, email varchar(255) DEFAULT NULL, remark text ); 
INSERT INTO customer( name, contact, telephone, email, remark) VALUES( 'customer1', 'Jack', '13512345678', 'jack@gmail.com', null );
INSERT INTO customer( name, contact, telephone, email, remark) VALUES( 'customer2', 'Rose', '13623456789', 'rose@gmail.com', null );
