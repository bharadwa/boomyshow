-- users

CREATE TABLE Users (
                       user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       phoneNumber VARCHAR(20) UNIQUE NOT NULL,
                       password VARCHAR(100) NOT NULL
);