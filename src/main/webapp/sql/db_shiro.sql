/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : db_shiro

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-09-22 18:03:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` varchar(40) NOT NULL,
  `permitNo` varchar(50) DEFAULT NULL,
  `permitName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', 'user:*', '用户操作权限');
INSERT INTO `t_permission` VALUES ('2', 'user:view', '查看');
INSERT INTO `t_permission` VALUES ('3', 'user:edit', '修改');
INSERT INTO `t_permission` VALUES ('4', 'user:del', '删除');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(20) DEFAULT NULL,
  `roleNo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '超级管理员', 'admin');
INSERT INTO `t_role` VALUES ('2', '一般用户', 'employee');

-- ----------------------------
-- Table structure for `t_role_permit`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permit`;
CREATE TABLE `t_role_permit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` varchar(50) DEFAULT NULL,
  `permissionId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permit
-- ----------------------------
INSERT INTO `t_role_permit` VALUES ('1', '1', '1');
INSERT INTO `t_role_permit` VALUES ('2', '2', '2');
INSERT INTO `t_role_permit` VALUES ('3', '1', '3');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '123', '1');
INSERT INTO `t_user` VALUES ('2', 'jack', '123', '2');
INSERT INTO `t_user` VALUES ('3', 'marry', '234', '2');
INSERT INTO `t_user` VALUES ('4', 'json', '345', '2');
