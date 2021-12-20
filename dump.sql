-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: bookkeeping
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `organizatsiya_recipient`
--

DROP TABLE IF EXISTS `organizatsiya_recipient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organizatsiya_recipient` (
  `id_recipient` int NOT NULL,
  `name_recipient` varchar(25) NOT NULL,
  `city_recipient` varchar(25) NOT NULL,
  `street_recipient` varchar(25) NOT NULL,
  `type_organization` varchar(25) NOT NULL,
  PRIMARY KEY (`id_recipient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizatsiya_recipient`
--

LOCK TABLES `organizatsiya_recipient` WRITE;
/*!40000 ALTER TABLE `organizatsiya_recipient` DISABLE KEYS */;
INSERT INTO `organizatsiya_recipient` VALUES (345,'ПРОТЕК','Москва','Чермянская 9а','Коммерческая'),(456,'Тортуга','Пенза','Суворова 10','Коммерческая'),(543,'Сервис-Торг','Пенза','Гладкова 12','Коммерческая');
/*!40000 ALTER TABLE `organizatsiya_recipient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transfers`
--

DROP TABLE IF EXISTS `transfers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transfers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_transfer` int DEFAULT NULL,
  `date_transfer` varchar(25) DEFAULT NULL,
  `transfer_type` varchar(25) DEFAULT NULL,
  `sum_transfer` int DEFAULT NULL,
  `id_recipient` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_recipient` (`id_recipient`),
  CONSTRAINT `transfers_ibfk_1` FOREIGN KEY (`id_recipient`) REFERENCES `organizatsiya_recipient` (`id_recipient`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfers`
--

LOCK TABLES `transfers` WRITE;
/*!40000 ALTER TABLE `transfers` DISABLE KEYS */;
INSERT INTO `transfers` VALUES (1,16332,'2021-12-16','Электронный перевод',334,456),(2,51503,'2021-12-16','Электронный перевод',23233,456),(3,19456,'2021-12-16','Электронный перевод',6543,456),(4,18029,'2021-12-16','Почтовый перевод',44444,543),(5,71380,'2021-12-16','Электронный перевод',12222,456),(6,35686,'2021-12-16','Банковский перевод',1000000000,543),(7,55978,'2021-12-17','Электронный перевод',18999,456),(8,106871,'2021-12-17','Банковский перевод',10000,345);
/*!40000 ALTER TABLE `transfers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `idUser` int NOT NULL AUTO_INCREMENT,
  `login` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Катя','123'),(4,'Настя','123');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-21  0:24:44
