/*
Navicat MySQL Data Transfer

Source Server         : Database
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : shoppingonline

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2016-12-18 21:43:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'admin', '123456', 'lam thai binh', 'ltb0374@gmail.com', 'staff');
INSERT INTO `account` VALUES ('2', 'haiph', '123', 'Pham Hoang Hai', ' haiph.ssc@gmail.com', 'staff');
INSERT INTO `account` VALUES ('79', 'ititiu12002', '081194', 'test', 'test', 'customer');
INSERT INTO `account` VALUES ('80', 'haiph0811', 'ititiu12002', 'HaiPham Hoang', 'haiph.ssc@gmail.com', 'customer');
INSERT INTO `account` VALUES ('82', 'Do', 'dodo', 'Do Ding Dong', 'dingdodo@gmail.com', 'customer');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_customer` int(11) DEFAULT NULL,
  `price_sum` double(255,0) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `date_delivery` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('15', '79', '685', '288 E1 Nam Ky Khoi Nghia', '13/5/2016', '0', '01225950558');
INSERT INTO `cart` VALUES ('16', '79', '255', 'Luna Mars Sun', '13/5/2016', '1', '041142244');
INSERT INTO `cart` VALUES ('17', '79', '1056', 'Sun ', '13/5/2016', '1', '092929292');
INSERT INTO `cart` VALUES ('18', '79', '805', 'sjsjsjs', '13/5/2016', '1', 'sjsjsjs');
INSERT INTO `cart` VALUES ('19', '79', '468', 'ssss', '13/5/2016', '1', 'sssss');
INSERT INTO `cart` VALUES ('20', '79', '896', 'q7', '13/5/2016', '1', '02939192');
INSERT INTO `cart` VALUES ('21', '2', '841', '238/31 Bach Dang P.24 Q.BT', '14/5/2016', '1', '12252');
INSERT INTO `cart` VALUES ('22', '2', '1026', '230 ly te xuyen, thu duc', '16/12/2016', '1', '0944114367');

-- ----------------------------
-- Table structure for cart_detail
-- ----------------------------
DROP TABLE IF EXISTS `cart_detail`;
CREATE TABLE `cart_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cart_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` double(11,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart_detail
-- ----------------------------
INSERT INTO `cart_detail` VALUES ('1', '12', '1', '1', '152');
INSERT INTO `cart_detail` VALUES ('4', '15', '2', '2', '430');
INSERT INTO `cart_detail` VALUES ('5', '15', '2', '2', '430');
INSERT INTO `cart_detail` VALUES ('6', '16', '3', '2', '240');
INSERT INTO `cart_detail` VALUES ('7', '17', '4', '1', '398');
INSERT INTO `cart_detail` VALUES ('8', '17', '4', '1', '398');
INSERT INTO `cart_detail` VALUES ('9', '17', '4', '1', '398');
INSERT INTO `cart_detail` VALUES ('10', '18', '3', '2', '240');
INSERT INTO `cart_detail` VALUES ('11', '18', '3', '2', '240');
INSERT INTO `cart_detail` VALUES ('12', '20', '3', '2', '240');
INSERT INTO `cart_detail` VALUES ('13', '20', '6', '2', '426');
INSERT INTO `cart_detail` VALUES ('14', '20', '2', '1', '215');
INSERT INTO `cart_detail` VALUES ('15', '21', '2', '1', '215');
INSERT INTO `cart_detail` VALUES ('16', '21', '4', '1', '398');
INSERT INTO `cart_detail` VALUES ('17', '21', '6', '1', '213');
INSERT INTO `cart_detail` VALUES ('18', '22', '4', '2', '796');
INSERT INTO `cart_detail` VALUES ('19', '22', '2', '1', '215');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Type` varchar(255) DEFAULT NULL,
  `Description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'sport', 'There is a wide selection available to meet the demands of an active lifestyle. Divers watches, also called Marine watches, are specially formulated to withstand the pressure of deep sea diving, reaching depths as great as 2000 meters. Most divers watches come with basic features including water resistance, a unidirectional rotating bezel (for timing the amount of oxygen you have left in your tank) and brilliant luminescence. Equally  ergonomic are the Pilot watches, also called Aviator watches. Specifically designed to meet the navigational needs of pilots, pilot watches are capable of performing all calculations a flight plan requires.');
INSERT INTO `category` VALUES ('2', 'luxury', 'Sometimes referred to as Haute Horlogerie, luxury watches are great for collectors and watch connoisseurs. Luxury watches are for those who appreciate expert watch movements and exquisite handcrafted complications that are encased in superior materials and precious gems.');
INSERT INTO `category` VALUES ('3', 'mechanical', 'A mechanical watch is a watch that uses a mechanical mechanism to measure the passage of time, as opposed to modern quartz watches which function electronically. It is driven by a spring (called a mainspring) which must be wound periodically. Its force is transmitted through a series of gears to power the balance wheel, a weighted wheel which oscillates back and forth at a constant rate. A device called an escapement releases the watch\'s wheels to move forward a small amount with each swing of the balance wheel, moving the watch\'s hands forward at a constant rate. This makes the \'ticking\' sound characteristic of all mechanical watches. Mechanical watches evolved in Europe in the 17th century from spring powered clocks, which appeared in the 15th century.');
INSERT INTO `category` VALUES ('4', 'smart', 'A smartwatch is a computerized wristwatch with functionality that is enhanced beyond timekeeping. While early models can perform basic tasks, such as calculations, translations, and game-playing, modern smartwatches are effectively wearable computers. Many run mobile apps, using a mobile operating system.');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `username` text,
  `content` text,
  `date` text,
  `idcmt` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`idcmt`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('Tri Nguyen', 'kskskssks', '2016-05-10 16:33:36', '4', '1');
INSERT INTO `comment` VALUES ('Tri Nguyen', 'kskskssks', '2016-05-10 16:33:36', '5', '1');
INSERT INTO `comment` VALUES ('null', 'Pham Hoang Hai', '2016-05-10 16:38:07', '6', '1');
INSERT INTO `comment` VALUES ('haiph', 'asdasdxxxx', '2016-05-10 18:38:21', '7', '1');
INSERT INTO `comment` VALUES ('haiph', 'dong ho nay qua dep ', '2016-05-10 19:04:51', '8', '2');
INSERT INTO `comment` VALUES ('haiph', 'adaasda', '2016-12-10 11:35:47', '9', '5');
INSERT INTO `comment` VALUES ('haiph', 'sasadasd', '2016-12-10 11:35:54', '10', '5');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `CategoryID` int(11) DEFAULT NULL,
  `Price` double(11,0) DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'Invicta Men\'s 8928OB Pro', '2', '152', '1');
INSERT INTO `product` VALUES ('2', 'Luxury Quartz Sport Military Stainless', '3', '215', '2');
INSERT INTO `product` VALUES ('3', 'Stainless Steel Luxury Sport Analog Quartz Modern', '1', '120', '18');
INSERT INTO `product` VALUES ('4', 'Apple Watch Sport, Space Grey Aluminum ', '4', '398', '4');
INSERT INTO `product` VALUES ('5', 'Samsung Galaxy Gear Smartwatch', '4', '329', '5');
INSERT INTO `product` VALUES ('6', 'Casio G-Shock GA110-1B', '1', '213', '6');
INSERT INTO `product` VALUES ('7', 'Casio GA1000-4A G-Aviation G-Shock', '1', '315', '7');
INSERT INTO `product` VALUES ('8', ' G-Shock Military Sand', '1', '215', '8');
INSERT INTO `product` VALUES ('9', 'SEIKO Automatic Diver’s Watch', '3', '550', '9');
INSERT INTO `product` VALUES ('10', 'Mens Steel Rolex Oyster Perpetual', '2', '3150', '10');
INSERT INTO `product` VALUES ('11', 'Rolex Submariner Black Dial Ceramic Bezel ', '2', '4200', '11');
INSERT INTO `product` VALUES ('12', 'Omega Deville Prestige Co', '3', '2100', '12');
INSERT INTO `product` VALUES ('13', 'Apple Smart Watch', '4', '465', '14');
INSERT INTO `product` VALUES ('14', 'Luxury Couple Watch', '3', '1200', '15');
INSERT INTO `product` VALUES ('15', 'Orient Luxury Watch', '3', '2152', '17');
INSERT INTO `product` VALUES ('16', 'XiangXao Pink Leather Watch', '2', '215', '13');
INSERT INTO `product` VALUES ('17', 'G-shock Grey Stand Watch', '1', '315', '22');
INSERT INTO `product` VALUES ('18', 'Rolex Hermless Stogery Watch', '3', '2100', '21');
INSERT INTO `product` VALUES ('19', 'Samsung Smart Watch', '4', '515', '23');
INSERT INTO `product` VALUES ('20', 'Standless Smart Watch', '4', '550', '24');
