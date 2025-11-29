-- Database creation script (SQL Server)
 IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = 'fullstack_test')
 BEGIN
 CREATE DATABASE fullstack_test;
 END
 GO
 USE fullstack_test;
 GO
 CREATE TABLE users (
 id INT IDENTITY(1,1) PRIMARY KEY,
 email VARCHAR(200) NOT NULL UNIQUE,
 password VARCHAR(300) NOT NULL,
 role VARCHAR(50) NOT NULL,
 created_at DATETIME DEFAULT GETDATE()
 );
 GO
 CREATE TABLE products (
 id INT IDENTITY(1,1) PRIMARY KEY,
 name VARCHAR(200) NOT NULL,
 description VARCHAR(500),
 
price DECIMAL(10,2) NOT NULL,
 stock INT NOT NULL,
 type VARCHAR(100),
 created_at DATETIME DEFAULT GETDATE()
 );
 GO-- example admin user (password = admin123)
 INSERT INTO users (email, password, role)
 VALUES ('admin@test.com', '$2a$10$DOWSDzjYZR51GDX0BpvyOeGWix.AI0I/
 UhR6HKQ1zHp1oD7wM0hL6', 'ADMIN');
 GO