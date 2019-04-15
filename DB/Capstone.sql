CREATE DATABASE  IF NOT EXISTS `capstone` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `capstone`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: capstone
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `hour` tinyint(10) DEFAULT NULL,
  `duration` tinyint(10) DEFAULT NULL,
  `doctor` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `purpose` text,
  `attendance` tinyint(4) DEFAULT NULL,
  `diagnostics` text,
  `patient_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `pat_id_idx` (`id`,`patient_id`),
  KEY `pat_id_idx1` (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,'2019-04-15',9,1,NULL,'descriptiopn',NULL,0,'',0),(2,'2019-03-20',10,2,NULL,'description',NULL,NULL,NULL,NULL),(3,'2019-02-20',9,2,NULL,'description',NULL,NULL,NULL,NULL),(5,'2019-02-20',10,1,NULL,'des',NULL,NULL,NULL,NULL),(6,'2019-03-30',11,1,NULL,'test','follow up',NULL,NULL,NULL),(20,'2019-04-15',11,1,'Jo','test','follow up',0,'very bad',0);
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointments_per_patient`
--

DROP TABLE IF EXISTS `appointments_per_patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointments_per_patient` (
  `id` bigint(20) NOT NULL,
  `appoiment_id` bigint(20) NOT NULL,
  `patient_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments_per_patient`
--

LOCK TABLES `appointments_per_patient` WRITE;
/*!40000 ALTER TABLE `appointments_per_patient` DISABLE KEYS */;
/*!40000 ALTER TABLE `appointments_per_patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conditions`
--

DROP TABLE IF EXISTS `conditions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conditions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conditions`
--

LOCK TABLES `conditions` WRITE;
/*!40000 ALTER TABLE `conditions` DISABLE KEYS */;
/*!40000 ALTER TABLE `conditions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
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
  KEY `user_id_idx` (`user_id`),
  KEY `role_id_idx` (`role_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (3,2,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(45) NOT NULL,
  `password` varchar(124) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `office` int(11) DEFAULT NULL,
  `position` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `office_idx` (`office`),
  KEY `position_idx` (`position`),
  CONSTRAINT `office` FOREIGN KEY (`office`) REFERENCES `office` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `position` FOREIGN KEY (`position`) REFERENCES `positions` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'jPerez_16','$2a$04$m0as9WAXlo1Qx/aIRdlHPunHYlu6SMllt78B9fz5k6WptdLvQQgxy','Jovanny Perez',1,1),(3,'ewagner04','$2a$04$md2CbGvqtKtTB0ahNLKMgeet2VPy8EwBpWkW7T1b1g1VRdyRkI1hi','Eric Wagner',1,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'capstone'
--

--
-- Dumping routines for database 'capstone'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-15 11:19:55
