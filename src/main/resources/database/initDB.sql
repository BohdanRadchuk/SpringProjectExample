CREATE SCHEMA IF NOT EXISTS springdata
DEFAULT CHARACTER SET utf8;
USE springdata;
CREATE TABLE IF NOT EXISTS springdata.manufacturers (
  id BINARY(16) PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);
CREATE TABLE IF NOT EXISTS springdata.products (
  id BINARY(16) PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  price DECIMAL NOT NULL,
  id_manufacturer BINARY(16) NOT NULL,
 FOREIGN KEY (id_manufacturer) REFERENCES springdata.manufacturers(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS springdata.roles (
  id BINARY(16) PRIMARY KEY,
  role VARCHAR(100) NOT NULL
);
CREATE TABLE IF NOT EXISTS springdata.users (
  id BINARY(16) PRIMARY KEY ,
  email VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(120)NOT NULL
);
CREATE TABLE IF NOT EXISTS springdata.users_roles (
  id_user BINARY(16) NOT NULL,
  id_role BINARY(16) NOT NULL,
  FOREIGN KEY (id_user) REFERENCES springdata.users(id) ON DELETE CASCADE,
  FOREIGN KEY (id_role) REFERENCES springdata.roles(id) ON DELETE CASCADE
);
