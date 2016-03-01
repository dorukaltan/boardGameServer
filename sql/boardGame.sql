-- MySQL dump 10.13  Distrib 5.7.10, for osx10.11 (x86_64)
--
-- Host: localhost    Database: BoardGame
-- ------------------------------------------------------
-- Server version	5.7.10

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
-- Table structure for table `GameTable`
--

DROP TABLE IF EXISTS `GameTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GameTable` (
  `tableId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'A',
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tableId`),
  KEY `userid_idx` (`userId`),
  CONSTRAINT `fk_GameTable_userId` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GameTable`
--

LOCK TABLES `GameTable` WRITE;
/*!40000 ALTER TABLE `GameTable` DISABLE KEYS */;
INSERT INTO `GameTable` VALUES (19,9,'2016-01-04 00:24:31','Mehmet\'s table','A','62b678c706d098bf5b2431f9dc466d2d');
/*!40000 ALTER TABLE `GameTable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GameTable_User`
--

DROP TABLE IF EXISTS `GameTable_User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GameTable_User` (
  `tableId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `status` varchar(10) NOT NULL DEFAULT 'A',
  `joinTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `idx_tableId` (`tableId`),
  KEY `idx_userId_tableId` (`userId`,`tableId`),
  CONSTRAINT `fk_tableId` FOREIGN KEY (`tableId`) REFERENCES `GameTable` (`tableId`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GameTable_User`
--

LOCK TABLES `GameTable_User` WRITE;
/*!40000 ALTER TABLE `GameTable_User` DISABLE KEYS */;
INSERT INTO `GameTable_User` VALUES (19,9,'A','2016-01-04 00:25:17'),(19,10,'P','2016-01-04 00:26:59'),(19,10,'P','2016-01-04 00:28:05'),(19,10,'A','2016-01-04 00:30:56');
/*!40000 ALTER TABLE `GameTable_User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `signUpTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (9,'Mehmetuskup33@gmail.com','Mehmet','Üsküp','62b678c706d098bf5b2431f9dc466d2d','2016-01-04 00:20:20'),(10,'dorukaltan@gmail.com','Doruk','Altan','62b678c706d098bf5b2431f9dc466d2d','2016-01-04 00:26:26');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-01 20:41:49
