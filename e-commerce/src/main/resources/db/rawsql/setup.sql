/* database creation */
CREATE DATABASE IF NOT EXISTS `ecommerce` DEFAULT CHARACTER SET latin1;

/* create admin user */
GRANT ALL PRIVILEGES ON ecommerce.* TO `ecommerceAdmin`@`localhost` IDENTIFIED BY 'admin' WITH GRANT OPTION;

/* create application user */
GRANT SELECT, INSERT, UPDATE, DELETE, LOCK TABLES, CREATE TEMPORARY TABLES ON ecommerce.* TO `ecommerce`@`localhost` IDENTIFIED BY 'ecommerce';

GRANT SELECT, INSERT, UPDATE, DELETE, LOCK TABLES, CREATE TEMPORARY TABLES ON ecommerce.* TO `ecommerce`@`localhost` IDENTIFIED BY 'ecommerce';

CREATE TABLE IF NOT EXISTS `ecommerce`.`product` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `name` TEXT NOT NULL ,
  `description` TEXT NULL ,
  `price` DECIMAL(19, 2) NOT NULL ,
  `storage` LONG NOT NULL ,
  `visible` BOOLEAN NOT NULL ,
  PRIMARY KEY (`id`) );

CREATE TABLE IF NOT EXISTS users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));

CREATE TABLE IF NOT EXISTS user_roles (
  user_role_id INT(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  ROLE VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (ROLE,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));