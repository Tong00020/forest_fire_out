-- MySQL dump 10.13  Distrib 5.7.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: loja
-- ------------------------------------------------------
-- Server version	5.7.31

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
-- Table structure for table `budget`
--

DROP TABLE IF EXISTS `budget`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budget` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price_services` decimal(10,2) DEFAULT NULL,
  `total_items` decimal(10,2) DEFAULT NULL,
  `total` decimal(10,2) NOT NULL,
  `date` date NOT NULL,
  `vehicles_id` int(11) NOT NULL,
  `services_id` int(11) NOT NULL,
  `clients_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_budget_clients1_idx` (`clients_id`),
  KEY `fk_budget_vehicles1_idx` (`vehicles_id`),
  KEY `fk_budget_services1_idx` (`services_id`),
  CONSTRAINT `fk_budget_clients1` FOREIGN KEY (`clients_id`) REFERENCES `clients` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_budget_services1` FOREIGN KEY (`services_id`) REFERENCES `services` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_budget_vehicles1` FOREIGN KEY (`vehicles_id`) REFERENCES `vehicles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `budget_details`
--

DROP TABLE IF EXISTS `budget_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budget_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` decimal(10,2) NOT NULL,
  `amount` int(10) unsigned NOT NULL DEFAULT '0',
  `subtotal` decimal(10,2) NOT NULL,
  `budget_id` int(11) NOT NULL,
  `products_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_budget_details_budget1_idx` (`budget_id`),
  KEY `fk_budget_details_products1_idx` (`products_id`),
  CONSTRAINT `fk_budget_details_budget1` FOREIGN KEY (`budget_id`) REFERENCES `budget` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_budget_details_products1` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(14) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `address_number` varchar(45) NOT NULL,
  `complement` varchar(255) NOT NULL,
  `state` char(2) NOT NULL,
  `city` varchar(255) NOT NULL,
  `cep` varchar(10) NOT NULL,
  `cell_phone` varchar(15) NOT NULL,
  `fixed_phone` varchar(14) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `cell_phone` varchar(15) NOT NULL,
  `fixed_phone` varchar(14) DEFAULT NULL,
  `cep` varchar(10) NOT NULL,
  `address` varchar(255) NOT NULL,
  `address_number` int(11) NOT NULL,
  `complement` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `state` char(2) NOT NULL,
  `status` varchar(45) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `job_title` varchar(255) DEFAULT NULL,
  `reports_to` int(11) DEFAULT NULL,
  `privileges_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employees_employees1_idx` (`reports_to`),
  KEY `fk_employees_privileges1_idx` (`privileges_id`),
  CONSTRAINT `fk_employees_employees1` FOREIGN KEY (`reports_to`) REFERENCES `employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_employees_privileges1` FOREIGN KEY (`privileges_id`) REFERENCES `privileges` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discount` decimal(10,2) DEFAULT NULL,
  `observation` varchar(45) DEFAULT NULL,
  `payment` varchar(191) DEFAULT NULL,
  `situation` varchar(191) NOT NULL DEFAULT 'Aberto',
  `date` date NOT NULL,
  `employees_id` int(11) NOT NULL,
  `budget_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_orders_employees1_idx` (`employees_id`),
  KEY `fk_orders_budget1_idx` (`budget_id`),
  CONSTRAINT `fk_orders_budget1` FOREIGN KEY (`budget_id`) REFERENCES `budget` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_employees1` FOREIGN KEY (`employees_id`) REFERENCES `employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `privileges`
--

DROP TABLE IF EXISTS `privileges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privileges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `is_superadmin` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `barcode` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `providers_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_products_providers1_idx` (`providers_id`),
  CONSTRAINT `fk_products_providers1` FOREIGN KEY (`providers_id`) REFERENCES `providers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `providers`
--

DROP TABLE IF EXISTS `providers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `providers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `cnpj` varchar(18) NOT NULL,
  `cell_phone` varchar(15) NOT NULL,
  `fixed_phone` varchar(14) DEFAULT NULL,
  `cep` varchar(10) NOT NULL,
  `address` varchar(255) NOT NULL,
  `address_number` varchar(45) NOT NULL,
  `complement` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `state` char(2) NOT NULL,
  `url_site` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(45) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `plate` varchar(45) NOT NULL,
  `year` year(4) NOT NULL,
  `color` varchar(45) NOT NULL,
  `type_fuel` varchar(45) DEFAULT NULL,
  `km_current` double DEFAULT NULL,
  `clients_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vehicles_customers_idx` (`clients_id`),
  CONSTRAINT `fk_vehicles_customers` FOREIGN KEY (`clients_id`) REFERENCES `clients` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-28 18:54:57
