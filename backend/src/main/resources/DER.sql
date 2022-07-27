-- MySQL Script generated by MySQL Workbench
-- Mon Nov 16 22:37:21 2020
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
-- Table `asadb`.`profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`profile` (
  `id` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `iduser_profile_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`user` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fullname` VARCHAR(45) NOT NULL,
  `cpf` CHAR(11) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `status` TINYINT(1) UNSIGNED NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `profile_id` TINYINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC),
  UNIQUE INDEX `iduser_UNIQUE` (`id` ASC),
  INDEX `fk_user_profile1_idx` (`profile_id` ASC),
  CONSTRAINT `fk_user_profile1`
    FOREIGN KEY (`profile_id`)
    REFERENCES `asadb`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`department` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `iddepartments_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`subdepartment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`subdepartment` (
  `id` TINYINT(1) UNSIGNED NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  `department_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idsubdepartments_UNIQUE` (`id` ASC),
  INDEX `fk_subdepartment_department1_idx` (`department_id` ASC),
  CONSTRAINT `fk_subdepartment_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `asadb`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`contact` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `primary_phone_type` TINYINT(1) UNSIGNED NOT NULL,
  `secondary_phone_type` TINYINT(1) UNSIGNED NOT NULL,
  `email_type` TINYINT(1) UNSIGNED NOT NULL,
  `newsletter` TINYINT(1) UNSIGNED NOT NULL,
  `message_confirmation` TINYINT(1) UNSIGNED NOT NULL,
  `primary_phone` CHAR(15) NULL,
  `secondary_phone` CHAR(15) NULL,
  `email` VARCHAR(50) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idcontact_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`family`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`family` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `register_date` DATE NOT NULL,
  `family_gross_salary` DECIMAL(7,2) NULL,
  `per_capita_income` DECIMAL(7,2) NULL,
  `helthcare_center` VARCHAR(45) NULL,
  `food_insecurity_situation` TINYINT(1) UNSIGNED NULL,
  `ethnicity` VARCHAR(45) NULL,
  `community` VARCHAR(45) NULL,
  `indian_village` VARCHAR(45) NULL,
  `hospitalized_person` TINYINT(2) UNSIGNED NULL,
  `family_code` CHAR(11) NULL,
  `child_labour` TINYINT(1) UNSIGNED NULL,
  `update_date` DATE NULL,
  `observation` NVARCHAR(1000) NULL,
  `contact_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idpersonal_information_reference_UNIQUE` (`id` ASC),
  INDEX `fk_family_contact1_idx` (`contact_id` ASC),
  UNIQUE INDEX `family_code_UNIQUE` (`family_code` ASC),
  CONSTRAINT `fk_family_contact1`
    FOREIGN KEY (`contact_id`)
    REFERENCES `asadb`.`contact` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`property_characteristic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`property_characteristic` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `property_situation` TINYINT(1) UNSIGNED NOT NULL,
  `electricity` TINYINT(1) UNSIGNED NOT NULL,
  `water_supply` TINYINT(1) UNSIGNED NOT NULL,
  `building_characteristic` TINYINT(1) UNSIGNED NULL,
  `electricity_price` DECIMAL(6,2) NULL,
  `water_supply_price` DECIMAL(6,2) NULL,
  `risk_area_flood` TINYINT(1) UNSIGNED NULL,
  `property_observation` VARCHAR(150) NULL,
  `building_observation` VARCHAR(150) NULL,
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
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idresidence_characteristic_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`address` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
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
  `property_characteristic_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idfamily_address_UNIQUE` (`id` ASC),
  INDEX `fk_address_property_characteristic1_idx` (`property_characteristic_id` ASC),
  CONSTRAINT `fk_address_property_characteristic1`
    FOREIGN KEY (`property_characteristic_id`)
    REFERENCES `asadb`.`property_characteristic` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`work_information`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`work_information` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idwork_information_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`filiation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`filiation` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fullname_mother` VARCHAR(80) NULL,
  `fullname_father` VARCHAR(80) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idfiliation_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`place_of_birth`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`place_of_birth` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `registry_office` TINYINT(1) UNSIGNED NOT NULL,
  `hometown` VARCHAR(45) NULL,
  `home_state` VARCHAR(45) NULL,
  `foreign_country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idplace_of_birth_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`identity_card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`identity_card` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(16) NULL,
  `complement` CHAR(5) NULL,
  `issuing_date` DATE NULL,
  `issuing_state` VARCHAR(30) NULL,
  `issuing_state_initial` CHAR(8) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ididentity_card_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`work_card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`work_card` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `number` CHAR(7) NULL,
  `serie` CHAR(5) NULL,
  `issuing_date` DATE NULL,
  `issuing_state` VARCHAR(30) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idwork_permit_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`electoral_card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`electoral_card` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `number` CHAR(12) NULL,
  `electoral_ward` CHAR(4) NULL,
  `electoral_office` CHAR(4) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idelectoral_card_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`public_civil_registry`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`public_civil_registry` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `certificate_type` TINYINT(1) UNSIGNED NOT NULL,
  `registry_office` VARCHAR(45) NULL,
  `register_date` DATE NULL,
  `number_book` INT(8) UNSIGNED ZEROFILL NULL,
  `entry_sheet` SMALLINT(4) UNSIGNED ZEROFILL NULL,
  `rani` INT(8) UNSIGNED ZEROFILL NULL,
  `registration` VARCHAR(32) NULL,
  `register_state` VARCHAR(45) NULL,
  `register_town` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idpublic_civil_registry_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`civil_documentation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`civil_documentation` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `marital_status` TINYINT(1) UNSIGNED NOT NULL,
  `cpf` CHAR(11) NULL,
  `nis` CHAR(11) NULL,
  `senior_card` TINYINT(1) UNSIGNED NULL,
  `young_card` TINYINT(1) UNSIGNED NULL,
  `filiation_id` INT UNSIGNED NOT NULL,
  `place_of_birth_id` INT UNSIGNED NOT NULL,
  `identity_card_id` INT UNSIGNED NOT NULL,
  `work_card_id` INT UNSIGNED NOT NULL,
  `electoral_card_id` INT UNSIGNED NOT NULL,
  `public_civil_registry_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idcivil_documentation_UNIQUE` (`id` ASC),
  UNIQUE INDEX `nis_UNIQUE` (`nis` ASC),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC),
  INDEX `fk_civil_documentation_filiation1_idx` (`filiation_id` ASC),
  INDEX `fk_civil_documentation_place_of_birth1_idx` (`place_of_birth_id` ASC),
  INDEX `fk_civil_documentation_identity_card1_idx` (`identity_card_id` ASC),
  INDEX `fk_civil_documentation_work_card1_idx` (`work_card_id` ASC),
  INDEX `fk_civil_documentation_electoral_card1_idx` (`electoral_card_id` ASC),
  INDEX `fk_civil_documentation_public_civil_registry1_idx` (`public_civil_registry_id` ASC),
  CONSTRAINT `fk_civil_documentation_filiation1`
    FOREIGN KEY (`filiation_id`)
    REFERENCES `asadb`.`filiation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_civil_documentation_place_of_birth1`
    FOREIGN KEY (`place_of_birth_id`)
    REFERENCES `asadb`.`place_of_birth` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_civil_documentation_identity_card1`
    FOREIGN KEY (`identity_card_id`)
    REFERENCES `asadb`.`identity_card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_civil_documentation_work_card1`
    FOREIGN KEY (`work_card_id`)
    REFERENCES `asadb`.`work_card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_civil_documentation_electoral_card1`
    FOREIGN KEY (`electoral_card_id`)
    REFERENCES `asadb`.`electoral_card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_civil_documentation_public_civil_registry1`
    FOREIGN KEY (`public_civil_registry_id`)
    REFERENCES `asadb`.`public_civil_registry` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`school_information`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`school_information` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `town` VARCHAR(45) NOT NULL,
  `code_inep` INT(8) UNSIGNED NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idschool_address_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`educational_information`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`educational_information` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `alphabetization` TINYINT(1) UNSIGNED NOT NULL,
  `student` TINYINT(1) UNSIGNED NOT NULL,
  `register_date` DATE NOT NULL,
  `educational_level` TINYINT(2) UNSIGNED NULL,
  `course_enroll` TINYINT(2) UNSIGNED NULL,
  `course_enroll_serie` TINYINT(1) UNSIGNED NULL,
  `pronatec` TINYINT(1) UNSIGNED NULL,
  `update_date` DATE NULL,
  `observation` VARCHAR(150) NULL,
  `school_information_id` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ideducational_information_UNIQUE` (`id` ASC),
  INDEX `fk_educational_information_school_information1_idx` (`school_information_id` ASC),
  CONSTRAINT `fk_educational_information_school_information1`
    FOREIGN KEY (`school_information_id`)
    REFERENCES `asadb`.`school_information` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`health_condition`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`health_condition` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `register_date` DATE NOT NULL,
  `reference_care` VARCHAR(45) NULL,
  `serious_illness` VARCHAR(45) NULL,
  `prescription_medication` VARCHAR(45) NULL,
  `alcoholic` VARCHAR(45) NULL,
  `drug_addict` VARCHAR(45) NULL,
  `pregnancy` TINYINT(1) UNSIGNED NULL,
  `antenatal_visit` TINYINT(1) UNSIGNED NULL,
  `contraceptive_method` VARCHAR(45) NULL,
  `chronic_disease` VARCHAR(45) NULL,
  `free_pass` TINYINT(1) UNSIGNED NULL,
  `observation` VARCHAR(150) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idhealth_condition_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`remuneration`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`remuneration` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` TINYINT(2) UNSIGNED NOT NULL,
  `gross_salary` DECIMAL(7,2) NOT NULL,
  `gross_salary_period` DECIMAL(7,2) NULL,
  `continuous_cash_benefit` TINYINT(1) UNSIGNED NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idremuneration_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`household`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`household` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fullname` VARCHAR(80) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `genre` VARCHAR(25) NOT NULL,
  `family_reference_interaction` TINYINT(2) UNSIGNED NOT NULL,
  `register_date` DATE NOT NULL,
  `age` TINYINT(3) UNSIGNED NULL,
  `nickname` VARCHAR(30) NULL,
  `race` TINYINT(1) UNSIGNED NULL,
  `update_date` DATE NULL,
  `work_information_id` INT UNSIGNED NOT NULL,
  `civil_documentation_id` INT UNSIGNED NOT NULL,
  `educational_information_id` INT UNSIGNED NOT NULL,
  `health_condition_id` INT UNSIGNED NOT NULL,
  `remuneration_id` INT UNSIGNED NOT NULL,
  `family_id` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idhousehold_UNIQUE` (`id` ASC),
  INDEX `fk_household_work_information1_idx` (`work_information_id` ASC),
  INDEX `fk_household_civil_documentation1_idx` (`civil_documentation_id` ASC),
  INDEX `fk_household_educational_information1_idx` (`educational_information_id` ASC),
  INDEX `fk_household_health_condition1_idx` (`health_condition_id` ASC),
  INDEX `fk_household_remuneration1_idx` (`remuneration_id` ASC),
  INDEX `fk_household_family1_idx` (`family_id` ASC),
  CONSTRAINT `fk_household_work_information1`
    FOREIGN KEY (`work_information_id`)
    REFERENCES `asadb`.`work_information` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_household_civil_documentation1`
    FOREIGN KEY (`civil_documentation_id`)
    REFERENCES `asadb`.`civil_documentation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_household_educational_information1`
    FOREIGN KEY (`educational_information_id`)
    REFERENCES `asadb`.`educational_information` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_household_health_condition1`
    FOREIGN KEY (`health_condition_id`)
    REFERENCES `asadb`.`health_condition` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_household_remuneration1`
    FOREIGN KEY (`remuneration_id`)
    REFERENCES `asadb`.`remuneration` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_household_family1`
    FOREIGN KEY (`family_id`)
    REFERENCES `asadb`.`family` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`single_registry_identification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`single_registry_identification` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `interview_date` DATE NOT NULL,
  `operation_type` TINYINT(1) UNSIGNED NULL,
  `interview_type` TINYINT(1) UNSIGNED NULL,
  `form_type` TINYINT(1) UNSIGNED NULL,
  `description` VARCHAR(45) NULL,
  `observation` VARCHAR(150) NULL,
  `family_id` INT UNSIGNED NOT NULL,
  `user_id` INT UNSIGNED NOT NULL,
  `subdepartment_id` TINYINT(1) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idsingle_registry_identification_UNIQUE` (`id` ASC),
  INDEX `fk_single_registry_identification_family1_idx` (`family_id` ASC),
  INDEX `fk_single_registry_identification_user1_idx` (`user_id` ASC),
  INDEX `fk_single_registry_identification_subdepartment1_idx` (`subdepartment_id` ASC),
  CONSTRAINT `fk_single_registry_identification_family1`
    FOREIGN KEY (`family_id`)
    REFERENCES `asadb`.`family` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_single_registry_identification_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `asadb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_single_registry_identification_subdepartment1`
    FOREIGN KEY (`subdepartment_id`)
    REFERENCES `asadb`.`subdepartment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`social_program`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`social_program` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `receive_benefit` TINYINT(1) UNSIGNED NOT NULL,
  `family_gross_salary` DECIMAL(7,2) NULL,
  `per_capita_income` DECIMAL(7,2) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idsocial_programs_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`expense`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`expense` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `status` TINYINT(1) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idfamily_expenses_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`family_answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`family_answer` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `register_date` DATE NOT NULL,
  `form_name` VARCHAR(45) NOT NULL,
  `json` NVARCHAR(1000) NOT NULL,
  `family_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idanswers_forms_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`household_answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`household_answer` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `register_date` DATE NOT NULL,
  `form_name` VARCHAR(45) NOT NULL,
  `json` NVARCHAR(1000) NOT NULL,
  `household_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idanswers_household_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`authentication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`authentication` (
  `token` VARCHAR(36) NOT NULL,
  `user_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`token`),
  UNIQUE INDEX `token_UNIQUE` (`token` ASC),
  INDEX `fk_authentication_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_authentication_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `asadb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`family_has_social_program`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`family_has_social_program` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `program_type` TINYINT(1) UNSIGNED NULL,
  `amount_received` DECIMAL(7,2) NULL,
  `family_id` INT UNSIGNED NOT NULL,
  `social_program_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_family_has_social_program_social_program1_idx` (`social_program_id` ASC),
  INDEX `fk_family_has_social_program_family1_idx` (`family_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_family_has_social_program_family1`
    FOREIGN KEY (`family_id`)
    REFERENCES `asadb`.`family` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_family_has_social_program_social_program1`
    FOREIGN KEY (`social_program_id`)
    REFERENCES `asadb`.`social_program` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`household_has_remuneration`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`household_has_remuneration` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `remuneration_type` TINYINT(1) UNSIGNED NULL,
  `amount_received` DECIMAL(7,2) NULL,
  `household_id` INT UNSIGNED NOT NULL,
  `remuneration_id` INT UNSIGNED NOT NULL,
  INDEX `fk_household_has_remuneration_remuneration1_idx` (`remuneration_id` ASC),
  INDEX `fk_household_has_remuneration_household1_idx` (`household_id` ASC),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_household_has_remuneration_household1`
    FOREIGN KEY (`household_id`)
    REFERENCES `asadb`.`household` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_household_has_remuneration_remuneration1`
    FOREIGN KEY (`remuneration_id`)
    REFERENCES `asadb`.`remuneration` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`family_has_expense`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`family_has_expense` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `expense_type` TINYINT(1) UNSIGNED NULL,
  `amount_spent` DECIMAL(7,2) NULL,
  `family_id` INT UNSIGNED NOT NULL,
  `expense_id` INT UNSIGNED NOT NULL,
  INDEX `fk_family_has_expense_expense1_idx` (`expense_id` ASC),
  INDEX `fk_family_has_expense_family1_idx` (`family_id` ASC),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_family_has_expense_family1`
    FOREIGN KEY (`family_id`)
    REFERENCES `asadb`.`family` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_family_has_expense_expense1`
    FOREIGN KEY (`expense_id`)
    REFERENCES `asadb`.`expense` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`family_has_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`family_has_address` (
  `family_id` INT UNSIGNED NOT NULL,
  `address_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`family_id`, `address_id`),
  INDEX `fk_family_has_address_address1_idx` (`address_id` ASC),
  INDEX `fk_family_has_address_family1_idx` (`family_id` ASC),
  CONSTRAINT `fk_family_has_address_family1`
    FOREIGN KEY (`family_id`)
    REFERENCES `asadb`.`family` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_family_has_address_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `asadb`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`disability`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`disability` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` TINYINT(1) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `type_UNIQUE` (`type` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asadb`.`health_condition_has_disability`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asadb`.`health_condition_has_disability` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `constant_care` TINYINT(1) UNSIGNED NULL,
  `health_condition_id` INT UNSIGNED NOT NULL,
  `disability_id` INT UNSIGNED NOT NULL,
  INDEX `fk_health_condition_has_disability_disability1_idx` (`disability_id` ASC),
  INDEX `fk_health_condition_has_disability_health_condition1_idx` (`health_condition_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_health_condition_has_disability_health_condition1`
    FOREIGN KEY (`health_condition_id`)
    REFERENCES `asadb`.`health_condition` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_health_condition_has_disability_disability1`
    FOREIGN KEY (`disability_id`)
    REFERENCES `asadb`.`disability` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
