/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : flyme

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-03-14 15:06:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(300) DEFAULT NULL COMMENT '用户名',
  `password` varchar(300) DEFAULT NULL COMMENT '密码',
  `age` int(10) unsigned zerofill DEFAULT NULL COMMENT '年龄',
  `cell_phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `is_del` tinyint(3) unsigned zerofill DEFAULT '000',
  `cost` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zxf', '1123', '0000000025', '15201143124', '000', '0.00');
