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
-- Dumping data for table `budget`
--

LOCK TABLES `budget` WRITE;
/*!40000 ALTER TABLE `budget` DISABLE KEYS */;
INSERT INTO `budget` VALUES (1,60.00,615.00,675.00,'2021-11-06',2,1,3),(2,70.00,325.50,395.50,'2021-11-16',1,3,2),(3,80.00,546.45,626.45,'2021-11-26',3,5,5),(4,110.00,489.84,599.84,'2021-12-06',4,7,4),(5,235.00,849.84,1084.84,'2021-12-16',5,8,1);
/*!40000 ALTER TABLE `budget` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `budget_details`
--

LOCK TABLES `budget_details` WRITE;
/*!40000 ALTER TABLE `budget_details` DISABLE KEYS */;
INSERT INTO `budget_details` VALUES (1,150.00,4,600.00,1,9),(2,15.00,1,15.00,1,10),(3,151.61,1,151.61,2,4),(4,39.50,1,39.50,2,6),(5,134.39,1,134.39,2,7),(6,534.12,1,534.12,3,5),(7,12.33,1,12.33,3,11),(8,314.84,1,314.84,4,2),(9,150.00,1,150.00,4,9),(10,25.00,1,25.00,4,12),(11,314.84,1,314.84,5,2),(12,535.00,1,535.00,5,13);
/*!40000 ALTER TABLE `budget_details` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'063.862.116-00','Kauê Anthony Cauã Cavalcanti','Rua Acer','827','Centro da Serra','ES','Serra','29179-415','(27) 99899-3109','','kaueanthonycauacavalcanti__kaueanthonycauacavalcanti@revati.com.br'),(2,'372.265.475-03','Francisca Louise Assis','Quadra Quadra 2 Comércio Local 18','660','Sobradinho','DF','Brasília','73016-145','(61) 98722-0250','','franciscalouiseassis..franciscalouiseassis@biconsult.com.br'),(3,'958.178.428-40','Breno Thomas Drumond','Beco Aguiar','348','São José','RJ','Belford Roxo','26193-584','(21) 99118-5285','','brenothomasdrumond_@usa.com'),(4,'633.728.004-00','Henrique Calebe Diego Rodrigues','Alameda Ana Maria Muniz','942','Popular Nova','MS','Corumbá','79321-050','(67) 98119-9452','','henriquecalebediegorodrigues__henriquecalebediegorodrigues@domain.com.br'),(5,'333.522.085-49','Lara Alessandra Tânia Almada','Rua Marly Félix do Nascimento','676','Mangabeira','PB','João Pessoa','58056-575','(83) 99675-8430','','laraalessandrataniaalmada__laraalessandrataniaalmada@agenziamarketing.com.br');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Esther Isabelly Mirella Nunes',NULL,'eestherisabellymirellanunes@tricoproducts.com.br','470.609.975-71','(51) 98568-2434','(51) 3501-6786','90810-464','Rua Ilha',556,'Santa Tereza','Porto Alegre','RS','ATIVO','admin','admin','ADMINISTRADOR',NULL,1);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `privileges`
--

LOCK TABLES `privileges` WRITE;
/*!40000 ALTER TABLE `privileges` DISABLE KEYS */;
INSERT INTO `privileges` VALUES (1,'Super Administrator',1);
/*!40000 ALTER TABLE `privileges` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Farol Milha 16 Led 48w',NULL,'Iluminação',200.50,NULL,NULL,2),(2,'Pneu Firestone F-series',NULL,'Pneus',314.84,NULL,NULL,1),(3,'Som Automotivo Pioneer Mvh S218bt',NULL,'Som Automotivo',380.00,NULL,NULL,3),(4,'Kit Capa Couro Banco Carro Tapete Volante Chvrolet',NULL,'Aces. de Carros e Caminhonetes',151.61,NULL,NULL,5),(5,'Kit Alavanca De Câmbio Montana Ágile 10 Á 13 (original)',NULL,'Transmissão',534.12,NULL,NULL,4),(6,'Filtro Ar Condicionado Cabine Para Carro Original Bosch',NULL,'Filtros Automotivos',39.50,NULL,NULL,4),(7,'Bateria Automotiva 50/60 Amperes Kf',NULL,'Baterias de Carro',134.39,NULL,NULL,1),(8,'Jogo De Velas Fox Gol G4 G5 G6 Voyage 1.0 1.6 8v Flex Sp30',NULL,'Peças de Carros e Caminhonetes',69.15,NULL,NULL,3),(9,'Pastilhas Freio Disco Freio Lonas Gol G2 G3 G4 Sist. Varga',NULL,'Freios',150.00,NULL,NULL,5),(10,'Par Palheta Limpador Parabrisa Original Skywind',NULL,'Peças de Exterior',15.00,NULL,NULL,2),(11,'Cartela De Adesivos Moto Motocross Carro Bike Caminhao 16',NULL,'Tuning',12.33,NULL,NULL,4),(12,'Capa Chave Canivete Vw Silicone Novo Golf Mk7 Tcross Nivus',NULL,'Alarmes e Acessórios',25.00,NULL,NULL,5),(13,'Placa De Fusíveis Bateria',NULL,'Modulos de Fusiveis',535.00,NULL,NULL,5);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `providers`
--

LOCK TABLES `providers` WRITE;
/*!40000 ALTER TABLE `providers` DISABLE KEYS */;
INSERT INTO `providers` VALUES (1,'Otávio e Adriana Vidros Ltda','60.029.254/0001-64','(14) 98910-1027','','16402-291','Rua Antônio Samora','867','Jardim Tangará','Lins','SP',''),(2,'Lucca e Carolina Limpeza Ltda','93.825.788/0001-56','(68) 99605-8626','','69920-187','Travessa Café','186','Distrito Industrial','Rio Branco','AC',''),(3,'Enrico e Benedito Telas ME','18.374.787/0001-17','(82) 98506-1430','','57307-700','Rua José Sabino Sampaio','167','Jardim Esperança','Arapiraca','AL',''),(4,'Ryan e Evelyn Gráfica Ltda','11.475.148/0001-07','(96) 98715-4778','','68909-546','Avenida Alvaro Carvalho Barbosa','994','Boné Azul','Macapá','AP',''),(5,'Sophia e Bernardo Eletrônica Ltda','43.184.699/0001-08','(92) 99641-4984','','69400-410','Rua Coronel Salgado','152','São Francisco','Manacapuru','AM','');
/*!40000 ALTER TABLE `providers` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'Reparos Automóveis',NULL),(2,'Troca de Óleo',NULL),(3,'Revenda de Produtos',NULL),(4,'Reparos Automoveis',NULL),(5,'Alinhamento e Balaceamento',NULL),(6,'Freios',NULL),(7,'Suspensão',NULL),(8,'Injeção Eletrônica',NULL),(9,'Sistema Elétrico',NULL);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Dumping data for table `vehicles`
--

LOCK TABLES `vehicles` WRITE;
/*!40000 ALTER TABLE `vehicles` DISABLE KEYS */;
INSERT INTO `vehicles` VALUES (1,'Tempra HLX 2.0 16V 4p','Fiat','MXW-8161',1996,'Marrom','Gasolina',50000,2),(2,'Deville/Eldorado 4.9','Cadillac','MNW-0233',1991,'Branco','Diesel',25000,3),(3,'A3 1.8 5p Aut.','Audi','HVP-2348',1997,'Marrom','Elétrico',100000,5),(4,'XJ-8 Executive/ Centenary 4.0','Jaguar','NER-3848',1998,'Vermelho','Flex',12500,4),(5,'T-4 4x4 3.2 TGV tdi Cap. R','Troller','GKX-6825',2013,'Preto','Etanol',75250,1);
/*!40000 ALTER TABLE `vehicles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-28 18:53:15
