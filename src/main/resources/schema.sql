CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    number_of_pages INT NOT NULL,
    category VARCHAR(50),
    content TEXT
);
