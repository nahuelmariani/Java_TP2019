-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: java_club
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `actividad` (
  `id_actividad` int(11) NOT NULL,
  `nom_actividad` varchar(45) DEFAULT NULL,
  `desc_actividad` varchar(45) DEFAULT NULL,
  `cupo` int(11) DEFAULT NULL,
  `importe_adicional` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_actividad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES (2,'Natacion','Libre',5,'200'),(3,'Futbol 5','Amateur',5,'300'),(4,'Gimnasio','Maquinas',10,'320'),(5,'Running','Grupal',15,'550');
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `inscripcion` (
  `id_actividad` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `fecha_inscripcion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_actividad`,`id_usuario`),
  KEY `id_usuario_fk_idx` (`id_usuario`),
  CONSTRAINT `id_actividad_fk` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`),
  CONSTRAINT `id_usuario_fk` FOREIGN KEY (`id_usuario`) REFERENCES `persona` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
INSERT INTO `inscripcion` VALUES (4,3,'2019-12-11 03:07:51');
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instalacion`
--

DROP TABLE IF EXISTS `instalacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `instalacion` (
  `id_instalacion` int(11) NOT NULL AUTO_INCREMENT,
  `nom_instalacion` varchar(45) DEFAULT NULL,
  `desc_instalacion` varchar(45) DEFAULT NULL,
  `importe` float DEFAULT NULL,
  PRIMARY KEY (`id_instalacion`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instalacion`
--

LOCK TABLES `instalacion` WRITE;
/*!40000 ALTER TABLE `instalacion` DISABLE KEYS */;
INSERT INTO `instalacion` VALUES (5,'Cancha de Fútbol 5','Techada, césped sintético.',350),(6,'Cancha de Tenis','Polvo de ladrillo.',199.99),(7,'Quincho ','Capacidad para 200 personas.',450),(10,'Cancha de Basquet','Techada, piso parqué.',574.99);
/*!40000 ALTER TABLE `instalacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellido` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tipo_doc` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nro_doc` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tel` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `habilitado` tinyint(4) DEFAULT NULL,
  `rol` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Nahuel','Mariani','DNI','35642102','admin@admin','admin','3464513125',1,'Administrador'),(2,'Julieta','Steckinger','DNI','35642101','empleado@empleado','empleado','3464513126',1,'Empleado'),(3,'Ayelen','Demaria','DNI','35642100','socio@socio','socio','3464513127',1,'Socio'),(19,'Pedro','Rodriguez','DNI','35642103','000@000','000','0000',1,'Empleado'),(20,'Pablo','Gonzalez','LE','35642104','111@111','111','1111',0,'Administrador'),(21,'Jose','Martinez','DNI','35642105','222@222','222','2222',1,'Socio'),(22,'Maria','Perez','DNI','35642106','333@333','333','3333',1,'Socio'),(23,'Julia','Dominguez','LE','35642107','444@444','444','4444',1,'Socio'),(24,'Marta','Papa','LE','3564108','555@555','555','5555',1,'Socio');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reserva` (
  `id_reserva` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_reserva` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_hora_desde` datetime NOT NULL,
  `fecha_hora_hasta` datetime NOT NULL,
  `fecha_cancelacion` datetime DEFAULT NULL,
  `id_instalacion` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_reserva`),
  KEY `id_Instalacion _idx` (`id_instalacion`),
  KEY `id_usuario_idx` (`id_usuario`),
  CONSTRAINT `id_Instalacion ` FOREIGN KEY (`id_instalacion`) REFERENCES `instalacion` (`id_instalacion`),
  CONSTRAINT `id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,'2019-11-19 16:05:53','2019-01-01 00:00:00','2019-01-01 00:00:00','2019-12-10 00:58:04',6,3),(2,'2019-11-19 16:25:42','2019-03-02 00:00:00','2019-03-02 00:00:00','2019-12-10 00:53:20',7,3),(3,'2019-11-19 16:28:59','2019-03-02 00:00:00','2019-03-02 00:00:00',NULL,10,3),(4,'2019-11-19 16:34:45','2019-03-02 18:15:18','2019-03-02 18:15:18',NULL,5,3),(5,'2019-11-26 15:33:35','2019-03-02 18:15:18','2019-03-02 18:18:18','2019-12-10 04:11:53',5,3),(6,'2019-11-26 15:34:53','2019-03-02 18:15:18','2019-03-02 18:18:18','2019-12-10 00:58:06',5,3),(7,'2019-11-26 17:09:40','2019-03-02 18:15:18','2019-03-02 18:15:18','2019-12-10 00:53:21',7,3),(8,'2019-12-09 12:40:50','2018-05-09 15:12:12','2018-05-09 15:12:12','2019-12-10 01:00:02',6,3),(9,'2019-12-09 12:41:51','2018-05-05 15:12:13','2018-05-05 15:12:13','2019-12-10 01:42:16',7,3),(10,'2019-12-09 22:59:56','2019-09-21 21:32:15','2019-09-21 22:32:15',NULL,6,3),(11,'2019-12-09 23:49:01','2019-01-01 18:00:00','2019-01-01 19:00:00',NULL,7,3),(12,'2019-12-10 00:49:10','2019-01-01 18:00:00','2019-01-01 21:00:00',NULL,5,3),(13,'2019-12-10 00:57:28','2019-01-01 18:00:00','2019-01-01 19:35:00',NULL,5,3),(14,'2019-12-10 01:03:42','2019-10-10 21:30:00','2019-10-10 21:45:00',NULL,5,3),(15,'2019-12-10 01:17:31','2019-10-10 21:30:00','2019-10-10 21:55:00',NULL,6,3),(16,'2019-12-10 01:19:04','2019-10-10 21:30:00','2019-10-10 22:39:00',NULL,5,3),(17,'2019-12-10 02:11:13','2020-01-01 20:18:00','2020-01-02 20:18:00',NULL,5,3);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-11  3:30:16
