INSERT INTO `ecommerce`.`product` (`name`, `description`, `price`, `storage`, `visible`) VALUES ('iphone 5', ' Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', '599.99', '10', '1');

INSERT INTO `ecommerce`.`product` (`name`, `description`, `price`, `storage`, `visible`) VALUES ('iphone 6', ' Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', '799.00', '0', '0');

INSERT INTO `ecommerce`.`product` (`name`, `description`, `price`, `storage`, `visible`) VALUES ('iphone 5s', ' Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', '649.99', '3', '1');

INSERT INTO users(username,password,enabled)
VALUES ('admin','$2a$10$ppdXreIB7nKd9pEJy2iCeu9W5LzRV/h4M6SpgA8gnCz57ZaBq2.H6', TRUE);

INSERT INTO users(username,password,enabled)
VALUES ('demouser','$2a$10$FcLl9lhebtN36xP0KZa24ecRlF1a/BwCn5banFr6rGWi1zonvRKiO', TRUE);

INSERT INTO user_roles (username, ROLE)
VALUES ('admin', 'ROLE_USER');
INSERT INTO user_roles (username, ROLE)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO user_roles (username, ROLE)
VALUES ('demouser', 'ROLE_USER');
