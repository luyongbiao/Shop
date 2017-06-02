/*
Navicat MySQL Data Transfer

Source Server         : Eric
Source Server Version : 50552
Source Host           : localhost:3306
Source Database       : shopping

Target Server Type    : MYSQL
Target Server Version : 50552
File Encoding         : 65001

Date: 2017-06-02 23:01:39
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=33038 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodscategory
-- ----------------------------
INSERT INTO `goodscategory` VALUES ('11001', '1', '1001');
INSERT INTO `goodscategory` VALUES ('11002', '1', '1002');
INSERT INTO `goodscategory` VALUES ('11003', '1', '1003');
INSERT INTO `goodscategory` VALUES ('11004', '1', '1004');
INSERT INTO `goodscategory` VALUES ('11005', '1', '1005');
INSERT INTO `goodscategory` VALUES ('11006', '1', '1006');
INSERT INTO `goodscategory` VALUES ('22001', '2', '2001');
INSERT INTO `goodscategory` VALUES ('22002', '2', '2002');
INSERT INTO `goodscategory` VALUES ('22003', '2', '2003');
INSERT INTO `goodscategory` VALUES ('22004', '2', '2004');
INSERT INTO `goodscategory` VALUES ('22005', '2', '2005');
INSERT INTO `goodscategory` VALUES ('22006', '2', '2006');
INSERT INTO `goodscategory` VALUES ('33001', '3', '3001');
INSERT INTO `goodscategory` VALUES ('33002', '3', '3002');
INSERT INTO `goodscategory` VALUES ('33003', '3', '3003');
INSERT INTO `goodscategory` VALUES ('33004', '3', '3004');
INSERT INTO `goodscategory` VALUES ('33005', '3', '3005');
INSERT INTO `goodscategory` VALUES ('33006', '3', '3006');
INSERT INTO `goodscategory` VALUES ('33007', '3', '3007');
INSERT INTO `goodscategory` VALUES ('33008', '3', '3008');
INSERT INTO `goodscategory` VALUES ('33009', '3', '3009');
INSERT INTO `goodscategory` VALUES ('33010', '7', '4007');
INSERT INTO `goodscategory` VALUES ('33011', '7', '4008');
INSERT INTO `goodscategory` VALUES ('33012', '7', '4009');
INSERT INTO `goodscategory` VALUES ('33013', '7', '4010');
INSERT INTO `goodscategory` VALUES ('33014', '7', '4011');
INSERT INTO `goodscategory` VALUES ('33015', '7', '4012');
INSERT INTO `goodscategory` VALUES ('33016', '5', '4013');
INSERT INTO `goodscategory` VALUES ('33017', '5', '4014');
INSERT INTO `goodscategory` VALUES ('33018', '5', '4015');
INSERT INTO `goodscategory` VALUES ('33019', '5', '4016');
INSERT INTO `goodscategory` VALUES ('33020', '5', '4017');
INSERT INTO `goodscategory` VALUES ('33021', '4', '4001');
INSERT INTO `goodscategory` VALUES ('33022', '4', '4002');
INSERT INTO `goodscategory` VALUES ('33023', '4', '4003');
INSERT INTO `goodscategory` VALUES ('33024', '4', '4004');
INSERT INTO `goodscategory` VALUES ('33025', '4', '4005');
INSERT INTO `goodscategory` VALUES ('33026', '7', '4018');
INSERT INTO `goodscategory` VALUES ('33027', '7', '4019');
INSERT INTO `goodscategory` VALUES ('33028', '7', '4020');
INSERT INTO `goodscategory` VALUES ('33029', '9', '4021');
INSERT INTO `goodscategory` VALUES ('33030', '5', '4022');
INSERT INTO `goodscategory` VALUES ('33031', '5', '4023');
INSERT INTO `goodscategory` VALUES ('33032', '5', '4024');
INSERT INTO `goodscategory` VALUES ('33033', '5', '4025');
INSERT INTO `goodscategory` VALUES ('33034', '5', '4026');
INSERT INTO `goodscategory` VALUES ('33035', '5', '4027');
INSERT INTO `goodscategory` VALUES ('33036', '5', '4028');
INSERT INTO `goodscategory` VALUES ('33037', '2', '4029');
