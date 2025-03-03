CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       email VARCHAR(100) NOT NULL,
                       password VARCHAR(255) NOT NULL
);
INSERT INTO users (username, email, password)
VALUES
    ('admin', 'admin@example.com', 'admin123'),
    ('user1', 'user1@example.com', 'password1'),
    ('user2', 'user2@example.com', 'password2');