-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema capstone
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema capstone
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `capstone` DEFAULT CHARACTER SET utf8 ;
USE `capstone` ;

-- -----------------------------------------------------
-- Table `capstone`.`appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`appointment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `date` DATE NULL DEFAULT NULL,
  `hour` TINYINT(10) NULL DEFAULT NULL,
  `duration` TINYINT(10) NULL DEFAULT NULL,
  `doctor` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `purpose` TEXT NULL DEFAULT NULL,
  `attendance` TINYINT(4) NULL DEFAULT NULL,
  `diagnostics` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`conditions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`conditions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`doctor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`eye`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`eye` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `color` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`insurance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`insurance` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `insurance_name` VARCHAR(45) NULL DEFAULT NULL,
  `group_number` VARCHAR(45) NULL DEFAULT NULL,
  `pcp` VARCHAR(100) NULL DEFAULT NULL,
  `effective_date` DATE NULL DEFAULT NULL,
  `insurance_number` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`marital_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`marital_status` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `marital_status` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`patient` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `weight` VARCHAR(45) NULL DEFAULT NULL,
  `height` VARCHAR(45) NULL DEFAULT NULL,
  `gender` TINYINT(4) NULL DEFAULT NULL,
  `eye_colour` INT(11) NULL DEFAULT NULL,
  `ssn` VARCHAR(45) NULL DEFAULT NULL,
  `DOB` DATE NULL DEFAULT NULL,
  `phone_number` VARCHAR(13) NULL DEFAULT NULL,
  `insurance` INT(11) NULL DEFAULT '0',
  `address` VARCHAR(200) NULL DEFAULT NULL,
  `marital_status` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `eye_idx` (`eye_colour` ASC),
  INDEX `insurance_idx` (`insurance` ASC),
  INDEX `marital_status_idx` (`marital_status` ASC),
  CONSTRAINT `eye`
    FOREIGN KEY (`eye_colour`)
    REFERENCES `capstone`.`eye` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `insurance`
    FOREIGN KEY (`insurance`)
    REFERENCES `capstone`.`insurance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `marital_status`
    FOREIGN KEY (`marital_status`)
    REFERENCES `capstone`.`marital_status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`emergency_contacts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`emergency_contacts` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `patient_id` INT(11) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `relationship` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `mobile` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `pat_id_idx` (`patient_id` ASC),
  CONSTRAINT `patient_id_from_emergency_contacts`
    FOREIGN KEY (`patient_id`)
    REFERENCES `capstone`.`patient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`event` (
  `id` BIGINT(20) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `end` DATETIME NULL DEFAULT NULL,
  `start` DATETIME NULL DEFAULT NULL,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`medication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`medication` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `medication` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`office`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`office` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`patient_medication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`patient_medication` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `patient_id` INT(11) NULL DEFAULT NULL,
  `medication_id` INT(11) NULL DEFAULT NULL,
  `current` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `pat_id_idx` (`patient_id` ASC),
  INDEX `med_id_idx` (`medication_id` ASC),
  CONSTRAINT `med_id`
    FOREIGN KEY (`medication_id`)
    REFERENCES `capstone`.`medication` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `pat_id`
    FOREIGN KEY (`patient_id`)
    REFERENCES `capstone`.`patient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`patients_medical_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`patients_medical_history` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `patient_id` INT(11) NULL DEFAULT NULL,
  `condition` INT(11) NULL DEFAULT NULL,
  `current` INT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `patient_idx` (`patient_id` ASC),
  INDEX `conditon_idx` (`condition` ASC),
  CONSTRAINT `conditon`
    FOREIGN KEY (`condition`)
    REFERENCES `capstone`.`conditions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `patient`
    FOREIGN KEY (`patient_id`)
    REFERENCES `capstone`.`patient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`positions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`positions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `position` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`user` (
  `id` INT(11) NOT NULL,
  `level` INT(11) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `office` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `position` VARCHAR(255) NULL DEFAULT NULL,
  `user_id` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(45) NOT NULL,
  `password` VARCHAR(124) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `office` INT(11) NULL DEFAULT NULL,
  `position` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `office_idx` (`office` ASC),
  INDEX `position_idx` (`position` ASC),
  CONSTRAINT `office`
    FOREIGN KEY (`office`)
    REFERENCES `capstone`.`office` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `position`
    FOREIGN KEY (`position`)
    REFERENCES `capstone`.`positions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone`.`user_role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NULL DEFAULT NULL,
  `role_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC),
  INDEX `role_id_idx` (`role_id` ASC),
  CONSTRAINT `role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `capstone`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `capstone`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
INSERT INTO `positions` VALUES (1,'nurse'),(2,'admin'),(3,'doctor');
INSERT INTO `office` VALUES (1,'Allstar Aurora','Aurora');
INSERT INTO `users` VALUES (2,'jPerez_16','$2a$04$m0as9WAXlo1Qx/aIRdlHPunHYlu6SMllt78B9fz5k6WptdLvQQgxy','Jovanny Perez',1,1),(3,'ewagner04','$2a$04$md2CbGvqtKtTB0ahNLKMgeet2VPy8EwBpWkW7T1b1g1VRdyRkI1hi','Eric Wagner',1,1);