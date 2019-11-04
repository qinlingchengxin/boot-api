/*
Navicat MySQL Data Transfer

Source Server         : 139-3306
Source Server Version : 50644
Source Host           : 10.40.40.139:3306
Source Database       : boot_api

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2019-11-04 16:02:02
*/

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `boot_api` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `boot_api`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '主键',
  `mag_type` int(2) NOT NULL DEFAULT '0' COMMENT '类型 0-普通管理员/1-超级管理员',
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `pwd` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='管理员表';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('dfde0f72-af48-40a9-8c27-2dd06627ee8b', '1', 'admin', 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `age` int(11) NOT NULL DEFAULT '0',
  `create_time` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'tom', '112', '1572845668000');
INSERT INTO `person` VALUES ('2', '23', '12', '1572845668000');
INSERT INTO `person` VALUES ('3', '34', '1', '0');
INSERT INTO `person` VALUES ('4', '45', '2', '0');
INSERT INTO `person` VALUES ('5', '56', '3', '0');
INSERT INTO `person` VALUES ('6', '667', '4', '0');
INSERT INTO `person` VALUES ('7', '6', '5', '0');
INSERT INTO `person` VALUES ('8', '6', '6', '0');
INSERT INTO `person` VALUES ('9', '6', '7', '0');
INSERT INTO `person` VALUES ('10', '6', '8', '0');
INSERT INTO `person` VALUES ('11', '6', '9', '0');
INSERT INTO `person` VALUES ('12', '6', '0', '0');
INSERT INTO `person` VALUES ('13', '6', '34', '0');
