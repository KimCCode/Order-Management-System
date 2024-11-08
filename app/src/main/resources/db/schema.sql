CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    phone VARCHAR(20)
);

CREATE TABLE sizes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT
);

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customerId INT,  -- references orders table
    productId INT,  -- references products table
    sizeId INT,
    quantity INT NOT NULL,  -- number of units ordered
    date VARCHAR(20),
    FOREIGN KEY (customerId) REFERENCES customers(id),
    FOREIGN KEY (productId) REFERENCES products(id),
    FOREIGN KEY (sizeId) REFERENCES sizes(id)
);

INSERT INTO products (name) VALUES ("Rainbow");
INSERT INTO sizes (name, price) VALUES ("Small", 47);
INSERT INTO sizes (name, price) VALUES ("Large", 55);
INSERT INTO sizes (name, price) VALUES ("Combo", 60);

