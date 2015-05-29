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
  `price` DECIMAL(19, 4) NOT NULL ,
  `storage` LONG NOT NULL ,
  `visible` BOOLEAN NOT NULL ,
  PRIMARY KEY (`id`) );