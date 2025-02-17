-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: recruit
-- ------------------------------------------------------
-- Server version	5.7.24

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
-- Table structure for table `jobpostings`
--

DROP TABLE IF EXISTS `jobpostings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobpostings` (
  `id` int(9) NOT NULL,
  `jobposting_name` varchar(45) NOT NULL,
  `employer_name` varchar(45) NOT NULL,
  `hourly_salary` float NOT NULL,
  `openings` int(3) NOT NULL,
  `job_description` text NOT NULL,
  `users_id` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobpostings`
--

LOCK TABLES `jobpostings` WRITE;
/*!40000 ALTER TABLE `jobpostings` DISABLE KEYS */;
INSERT INTO `jobpostings` VALUES (1,'Head Chef','Sushi Shiro',36,1,'Looking for a head chef with 10 years sushi crafting experience.',1),(4,'Executive Chef','Pizza Planet',55,1,'Pizza Planet is looking for an executive chef with 15 years of experience in a head chef position or similar.',1),(5,'Server','Italian Fine Cuisine',18,1,'Italian Fine Cuisine is seeking an experienced server for the busy weekend shift.',1);
/*!40000 ALTER TABLE `jobpostings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resumes`
--

DROP TABLE IF EXISTS `resumes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resumes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `history` text NOT NULL,
  `skills` text NOT NULL,
  `jobPosting_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_resumes_jobpostings_idx` (`jobPosting_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resumes`
--

LOCK TABLES `resumes` WRITE;
/*!40000 ALTER TABLE `resumes` DISABLE KEYS */;
INSERT INTO `resumes` VALUES (1,'Janina Deetlof','991-585-0033','ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia','pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at',5),(2,'Farlie Burnes','538-965-1200','tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie','at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut',4),(3,'Penni Sandilands','130-278-2499','bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit','penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor',4),(4,'Andra Dominici','834-359-4684','consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero','magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem',1),(5,'Keslie Colecrough','428-102-8449','primis in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui','nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla',3),(6,'Jodi Cregin','264-610-6888','lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed','posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum',5),(7,'Jolie Lintall','747-895-2622','ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit','ut odio cras mi pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit',4),(8,'Craig Cosyns','332-778-3966','blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare','sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec',5),(9,'Fionnula Gurden','143-653-2823','in hac habitasse platea dictumst etiam faucibus cursus urna ut','enim blandit mi in porttitor pede justo eu massa donec dapibus duis at',4),(10,'Roley Knightsbridge','306-104-3138','faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat','integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu',1),(11,'Ashla Wanless','812-761-1633','vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum','curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum',4),(12,'Annmarie Stollsteimer','565-283-9336','libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor','amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed',4),(13,'Gina Pates','787-358-6113','in eleifend quam a odio in hac habitasse platea dictumst maecenas','felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis',3),(14,'Rayner Pohlak','232-934-1138','hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate','libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis',5),(15,'Aili Capon','477-238-2790','feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium','primis in faucibus orci luctus et ultrices posuere cubilia curae',3),(16,'Ileana Audas','450-371-9388','feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce','nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea',1),(17,'Gaylene Viollet','379-792-6776','turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh','odio cras mi pede malesuada in imperdiet et commodo vulputate justo in',4),(18,'Melloney Vallantine','970-134-4142','rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut','vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam',3),(19,'Daile Donaher','349-909-9280','tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer','accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio',1),(20,'Shani Knivett','885-402-9500','nunc rhoncus dui vel sem sed sagittis nam congue risus semper','duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor',3),(21,'Sigvard Lakenton','149-456-7451','nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus','pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse',3),(22,'Hartwell Fairhead','720-567-9046','nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede','vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero',5),(23,'Augusta Isted','984-320-8430','nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit','in ante vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae duis',4),(24,'Pepe Lukacs','355-743-2199','natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue','nulla elit ac nulla sed vel enim sit amet nunc viverra',3),(25,'Brien Gilvear','779-667-9312','pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare','ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate',4),(26,'Ralph Conduit','256-429-9642','leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin','dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor',4),(27,'Abby O\'Gaven','788-116-6651','donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim','habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer',3),(28,'Eartha Sacase','851-648-9547','aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec','turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec',5),(29,'Querida Kennifeck','285-641-6285','tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec','ullamcorper purus sit amet nulla quisque arcu libero rutrum ac lobortis vel dapibus at diam nam tristique tortor eu',2),(30,'Humfried Saxton','669-861-8453','est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat','justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices',4),(31,'Kristyn Guye','897-606-3318','neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis','nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id',3),(32,'Corliss Habron','118-559-1598','ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia','eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis',5),(33,'Cherin Stukings','382-473-0889','enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum ac tellus semper interdum mauris','donec semper sapien a libero nam dui proin leo odio porttitor id consequat in',4),(34,'Livvyy Ullyatt','327-617-6696','rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio','id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede',2),(35,'Vivianna Currall','891-125-8925','porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis','commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing',1),(36,'Del Lappin','214-786-9636','rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id','in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in',2),(37,'Brew Acedo','875-600-2842','donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat','rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie',2),(38,'Tally Milburn','573-119-0776','nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque','congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium',4),(39,'Donica Snedker','621-758-3394','nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in','elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium',1),(40,'Marlene Weiss','396-509-1054','curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam','ut odio cras mi pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum',5),(41,'Candis Prudence','654-669-1454','tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend','cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis',4),(42,'Hedi Kalisz','232-910-9973','ac tellus semper interdum mauris ullamcorper purus sit amet nulla','nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac',5),(43,'Marlee Ladbury','821-412-9623','suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla','nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum',3),(44,'Iseabal Karlsson','839-461-1799','dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum','enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum',2),(45,'Lizzie Gookey','178-743-9460','orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur','faucibus accumsan odio curabitur convallis duis consequat dui nec nisi',1),(46,'Merla Varfolomeev','338-383-7217','mauris ullamcorper purus sit amet nulla quisque arcu libero rutrum ac lobortis vel dapibus at diam nam tristique tortor','varius integer ac leo pellentesque ultrices mattis odio donec vitae',5),(47,'Zolly Twoohy','924-295-6432','aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi','molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue',4),(48,'Glynn Morgan','517-826-1432','massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt','in felis donec semper sapien a libero nam dui proin leo odio porttitor id',3),(49,'Evyn Harget','124-929-9310','quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis','hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at',5),(50,'Leda Kneeland','575-176-5578','nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque','a suscipit nulla elit ac nulla sed vel enim sit amet nunc',5);
/*!40000 ALTER TABLE `resumes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `emailaddress` varchar(45) NOT NULL,
  `phone_no` varchar(15) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Administrator','System','sysadmin@recruit.com','5555555555','123','123'),(2,'Donnelly','Dan','dan@recruitats.com','5555555555','drd413','password'),(3,'Kemp','Carter ','carterkemp31@gmail','6196269544','Whimsie','a'),(4,'Kemp','Carter ','carterkemp31@gmail','6196269544','Whimsie','a'),(5,'Kemp','Carter ','carterkemp31@gmail','6196269544','Whimsie','aa'),(6,'Kemp','Carter ','carterkemp31@gmail','6196269544','drd413','password');
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

-- Dump completed on 2025-02-09 22:30:58
