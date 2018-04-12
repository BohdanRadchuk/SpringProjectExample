CREATE SCHEMA IF NOT EXISTS springdata
DEFAULT CHARACTER SET utf8;
USE springdata;
CREATE TABLE IF NOT EXISTS springdata.manufacturers (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);
CREATE TABLE IF NOT EXISTS springdata.products (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  price DECIMAL NOT NULL,
  manufacturer_id VARCHAR(100) NOT NULL,
 FOREIGN KEY (manufacturer_id) REFERENCES springdata.manufacturers(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS springdata.roles (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);
CREATE TABLE IF NOT EXISTS springdata.users (
  id VARCHAR(36) PRIMARY KEY ,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  firstName VARCHAR(100) NOT NULL,
  lastName VARCHAR(120)NOT NULL,
  role_id VARCHAR(36) NOT NULL,
  FOREIGN KEY (role_id) REFERENCES springdata.roles(id) ON DELETE CASCADE
);
