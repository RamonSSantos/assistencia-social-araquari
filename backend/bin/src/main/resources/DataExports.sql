-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: asadb
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departments` (
  `iddepartment` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`iddepartment`),
  UNIQUE KEY `iddepartments_UNIQUE` (`iddepartment`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'Gestão da Secretaria'),(2,'Proteção Social Básica'),(3,'Proteção Social Especial');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profiles`
--

DROP TABLE IF EXISTS `profiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profiles` (
  `idprofile` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(25) NOT NULL,
  PRIMARY KEY (`idprofile`),
  UNIQUE KEY `iduser_profile_UNIQUE` (`idprofile`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profiles`
--

LOCK TABLES `profiles` WRITE;
/*!40000 ALTER TABLE `profiles` DISABLE KEYS */;
INSERT INTO `profiles` VALUES (1,'Assistente Social'),(2,'Coordenador'),(3,'Psicólogo'),(4,'Orientador Educacional'),(5,'Entrevistador'),(6,'Administrador');
/*!40000 ALTER TABLE `profiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subdepartments`
--

DROP TABLE IF EXISTS `subdepartments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subdepartments` (
  `idsubdepartment` tinyint(1) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  `iddepartment` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idsubdepartment`),
  UNIQUE KEY `idsubdepartments_UNIQUE` (`idsubdepartment`),
  KEY `fk_subdepartments_departments1_idx` (`iddepartment`),
  CONSTRAINT `fk_subdepartments_departments1` FOREIGN KEY (`iddepartment`) REFERENCES `departments` (`iddepartment`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subdepartments`
--

LOCK TABLES `subdepartments` WRITE;
/*!40000 ALTER TABLE `subdepartments` DISABLE KEYS */;
INSERT INTO `subdepartments` VALUES (1,'Cadastro Único',1),(2,'Serviços de Benefícios Eventuais',1),(3,'Vigilância Socioassistencial',1),(4,'CRAS Esmeralda Conceição Duarte',2),(5,'CRAS Justina Cabral',2),(6,'CREAS Vera Lucia Gomes',3),(7,'Abrigo',3);
/*!40000 ALTER TABLE `subdepartments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `iduser` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fullname` varchar(45) NOT NULL,
  `cpf` bigint(11) unsigned NOT NULL,
  `password` varchar(45) NOT NULL,
  `status` tinyint(1) unsigned NOT NULL,
  `email` varchar(45) NOT NULL,
  `idprofile` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  UNIQUE KEY `iduser_UNIQUE` (`iduser`),
  KEY `fk_users_user_profile_idx` (`idprofile`),
  CONSTRAINT `fk_users_user_profile` FOREIGN KEY (`idprofile`) REFERENCES `profiles` (`idprofile`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'ADM System',12345678912,'ED5A62730D49D6D343CB55BB3C4263C9',1,'adm.asa@gmail.com',6);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'asadb'
--

--
-- Dumping routines for database 'asadb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-28 19:00:39
