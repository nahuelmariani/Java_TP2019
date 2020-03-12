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
) ENGINE=InnoDB AUTO_INCREMENT=321 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuota`
--

LOCK TABLES `cuota` WRITE;
/*!40000 ALTER TABLE `cuota` DISABLE KEYS */;
INSERT INTO `cuota` VALUES (109,1,2020,800,'2020-02-23 23:45:29',3),(110,2,2020,800,NULL,3),(111,3,2020,800,'2020-02-24 15:13:22',3),(112,4,2020,800,NULL,3),(113,5,2020,800,NULL,3),(114,6,2020,800,NULL,3),(115,7,2020,800,NULL,3),(116,8,2020,800,NULL,3),(117,9,2020,800,NULL,3),(118,10,2020,800,NULL,3),(119,11,2020,800,NULL,3),(120,12,2020,800,NULL,3),(291,3,2020,1000,NULL,24),(292,4,2020,1000,NULL,24),(293,5,2020,1000,NULL,24),(294,6,2020,1000,'2020-03-12 04:46:18',24),(295,7,2020,1000,NULL,24),(296,8,2020,1000,NULL,24),(297,9,2020,1000,NULL,24),(298,10,2020,1000,NULL,24),(299,11,2020,1000,NULL,24),(300,12,2020,1000,NULL,24),(301,3,2020,1200,NULL,22),(302,4,2020,1200,NULL,22),(303,5,2020,1200,NULL,22),(304,6,2020,1200,NULL,22),(305,7,2020,1200,NULL,22),(306,8,2020,1200,NULL,22),(307,9,2020,1200,NULL,22),(308,10,2020,1200,NULL,22),(309,11,2020,1200,NULL,22),(310,12,2020,1200,NULL,22),(311,3,2020,1100,NULL,21),(312,4,2020,1100,NULL,21),(313,5,2020,1100,NULL,21),(314,6,2020,1100,NULL,21),(315,7,2020,1100,NULL,21),(316,8,2020,1100,NULL,21),(317,9,2020,1100,NULL,21),(318,10,2020,1100,NULL,21),(319,11,2020,1100,NULL,21),(320,12,2020,1100,NULL,21);
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
INSERT INTO `inscripcion` VALUES (2,22,'2020-03-11 22:19:04',1),(2,21,'2020-03-11 22:19:44',1),(2,23,'2020-03-11 22:20:03',1),(3,3,'2020-03-11 22:20:20',1);
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
  PRIMARY KEY (`id_reserva`),
  KEY `id_Instalacion _idx` (`id_instalacion`),
  KEY `id_usuario_idx` (`id_usuario`),
  CONSTRAINT `id_Instalacion ` FOREIGN KEY (`id_instalacion`) REFERENCES `instalacion` (`id_instalacion`),
  CONSTRAINT `id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (24,'2020-03-12 03:20:56','2020-10-10 10:10:00','2020-10-10 12:12:00','2020-03-12 03:24:45',10,3),(25,'2020-03-12 03:37:30','2020-10-10 20:20:00','2020-10-10 21:21:00','2020-03-12 03:37:50',10,3),(26,'2020-03-12 03:45:01','2020-10-10 10:10:00','2020-10-10 12:10:00','2020-03-12 03:45:25',12,3);
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

-- Dump completed on 2020-03-12  4:03:54
