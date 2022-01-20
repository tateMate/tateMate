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
CREATE DATABASE IF NOT EXISTS `tatemate` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tatemate`;

-- 테이블 tatemate.cocomment 구조 내보내기
CREATE TABLE IF NOT EXISTS `cocomment` (
  `cocomment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id` int(11) NOT NULL,
  `cocomment_id_from` int(11) NOT NULL,
  `cocomment_contents` varchar(500) NOT NULL,
  `cocomment_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `cocomment_status` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`cocomment_id`) USING BTREE,
  KEY `FK_comment_TO_cocomment_1` (`comment_id`) USING BTREE,
  KEY `FK_USER_TO_cocomment_1` (`cocomment_id_from`) USING BTREE,
  CONSTRAINT `FK_USER_TO_cocomment_1` FOREIGN KEY (`cocomment_id_from`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_comment_TO_cocomment_1` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`comment_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 테이블 데이터 tatemate.cocomment:~5 rows (대략적) 내보내기
DELETE FROM `cocomment`;
/*!40000 ALTER TABLE `cocomment` DISABLE KEYS */;
INSERT INTO `cocomment` (`cocomment_id`, `comment_id`, `cocomment_id_from`, `cocomment_contents`, `cocomment_time`, `cocomment_status`) VALUES
	(1, 1, 1, '2번이 1번에게 단 댓글에 1번이 답글', '2021-12-22 14:17:13', 1),
	(2, 1, 3, '2번이 1번에게 단 댓글에 3번이 답글', '2021-12-22 14:17:34', 1),
	(3, 2, 1, '3번이 1번에게 단 댓글에 1번이 답글', '2021-12-22 14:17:56', 1),
	(4, 2, 2, '3번이 1번에게 단 댓그리 2번이 답글', '2021-12-22 14:18:09', 1),
	(5, 2, 3, '3번이 1번에게 단 댓글에 3번이 답글', '2021-12-22 14:18:23', 1),
	(6, 10, 36, 'qewrwr', '2022-01-12 22:32:57', 0);
/*!40000 ALTER TABLE `cocomment` ENABLE KEYS */;

-- 테이블 tatemate.comment 구조 내보내기
CREATE TABLE IF NOT EXISTS `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id_to` int(11) NOT NULL,
  `comment_id_from` int(11) NOT NULL,
  `comment_contents` varchar(500) NOT NULL,
  `comment_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `comment_access` tinyint(1) NOT NULL,
  `comment_status` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`comment_id`) USING BTREE,
  KEY `FK_USER_TO_comment_1` (`comment_id_to`) USING BTREE,
  KEY `FK_USER_TO_comment_2` (`comment_id_from`) USING BTREE,
  CONSTRAINT `FK_USER_TO_comment_1` FOREIGN KEY (`comment_id_to`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USER_TO_comment_2` FOREIGN KEY (`comment_id_from`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- 테이블 데이터 tatemate.comment:~8 rows (대략적) 내보내기
DELETE FROM `comment`;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`comment_id`, `comment_id_to`, `comment_id_from`, `comment_contents`, `comment_time`, `comment_access`, `comment_status`) VALUES
	(1, 1, 2, '2번유저가1번유저에게', '2021-12-22 14:15:39', 0, 1),
	(2, 1, 3, '3번유저가 1번유저에게', '2021-12-22 14:16:32', 0, 1),
	(3, 2, 1, '1번유저가 2번유저에게', '2021-12-23 11:44:54', 0, 1),
	(4, 1, 8, 'testtest', '2021-12-23 16:02:27', 0, 0),
	(5, 1, 12, 'test', '2021-12-24 17:04:38', 0, 2),
	(6, 1, 12, 'testtest', '2021-12-24 17:04:43', 0, 0),
	(7, 1, 10, '수정', '2021-12-29 16:14:26', 0, 2),
	(8, 1, 10, 'testestestestes', '2021-12-29 13:47:15', 0, 0),
	(9, 36, 36, 'asd', '2022-01-12 22:32:38', 0, 0),
	(10, 1, 36, 'qwewr', '2022-01-12 22:32:47', 1, 0);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;

-- 테이블 tatemate.intro_image 구조 내보내기
CREATE TABLE IF NOT EXISTS `intro_image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `image_address` varchar(255) NOT NULL,
  PRIMARY KEY (`image_id`),
  KEY `FK_USER_TO_intro_image_1` (`user_id`),
  CONSTRAINT `FK_USER_TO_intro_image_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 tatemate.intro_image:~0 rows (대략적) 내보내기
DELETE FROM `intro_image`;
/*!40000 ALTER TABLE `intro_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `intro_image` ENABLE KEYS */;

-- 테이블 tatemate.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(64) NOT NULL,
  `user_pw` varchar(256) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- 테이블 데이터 tatemate.user:~10 rows (대략적) 내보내기
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `user_email`, `user_pw`, `user_nickname`, `user_gender`, `user_nationality`, `user_age`, `user_smoking`, `user_vaccine`, `user_room`, `user_matching`, `user_pet`, `user_intro`, `user_ideal`, `user_location`, `user_profile`, `user_sns`) VALUES
	(1, 'abc@abc.com', 'ff65115a10a4e720e0fe6148c25816a75149fc89c00cfc7922cfd5bbcc262c5b', '1번유저', 1, '한국', 28, 0, 2, 0, 1, NULL, NULL, NULL, '서울 중랑구 상봉동', NULL, NULL),
	(2, 'cba@cba.com', '4321', '2번유저', 0, '일본', 27, 1, 1, 1, 1, NULL, NULL, NULL, '서울 중랑구 망우동', NULL, NULL),
	(3, '123@12312.com', '5d389f5e2e34c6b0bad96581c22cee0be36dcf627cd73af4d4cccacd9ef40cc3', '3번유저', 1, 'america', 26, 0, 1, 0, 0, NULL, NULL, NULL, '', NULL, NULL),
	(4, 'test@testest.com', '13579', '테스테스테스트', 0, '피자나라', 26, 0, 1, 0, 0, NULL, NULL, NULL, '', NULL, NULL),
	(8, '123@123.com', '67d86d0382eb882efca5ed40c57aa3cfa28eca25cafa7f5810b9b4da94b46a81', '153', 0, '피자나라', 3, 0, 2, 0, 0, NULL, NULL, NULL, '', '123at123dcom.octet-stream', NULL),
	(9, 'adm', 'fcef631eab0be0f69d940e737b136e0cbcf4f6f1de81f50822862002655af92e', 'adm', 0, '123', 122, 0, 2, 0, 0, NULL, NULL, NULL, '서울 중랑구 상봉동', 'adm.octet-stream', NULL),
	(10, 'qwe', '18138372fad4b94533cd4881f03dc6c69296dd897234e0cee83f727e2e6b1f63', 'qwe', 0, '6', 6, 1, 1, 1, 1, NULL, NULL, NULL, '', 'qwe.jpeg', NULL),
	(11, 'asd', '54d5cb2d332dbdb4850293caae4559ce88b65163f1ea5d4e4b3ac49d772ded14', 'asd', 0, '1', 3, 0, 2, 0, 0, NULL, NULL, NULL, '', 'asd.octet-stream', NULL),
	(12, '111', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '11', 0, '32', 42, 0, 1, 0, 0, NULL, NULL, NULL, '서울 중랑구 면목동', '111.jpeg', NULL),
	(13, 'test', '37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578', 't2', 0, '132', 31, 0, 1, 0, 0, NULL, NULL, NULL, '서울 중랑구 신내동', 'test.jpeg', NULL),
	(36, 'noreplytatemate@gmail.com', '5469d09046d88a8d97855e33e1bf64da9dbca4fbbf5b3ac743d6850dc1622fb9', '1234', 0, '123', 12, 0, 4, 1, 1, 0, '', '', '서울 동대문구 답십리동', NULL, '');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 테이블 tatemate.user_character 구조 내보내기
