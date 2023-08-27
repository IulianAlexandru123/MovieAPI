-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: movie_db
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `movie_picture_urls`
--

DROP TABLE IF EXISTS `movie_picture_urls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_picture_urls` (
  `movie_id` binary(16) NOT NULL,
  `picture_urls` varchar(255) DEFAULT NULL,
  KEY `FKkg9c3m0g54yr169wghl7kvxud` (`movie_id`),
  CONSTRAINT `FKkg9c3m0g54yr169wghl7kvxud` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_picture_urls`
--

LOCK TABLES `movie_picture_urls` WRITE;
/*!40000 ALTER TABLE `movie_picture_urls` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie_picture_urls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_tags`
--

DROP TABLE IF EXISTS `movie_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_tags` (
  `movie_id` binary(16) NOT NULL,
  `tags` varchar(255) NOT NULL,
  KEY `FK9a632hawa9g4tp3qoq4bpvr2` (`movie_id`),
  CONSTRAINT `FK9a632hawa9g4tp3qoq4bpvr2` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_tags`
--

LOCK TABLES `movie_tags` WRITE;
/*!40000 ALTER TABLE `movie_tags` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `id` binary(16) NOT NULL,
  `date_available_until` datetime(6) NOT NULL,
  `date_released` datetime(6) NOT NULL,
  `description` varchar(255) NOT NULL,
  `genre` enum('ACTION','COMEDY','HORROR') NOT NULL,
  `length` bigint NOT NULL,
  `meta_description` varchar(255) DEFAULT NULL,
  `meta_title` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_favorite_categories`
--

DROP TABLE IF EXISTS `user_favorite_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_favorite_categories` (
  `user_id` binary(16) NOT NULL,
  `favorite_category` enum('ACTION','COMEDY','HORROR') DEFAULT NULL,
  KEY `FKgp05t4yjq3gdbapkiphxgg969` (`user_id`),
  CONSTRAINT `FKgp05t4yjq3gdbapkiphxgg969` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_favorite_categories`
--

LOCK TABLES `user_favorite_categories` WRITE;
/*!40000 ALTER TABLE `user_favorite_categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_favorite_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` binary(16) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `website_theme` enum('DARK','LIGHT') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_du5v5sr43g5bfnji4vb8hg5s3` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_favorite_movies`
--

DROP TABLE IF EXISTS `users_favorite_movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_favorite_movies` (
  `user_id` binary(16) NOT NULL,
  `favorite_movies_id` binary(16) NOT NULL,
  PRIMARY KEY (`user_id`,`favorite_movies_id`),
  KEY `FKh2hpb96rm1iscjq0nh98cldqg` (`favorite_movies_id`),
  CONSTRAINT `FKh2hpb96rm1iscjq0nh98cldqg` FOREIGN KEY (`favorite_movies_id`) REFERENCES `movies` (`id`),
  CONSTRAINT `FKhftvu1g691j791jhxdf092tiu` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_favorite_movies`
--

LOCK TABLES `users_favorite_movies` WRITE;
/*!40000 ALTER TABLE `users_favorite_movies` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_favorite_movies` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-28  0:15:20
