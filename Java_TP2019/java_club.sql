-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: java_club
-- ------------------------------------------------------
-- Server version	8.0.13

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
  `id_actividad` int(11) NOT NULL AUTO_INCREMENT,
  `nom_actividad` varchar(45) DEFAULT NULL,
  `desc_actividad` varchar(45) DEFAULT NULL,
  `cupo` int(11) DEFAULT NULL,
  `importe_adicional` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_actividad`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES (2,'Natacion','Libre',3,'200'),(3,'Futbol 5','Amateur',5,'300'),(4,'Gimnasio','Maquinas',10,'320'),(5,'Running','Grupal',15,'550'),(6,'Voley','Femenino',20,'490.0'),(7,'Hockey','grupos reducidos',23,'500.0');
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuota`
--

DROP TABLE IF EXISTS `cuota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cuota` (
  `idcuota` int(11) NOT NULL AUTO_INCREMENT,
  `mes` int(11) NOT NULL,
  `anio` int(11) NOT NULL,
  `importe` float NOT NULL,
  `fecha_pago` datetime DEFAULT NULL,
  `idPersona` int(11) NOT NULL,
  PRIMARY KEY (`idcuota`),
  KEY `idPersona_idx` (`idPersona`),
  CONSTRAINT `idPersona` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=381 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuota`
--

LOCK TABLES `cuota` WRITE;
/*!40000 ALTER TABLE `cuota` DISABLE KEYS */;
INSERT INTO `cuota` VALUES (321,1,2020,1100,NULL,3),(322,2,2020,1100,NULL,3),(323,3,2020,1100,NULL,3),(324,4,2020,1100,'2020-03-17 21:11:02',3),(325,5,2020,1100,NULL,3),(326,6,2020,1100,NULL,3),(327,7,2020,1100,NULL,3),(328,8,2020,1100,NULL,3),(329,9,2020,1100,NULL,3),(330,10,2020,1100,NULL,3),(331,11,2020,1100,NULL,3),(332,12,2020,1100,NULL,3),(333,1,2020,1100,NULL,21),(334,2,2020,1100,NULL,21),(335,3,2020,1100,NULL,21),(336,4,2020,1100,NULL,21),(337,5,2020,1100,NULL,21),(338,6,2020,1100,NULL,21),(339,7,2020,1100,NULL,21),(340,8,2020,1100,NULL,21),(341,9,2020,1100,NULL,21),(342,10,2020,1100,NULL,21),(343,11,2020,1100,NULL,21),(344,12,2020,1100,NULL,21),(345,1,2020,1100,NULL,22),(346,2,2020,1100,NULL,22),(347,3,2020,1100,NULL,22),(348,4,2020,1100,NULL,22),(349,5,2020,1100,NULL,22),(350,6,2020,1100,NULL,22),(351,7,2020,1100,NULL,22),(352,8,2020,1100,NULL,22),(353,9,2020,1100,NULL,22),(354,10,2020,1100,NULL,22),(355,11,2020,1100,NULL,22),(356,12,2020,1100,NULL,22),(357,1,2020,1100,NULL,23),(358,2,2020,1100,NULL,23),(359,3,2020,1100,NULL,23),(360,4,2020,1100,NULL,23),(361,5,2020,1100,NULL,23),(362,6,2020,1100,NULL,23),(363,7,2020,1100,NULL,23),(364,8,2020,1100,NULL,23),(365,9,2020,1100,NULL,23),(366,10,2020,1100,NULL,23),(367,11,2020,1100,NULL,23),(368,12,2020,1100,NULL,23),(369,1,2020,1100,NULL,24),(370,2,2020,1100,NULL,24),(371,3,2020,1100,NULL,24),(372,4,2020,1100,NULL,24),(373,5,2020,1100,NULL,24),(374,6,2020,1100,NULL,24),(375,7,2020,1100,NULL,24),(376,8,2020,1100,NULL,24),(377,9,2020,1100,NULL,24),(378,10,2020,1100,NULL,24),(379,11,2020,1100,NULL,24),(380,12,2020,1100,NULL,24);
/*!40000 ALTER TABLE `cuota` ENABLE KEYS */;
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
  `confirmada` tinyint(1) NOT NULL,
  KEY `id_usuario_fk_idx` (`id_usuario`),
  KEY `id_actividad_fk_idx` (`id_actividad`),
  CONSTRAINT `id_actividad_fk` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`),
  CONSTRAINT `id_usuario_fk` FOREIGN KEY (`id_usuario`) REFERENCES `persona` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
