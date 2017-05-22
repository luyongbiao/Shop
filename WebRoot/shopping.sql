/*
Navicat MySQL Data Transfer

Source Server         : naive
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : shopping

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-05-11 23:51:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(15) NOT NULL,
  `adminPassword` varchar(20) NOT NULL,
  `adminGendar` varchar(2) NOT NULL,
  `adminMobilePhone` varchar(11) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('3', '超级管理员', '9879898', '女', '45783478');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cartId` int(11) NOT NULL AUTO_INCREMENT,
  `cartCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `cartStatus` varchar(2) NOT NULL,
  `customerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`cartId`),
  KEY `cart_ibfk_1` (`customerId`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('1', '2017-05-09 14:31:15', '2', '2');

-- ----------------------------
-- Table structure for cartdetail
-- ----------------------------
DROP TABLE IF EXISTS `cartdetail`;
CREATE TABLE `cartdetail` (
  `cartDetailId` int(11) NOT NULL AUTO_INCREMENT,
  `goodsId` int(11) DEFAULT NULL,
  `cartId` int(11) DEFAULT NULL,
  `goodsCount` int(11) NOT NULL,
  `totalPrice` double(11,0) NOT NULL,
  PRIMARY KEY (`cartDetailId`),
  KEY `cartdetail_ibfk_1` (`goodsId`),
  KEY `cartdetail_ibfk_2` (`cartId`),
  CONSTRAINT `cartdetail_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`goodsId`),
  CONSTRAINT `cartdetail_ibfk_2` FOREIGN KEY (`cartId`) REFERENCES `cart` (`cartId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cartdetail
-- ----------------------------
INSERT INTO `cartdetail` VALUES ('1', '4', '1', '100', '10000');
INSERT INTO `cartdetail` VALUES ('4', '4', '1', '10000', '15');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('4', '电子产品', '1', '用电的产品 抵抗力官方进口量的撒飞机哦诶哦日哦耳温计偶然看了未考虑加入刻录机');
INSERT INTO `category` VALUES ('5', '电子产品', '1', '用电的产品 抵抗力官方进口量的撒飞机哦诶哦日哦耳温计偶然看了未考虑加入刻录机');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(20) NOT NULL,
  `customerPassword` varchar(20) NOT NULL,
  `customerGendar` varchar(2) NOT NULL,
  `customerAge` int(11) DEFAULT NULL,
  `customerAddress` varchar(100) NOT NULL,
  `custoemrMobilePhone` varchar(11) NOT NULL,
  `customerHomePhone` varchar(11) DEFAULT NULL,
  `vipId` int(11) NOT NULL,
  PRIMARY KEY (`customerId`),
  KEY `customer_ibfk_1` (`vipId`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`vipId`) REFERENCES `vip` (`vipId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '大多数', '2', '男', '1', '1', '1', '1', '1');
INSERT INTO `customer` VALUES ('2', '大人', '4', '女', '1', '2', '2', '1', '1');
INSERT INTO `customer` VALUES ('8', '不少人', '13233211', '女', '11', '广东高州', 'dfdsllfsld', '54354354354', '1');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` int(11) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(20) NOT NULL,
  `goodsPrice` double NOT NULL,
  `goodsStock` int(11) NOT NULL,
  `goodsDesc` text,
  `goodsShelfTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `goodsHits` bigint(20) NOT NULL,
  `goodsSales` bigint(20) NOT NULL,
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('4', '手机', '5000', '100', '的牢房里的', '2017-05-09 14:01:36', '1', '0');

-- ----------------------------
-- Table structure for goodscategory
-- ----------------------------
DROP TABLE IF EXISTS `goodscategory`;
CREATE TABLE `goodscategory` (
  `goodsCategoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  PRIMARY KEY (`goodsCategoryId`),
  KEY `goodscategory_ibfk_1` (`categoryId`),
  KEY `goodscategory_ibfk_2` (`goodsId`),
  CONSTRAINT `goodscategory_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `category` (`categoryId`),
  CONSTRAINT `goodscategory_ibfk_2` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodscategory
-- ----------------------------
INSERT INTO `goodscategory` VALUES ('1', '4', '4');
INSERT INTO `goodscategory` VALUES ('2', '4', '4');
INSERT INTO `goodscategory` VALUES ('3', '4', '4');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ordersId` int(11) NOT NULL AUTO_INCREMENT,
  `ordersNote` varchar(100) DEFAULT NULL,
  `ordersCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ordersPayTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `ordersStatusId` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ordersId`),
  KEY `orders_ibfk_1` (`ordersStatusId`),
  KEY `orders_ibfk_２` (`customerId`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`ordersStatusId`) REFERENCES `ordersstatus` (`ordersStatusId`),
  CONSTRAINT `orders_ibfk_２` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '国通快递', '2017-05-09 15:34:21', '2017-05-09 15:34:21', '2', '2');
INSERT INTO `orders` VALUES ('4', '圆通快递', '2017-05-09 15:31:31', '2017-05-09 15:31:31', '1', '8');

-- ----------------------------
-- Table structure for ordersdetail
-- ----------------------------
DROP TABLE IF EXISTS `ordersdetail`;
CREATE TABLE `ordersdetail` (
  `ordersDetailId` int(11) NOT NULL AUTO_INCREMENT,
  `ordersId` int(11) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `goodsCount` int(11) NOT NULL,
  `totalPrice` double(11,0) NOT NULL,
  PRIMARY KEY (`ordersDetailId`),
  KEY `ordersdetail_ibfk_1` (`ordersId`),
  KEY `ordersdetail_jbfk_2` (`goodsId`),
  CONSTRAINT `ordersdetail_ibfk_1` FOREIGN KEY (`ordersId`) REFERENCES `orders` (`ordersId`),
  CONSTRAINT `ordersdetail_jbfk_2` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordersdetail
-- ----------------------------
INSERT INTO `ordersdetail` VALUES ('3', '4', '4', '200', '1000');
INSERT INTO `ordersdetail` VALUES ('4', '1', '4', '2', '10');

-- ----------------------------
-- Table structure for ordersstatus
-- ----------------------------
DROP TABLE IF EXISTS `ordersstatus`;
CREATE TABLE `ordersstatus` (
  `ordersStatusId` int(11) NOT NULL AUTO_INCREMENT,
  `ordersStatusName` varchar(20) NOT NULL,
  PRIMARY KEY (`ordersStatusId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordersstatus
-- ----------------------------
INSERT INTO `ordersstatus` VALUES ('1', '1');
INSERT INTO `ordersstatus` VALUES ('2', '2');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `pictureId` int(11) NOT NULL AUTO_INCREMENT,
  `pictureName` varchar(50) NOT NULL,
  `picturePath` varchar(250) NOT NULL,
  `goodsId` int(11) DEFAULT NULL,
  PRIMARY KEY (`pictureId`),
  KEY `picture_ibfk_1` (`goodsId`),
  CONSTRAINT `picture_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`goodsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picture
-- ----------------------------

-- ----------------------------
-- Table structure for vip
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip` (
  `vipId` int(11) NOT NULL AUTO_INCREMENT,
  `vipName` varchar(20) NOT NULL,
  PRIMARY KEY (`vipId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vip
-- ----------------------------
INSERT INTO `vip` VALUES ('1', '1');
INSERT INTO `vip` VALUES ('2', '2');
