-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dao
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dao
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dao` DEFAULT CHARACTER SET utf8 ;
USE `dao` ;

-- -----------------------------------------------------
-- Table `dao`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dao`.`Persona` (
  `idPersona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `edad` INT(3) NOT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE INDEX `idPersona_UNIQUE` (`idPersona` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
