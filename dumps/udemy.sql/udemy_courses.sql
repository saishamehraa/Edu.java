-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: udemy
-- ------------------------------------------------------
-- Server version	8.4.0

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
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `photo` varchar(200) NOT NULL,
  `description` varchar(900) NOT NULL,
  `category` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_idx` (`category`),
  CONSTRAINT `category` FOREIGN KEY (`category`) REFERENCES `category` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Java','src/myuploads/1721741548729.jpg','Java courses teach students how to write Java code and develop applications using Java. The courses cover the core components of Java programming such as syntax, variables, methods, control statements, and understanding JVM, JRE, and JDK. Students will also learn about object-oriented programming and features of the Java language, and how to use Eclipse for writing and running Java code. They will develop programs that use Java collections and apply core object-oriented programming concepts using classes, polymorphism, and method overloading.','Programming'),(2,'C++','src/myuploads/1721741649747.jpg','C++ courses focus on teaching students the fundamentals of C++ programming, including syntax, variables, and control structures. They cover essential concepts like object-oriented programming, classes, inheritance, and polymorphism. Students will learn how to manage memory using pointers, references, and dynamic allocation. The course also introduces C++ Standard Library features, such as STL containers and algorithms. Practical exercises include developing applications, debugging, and optimizing C++ code.','Programming'),(3,'Python','src/myuploads/1721741738727.png','Python courses introduce students to Python programming, emphasizing readability and simplicity. Topics include basic syntax, data types, control flow, functions, and modules. Students learn object-oriented programming concepts, file handling, and error management. The course also covers Python libraries for tasks like data analysis (pandas), web development (Flask/Django), and automation. Practical projects involve developing scripts and applications to solve real-world problems, reinforcing core programming skills.','Programming'),(4,'Network Security','src/myuploads/1721742302497.jpg',' Protecting networks from attacks, understanding firewalls, intrusion detection systems (IDS), and network protocols.','Cyber Security'),(5,'Cloud Security','src/myuploads/1721742450308.jpg',' Protecting cloud-based systems and data, understanding cloud security models, and compliance issues related to cloud services.','Cyber Security'),(6,'Ethical Hacking & Penetration Testing','src/myuploads/1721742713824.jpeg','Techniques for identifying vulnerabilities in systems, ethical hacking principles, and tools used in penetration testing.','Cyber Security'),(7,'Animation','src/myuploads/1721743110062.jpeg',' Designing animated elements for videos, apps, and websites.','Graphic Designing'),(8,'Video Graphics','src/myuploads/1721743393460.png','Creating graphics and effects for video production, including title sequences and transitions.','Graphic Designing'),(9,'Front-End Development','src/myuploads/1721744033198.png','Front-end development involves creating the user interface of a website. It uses HTML for structure, CSS for styling, and JavaScript for interactivity. Front-end developers ensure websites are responsive and compatible across various devices and browsers. They may use frameworks like React or Vue.js to enhance development efficiency and performance.','Web Designing'),(10,'Back-End Development','src/myuploads/1721744177584.png','Back-end development handles server-side logic, databases, and APIs. It uses languages like Node.js, Python, or Java to process data and manage server operations. Back-end developers ensure secure data handling, implement authentication, and optimize server performance. They also manage databases and server environments to ensure application reliability and scalability.','Web Designing');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-25 14:10:02
