-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: testmydb
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `bookinfo`
--

DROP TABLE IF EXISTS `bookinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `isbn` char(13) NOT NULL COMMENT '书号',
  `name` varchar(200) NOT NULL COMMENT '书名',
  `author` varchar(100) NOT NULL COMMENT '作者',
  `press` varchar(100) NOT NULL COMMENT '出版社',
  `price` decimal(7,2) NOT NULL COMMENT '价格',
  `pubdate` date NOT NULL COMMENT '出版日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookinfo`
--

LOCK TABLES `bookinfo` WRITE;
/*!40000 ALTER TABLE `bookinfo` DISABLE KEYS */;
INSERT INTO `bookinfo` VALUES (1,'9787111544937','深入理解计算机系统（原书第3版）','兰德尔 E.布莱恩特','机械工业出版社',139.00,'2016-12-01'),(2,'9787111384991','鸟哥的Linux私房菜：服务器架设篇（第三版）','鸟哥','机械工业出版社',108.00,'2012-06-01'),(3,'9787115450326','网络操作系统 (第2版)','陈景亮','人民邮电出版社',69.80,'2017-06-01'),(4,'9787115483690','CentOS Linux系统管理与运维(第2版) ','张金石','人民邮电出版社',69.80,'2018-07-01'),(5,'9787115428028','Python编程 从入门到实践','埃里克·马瑟斯','人民邮电出版社',89.00,'2016-07-01'),(6,'9787302438205','Python零基础入门学习','李佳宇','清华大学出版社',49.00,'2016-10-01'),(7,'9787301299487','Excel 2016函数与公式应用大全','Excel Home','北京大学出版社',119.00,'2018-11-01'),(8,'9787517068112','WPS Office办公应用从入门到精通 ','IT新时代教育','中国水利水电出版社',69.80,'2019-01-01'),(9,'9787115424914','图解密码技术 第3版','结城浩','人民邮电出版社',89.00,'2016-06-01'),(10,'9787115383440','SQL学习指南（第2版 修订版）','Alan Beaulieu','人民邮电出版社',49.00,'2015-02-01');
/*!40000 ALTER TABLE `bookinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-13 10:15:32
