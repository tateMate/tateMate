-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.5.8-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- tatemate 데이터베이스 구조 내보내기
DROP DATABASE IF EXISTS `tatemate`;
CREATE DATABASE IF NOT EXISTS `tatemate` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tatemate`;

-- 테이블 tatemate.cocoment 구조 내보내기
DROP TABLE IF EXISTS `cocoment`;
CREATE TABLE IF NOT EXISTS `cocoment` (
  `cocoment_id` int(11) NOT NULL AUTO_INCREMENT,
  `coment_id` int(11) NOT NULL,
  `cocoment_id_from` int(11) NOT NULL,
  `cocoment_contents` varchar(500) NOT NULL,
  `cocoment_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `cocoment_status` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`cocoment_id`),
  KEY `FK_coment_TO_cocoment_1` (`coment_id`),
  KEY `FK_USER_TO_cocoment_1` (`cocoment_id_from`),
  CONSTRAINT `FK_USER_TO_cocoment_1` FOREIGN KEY (`cocoment_id_from`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_coment_TO_cocoment_1` FOREIGN KEY (`coment_id`) REFERENCES `coment` (`coment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 tatemate.cocoment:~0 rows (대략적) 내보내기
DELETE FROM `cocoment`;
/*!40000 ALTER TABLE `cocoment` DISABLE KEYS */;
/*!40000 ALTER TABLE `cocoment` ENABLE KEYS */;

-- 테이블 tatemate.coment 구조 내보내기
DROP TABLE IF EXISTS `coment`;
CREATE TABLE IF NOT EXISTS `coment` (
  `coment_id` int(11) NOT NULL AUTO_INCREMENT,
  `coment_id_to` int(11) NOT NULL,
  `coment_id_from` int(11) NOT NULL,
  `coment_contents` varchar(500) NOT NULL,
  `coment_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `coment_access` tinyint(1) NOT NULL,
  `coment_status` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`coment_id`),
  KEY `FK_USER_TO_coment_1` (`coment_id_to`),
  KEY `FK_USER_TO_coment_2` (`coment_id_from`),
  CONSTRAINT `FK_USER_TO_coment_1` FOREIGN KEY (`coment_id_to`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_USER_TO_coment_2` FOREIGN KEY (`coment_id_from`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 tatemate.coment:~0 rows (대략적) 내보내기
DELETE FROM `coment`;
/*!40000 ALTER TABLE `coment` DISABLE KEYS */;
/*!40000 ALTER TABLE `coment` ENABLE KEYS */;

-- 테이블 tatemate.intro_image 구조 내보내기
DROP TABLE IF EXISTS `intro_image`;
CREATE TABLE IF NOT EXISTS `intro_image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `image_address` varchar(255) NOT NULL,
  PRIMARY KEY (`image_id`),
  KEY `FK_USER_TO_intro_image_1` (`user_id`),
  CONSTRAINT `FK_USER_TO_intro_image_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 tatemate.intro_image:~0 rows (대략적) 내보내기
DELETE FROM `intro_image`;
/*!40000 ALTER TABLE `intro_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `intro_image` ENABLE KEYS */;

-- 테이블 tatemate.user 구조 내보내기
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(50) NOT NULL,
  `user_pw` varchar(15) NOT NULL,
  `user_nickname` varchar(50) NOT NULL,
  `user_gender` tinyint(1) NOT NULL,
  `user_nationality` varchar(50) NOT NULL,
  `user_age` tinyint(4) NOT NULL,
  `user_smoking` tinyint(1) NOT NULL,
  `user_vaccine` tinyint(1) NOT NULL,
  `user_room` tinyint(1) NOT NULL,
  `user_matching` tinyint(1) NOT NULL,
  `user_pet` tinyint(1) DEFAULT NULL,
  `user_intro` varchar(500) DEFAULT NULL,
  `user_ideal` varchar(500) DEFAULT NULL,
  `user_location` varchar(50) DEFAULT NULL,
  `user_profile` varchar(255) DEFAULT NULL,
  `user_sns` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 tatemate.user:~0 rows (대략적) 내보내기
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 테이블 tatemate.user_character 구조 내보내기
DROP TABLE IF EXISTS `user_character`;
CREATE TABLE IF NOT EXISTS `user_character` (
  `user_id` int(11) NOT NULL,
  `cleanliness` tinyint(4) NOT NULL,
  `wakeup_time` tinyint(4) NOT NULL,
  `sleep_time` tinyint(4) NOT NULL,
  `cooking_frequency` tinyint(4) NOT NULL,
  `chatter` tinyint(4) NOT NULL,
  `snoring` tinyint(4) NOT NULL,
  `mbti` varchar(4) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FK_USER_TO_user_character_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 tatemate.user_character:~0 rows (대략적) 내보내기
DELETE FROM `user_character`;
/*!40000 ALTER TABLE `user_character` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_character` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
