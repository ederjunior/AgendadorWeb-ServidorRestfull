CREATE DATABASE  IF NOT EXISTS `agendadorweb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `agendadorweb`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: agendadorweb
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agenda` (
  `id_a` int(11) NOT NULL AUTO_INCREMENT,
  `dataHora_a` datetime NOT NULL,
  `status_a` varchar(20) NOT NULL,
  `ventilador_a` varchar(20) NOT NULL,
  `luz_sala_a` varchar(20) NOT NULL,
  `tv_a` varchar(20) NOT NULL,
  `luz_quarto_a` varchar(20) NOT NULL,
  PRIMARY KEY (`id_a`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
INSERT INTO `agenda` VALUES (53,'2017-06-14 21:42:11','Ativo','desligado','desligado','desligado','desligado'),(54,'2017-06-14 21:56:46','Ativo','ligado','ligado','ligado','ligado'),(55,'2017-06-14 21:57:43','Ativo','ligado','ligado','ligado','ligado'),(56,'2017-06-14 22:00:56','Ativo','ligado','ligado','ligado','ligado'),(57,'2017-06-14 22:01:06','Ativo','desligado','desligado','desligado','desligado'),(58,'2017-06-14 22:04:48','Ativo','ligado','ligado','ligado','ligado'),(59,'2017-06-19 19:29:31','Desativado','ligado','ligado','ligado','ligado'),(60,'2017-06-21 20:17:08','Ativo','desligado','desligado','desligado','desligado');
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-21  0:29:44
