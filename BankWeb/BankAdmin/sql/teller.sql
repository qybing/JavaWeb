/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-12-21 00:58:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for teller
-- ----------------------------
DROP TABLE IF EXISTS `teller`;
CREATE TABLE `teller` (
  `teller_id` varchar(30) NOT NULL,
  `teller_name` varchar(10) NOT NULL,
  `teller_ps` varchar(10) NOT NULL,
  `subbank_id` varchar(10) NOT NULL,
  PRIMARY KEY (`teller_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teller
-- ----------------------------
INSERT INTO `teller` VALUES ('1', '张三', '1', '1');
SET FOREIGN_KEY_CHECKS=1;
