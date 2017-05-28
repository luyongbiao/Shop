/*
Navicat MySQL Data Transfer

Source Server         : naive
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : shopping

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-05-28 16:46:20
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
  `adminGender` varchar(2) NOT NULL,
  `adminMobilePhone` varchar(11) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('3', '超级管理员', '9879898', '女', '45783478');
INSERT INTO `admin` VALUES ('4', '1', '1', '男', '1');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cartId` int(11) NOT NULL AUTO_INCREMENT,
  `cartCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `customerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`cartId`),
  KEY `cart_ibfk_1` (`customerId`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('1', '2017-05-26 22:53:54', '1');

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
  `goodsStatus` int(11) NOT NULL,
  PRIMARY KEY (`cartDetailId`),
  KEY `cartdetail_ibfk_1` (`goodsId`),
  KEY `cartdetail_ibfk_2` (`cartId`),
  CONSTRAINT `cartdetail_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`goodsId`),
  CONSTRAINT `cartdetail_ibfk_2` FOREIGN KEY (`cartId`) REFERENCES `cart` (`cartId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cartdetail
-- ----------------------------
INSERT INTO `cartdetail` VALUES ('1', '1006', '1', '1', '15', '1');

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

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(20) NOT NULL,
  `customerPassword` varchar(20) NOT NULL,
  `customerGender` varchar(2) NOT NULL,
  `customerAge` int(11) DEFAULT NULL,
  `customerAddress` varchar(100) NOT NULL,
  `custoemrMobilePhone` varchar(11) NOT NULL,
  `customerHomePhone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '大多数', '2', '男', '1', '1', '1', '1');
INSERT INTO `customer` VALUES ('2', '大人', '4', '女', '1', '2', '2', '1');
INSERT INTO `customer` VALUES ('8', '不少人', '13233211', '女', '11', '广东高州', 'dfdsllfsld', '54354354354');
INSERT INTO `customer` VALUES ('23', '1', '1', 'M', '1', '', '1', '1');

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
  `goodsPic` text NOT NULL,
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=4029 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1001', '苹果', '10', '1000', '洛川苹果 陕西红富士苹果  约14.5斤 40枚', '2017-05-25 10:58:07', '0', '2', 'image/fruit/apple.jpg');
INSERT INTO `goods` VALUES ('1002', '梨子', '11', '1000', '新疆库尔勒精选香梨1kg', '2017-05-15 20:30:40', '0', '1', 'image/fruit/pear.jpg');
INSERT INTO `goods` VALUES ('1003', '奇异果', '12', '1000', 'Zespri佳沛新西兰阳光金奇异果6个', '2017-05-15 20:30:47', '0', '0', 'image/fruit/kiwi.jpg');
INSERT INTO `goods` VALUES ('1004', '柠檬', '13', '1000', '四川优选黄柠檬4个约80g/个', '2017-05-15 20:30:53', '0', '0', 'image/fruit/lemon.jpg');
INSERT INTO `goods` VALUES ('1005', '橙', '14', '1000', '湖北伦晚脐橙1kg约140g/个橙子', '2017-05-15 20:31:03', '0', '0', 'image/fruit/orange.jpg');
INSERT INTO `goods` VALUES ('1006', '芒果', '15', '1000', '海南小台农芒果1kg 新鲜水果', '2017-05-15 20:31:10', '0', '0', 'image/fruit/mango.jpg');
INSERT INTO `goods` VALUES ('2001', '曲奇', '80', '1000', '卜珂蔓越莓黄油曲奇饼干200g*5美食糕点心零食', '2017-05-15 20:33:17', '0', '0', 'image/snacks/cookies.jpg');
INSERT INTO `goods` VALUES ('2002', '核桃', '24', '1000', '西域美农新疆薄皮核桃250g非纸皮核桃坚果炒货', '2017-05-15 20:33:26', '0', '0', 'image/snacks/nut.jpg');
INSERT INTO `goods` VALUES ('2003', '豆干', '75', '1000', '徽家铺子素肉豆干三明治麻辣味超值组合装750g', '2017-05-15 20:59:55', '0', '0', 'image/snacks/tufo.jpg');
INSERT INTO `goods` VALUES ('2004', '核桃', '23', '1000', '新疆薄皮核桃250g非纸皮核桃坚果炒货', '2017-05-21 14:24:54', '0', '0', 'image/snacks/nut.jpg');
INSERT INTO `goods` VALUES ('2005', '棒棒糖', '25', '1000', '不二家果味棒棒糖 儿童糖果零食喜糖', '2017-05-25 12:52:59', '0', '0', 'image/snacks/lollipop.jpg');
INSERT INTO `goods` VALUES ('2006', '大白兔原味奶糖', '27', '1000', '大白兔 原味奶糖454g/袋 童年的味道', '2017-05-23 22:25:37', '0', '0', 'image/snacks/rabbit.jpg');
INSERT INTO `goods` VALUES ('3001', '牛排', '40', '1000', '澳洲小公牛嫩肩牛排200g(2片) 原切牛排', '2017-05-15 21:08:31', '0', '0', 'image/meat/steak.jpg');
INSERT INTO `goods` VALUES ('3002', '牛腩', '40', '1000', '澳洲精选S级牛腩块500g', '2017-05-23 22:24:15', '0', '0', 'image/meat/sirloin.jpg');
INSERT INTO `goods` VALUES ('3003', '牛腩1', '40', '1000', '澳洲精选S级牛腩块500g', '2017-05-23 22:24:19', '0', '0', 'image/meat/sirloin.jpg');
INSERT INTO `goods` VALUES ('3004', '牛排', '44', '1000', '澳洲小公牛嫩肩牛排200g(2片) 原切牛排', '2017-05-15 22:40:56', '0', '0', 'image/meat/steak.jpg');
INSERT INTO `goods` VALUES ('3005', '肥牛', '39', '1000', '澳洲肥牛卷350g 火锅食材', '2017-05-21 14:21:28', '0', '0', 'image/meat/beefFat.jpg');
INSERT INTO `goods` VALUES ('3006', '肥牛1', '38', '1000', '澳洲肥牛卷350g 火锅食材', '2017-05-21 14:23:47', '0', '0', 'image/meat/beefFat.jpg');
INSERT INTO `goods` VALUES ('3007', '猪脊骨', '10', '1000', '丹麦皇冠猪净脊骨段400g', '2017-05-21 14:29:51', '0', '0', 'image/meat/bone.jpg');
INSERT INTO `goods` VALUES ('3008', '牛肉片', '25', '1000', '科尔沁澳洲牛肉片150g', '2017-05-21 14:32:04', '0', '0', 'image/meat/slices.jpg');
INSERT INTO `goods` VALUES ('3009', '牛肋骨', '35', '1000', '伊赛西门塔尔牛肋排段500g牛肉', '2017-05-21 14:35:07', '0', '0', 'image/meat/cattleBone.jpg');
INSERT INTO `goods` VALUES ('4001', '从你的全世界路过', '25', '200', '从你的全世界路过 作者张嘉佳 青春励志文学畅销书籍', '2017-05-25 12:51:53', '0', '0', 'image/book/book1.jpg');
INSERT INTO `goods` VALUES ('4002', '解忧杂货店', '27', '100', '解忧杂货店 文学救赎励志心理学读物', '2017-05-25 12:51:04', '0', '0', 'image/book/book2.jpg');
INSERT INTO `goods` VALUES ('4003', '小王子', '16', '100', '小王子 中文版 外国小说', '2017-05-25 12:50:41', '0', '0', 'image/book/book3.jpg');
INSERT INTO `goods` VALUES ('4004', '摆渡人', '17', '100', '摆渡人 现代当代外国读物散文随笔畅销书', '2017-05-25 12:53:34', '0', '0', 'image/book/book4.jpg');
INSERT INTO `goods` VALUES ('4005', '给孩子读诗', '40', '100', '给孩子读诗 《朗读者读给孩子的诗散文', '2017-05-25 12:49:34', '0', '0', 'image/book/book5.jpg');
INSERT INTO `goods` VALUES ('4007', '洗衣液', '89', '1000', '蓝月亮洗衣液 自然清香 深层洁净衣物护理 1kg/瓶装', '2017-05-21 14:21:28', '1', '1', 'image/clean/blueMoon.jpg');
INSERT INTO `goods` VALUES ('4008', '洗洁精', '11', '1000', '立白柠檬去油洗洁精1.5kg瓶装不伤手食品用蔬果净', '2017-05-21 14:21:28', '1', '1', 'image/clean/libai.jpg');
INSERT INTO `goods` VALUES ('4009', '百洁布', '11', '1000', '海绵百洁擦抹布洗碗布 8片特惠装 油污专用吸水', '2017-05-21 14:21:28', '1', '1', 'image/clean/miaojie.jpg');
INSERT INTO `goods` VALUES ('4010', '蚊香', '11', '1000', '榄菊 无烟型蚊香40盘/盒送蚊香座 盘香防蚊驱蚊', '2017-05-21 14:21:28', '1', '1', 'image/clean/wenxiang.jpg');
INSERT INTO `goods` VALUES ('4011', '洗衣皂液', '29', '1000', '妈妈壹选 一次漂清洗护合一天然洗衣皂液倍柔清香1kg', '2017-05-25 10:40:36', '1', '1', 'image/clean/soap.jpg');
INSERT INTO `goods` VALUES ('4012', '消毒液', '66', '1000', '威露士衣物家居除菌消毒液3x1L送3支60ml合计3.18L', '2017-05-25 10:40:49', '1', '1', 'image/clean/disinfectant.jpg');
INSERT INTO `goods` VALUES ('4013', '软包抽纸', '15', '1000', '维达超韧系列软包抽纸3层130抽6包面巾纸 小幅纸巾', '2017-05-25 11:12:28', '1', '1', 'image/paper/weida.jpg');
INSERT INTO `goods` VALUES ('4014', '芯卷纸', '51', '1000', '维达蓝色经典系列卫生纸巾3层140g27卷有芯卷纸 箱装', '2017-05-25 11:12:31', '1', '1', 'image/paper/weida2.jpg');
INSERT INTO `goods` VALUES ('4015', '手帕纸', '28', '1000', '维达 超韧系列手帕纸 4层8张60包纸巾（无香型）', '2017-05-25 11:12:34', '1', '1', 'image/paper/weida3.jpg');
INSERT INTO `goods` VALUES ('4016', '手帕纸', '27', '1000', '得宝手帕纸4层加厚7张36包 天然无香 无纸屑有品位', '2017-05-25 11:12:38', '1', '1', 'image/paper/tempo.jpg');
INSERT INTO `goods` VALUES ('4017', '抽纸', '59.9', '1000', '清风抽纸 原木金装3层140抽*24包中规面纸巾整箱', '2017-05-25 11:12:41', '1', '1', 'image/paper/qingfeng.jpg');
INSERT INTO `goods` VALUES ('4018', '湿厕纸', '38.9', '1000', '维达湿厕纸40片/包*3包 无纺布可冲入马桶 杀菌洁肤', '2017-05-25 11:17:48', '1', '1', 'image/clean/toiletPaper.jpg');
INSERT INTO `goods` VALUES ('4019', '厨房纸巾', '12.9', '1000', '五月花厨房纸巾3卷*120张 厨房专用 吸油吸水超值', '2017-05-25 11:17:53', '1', '1', 'image/clean/paper.jpg');
INSERT INTO `goods` VALUES ('4020', '厨房纸巾', '16.9', '1000', '洁柔厨房用纸 天然无香吸油吸水料理纸巾2层2卷纸巾', '2017-05-25 12:28:31', '1', '1', 'image/clean/paper2.jpg');
INSERT INTO `goods` VALUES ('4021', '洁面乳', '78.9', '1000', '加拿大进口Cetaphil/丝塔芙洁面乳473ml洗面奶家庭装', '2017-05-25 12:29:34', '1', '1', 'image/facial/cetaphil.jpg');
INSERT INTO `goods` VALUES ('4022', '黑人牙膏', '13.8', '1000', '黑人牙膏双重薄荷225g去口臭清新口气防蛀天然正品', '2017-05-21 14:21:28', '1', '1', 'image/paper/toothpaste1.jpg');
INSERT INTO `goods` VALUES ('4023', '儿童牙膏', '10.9', '1000', '德国进口el-c儿童牙膏6-12岁换牙期防蛀低泡75ml90克', '2017-05-25 21:16:38', '1', '1', 'image/paper/toothpaste2.jpg');
INSERT INTO `goods` VALUES ('4024', '佳洁士牙膏', '11.9', '1000', '佳洁士牙膏 3D炫白去牙渍美白晨露荷香清新口气180g', '2017-05-21 14:21:28', '1', '1', 'image/paper/toothpaste3.jpg');
INSERT INTO `goods` VALUES ('4025', '黑人牙膏', '13.9', '1000', '黑人牙膏茶倍健190g持久清新口气固齿防蛀去除牙菌斑', '2017-05-21 14:21:28', '1', '1', 'image/paper/toothpaste4.jpg');
INSERT INTO `goods` VALUES ('4026', '纯棉毛巾', '49', '1000', '孚日洁玉纯棉毛巾4条装成人洗脸全棉柔软吸水面巾', '2017-05-21 14:21:28', '1', '1', 'image/paper/towel1.jpg');
INSERT INTO `goods` VALUES ('4027', '毛巾', '10.9', '1000', '金号毛巾 纯棉无捻纱条纹情侣 加厚柔软面巾一条装', '2017-05-25 12:37:13', '1', '1', 'image/paper/towel2.jpg');
INSERT INTO `goods` VALUES ('4028', '儿童毛巾', '7.9', '1000', '洁丽雅纯棉可爱小熊儿童毛巾1条 健康童巾毛巾', '2017-05-25 12:38:03', '1', '1', 'image/paper/towel3.jpg');

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
) ENGINE=InnoDB AUTO_INCREMENT=33037 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordersdetail
-- ----------------------------

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
