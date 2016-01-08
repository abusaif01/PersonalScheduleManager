/*
MySQL Data Transfer
Source Host: localhost
Source Database: saif
Target Host: localhost
Target Database: saif
Date: 12/29/2010 7:32:39 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for daily
-- ----------------------------
DROP TABLE IF EXISTS `daily`;
CREATE TABLE `daily` (
  `no` int(4) NOT NULL AUTO_INCREMENT,
  `time` time NOT NULL,
  `ocation` varchar(500) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for imd
-- ----------------------------
DROP TABLE IF EXISTS `imd`;
CREATE TABLE `imd` (
  `no` int(4) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL DEFAULT '0000-00-00',
  `ocation` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for monthly
-- ----------------------------
DROP TABLE IF EXISTS `monthly`;
CREATE TABLE `monthly` (
  `no` int(4) NOT NULL AUTO_INCREMENT,
  `date` varchar(3) NOT NULL,
  `time` time NOT NULL,
  `ocation` varchar(500) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for once
-- ----------------------------
DROP TABLE IF EXISTS `once`;
CREATE TABLE `once` (
  `no` int(4) NOT NULL AUTO_INCREMENT,
  `date` varchar(12) NOT NULL,
  `time` time NOT NULL,
  `ocation` varchar(500) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for today
-- ----------------------------
DROP TABLE IF EXISTS `today`;
CREATE TABLE `today` (
  `no` int(3) NOT NULL AUTO_INCREMENT,
  `type` varchar(10) NOT NULL,
  `time` time NOT NULL,
  `ocation` varchar(100) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for weakly
-- ----------------------------
DROP TABLE IF EXISTS `weakly`;
CREATE TABLE `weakly` (
  `no` int(4) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `ocation` varchar(500) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for yearly
-- ----------------------------
DROP TABLE IF EXISTS `yearly`;
CREATE TABLE `yearly` (
  `no` int(4) NOT NULL AUTO_INCREMENT,
  `date` varchar(5) NOT NULL,
  `time` time NOT NULL,
  `ocation` varchar(500) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `daily` VALUES ('1', '02:02:00', 'love you bou');
INSERT INTO `daily` VALUES ('5', '13:30:00', 'lunch time');
INSERT INTO `daily` VALUES ('12', '00:00:00', 'tea');
INSERT INTO `daily` VALUES ('13', '00:00:00', 'lunch');
INSERT INTO `daily` VALUES ('14', '00:00:00', 'lunch');
INSERT INTO `daily` VALUES ('15', '00:00:00', 'lunch');
INSERT INTO `daily` VALUES ('16', '00:00:00', 'dinner');
INSERT INTO `daily` VALUES ('17', '00:00:00', 'dinner');
INSERT INTO `daily` VALUES ('18', '00:00:00', 'dinner');
INSERT INTO `daily` VALUES ('19', '00:00:00', 'dinner');
INSERT INTO `daily` VALUES ('20', '00:00:00', 'jani na');
INSERT INTO `imd` VALUES ('1', '2010-12-08', ' my_birth_day');
INSERT INTO `imd` VALUES ('2', '2010-11-02', 'babu\'s_bith_day');
INSERT INTO `imd` VALUES ('3', '2010-11-07', 'zaki\'s_birth_day');
INSERT INTO `imd` VALUES ('4', '2010-12-16', 'Victory_day');
INSERT INTO `imd` VALUES ('6', '1989-11-11', 'nothing');
INSERT INTO `imd` VALUES ('7', '1969-12-31', ' hello');
INSERT INTO `imd` VALUES ('8', '1992-06-16', 'soaib\'s_birthday');
INSERT INTO `imd` VALUES ('9', '1989-12-15', 'tulin\'s_birthday');
INSERT INTO `imd` VALUES ('10', '2080-12-12', 'ki jaani');
INSERT INTO `imd` VALUES ('11', '2011-02-01', 'dsaf');
INSERT INTO `imd` VALUES ('12', '2010-12-09', 'gorardim');
INSERT INTO `monthly` VALUES ('1', '2', '02:01:27', 'pay gas bill');
INSERT INTO `monthly` VALUES ('2', '3', '02:01:42', 'pay school fees');
INSERT INTO `monthly` VALUES ('3', '19', '02:01:56', 'its a monthly job');
INSERT INTO `monthly` VALUES ('4', '19', '02:02:10', 'its another monthly job');
INSERT INTO `monthly` VALUES ('5', '22', '23:55:00', 'jani na ki');
INSERT INTO `monthly` VALUES ('6', '1', '00:00:00', 'lunch');
INSERT INTO `monthly` VALUES ('7', '1', '00:00:00', 'dinner');
INSERT INTO `once` VALUES ('1', '2010-12-20', '03:24:48', 'jani na ki');
INSERT INTO `once` VALUES ('2', '2011-01-01', '03:24:48', 'hello');
INSERT INTO `once` VALUES ('3', '2010-02-02', '02:02:00', 'ghjgh');
INSERT INTO `once` VALUES ('4', '2050-03-03', '05:12:00', 'hai hai hia');
INSERT INTO `once` VALUES ('5', '2010-12-22', '03:00:00', 'faol fazil');
INSERT INTO `today` VALUES ('1', 'daily', '02:02:00', 'love you bou');
INSERT INTO `today` VALUES ('2', 'daily', '13:30:00', 'lunch time');
INSERT INTO `today` VALUES ('3', 'daily', '00:00:00', 'tea');
INSERT INTO `today` VALUES ('4', 'daily', '00:00:00', 'lunch');
INSERT INTO `today` VALUES ('5', 'daily', '00:00:00', 'lunch');
INSERT INTO `today` VALUES ('6', 'daily', '00:00:00', 'lunch');
INSERT INTO `today` VALUES ('7', 'daily', '00:00:00', 'dinner');
INSERT INTO `today` VALUES ('8', 'daily', '00:00:00', 'dinner');
INSERT INTO `today` VALUES ('9', 'daily', '00:00:00', 'dinner');
INSERT INTO `today` VALUES ('10', 'daily', '00:00:00', 'dinner');
INSERT INTO `today` VALUES ('11', 'daily', '00:00:00', 'jani na');
INSERT INTO `today` VALUES ('12', 'monthly', '02:01:56', 'its a monthly job');
INSERT INTO `today` VALUES ('13', 'monthly', '02:02:10', 'its another monthly job');
INSERT INTO `today` VALUES ('14', 'yearly', '00:23:00', 'happy new year');
INSERT INTO `today` VALUES ('15', 'yearly', '07:23:21', 'heeeee');
INSERT INTO `weakly` VALUES ('1', '2010-12-19', '10:24:07', 'thi_s-weak1');
INSERT INTO `weakly` VALUES ('2', '2010-12-31', '03:24:27', 'thi_s-weak2');
INSERT INTO `yearly` VALUES ('1', '12-19', '00:23:00', 'happy new year');
INSERT INTO `yearly` VALUES ('2', '12-19', '07:23:21', 'heeeee');
INSERT INTO `yearly` VALUES ('3', '02-01', '00:00:00', 'secod day of year');
