/*
Navicat MySQL Data Transfer

Source Server         : Eric
Source Server Version : 50552
Source Host           : localhost:3306
Source Database       : shopping

Target Server Type    : MYSQL
Target Server Version : 50552
File Encoding         : 65001

Date: 2017-06-02 23:01:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(30) NOT NULL,
  `categoryLevel` int(11) NOT NULL,
  `categoryDesc` text,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'fruit', '1', '水果蔬菜');
INSERT INTO `category` VALUES ('2', '饼干零食', '1', '饼干零食');
INSERT INTO `category` VALUES ('3', '新鲜肉类', '1', '新鲜肉类');
INSERT INTO `category` VALUES ('4', '图书音像', '1', '图书音像');
INSERT INTO `category` VALUES ('5', '纸巾洗漱', '1', '纸巾洗漱');
INSERT INTO `category` VALUES ('6', '淋浴用品', '1', '淋浴用品');
INSERT INTO `category` VALUES ('7', '清洁用品', '1', '清洁用品');
INSERT INTO `category` VALUES ('8', '电子电器', '1', '电子电器');
INSERT INTO `category` VALUES ('9', '美容洗护', '1', '美容洗护');
