/*
Navicat MySQL Data Transfer

Source Server         : minic
Source Server Version : 50524
Source Host           : localhost:3306
Source Database       : etl

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2016-06-18 20:29:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `username` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('a', null, null, 'a');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` varchar(255) NOT NULL,
  `cIntro` varchar(255) DEFAULT NULL,
  `cName` varchar(255) DEFAULT NULL,
  `credits` varchar(255) DEFAULT NULL,
  `chief` varchar(255) DEFAULT NULL,
  `gName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('0101', null, '文化阅读与沟通Ⅰ', null, null, '文化阅读与沟通');
INSERT INTO `course` VALUES ('0102', null, '文化阅读与沟通Ⅱ', null, null, '文化阅读与沟通');

-- ----------------------------
-- Table structure for coursegroup
-- ----------------------------
DROP TABLE IF EXISTS `coursegroup`;
CREATE TABLE `coursegroup` (
  `id` varchar(255) NOT NULL,
  `gName` varchar(255) DEFAULT NULL,
  `urlNames` varchar(255) DEFAULT NULL,
  `urls` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coursegroup
-- ----------------------------
INSERT INTO `coursegroup` VALUES ('01', '文化阅读与沟通', '测试;', 'www.baidu.com;');
INSERT INTO `coursegroup` VALUES ('02', 'af', null, null);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `_content` varchar(255) DEFAULT NULL,
  `_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `_title` varchar(255) DEFAULT NULL,
  `publishRole` int(11) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', 'News1', '2016-03-08 00:00:00', 'news1', '0', 'wy');
INSERT INTO `news` VALUES ('2', 'News2', '2016-03-14 00:00:00', 'News2', '0', 'wy');
INSERT INTO `news` VALUES ('3', 'News3', '2016-03-14 00:00:00', 'News3', '0', 'wy');
INSERT INTO `news` VALUES ('4', 'News4', '2016-03-14 00:00:00', 'News4', '0', 'wy');
INSERT INTO `news` VALUES ('7', 'post6', null, 'post6', '0', null);

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `cId` int(11) NOT NULL,
  `_content` varchar(255) DEFAULT NULL,
  `_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `_title` varchar(255) DEFAULT NULL,
  `publishRole` int(11) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `toPerson` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '1', 'post1', '2016-03-14 00:00:00', 'post1', '0', 'wy', '');
INSERT INTO `post` VALUES ('2', '1', 'post2', '2016-03-14 00:00:00', 'post2', '0', 'wy', '');
INSERT INTO `post` VALUES ('3', '1', 'post3', '2016-03-14 00:00:00', 'post3', '0', 'wy', '');
INSERT INTO `post` VALUES ('4', '1', 'post4', '2016-03-14 00:00:00', 'post4', '0', 'wy', '');
INSERT INTO `post` VALUES ('5', '1', 'post5', '2016-03-14 00:00:00', 'post5', '0', 'wy', '');
INSERT INTO `post` VALUES ('6', '0', 'post6', null, 'post6', '0', null, null);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `username` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('s', null, null, 's');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `username` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `intro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('t', null, null, 't', null);

-- ----------------------------
-- Table structure for unit
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit` (
  `id` int(11) NOT NULL,
  `uIntro` varchar(255) DEFAULT NULL,
  `uName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of unit
-- ----------------------------
