CREATE TABLE IF NOT EXISTS users (
  id       INT PRIMARY KEY,
  username VARCHAR(255),
  email    VARCHAR(255),
  password VARCHAR(255),
  enabled INT DEFAULT 1
);

CREATE TABLE IF NOT EXISTS roles (
  id   INT PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS user_roles (
  id      INT PRIMARY KEY,
  user_id INT,
  role_id INT
);