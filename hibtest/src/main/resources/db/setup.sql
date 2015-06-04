/* database creation */
CREATE DATABASE IF NOT EXISTS `accounts` DEFAULT CHARACTER SET latin1;

/* create admin user */
GRANT ALL PRIVILEGES ON accounts.* TO `accountsAdmin`@`localhost` IDENTIFIED BY 'admin' WITH GRANT OPTION;

/* create application user */
GRANT SELECT, INSERT, UPDATE, DELETE, LOCK TABLES, CREATE TEMPORARY TABLES ON accounts.* TO `accounts`@`localhost` IDENTIFIED BY 'accounts';

GRANT SELECT, INSERT, UPDATE, DELETE, LOCK TABLES, CREATE TEMPORARY TABLES ON accounts.* TO `accounts`@`localhost` IDENTIFIED BY 'accounts';

CREATE TABLE IF NOT EXISTS `accounts`.`account` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30) NOT NULL UNIQUE ,
  `password` VARCHAR(40) NOT NULL ,
  PRIMARY KEY (`id`) );

CREATE TABLE IF NOT EXISTS `accounts`.`profile` (
  `account` BIGINT NOT NULL REFERENCES `accounts`.`account` (`id`),
  `name` TEXT NULL ,
  `lastname` TEXT NULL ,
  `birth` DATE NULL ,
  PRIMARY KEY (`account`) );

CREATE TABLE IF NOT EXISTS `accounts`.`group` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` TEXT NOT NULL,
  `permissions` TEXT NOT NULL ,
  PRIMARY KEY (`id`) );

CREATE TABLE IF NOT EXISTS `accounts`.`profile_info` (
  `profile` BIGINT NOT NULL REFERENCES `accounts`.`profile` (`account`),
  `key` VARCHAR(30) NOT NULL,
  `value` TEXT NOT NULL ,
  PRIMARY KEY (`profile`, `key`) );

CREATE TABLE IF NOT EXISTS `accounts`.`participant` (
  `group_id` BIGINT NOT NULL REFERENCES `accounts`.`group` (`id`),
  `acc_id` BIGINT NOT NULL REFERENCES `accounts`.`profile` (`account`),
  PRIMARY KEY (`group_id`, `acc_id`) );
