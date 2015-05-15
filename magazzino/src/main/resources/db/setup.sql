/* database creation */
CREATE DATABASE IF NOT EXISTS `warehouse` DEFAULT CHARACTER SET latin1;

/* create admin user if doesn't exists  */
GRANT ALL PRIVILEGES ON warehouse.* TO `warehouseAdmin`@`localhost` IDENTIFIED BY 'admin' WITH GRANT OPTION;

/* create application user */
GRANT SELECT, INSERT, UPDATE, DELETE, LOCK TABLES, CREATE TEMPORARY TABLES ON warehouse.* TO `warehouse`@`localhost` IDENTIFIED BY 'warehouse';

GRANT SELECT, INSERT, UPDATE, DELETE, LOCK TABLES, CREATE TEMPORARY TABLES ON warehouse.* TO `warehouse`@`localhost` IDENTIFIED BY 'warehouse';