INSERT INTO `inscripcion` VALUES (2,22,'2020-03-11 22:19:04',1),(2,21,'2020-03-11 22:19:44',1),(2,23,'2020-03-11 22:20:03',1),(3,3,'2020-03-11 22:20:20',1),(3,24,'2020-03-17 21:08:17',1),(4,3,'2020-03-21 16:36:50',1);
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
  `imagen` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_instalacion`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instalacion`
--

LOCK TABLES `instalacion` WRITE;
/*!40000 ALTER TABLE `instalacion` DISABLE KEYS */;
INSERT INTO `instalacion` VALUES (5,'Cancha de Fútbol 5','Techada, césped sintético.',350,'img_01.jpg'),(6,'Cancha de Tenis','Polvo de ladrillo.',199.99,'img_02.jpg'),(7,'Quincho ','Capacidad para 200 personas.',450,'img_07.jpg'),(10,'Cancha de Basquet','Techada, piso parqué.',574.99,'img_05.jpg'),(12,'Sede','Centro de la ciudad',1000,'img_03.jpg');
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
  `rol` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Nahuel','Mariani','DNI','35642102','admin@admin','admin','3464513125',1,'Administrador'),(2,'Julieta','Steckinger','DNI','35642101','empleado@empleado','empleado','3464513126',1,'Empleado'),(3,'Ayelen','Demaria','DNI','35642100','socio@socio','socio','3464513127',1,'Socio'),(19,'Pedro','Rodriguez','DNI','35642103','000@000','000','0000',1,'Empleado'),(20,'Pablo','Gonzalez','LE','35642104','111@111','111','1111',0,'Administrador'),(21,'Jose','Martinez','DNI','35642105','222@222','222','2222',1,'Socio'),(22,'Maria','Perez','DNI','35642106','333@333','333','3333',1,'Socio'),(23,'Julia','Dominguez','LE','35642107','444@444','444','4444',1,'Socio'),(24,'Marta','Papa','DNI','35642108','555@555','555','5555',1,'Socio');
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
  `confirmada` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_reserva`),
  KEY `id_Instalacion _idx` (`id_instalacion`),
  KEY `id_usuario_idx` (`id_usuario`),
  CONSTRAINT `id_Instalacion ` FOREIGN KEY (`id_instalacion`) REFERENCES `instalacion` (`id_instalacion`),
  CONSTRAINT `id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (24,'2020-03-12 03:20:56','2020-10-10 10:10:00','2020-10-10 12:12:00','2020-03-12 03:24:45',10,3,0),(25,'2020-03-12 03:37:30','2020-10-10 20:20:00','2020-10-10 21:21:00','2020-03-12 03:37:50',10,3,0),(26,'2020-03-12 03:45:01','2020-10-10 10:10:00','2020-10-10 12:10:00','2020-03-12 03:45:25',12,3,0),(27,'2020-03-20 21:13:10','2020-04-05 21:00:00','2020-04-05 22:00:00',NULL,7,3,0),(28,'2020-03-20 21:18:44','2020-04-08 12:00:00','2020-04-08 13:00:00',NULL,6,3,0),(29,'2020-03-21 17:31:03','2020-06-14 12:00:00','2020-06-14 15:00:00',NULL,7,3,1);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valores_cuota`
--

DROP TABLE IF EXISTS `valores_cuota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `valores_cuota` (
  `idValoresCuota` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `valor` float NOT NULL,
  PRIMARY KEY (`idValoresCuota`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valores_cuota`
--

LOCK TABLES `valores_cuota` WRITE;
/*!40000 ALTER TABLE `valores_cuota` DISABLE KEYS */;
INSERT INTO `valores_cuota` VALUES (1,'2020-03-10 00:00:00',800),(2,'2020-03-11 00:00:00',1100),(3,'2020-10-10 00:00:00',1200),(4,'2020-03-25 00:00:00',1300),(5,'2020-03-31 00:00:00',1500),(6,'2020-03-28 00:00:00',1600),(7,'2020-04-25 00:00:00',2000),(8,'2020-05-31 00:00:00',3000);
/*!40000 ALTER TABLE `valores_cuota` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-21 17:40:04