CREATE TABLE IF NOT EXISTS `user_character` (
  `user_id` int(11) NOT NULL,
  `cleanliness` tinyint(4) DEFAULT NULL,
  `wakeup_time` tinyint(4) DEFAULT NULL,
  `sleep_time` tinyint(4) DEFAULT NULL,
  `cooking_frequency` tinyint(4) DEFAULT NULL,
  `chatter` tinyint(4) DEFAULT NULL,
  `snoring` tinyint(4) DEFAULT NULL,
  `mbti` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FK_USER_TO_user_character_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 tatemate.user_character:~7 rows (대략적) 내보내기
DELETE FROM `user_character`;
/*!40000 ALTER TABLE `user_character` DISABLE KEYS */;
INSERT INTO `user_character` (`user_id`, `cleanliness`, `wakeup_time`, `sleep_time`, `cooking_frequency`, `chatter`, `snoring`, `mbti`) VALUES
	(1, 5, 4, 3, 3, 4, 4, NULL),
	(2, 5, 3, 2, 2, 3, 3, NULL),
	(4, 4, 4, 4, 3, 3, 4, NULL),
	(8, 5, 4, 3, 4, 2, 1, 'estp'),
	(9, 1, 1, 1, 1, 1, 1, 'INTP'),
	(12, 5, 1, 2, 3, 4, 2, 'istp'),
	(13, 5, 4, 3, 3, 4, 4, NULL),
	(36, 2, 3, 2, 3, 0, 0, '');
/*!40000 ALTER TABLE `user_character` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
