CREATE DATABASE  IF NOT EXISTS `rating_microservice` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rating_microservice`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: rating_microservice
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `rating_description`
--

DROP TABLE IF EXISTS `rating_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating_description` (
  `id` int NOT NULL AUTO_INCREMENT,
  `doctor_name` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `score` int NOT NULL,
  `text` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `uuid` binary(16) DEFAULT NULL,
  `rating_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmhkage8o53tdwthf570etbxy8` (`rating_id`),
  CONSTRAINT `FKmhkage8o53tdwthf570etbxy8` FOREIGN KEY (`rating_id`) REFERENCES `ratings` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating_description`
--

LOCK TABLES `rating_description` WRITE;
/*!40000 ALTER TABLE `rating_description` DISABLE KEYS */;
INSERT INTO `rating_description` VALUES (1,'John Smith','2024-05-08 13:58:05.257141',5,'Kan nemt anbefales!','Livredder',_binary 'ââqï™NÅ<ã2cı\ÎB',1),(2,'John Smith Junior','2024-05-08 14:07:39.245096',1,'Titlen taler for sig selv','Elendig',_binary '1∫˛≥BMJ†w\ @\Ÿ^&F',2),(3,'John Smith Junior','2024-05-08 14:50:48.779510',1,'test2','test1',_binary '\· \∆\n∑iK˜áß˝9/$\»',3),(4,'John Smith Junior','2024-05-08 14:51:21.281597',3,'test opdatering','test opdatering',NULL,4),(5,'John Smith Junior','2024-05-08 14:52:05.648855',3,'test opdatering','test opdatering',NULL,5),(6,'John Smith Junior','2024-05-08 15:13:17.213559',3,'test text opd','test titel opd',_binary '∫–ÜKy°@\Ë¨¸*…Ø,á',6),(7,'John Smith Junior','2024-05-08 15:15:24.735993',3,'test test','test test',_binary '\'¯RàJO)äI.U<\◊A\Â',7),(8,'John Smith Junior','2024-05-08 15:17:57.877930',3,'test test','test test',_binary 'm¯\r\“\ﬂ\0H#ø¢&Bb8 K',8),(9,'John Smith Junior','2024-05-08 15:20:33.414703',4,'Opdateret!!','Opdateret titel',NULL,3),(10,'John Smith Junior','2024-05-08 15:27:45.562444',2,'Igen!','Opdateret igen!',_binary '5t ºk†@Ñ∫\ﬁnõ7ç◊¥',9),(11,'John Smith Junior','2024-05-08 15:30:33.321904',4,'opdateret igen!','Opdateret igen!',_binary '\√^~xT\ÿDÖÑG∂pQE=',10),(12,'John Smith Junior','2024-05-08 15:33:00.020830',3,'test1','test1',_binary '[7-ê\ÎõE›∂*_˘ó&d',11),(13,'John Smith Junior','2024-05-08 15:39:29.927233',3,'test2','test2',_binary '∞xƒ©ÉHHè\„tú<@',12),(14,'John Smith Junior','2024-05-08 15:46:41.990360',1,'Opdateret korrekt','Opdateret titel !',_binary '¢\ÕK\Ï£Oõà´\«\\t∫ô]',3);
/*!40000 ALTER TABLE `rating_description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating_removed`
--

DROP TABLE IF EXISTS `rating_removed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating_removed` (
  `id` int NOT NULL AUTO_INCREMENT,
  `removed_date` datetime(6) DEFAULT NULL,
  `rating_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb9ukm449icvmmuhyonj1lg949` (`rating_id`),
  CONSTRAINT `FKb9ukm449icvmmuhyonj1lg949` FOREIGN KEY (`rating_id`) REFERENCES `ratings` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating_removed`
--

LOCK TABLES `rating_removed` WRITE;
/*!40000 ALTER TABLE `rating_removed` DISABLE KEYS */;
INSERT INTO `rating_removed` VALUES (1,'2024-05-08 14:14:38.724999',2),(2,'2024-05-08 14:51:46.649159',4),(3,'2024-05-08 15:07:35.023384',5),(4,'2024-05-08 15:14:19.697926',6),(5,'2024-05-08 15:17:36.019199',7),(6,'2024-05-08 15:30:09.901903',9),(7,'2024-05-08 15:32:19.531554',10),(8,'2024-05-08 15:32:25.950176',8),(9,'2024-05-08 15:39:16.471199',11),(10,'2024-05-08 15:46:05.180092',12);
/*!40000 ALTER TABLE `rating_removed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ratings`
--

DROP TABLE IF EXISTS `ratings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ratings` (
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ratings`
--

LOCK TABLES `ratings` WRITE;
/*!40000 ALTER TABLE `ratings` DISABLE KEYS */;
INSERT INTO `ratings` VALUES (1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12);
/*!40000 ALTER TABLE `ratings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-09  1:37:56
