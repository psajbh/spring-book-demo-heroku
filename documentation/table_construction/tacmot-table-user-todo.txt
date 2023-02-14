table: user with todo

DROP TABLE IF EXISTS `todo`;

SET NAMES utf8 ;

DROP TABLE IF EXISTS `user`;
 SET character_set_client = utf8mb4 ;
 
CREATE TABLE `user` (
  `id` int(20) NOT NULL,
  `date_created` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `ldap_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `gender` enum('M','F') NOT NULL,
  `ratelevel` enum('1','10','100') NOT NULL,
  `rate_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gj2fy3dcix7ph7k8684gka40c` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,NULL,'nancy@yahoo.com','Nancy','Hart',NULL,'Nancy','111-111-1111','M','1',NULL),(2,NULL,'johns@gmail.com','John','Hart','john001','John','222-222-2222','M','1',NULL);
UNLOCK TABLES;

DROP TABLE IF EXISTS `todo`;
SET character_set_client = utf8mb4 ;

CREATE TABLE `todo` (
  `id` int(20) NOT NULL,
  `complete` bit(1) NOT NULL,
  `complete_date` datetime(6) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `task_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2ft3dfk1d3uw77pas3xqwymm7` (`user_id`),
  CONSTRAINT `FK2ft3dfk1d3uw77pas3xqwymm7` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


#LOCK TABLES `todo` WRITE;
#INSERT INTO `todo` VALUES (17,_binary '\0',NULL,'2022-07-22 15:42:49.603000','Work',1),(18,_binary '\0',NULL,'2022-07-22 15:44:54.803000','Get Spring Boot Demo Applicaton running',2);
#UNLOCK TABLES;

