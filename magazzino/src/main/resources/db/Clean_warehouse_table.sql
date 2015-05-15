DROP TABLE IF EXISTS `warehouse`.`warehouse`;

CREATE  TABLE `warehouse`.`warehouse` (
  `id` INT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `brand` VARCHAR(45) NULL ,
  `category` VARCHAR(45) NULL ,
  `quantity` INT NOT NULL DEFAULT 0 ,
  `last_update` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE (`name`, `brand`, `category`),
  PRIMARY KEY (`id`));
