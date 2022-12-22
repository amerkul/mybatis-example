CREATE TABLE users (
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) UNIQUE NOT NULL,
    salary INT
);

CREATE TABLE books (
    book_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) UNIQUE NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT user_foreign_key
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);