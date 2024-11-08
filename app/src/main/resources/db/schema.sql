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

CREATE TABLE order_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customerId INT,  -- references orders table
    productId INT,  -- references products table
    sizeId INT,
    quantity INT NOT NULL,  -- number of units ordered
    date DATE,
    FOREIGN KEY (customerId) REFERENCES customers(id),
    FOREIGN KEY (productId) REFERENCES products(id),
    FOREIGN KEY (sizeId) REFERENCES sizes(id)
);

