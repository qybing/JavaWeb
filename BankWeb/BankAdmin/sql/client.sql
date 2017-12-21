/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-21 17:15:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `client`
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `client_id` varchar(50) DEFAULT NULL,
  `client_ps` varchar(20) DEFAULT NULL,
  `client_name` varchar(20) DEFAULT NULL,
  `client_phone` varchar(20) DEFAULT NULL,
  `client_money` double(20,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('1', 'client1', 'client1', '张三', '1111', '-10000');
INSERT INTO `client` VALUES ('2', 'client2', 'client2', '李四', '2222', '0');
INSERT INTO `client` VALUES ('3', 'client3', 'client3', '张小三', '3333', '1000');
INSERT INTO `client` VALUES ('4', 'client4', 'client4', '张大三', '4444', '1000');
INSERT INTO `client` VALUES ('5', '1', '1', '1', '1', '1');
INSERT INTO `client` VALUES ('6', '2', '2', '2', '2', '2');
INSERT INTO `client` VALUES ('7', '3', '3', '3', '3', '3');
