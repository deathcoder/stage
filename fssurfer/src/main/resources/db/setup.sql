/* database creation */
CREATE DATABASE IF NOT EXISTS `surfer` DEFAULT CHARACTER SET latin1;

/* create admin user */
GRANT ALL PRIVILEGES ON surfer.* TO `surferAdmin`@`localhost` IDENTIFIED BY 'admin' WITH GRANT OPTION;

/* create application user */
GRANT SELECT, INSERT, UPDATE, DELETE, LOCK TABLES, CREATE TEMPORARY TABLES ON surfer.* TO `surfer`@`localhost` IDENTIFIED BY 'surfer';

GRANT SELECT, INSERT, UPDATE, DELETE, LOCK TABLES, CREATE TEMPORARY TABLES ON surfer.* TO `surfer`@`localhost` IDENTIFIED BY 'surfer';

CREATE TABLE IF NOT EXISTS `surfer`.`files` (
  `abspath` VARCHAR(500) NOT NULL ,
  `name` VARCHAR(100) NOT NULL ,
  `type` VARCHAR(4) NULL ,
  `extension` VARCHAR(45) NOT NULL ,
  `permissions` VARCHAR(3) NULL ,
  `size` BIGINT NULL ,
  PRIMARY KEY (`abspath`) );
