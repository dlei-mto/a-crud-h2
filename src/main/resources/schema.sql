-- CREATE TABLE IF NOT EXISTS employees (id INT NOT NULL AUTO_INCREMENT, first_name VARCHAR(255), last_name VARCHAR(255), email_address VARCHAR(255), PRIMARY KEY (id));
DROP TABLE IF EXISTS employees;
CREATE TABLE employees (id IDENTITY PRIMARY KEY, first_name VARCHAR(255), last_name VARCHAR(255), email_address VARCHAR(255));
