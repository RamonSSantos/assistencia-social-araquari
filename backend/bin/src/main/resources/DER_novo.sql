-- MySQL Script generated by MySQL Workbench
-- Tue Mar  3 20:31:20 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema asadb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema asadb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `asadb` DEFAULT CHARACTER SET utf8 ;
USE `asadb` ;

-- -----------------------------------------------------
-- Table `asadb`.`profiles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`profiles` (
  `idprofile` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`idprofile`),
  UNIQUE INDEX `iduser_profile_UNIQUE` (`idprofile` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`users` (
  `iduser` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fullname` VARCHAR(45) NOT NULL,
  `cpf` BIGINT(11) UNSIGNED NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `status` TINYINT(1) UNSIGNED NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `idprofile` TINYINT UNSIGNED NOT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC),
  UNIQUE INDEX `iduser_UNIQUE` (`iduser` ASC),
  INDEX `fk_users_user_profile_idx` (`idprofile` ASC),
  CONSTRAINT `fk_users_user_profile`
    FOREIGN KEY (`idprofile`)
    REFERENCES `asadb`.`profiles` (`idprofile`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`departments` (
  `iddepartment` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`iddepartment`),
  UNIQUE INDEX `iddepartments_UNIQUE` (`iddepartment` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`subdepartments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`subdepartments` (
  `idsubdepartment` TINYINT(1) UNSIGNED NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  `iddepartment` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idsubdepartment`),
  UNIQUE INDEX `idsubdepartments_UNIQUE` (`idsubdepartment` ASC),
  INDEX `fk_subdepartments_departments1_idx` (`iddepartment` ASC),
  CONSTRAINT `fk_subdepartments_departments1`
    FOREIGN KEY (`iddepartment`)
    REFERENCES `asadb`.`departments` (`iddepartment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`contact` (
  `idcontact` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `type_primary_phone` TINYINT(1) UNSIGNED NOT NULL,
  `type_secondary_phone` TINYINT(1) UNSIGNED NOT NULL,
  `type_email` TINYINT(1) UNSIGNED NOT NULL,
  `newsletter` TINYINT(1) UNSIGNED NOT NULL,
  `confirm_message` TINYINT(1) UNSIGNED NOT NULL,
  `primary_phone` CHAR(15) NULL,
  `secondary_phone` CHAR(15) NULL,
  `email` VARCHAR(50) NULL,
  PRIMARY KEY (`idcontact`),
  UNIQUE INDEX `idcontact_UNIQUE` (`idcontact` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`family_reference`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`family_reference` (
  `idfamily_reference` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `register_date` DATE NOT NULL,
  `family_gross_salary` DECIMAL(7,2) NULL,
  `per_capita_income` DECIMAL(7,2) NULL,
  `helthcare_center` VARCHAR(45) NULL,
  `food_insecurity_situation` TINYINT(1) UNSIGNED NULL,
  `ethnicity` VARCHAR(45) NULL,
  `community` VARCHAR(45) NULL,
  `indian_village` VARCHAR(45) NULL,
  `hospitalized_person` TINYINT(2) UNSIGNED NULL,
  `update_date` DATE NULL,
  `observation` NVARCHAR(1000) NULL,
  `idcontact` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idfamily_reference`),
  UNIQUE INDEX `idpersonal_information_reference_UNIQUE` (`idfamily_reference` ASC),
  INDEX `fk_family_reference_contact1_idx` (`idcontact` ASC),
  CONSTRAINT `fk_family_reference_contact1`
    FOREIGN KEY (`idcontact`)
    REFERENCES `asadb`.`contact` (`idcontact`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`property_characteristic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`property_characteristic` (
  `idproperty_characteristic` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `property_situation` TINYINT(1) UNSIGNED NOT NULL,
  `building_characteristic` TINYINT(1) UNSIGNED NOT NULL,
  `electricity` TINYINT(1) UNSIGNED NOT NULL,
  `electricity_price` DECIMAL(6,2) NOT NULL,
  `water_supply` TINYINT(1) UNSIGNED NOT NULL,
  `water_supply_price` DECIMAL(6,2) NOT NULL,
  `risk_area_flood` TINYINT(1) UNSIGNED NOT NULL,
  `building_observation` VARCHAR(150) NULL,
  `property_observation` VARCHAR(150) NULL,
  `sanitary_sewer` TINYINT(1) UNSIGNED NULL,
  `garbage_collection` TINYINT(1) UNSIGNED NULL,
  `rooms` TINYINT(2) UNSIGNED NULL,
  `outside_wall_characteristic` TINYINT(1) UNSIGNED NULL,
  `floor_characteristic` TINYINT(1) UNSIGNED NULL,
  `bedrooms` TINYINT(1) UNSIGNED NULL,
  `accessibility` TINYINT(1) UNSIGNED NULL,
  `risk_area_geographic` TINYINT(1) UNSIGNED NULL,
  `risk_area_conflict` TINYINT(1) UNSIGNED NULL,
  `sidewalk` TINYINT(1) UNSIGNED NULL,
  `observation` VARCHAR(150) NULL,
  PRIMARY KEY (`idproperty_characteristic`),
  UNIQUE INDEX `idresidence_characteristic_UNIQUE` (`idproperty_characteristic` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`family_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`family_address` (
  `idfamily_address` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `public_area` VARCHAR(45) NOT NULL,
  `street` VARCHAR(80) NOT NULL,
  `number` TINYINT(5) UNSIGNED NOT NULL,
  `district_name` VARCHAR(45) NOT NULL,
  `location` TINYINT(1) UNSIGNED NOT NULL,
  `cep` CHAR(9) NULL,
  `complement` VARCHAR(45) NULL,
  `landmark` VARCHAR(45) NULL,
  `state` TINYINT(2) UNSIGNED NULL,
  `town` SMALLINT(5) UNSIGNED NULL,
  `district_code` TINYINT(2) UNSIGNED NULL,
  `subdistrict` TINYINT(2) UNSIGNED NULL,
  `census_sector` SMALLINT(4) UNSIGNED NULL,
  `idproperty_characteristic` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idfamily_address`),
  UNIQUE INDEX `idfamily_address_UNIQUE` (`idfamily_address` ASC),
  INDEX `fk_family_address_property_characteristic1_idx` (`idproperty_characteristic` ASC),
  CONSTRAINT `fk_family_address_property_characteristic1`
    FOREIGN KEY (`idproperty_characteristic`)
    REFERENCES `asadb`.`property_characteristic` (`idproperty_characteristic`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`work_information`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`work_information` (
  `idwork_information` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `retired` TINYINT(1) UNSIGNED NOT NULL,
  `work_last_week` TINYINT(1) UNSIGNED NOT NULL,
  `work_last_year` TINYINT(1) UNSIGNED NOT NULL,
  `register_date` DATE NOT NULL,
  `job_location` VARCHAR(45) NULL,
  `workday` VARCHAR(13) NULL,
  `job_title` VARCHAR(45) NULL,
  `professional_qualification` VARCHAR(45) NULL,
  `update_date` DATE NULL,
  `observation` VARCHAR(150) NULL,
  `months_worked` TINYINT(2) UNSIGNED NULL,
  PRIMARY KEY (`idwork_information`),
  UNIQUE INDEX `idwork_information_UNIQUE` (`idwork_information` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`filiation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`filiation` (
  `idfiliation` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fullname_mother` VARCHAR(80) NULL,
  `fullname_father` VARCHAR(80) NULL,
  PRIMARY KEY (`idfiliation`),
  UNIQUE INDEX `idfiliation_UNIQUE` (`idfiliation` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`place_of_birth`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`place_of_birth` (
  `idplace_of_birth` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `registry_office` TINYINT(1) UNSIGNED NOT NULL,
  `hometown` VARCHAR(45) NULL,
  `home_state` VARCHAR(45) NULL,
  `foreign_country` VARCHAR(45) NULL,
  PRIMARY KEY (`idplace_of_birth`),
  UNIQUE INDEX `idplace_of_birth_UNIQUE` (`idplace_of_birth` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`identity_card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`identity_card` (
  `ididentity_card` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `number` BIGINT(16) UNSIGNED NULL,
  `complement` CHAR(5) NULL,
  `date_issue` DATE NULL,
  `issuing_state` VARCHAR(30) NULL,
  `issuing_state_initials` CHAR(8) NULL,
  PRIMARY KEY (`ididentity_card`),
  UNIQUE INDEX `ididentity_card_UNIQUE` (`ididentity_card` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`work_card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`work_card` (
  `idwork_card` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `number` BIGINT(12) UNSIGNED NULL,
  `date_issue` DATE NULL,
  `issuing_state` VARCHAR(30) NULL,
  PRIMARY KEY (`idwork_card`),
  UNIQUE INDEX `idwork_permit_UNIQUE` (`idwork_card` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`electoral_card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`electoral_card` (
  `idelectoral_card` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `number` BIGINT(12) UNSIGNED NULL,
  `electoral_ward` SMALLINT(4) UNSIGNED NULL,
  `electoral_office` SMALLINT(4) UNSIGNED NULL,
  PRIMARY KEY (`idelectoral_card`),
  UNIQUE INDEX `idelectoral_card_UNIQUE` (`idelectoral_card` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`public_civil_registry`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`public_civil_registry` (
  `idpublic_civil_registry` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `type_certificate` TINYINT(1) UNSIGNED NOT NULL,
  `registry_office` VARCHAR(45) NULL,
  `register_date` DATE NULL,
  `number_book` INT(8) UNSIGNED NULL,
  `entry_sheet` SMALLINT(4) UNSIGNED NULL,
  `rani` INT(8) UNSIGNED NULL,
  `registration` VARCHAR(32) NULL,
  `register_state` VARCHAR(45) NULL,
  `register_town` VARCHAR(45) NULL,
  PRIMARY KEY (`idpublic_civil_registry`),
  UNIQUE INDEX `idpublic_civil_registry_UNIQUE` (`idpublic_civil_registry` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`civil_documentation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`civil_documentation` (
  `idcivil_documentation` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `marital_status` TINYINT(1) UNSIGNED NOT NULL,
  `cpf` BIGINT(11) UNSIGNED NULL,
  `nis` BIGINT(11) UNSIGNED NULL,
  `senior_card` TINYINT(1) UNSIGNED NULL,
  `young_card` TINYINT(1) UNSIGNED NULL,
  `idfiliation` INT UNSIGNED NOT NULL,
  `idplace_of_birth` INT UNSIGNED NOT NULL,
  `ididentity_card` INT UNSIGNED NOT NULL,
  `idwork_card` INT UNSIGNED NOT NULL,
  `idelectoral_card` INT UNSIGNED NOT NULL,
  `idpublic_civil_registry` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idcivil_documentation`),
  UNIQUE INDEX `idcivil_documentation_UNIQUE` (`idcivil_documentation` ASC),
  UNIQUE INDEX `nis_UNIQUE` (`nis` ASC),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC),
  INDEX `fk_civil_documentation_filiation1_idx` (`idfiliation` ASC),
  INDEX `fk_civil_documentation_place_of_birth1_idx` (`idplace_of_birth` ASC),
  INDEX `fk_civil_documentation_identity_card1_idx` (`ididentity_card` ASC),
  INDEX `fk_civil_documentation_work_card1_idx` (`idwork_card` ASC),
  INDEX `fk_civil_documentation_electoral_card1_idx` (`idelectoral_card` ASC),
  INDEX `fk_civil_documentation_public_civil_registry1_idx` (`idpublic_civil_registry` ASC),
  CONSTRAINT `fk_civil_documentation_filiation1`
    FOREIGN KEY (`idfiliation`)
    REFERENCES `asadb`.`filiation` (`idfiliation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_civil_documentation_place_of_birth1`
    FOREIGN KEY (`idplace_of_birth`)
    REFERENCES `asadb`.`place_of_birth` (`idplace_of_birth`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_civil_documentation_identity_card1`
    FOREIGN KEY (`ididentity_card`)
    REFERENCES `asadb`.`identity_card` (`ididentity_card`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_civil_documentation_work_card1`
    FOREIGN KEY (`idwork_card`)
    REFERENCES `asadb`.`work_card` (`idwork_card`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_civil_documentation_electoral_card1`
    FOREIGN KEY (`idelectoral_card`)
    REFERENCES `asadb`.`electoral_card` (`idelectoral_card`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_civil_documentation_public_civil_registry1`
    FOREIGN KEY (`idpublic_civil_registry`)
    REFERENCES `asadb`.`public_civil_registry` (`idpublic_civil_registry`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`school_information`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`school_information` (
  `idschool_address` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `town` VARCHAR(45) NOT NULL,
  `code_inep` INT(8) UNSIGNED NULL,
  PRIMARY KEY (`idschool_address`),
  UNIQUE INDEX `idschool_address_UNIQUE` (`idschool_address` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`educational_information`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`educational_information` (
  `ideducational_information` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `alphabetization` TINYINT(1) UNSIGNED NOT NULL,
  `student` TINYINT(1) UNSIGNED NOT NULL,
  `education_level` TINYINT(2) UNSIGNED NOT NULL,
  `register_date` DATE NOT NULL,
  `course_enroll` TINYINT(2) UNSIGNED NULL,
  `course_enroll_serie` TINYINT(1) UNSIGNED NULL,
  `pronatec` TINYINT(1) UNSIGNED NULL,
  `update_date` DATE NULL,
  `observation` VARCHAR(150) NULL,
  `idschool_information` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`ideducational_information`),
  UNIQUE INDEX `ideducational_information_UNIQUE` (`ideducational_information` ASC),
  INDEX `fk_educational_information_school_information1_idx` (`idschool_information` ASC),
  CONSTRAINT `fk_educational_information_school_information1`
    FOREIGN KEY (`idschool_information`)
    REFERENCES `asadb`.`school_information` (`idschool_address`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`health_conditions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`health_conditions` (
  `idhealth_condition` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `register_date` DATE NOT NULL,
  `type_disability` TINYINT(1) UNSIGNED NOT NULL,
  `constant_care` TINYINT(1) UNSIGNED NULL,
  `reference_care` VARCHAR(45) NULL,
  `serious_illness` VARCHAR(45) NULL,
  `prescription_medication` VARCHAR(45) NULL,
  `alcoholic` VARCHAR(45) NULL,
  `drug_addicts` VARCHAR(45) NULL,
  `pregnancy` TINYINT(1) UNSIGNED NULL,
  `antenatal_visit` TINYINT(1) UNSIGNED NULL,
  `contraceptive_method` VARCHAR(45) NULL,
  `chronic_diseases` VARCHAR(45) NULL,
  `free_pass` TINYINT(1) UNSIGNED NULL,
  `observation` VARCHAR(150) NULL,
  PRIMARY KEY (`idhealth_condition`),
  UNIQUE INDEX `idhealth_condition_UNIQUE` (`idhealth_condition` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`remuneration`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`remuneration` (
  `idremuneration` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `type_remuneration` TINYINT(2) UNSIGNED NOT NULL,
  `gross_salary` DECIMAL(7,2) NOT NULL,
  `gross_salary_period` DECIMAL(7,2) NULL,
  `continuous_cash_benefit` TINYINT(1) UNSIGNED NULL,
  PRIMARY KEY (`idremuneration`),
  UNIQUE INDEX `idremuneration_UNIQUE` (`idremuneration` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`household`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`household` (
  `idhousehold` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fullname` VARCHAR(80) NOT NULL,
  `birthday` DATE NOT NULL,
  `genre` VARCHAR(25) NOT NULL,
  `family_reference_interaction` TINYINT(2) UNSIGNED NOT NULL,
  `register_date` DATE NOT NULL,
  `age` TINYINT(3) UNSIGNED NULL,
  `nickname` VARCHAR(30) NULL,
  `race` TINYINT(1) NULL,
  `update_date` DATE NULL,
  `idwork_information` INT UNSIGNED NOT NULL,
  `idcivil_documentation` INT UNSIGNED NOT NULL,
  `ideducational_information` INT UNSIGNED NOT NULL,
  `idhealth_conditions` INT UNSIGNED NOT NULL,
  `idremuneration` INT UNSIGNED NOT NULL,
  `idfamily_reference` INT UNSIGNED NULL,
  PRIMARY KEY (`idhousehold`),
  UNIQUE INDEX `idhousehold_UNIQUE` (`idhousehold` ASC),
  INDEX `fk_household_family_reference1_idx` (`idfamily_reference` ASC),
  INDEX `fk_household_work_information1_idx` (`idwork_information` ASC),
  INDEX `fk_household_civil_documentation1_idx` (`idcivil_documentation` ASC),
  INDEX `fk_household_educational_information1_idx` (`ideducational_information` ASC),
  INDEX `fk_household_health_conditions1_idx` (`idhealth_conditions` ASC),
  INDEX `fk_household_remuneration1_idx` (`idremuneration` ASC),
  CONSTRAINT `fk_household_family_reference1`
    FOREIGN KEY (`idfamily_reference`)
    REFERENCES `asadb`.`family_reference` (`idfamily_reference`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_household_work_information1`
    FOREIGN KEY (`idwork_information`)
    REFERENCES `asadb`.`work_information` (`idwork_information`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_household_civil_documentation1`
    FOREIGN KEY (`idcivil_documentation`)
    REFERENCES `asadb`.`civil_documentation` (`idcivil_documentation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_household_educational_information1`
    FOREIGN KEY (`ideducational_information`)
    REFERENCES `asadb`.`educational_information` (`ideducational_information`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_household_health_conditions1`
    FOREIGN KEY (`idhealth_conditions`)
    REFERENCES `asadb`.`health_conditions` (`idhealth_condition`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_household_remuneration1`
    FOREIGN KEY (`idremuneration`)
    REFERENCES `asadb`.`remuneration` (`idremuneration`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`single_registry_identification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`single_registry_identification` (
  `idsingle_registry_identification` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `date_interview` DATE NOT NULL,
  `type_operation` TINYINT(1) UNSIGNED NULL,
  `type_interview` TINYINT(1) UNSIGNED NULL,
  `type_form` TINYINT(1) UNSIGNED NULL,
  `description` VARCHAR(45) NULL,
  `observation` VARCHAR(80) NULL,
  `idfamily_reference` INT UNSIGNED NOT NULL,
  `iduser` INT UNSIGNED NOT NULL,
  `idsubdepartment` TINYINT(1) UNSIGNED NOT NULL,
  PRIMARY KEY (`idsingle_registry_identification`),
  UNIQUE INDEX `idsingle_registry_identification_UNIQUE` (`idsingle_registry_identification` ASC),
  INDEX `fk_single_registry_identification_family_reference1_idx` (`idfamily_reference` ASC),
  INDEX `fk_single_registry_identification_users1_idx` (`iduser` ASC),
  INDEX `fk_single_registry_identification_subdepartments1_idx` (`idsubdepartment` ASC),
  CONSTRAINT `fk_single_registry_identification_family_reference1`
    FOREIGN KEY (`idfamily_reference`)
    REFERENCES `asadb`.`family_reference` (`idfamily_reference`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_single_registry_identification_users1`
    FOREIGN KEY (`iduser`)
    REFERENCES `asadb`.`users` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_single_registry_identification_subdepartments1`
    FOREIGN KEY (`idsubdepartment`)
    REFERENCES `asadb`.`subdepartments` (`idsubdepartment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`social_programs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`social_programs` (
  `idsocial_program` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `receive_benefits` TINYINT(1) UNSIGNED NOT NULL,
  `family_gross_salary` DECIMAL(7,2) NULL,
  `per_capita_income` DECIMAL(7,2) NULL,
  PRIMARY KEY (`idsocial_program`),
  UNIQUE INDEX `idsocial_programs_UNIQUE` (`idsocial_program` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`family_reference_has_social_programs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`family_reference_has_social_programs` (
  `idfamily_reference` INT UNSIGNED NOT NULL,
  `idsocial_programs` INT UNSIGNED NOT NULL,
  `type_program` TINYINT(1) UNSIGNED NULL,
  `value_received` DECIMAL(7,2) NULL,
  PRIMARY KEY (`idfamily_reference`, `idsocial_programs`),
  INDEX `fk_family_reference_has_social_programs_social_programs1_idx` (`idsocial_programs` ASC),
  INDEX `fk_family_reference_has_social_programs_family_reference1_idx` (`idfamily_reference` ASC),
  CONSTRAINT `fk_family_reference_has_social_programs_family_reference1`
    FOREIGN KEY (`idfamily_reference`)
    REFERENCES `asadb`.`family_reference` (`idfamily_reference`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_family_reference_has_social_programs_social_programs1`
    FOREIGN KEY (`idsocial_programs`)
    REFERENCES `asadb`.`social_programs` (`idsocial_program`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`household_has_remuneration`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`household_has_remuneration` (
  `idhousehold` INT UNSIGNED NOT NULL,
  `idremuneration` INT UNSIGNED NOT NULL,
  `type_remuneration` TINYINT(1) UNSIGNED NULL,
  `value_received` DECIMAL(5,2) NULL,
  PRIMARY KEY (`idhousehold`, `idremuneration`),
  INDEX `fk_household_has_remuneration_remuneration1_idx` (`idremuneration` ASC),
  INDEX `fk_household_has_remuneration_household1_idx` (`idhousehold` ASC),
  CONSTRAINT `fk_household_has_remuneration_household1`
    FOREIGN KEY (`idhousehold`)
    REFERENCES `asadb`.`household` (`idhousehold`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_household_has_remuneration_remuneration1`
    FOREIGN KEY (`idremuneration`)
    REFERENCES `asadb`.`remuneration` (`idremuneration`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`family_address_has_family_reference`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`family_address_has_family_reference` (
  `idfamily_address` INT UNSIGNED NOT NULL,
  `idfamily_reference` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idfamily_address`, `idfamily_reference`),
  INDEX `fk_family_address_has_family_reference_family_reference1_idx` (`idfamily_reference` ASC),
  INDEX `fk_family_address_has_family_reference_family_address1_idx` (`idfamily_address` ASC),
  CONSTRAINT `fk_family_address_has_family_reference_family_address1`
    FOREIGN KEY (`idfamily_address`)
    REFERENCES `asadb`.`family_address` (`idfamily_address`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_family_address_has_family_reference_family_reference1`
    FOREIGN KEY (`idfamily_reference`)
    REFERENCES `asadb`.`family_reference` (`idfamily_reference`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`family_expenses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`family_expenses` (
  `idfamily_expenses` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `status` TINYINT(1) UNSIGNED NOT NULL,
  PRIMARY KEY (`idfamily_expenses`),
  UNIQUE INDEX `idfamily_expenses_UNIQUE` (`idfamily_expenses` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`family_reference_has_family_expenses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`family_reference_has_family_expenses` (
  `idfamily_reference` INT UNSIGNED NOT NULL,
  `idfamily_expenses` INT UNSIGNED NOT NULL,
  `type_expenses` TINYINT(1) UNSIGNED NOT NULL,
  `value_expenses` DECIMAL(7,2) UNSIGNED NOT NULL,
  PRIMARY KEY (`idfamily_reference`, `idfamily_expenses`),
  INDEX `fk_family_reference_has_family_expenses_family_expenses1_idx` (`idfamily_expenses` ASC),
  INDEX `fk_family_reference_has_family_expenses_family_reference1_idx` (`idfamily_reference` ASC),
  CONSTRAINT `fk_family_reference_has_family_expenses_family_reference1`
    FOREIGN KEY (`idfamily_reference`)
    REFERENCES `asadb`.`family_reference` (`idfamily_reference`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_family_reference_has_family_expenses_family_expenses1`
    FOREIGN KEY (`idfamily_expenses`)
    REFERENCES `asadb`.`family_expenses` (`idfamily_expenses`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`answers_family`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`answers_family` (
  `idanswers_family` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `form` TINYINT UNSIGNED NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `value` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`idanswers_family`),
  UNIQUE INDEX `idanswers_forms_UNIQUE` (`idanswers_family` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`answers_household`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`answers_household` (
  `idanswers_household` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `form` TINYINT UNSIGNED NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `value` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`idanswers_household`),
  UNIQUE INDEX `idanswers_household_UNIQUE` (`idanswers_household` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`household_has_answers_household`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`household_has_answers_household` (
  `idhousehold` INT UNSIGNED NOT NULL,
  `idanswers_household` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idhousehold`, `idanswers_household`),
  INDEX `fk_household_has_answers_household_answers_household1_idx` (`idanswers_household` ASC),
  INDEX `fk_household_has_answers_household_household1_idx` (`idhousehold` ASC),
  CONSTRAINT `fk_household_has_answers_household_household1`
    FOREIGN KEY (`idhousehold`)
    REFERENCES `asadb`.`household` (`idhousehold`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_household_has_answers_household_answers_household1`
    FOREIGN KEY (`idanswers_household`)
    REFERENCES `asadb`.`answers_household` (`idanswers_household`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`single_registry_identification_has_answers_family`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`single_registry_identification_has_answers_family` (
  `idsingle_registry_identification` INT UNSIGNED NOT NULL,
  `idanswers_family` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idsingle_registry_identification`, `idanswers_family`),
  INDEX `fk_single_registry_identification_has_answers_family_answer_idx` (`idanswers_family` ASC),
  INDEX `fk_single_registry_identification_has_answers_family_single_idx` (`idsingle_registry_identification` ASC),
  CONSTRAINT `fk_single_registry_identification_has_answers_family_single_r1`
    FOREIGN KEY (`idsingle_registry_identification`)
    REFERENCES `asadb`.`single_registry_identification` (`idsingle_registry_identification`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_single_registry_identification_has_answers_family_answers_1`
    FOREIGN KEY (`idanswers_family`)
    REFERENCES `asadb`.`answers_family` (`idanswers_family`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`authentication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`authentication` (
  `token` VARCHAR(36) NOT NULL,
  `iduser` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`token`),
  UNIQUE INDEX `token_UNIQUE` (`token` ASC),
  INDEX `fk_authentication_users1_idx` (`iduser` ASC),
  CONSTRAINT `fk_authentication_users1`
    FOREIGN KEY (`iduser`)
    REFERENCES `asadb`.`users` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;