/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-12-21 00:57:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `client_id` varchar(50) NOT NULL,
  `client_ps` varchar(20) DEFAULT NULL,
  `client_name` varchar(20) DEFAULT NULL,
  `client_phone` varchar(20) DEFAULT NULL,
  `client_money` double(20,0) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('client1', 'client1', '张三', '1111', '-8000');
INSERT INTO `client` VALUES ('client2', 'client2', '李四', '2222', '7000');
INSERT INTO `client` VALUES ('client3', 'client3', '张小三', '3333', '1000');
INSERT INTO `client` VALUES ('client4', 'client4', '张大三', '4444', '1000');
SET FOREIGN_KEY_CHECKS=1;
