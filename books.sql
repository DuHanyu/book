/*
Navicat MySQL Data Transfer

Source Server         : books
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : books

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2018-05-20 12:39:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `aid` int(12) NOT NULL AUTO_INCREMENT,
  `aname` varchar(128) DEFAULT NULL,
  `pwd` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'hgx', 'hgxhgx');

-- ----------------------------
-- Table structure for `t_book`
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `bid` int(12) NOT NULL AUTO_INCREMENT,
  `bname` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  `currPrice` decimal(8,2) DEFAULT NULL,
  `discount` decimal(3,2) DEFAULT NULL,
  `press` varchar(255) DEFAULT NULL,
  `publishtime` varchar(255) DEFAULT NULL,
  `edition` int(6) DEFAULT NULL,
  `pageNum` int(6) DEFAULT NULL,
  `wordNum` int(12) DEFAULT NULL,
  `printtime` varchar(255) DEFAULT NULL,
  `booksize` int(6) DEFAULT NULL,
  `paper` varchar(255) DEFAULT NULL,
  `cid` int(12) DEFAULT NULL,
  `image_w` varchar(255) DEFAULT NULL,
  `image_b` varchar(255) DEFAULT NULL,
  `orderBy` int(12) DEFAULT NULL,
  PRIMARY KEY (`bid`),
  KEY `bid_cid` (`cid`),
  CONSTRAINT `bid_cid` FOREIGN KEY (`cid`) REFERENCES `t_category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('16', '零基础学编程 c语言入门经典 计算机网络编程书籍数据结构算法javascript高级程序设计 ', '何亦琛，古万荣', '88.00', '69.50', '7.90', '电子工业出版社', '2013-6-1', '1', '374', '48700', '2013-6-1', '16', '胶版纸', '51', 'book_img/09f854c7-41dd-4de5-b0eb-b9f99747b742_25211517-1_w_3.jpg', 'book_img/8ff7bdb7-5793-471a-83a9-ca79f7c869a6_25211517-1_b_3.jpg', null);
INSERT INTO `t_book` VALUES ('17', ' C++程序设计语言（第1—3部分）（原书第4版） C++之父作品新版，无可替代的C++领域经典的参考书。介绍了C++11的各项新特性、功能等。', '本贾尼?斯特劳斯特鲁普', '59.00', '99.00', '5.90', '机械工业出版社', '2013-06-20', '1', '374', '48700', '2013-6-1', '16', '胶版纸', '51', 'book_img/ea57b8b2-b503-41ac-864d-d7bbfdc0acb0_23999167-1_w_6.jpg', 'book_img/a484016f-3cd0-462a-8a86-77823d73e811_23999167-1_b_6.jpg', null);
INSERT INTO `t_book` VALUES ('18', 'C程序设计（第五版） “十二五”普通高等教育本科*规划教材、北京市高等教育精品教材立项项目、全国高校出版社优秀畅销书特等奖。发行逾1400万册，堪称出版界的奇迹。', '谭浩强', '39.00', '30.00', '6.90', '清华大学出版社', '2018-06-13', '1', '500', '35000', '2013-6-1', '16', '胶版纸', '51', 'book_img/4b08f294-d572-4658-9c18-f4792c770e12_25155686-1_w_1.jpg', 'book_img/55ea8fbb-3508-4d04-ac72-0605eab76679_25155686-1_b_1.jpg', null);
INSERT INTO `t_book` VALUES ('19', ' C语言程序设计：现代方法（第2版）(被誉为“近10年来最好的一部C语言著作”) ', 'K. N. King 著', '79.00', '57.00', '7.20', '人民邮电出版社', '2018-06-19', '1', '300', '25000', '2018-06-13', '16', '胶版纸', '51', 'book_img/71050893-eef1-4120-9ec8-b92b4ce059e5_20801298-1_w_3.jpg', 'book_img/b0df0c07-752c-41af-b183-04d40860be68_20801298-1_b_0.jpg', null);
INSERT INTO `t_book` VALUES ('20', ' C语言程序设计与问题求解（原书第7版） 经典教材再度升级，完美平衡程序设计思想与C语言特性的教学，轻松掌握你的*门编程语言 ', '杰瑞 R. 汉丽', '59.00', '90.90', '6.90', '机械工业出版社', '2018-06-13', '1', '374', '48700', '2018-06-21', '16', '胶版纸', '51', 'book_img/ac8c968c-af96-4311-8c9d-1d3f4dd9a1bf_25079961-1_w_3.jpg', 'book_img/27d8b9f8-6c88-4ebb-a5a1-9a6656d53109_25079961-1_b_3.jpg', null);
INSERT INTO `t_book` VALUES ('21', ' C语言程序设计（第4版）英文版 ', 'Stephen G. Kochan（史蒂芬·G·寇肯）', '108.00', '85.00', '6.90', '电子工业出版社', '2018-06-14', '1', '374', '48700', '2018-06-06', '16', '胶版纸', '51', 'book_img/4b000ce8-2393-45fc-8d2c-0eeff1dd194a_23934479-1_w_9.jpg', 'book_img/409f2905-5cea-495d-b8e1-f4b91bcd9180_23934479-1_b_9.jpg', null);
INSERT INTO `t_book` VALUES ('22', 'C程序设计新思维 第2版 C语言程序设计经典教程 赵岩倾情翻译 ', 'Ben Klemens 克莱蒙', '47.00', '39.50', '5.00', '人民邮电出版社', '2018-01-01', '1', '374', '48700', '2018-01-11', '16', '胶版纸', '51', 'book_img/87a3b221-87f3-4414-b942-c463c9abd832_25210288-1_w_1.jpg', 'book_img/c1e24036-c2f3-4750-8f1b-2cc9ba3aeba6_25210288-1_b_1.jpg', null);
INSERT INTO `t_book` VALUES ('23', 'Java语言程序设计（基础篇）（原书第10版） Daniel Liang的经典著作，全面整合Java 8的特性，采用“基础优先，问题驱动”的教学方式，循序渐进地介绍了程序设计基础、解决问题的方法、面向对象程序设计、图形用户界面设计、异常处理 ', 'Y.Daniel Liang', '60.00', '85.00', '6.90', '机械工业出版社', '2018-06-05', '1', '520', '45000', '2018-06-13', '16', '胶版纸', '52', 'book_img/95dd5835-c32c-45cf-902c-494419f3745c_23746255-1_w_1.jpg', 'book_img/5613e66f-a1cc-45ba-af0f-343a408f304a_23746255-1_b_1.jpg', null);
INSERT INTO `t_book` VALUES ('24', 'Java程序设计教程（原书第3版,实用为先，详解常用数据结构，培养算法思维，配套练习，案例分析） ', 'Struart Reges,Marty Stepp', '119.00', '94.00', '7.90', '机械工业出版社', '2018-06-06', '1', '374', '48700', '2018-06-05', '16', '胶版纸', '52', 'book_img/91274eac-0238-451c-a740-fe29e52efc9a_23668191-1_w_1.jpg', 'book_img/cd2c98dd-0be6-4aa2-a7b1-9396ac9806a3_23668191-1_b_1.jpg', null);
INSERT INTO `t_book` VALUES ('25', ' Java语言程序设计（基础篇）（英文版·第10版） ', '梁勇（Y.Daniel Liang）', '99.00', '78.20', '7.90', '机械工业出版社', '2018-06-13', '1', '374', '48700', '2019-06-12', '16', '胶版纸', '52', 'book_img/c821e705-f8f0-4eb2-8362-d40136d9350f_25104109-1_w_3.jpg', 'book_img/ec3ea428-6cb7-4d82-a870-898941c44a29_25104109-1_b_3.jpg', null);
INSERT INTO `t_book` VALUES ('26', ' Java程序设计（附光盘） ', '莱利 著，苏钰涵 等译', '59.00', '46.60', '7.90', '机械工业出版社', '2013-6-1', '1', '374', '48700', '2013-6-1', '16', '胶版纸', '52', 'book_img/f246b6eb-15d9-4e3c-beb7-3e9c1b5c0a11_9261042-1_w.jpg', 'book_img/f8dd14d5-47a4-4b8c-ac5f-7720be1b6c24_9261042-1_b_0.jpg', null);
INSERT INTO `t_book` VALUES ('27', ' Java程序设计 ', '叶加青', '59.00', '40.70', '6.90', '电子工业出版社', '2013-6-1', '1', '374', '48700', '2013-6-1', '16', '胶版纸', '52', 'book_img/6fd0a3b5-9a19-4bd7-b849-99bad1a0403d_25240873-1_w_3.jpg', 'book_img/1358e6f2-ebb1-405a-b487-efa471a5ce7f_25240873-1_b_3.jpg', null);
INSERT INTO `t_book` VALUES ('28', 'Java程序设计实例与操作 ', '丁永卫，谢志伟，高振栋', '59.00', '40.70', '6.90', '中航书苑文化传媒（北京）有限公司', '2013-6-1', '1', '374', '48700', '2013-6-1', '16', '胶版纸', '52', 'book_img/c80d9147-4f08-454d-bcb5-b9a8308bfbe5_21104519-1_w_2.jpg', 'book_img/371b868e-5e6b-47f5-95bc-6ebc644d4ee6_21104519-1_b_2.jpg', null);
INSERT INTO `t_book` VALUES ('29', ' Java程序设计与实例 ', '张文胜　', '59.00', '40.70', '6.90', '清华大学出版社', '2013-6-1', '1', '374', '48700', '2013-6-1', '16', '胶版纸', '52', 'book_img/ae0119fd-ee3c-441e-a9c8-85fc15f4930b_23781741-1_w_2.jpg', 'book_img/84ebcc34-1efa-4aa3-be3b-d67ff5d62a5c_23781741-1_b_2.jpg', null);
INSERT INTO `t_book` VALUES ('30', 'Java程序设计实践教程 ', '张永常', '59.00', '40.70', '6.90', '电子工业出版社', '2013-6-1', '1', '374', '48700', '2013-6-1', '16', '胶版纸', '52', 'book_img/2cc3a269-2e23-4607-b165-67a0d41a7f75_23308518-1_w_3.jpg', 'book_img/e9283012-49d1-44aa-b9ec-905659ef0293_23308518-1_b_3.jpg', null);
INSERT INTO `t_book` VALUES ('31', ' Java程序设计教程（第七版）（英文版）', '刘易斯，（美）洛夫特斯', '59.00', '40.70', '6.90', '电子工业出版社', '2013-6-1', '1', '374', '48700', '2013-6-1', '16', '胶版纸', '52', 'book_img/a1fbeec6-c41c-4945-bceb-5315443e6f37_22733164-1_w_1.jpg', 'book_img/3105e54e-cc9f-4d87-8a29-33cea5088462_22733164-1_b_1.jpg', null);
INSERT INTO `t_book` VALUES ('32', ' Java程序设计之网络编程基础教程 ', '李芝兴　', '59.00', '40.70', '6.90', '清华大学出版社', '2013-6-1', '1', '374', '48700', '2013-6-1', '16', '胶版纸', '52', 'book_img/ef18205c-f37d-49e9-816b-c4df213fc5df_23761173-1_w_1.jpg', 'book_img/b1b813b2-e731-4f23-8a17-dbff281f825b_23761173-1_b_670.jpg', null);
INSERT INTO `t_book` VALUES ('33', ' Java程序设计（第2版） ', '林邓伟，孟军霞　', '59.00', '40.70', '6.90', '北京理工大学出版社', '2013-6-1', '1', '374', '48700', '2013-6-1', '16', '胶版纸', '52', 'book_img/fd3ff780-88bf-4939-a9fb-a8c0604af2cd_23189917-1_w_1.jpg', 'book_img/68af4233-b7c1-4c4e-b80a-d2653da51dae_23189917-1_b_1.jpg', null);

-- ----------------------------
-- Table structure for `t_cartitem`
-- ----------------------------
DROP TABLE IF EXISTS `t_cartitem`;
CREATE TABLE `t_cartitem` (
  `cartItemId` int(12) NOT NULL AUTO_INCREMENT,
  `quantity` int(12) DEFAULT NULL,
  `bid` int(12) DEFAULT NULL,
  `uid` int(12) DEFAULT NULL,
  `orderBy` int(12) DEFAULT NULL,
  PRIMARY KEY (`cartItemId`),
  KEY `cartItemId_bid` (`bid`),
  KEY `cartItemId_uid` (`uid`),
  CONSTRAINT `cartItemId_bid` FOREIGN KEY (`bid`) REFERENCES `t_book` (`bid`),
  CONSTRAINT `cartItemId_uid` FOREIGN KEY (`uid`) REFERENCES `t_user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cartitem
-- ----------------------------
INSERT INTO `t_cartitem` VALUES ('55', '1', '28', null, null);

-- ----------------------------
-- Table structure for `t_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `cid` int(12) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  `miaoshu` varchar(255) DEFAULT NULL,
  `orderBy` int(12) DEFAULT NULL,
  `pid` int(12) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('36', '程序设计类', '程序设计类', '1', null);
INSERT INTO `t_category` VALUES ('37', '操作系统', '操作系统', '2', null);
INSERT INTO `t_category` VALUES ('51', 'C语言程序设计', 'C语言程序设计', null, '36');
INSERT INTO `t_category` VALUES ('52', 'Java语言程序设计', 'Java语言程序设计', null, '36');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `oid` int(12) NOT NULL AUTO_INCREMENT,
  `ordertime` varchar(128) DEFAULT NULL,
  `total` decimal(8,2) DEFAULT NULL,
  `status` int(4) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `uid` int(12) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `oid-uid` (`uid`),
  CONSTRAINT `oid-uid` FOREIGN KEY (`uid`) REFERENCES `t_user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('9', '2018-04-24 20:34:28', '104.50', '5', '北京市 昌平区 西三旗 金燕龙办公楼1层  张三爷', '3');
INSERT INTO `t_order` VALUES ('11', '2018-04-24 20:39:26', '184.40', '4', '北京市 昌平区 西三旗 金燕龙办公楼1层 “” 张三爷', '3');
INSERT INTO `t_order` VALUES ('13', '2018-04-24 20:48:51', '156.60', '3', '广东科技学院', '3');
INSERT INTO `t_order` VALUES ('14', '2018-04-24 20:54:40', '79.90', '4', '南苑宿舍2-811', '3');
INSERT INTO `t_order` VALUES ('15', '2018-04-26 21:08:05', '159.50', '5', '北京市 昌平区 西三旗 金燕龙办公楼1层 “” 张三爷', '3');
INSERT INTO `t_order` VALUES ('16', '2018-04-29 08:57:45', '104.50', '5', '北京市 昌平区 西三旗 金燕龙办公楼1层 “” 张三爷', '3');
INSERT INTO `t_order` VALUES ('17', '2018-04-29 13:43:27', '55.00', '3', '北京市 昌平区 西三旗 金燕龙办公楼1层 “” 张三爷', '3');
INSERT INTO `t_order` VALUES ('18', '2018-04-29 13:46:39', '464.90', '1', '北京市 昌平区 西三旗 金燕龙办公楼1层 “” 张三爷', '3');
INSERT INTO `t_order` VALUES ('19', '2018-04-29 15:49:18', '133.30', '1', '北京市 昌平区 西三旗 金燕龙办公楼1层 “” 张三爷', '3');
INSERT INTO `t_order` VALUES ('20', '2018-05-06 20:47:13', '241.00', '1', '2-811', '3');

-- ----------------------------
-- Table structure for `t_orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `t_orderitem`;
CREATE TABLE `t_orderitem` (
  `orderItemId` int(12) NOT NULL AUTO_INCREMENT,
  `quantity` int(12) DEFAULT NULL,
  `subtotal` decimal(8,2) DEFAULT NULL,
  `bid` int(12) DEFAULT NULL,
  `oid` int(12) DEFAULT NULL,
  `bname` varchar(255) DEFAULT NULL,
  `currPrice` decimal(8,2) DEFAULT NULL,
  `image_b` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderItemId`),
  KEY `bid_orderItemId` (`bid`),
  KEY `oid_orderItemId` (`oid`),
  CONSTRAINT `oid_orderItemId` FOREIGN KEY (`oid`) REFERENCES `t_order` (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orderitem
-- ----------------------------
INSERT INTO `t_orderitem` VALUES ('5', '1', '104.50', '4', '9', 'Java经典实例（第三版）\r\n本书对于Java程序员来说是理想的“第二本书”，300个Java应用经典技巧，涵盖了广泛的Java主题。 ', '104.50', 'book_img/24020254-1_b_6.jpg');
INSERT INTO `t_orderitem` VALUES ('6', '1', '104.50', '4', '11', 'Java经典实例（第三版）\r\n本书对于Java程序员来说是理想的“第二本书”，300个Java应用经典技巧，涵盖了广泛的Java主题。 ', '104.50', 'book_img/24020254-1_b_6.jpg');
INSERT INTO `t_orderitem` VALUES ('7', '1', '79.90', '7', '11', ' Linux从入门到精通（微课视频版）\r\n76集同步视频讲解 219项Linux试题分析 PPT教学课件 Linux认证考试 资深实战派讲师 小说式写作风格', '79.90', 'book_img/25249144-1_b_3.jpg');
INSERT INTO `t_orderitem` VALUES ('8', '1', '78.30', '1', '13', '零基础学编程 c语言入门经典 计算机网络编程书籍数据结构算法javascript高级程序设计 ', '78.30', 'book_img/25211517-1_b_3.jpg');
INSERT INTO `t_orderitem` VALUES ('9', '1', '78.30', '5', '13', ' Java程序设计从入门到精通\r\nJava9语言程序设计从入门到精通零基础学java编程思想教程 java核心技术开发实战经典javascriptweb计算机自学书籍 ', '78.30', 'book_img/25211499-1_b_3.jpg');
INSERT INTO `t_orderitem` VALUES ('10', '1', '79.90', '7', '14', ' Linux从入门到精通（微课视频版）\r\n76集同步视频讲解 219项Linux试题分析 PPT教学课件 Linux认证考试 资深实战派讲师 小说式写作风格', '79.90', 'book_img/25249144-1_b_3.jpg');
INSERT INTO `t_orderitem` VALUES ('11', '1', '104.50', '4', '15', 'Java经典实例（第三版）\r\n本书对于Java程序员来说是理想的“第二本书”，300个Java应用经典技巧，涵盖了广泛的Java主题。 ', '104.50', 'book_img/24020254-1_b_6.jpg');
INSERT INTO `t_orderitem` VALUES ('12', '1', '55.00', '3', '15', ' Java从入门到精通（第4版）（附光盘）\r\n畅销书全新改版 累计63次重印 30万读者选择的 java入门经典书 持续八年畅销 全行业优秀畅销书 长期位居java 销售排行榜前列 好学、好用 32小时视频 732个经典实例 369项', '55.00', 'book_img/24042210-1_b_5.jpg');
INSERT INTO `t_orderitem` VALUES ('13', '1', '104.50', '4', '16', 'Java经典实例（第三版）\r\n本书对于Java程序员来说是理想的“第二本书”，300个Java应用经典技巧，涵盖了广泛的Java主题。 ', '104.50', 'book_img/24020254-1_b_6.jpg');
INSERT INTO `t_orderitem` VALUES ('14', '1', '55.00', '3', '17', ' Java从入门到精通（第4版）（附光盘）\r\n畅销书全新改版 累计63次重印 30万读者选择的 java入门经典书 持续八年畅销 全行业优秀畅销书 长期位居java 销售排行榜前列 好学、好用 32小时视频 732个经典实例 369项', '55.00', 'book_img/24042210-1_b_5.jpg');
INSERT INTO `t_orderitem` VALUES ('15', '1', '47.20', '6', '18', ' Linux从入门到精通（第2版）（配光盘）（Linux典藏大系）\r\n【Linux畅销书！累计18次印刷，畅销6万余册，荣获“读者喜爱的原创IT技术图书奖”，42小时教学视频，提供Ubuntu安装文件，送教学PPT，Linux新手必读】 ', '47.20', 'book_img/23412693-1_b_2.jpg');
INSERT INTO `t_orderitem` VALUES ('16', '1', '79.90', '7', '18', ' Linux从入门到精通（微课视频版）\r\n76集同步视频讲解 219项Linux试题分析 PPT教学课件 Linux认证考试 资深实战派讲师 小说式写作风格', '79.90', 'book_img/25249144-1_b_3.jpg');
INSERT INTO `t_orderitem` VALUES ('17', '1', '55.00', '3', '18', ' Java从入门到精通（第4版）（附光盘）\r\n畅销书全新改版 累计63次重印 30万读者选择的 java入门经典书 持续八年畅销 全行业优秀畅销书 长期位居java 销售排行榜前列 好学、好用 32小时视频 732个经典实例 369项', '55.00', 'book_img/24042210-1_b_5.jpg');
INSERT INTO `t_orderitem` VALUES ('18', '1', '104.50', '4', '18', 'Java经典实例（第三版）\r\n本书对于Java程序员来说是理想的“第二本书”，300个Java应用经典技巧，涵盖了广泛的Java主题。 ', '104.50', 'book_img/24020254-1_b_6.jpg');
INSERT INTO `t_orderitem` VALUES ('19', '1', '78.30', '1', '18', '零基础学编程 c语言入门经典 计算机网络编程书籍数据结构算法javascript高级程序设计 ', '78.30', 'book_img/25211517-1_b_3.jpg');
INSERT INTO `t_orderitem` VALUES ('20', '1', '100.00', '14', '18', 'jjjj', '100.00', 'book_img/a8944fa4-7812-4992-8905-c226e5e62c55_01751679-27f2-4836-aaa1-9a87c754963a_25254513-1_l_5.jpg');
INSERT INTO `t_orderitem` VALUES ('21', '1', '55.00', '3', '19', ' Java从入门到精通（第4版）（附光盘）\r\n畅销书全新改版 累计63次重印 30万读者选择的 java入门经典书 持续八年畅销 全行业优秀畅销书 长期位居java 销售排行榜前列 好学、好用 32小时视频 732个经典实例 369项', '55.00', 'book_img/24042210-1_b_5.jpg');
INSERT INTO `t_orderitem` VALUES ('22', '1', '78.30', '1', '19', '零基础学编程 c语言入门经典 计算机网络编程书籍数据结构算法javascript高级程序设计 ', '78.30', 'book_img/25211517-1_b_3.jpg');
INSERT INTO `t_orderitem` VALUES ('23', '1', '40.70', '28', '20', 'Java程序设计实例与操作 ', '40.70', 'book_img/371b868e-5e6b-47f5-95bc-6ebc644d4ee6_21104519-1_b_2.jpg');
INSERT INTO `t_orderitem` VALUES ('24', '1', '40.70', '27', '20', ' Java程序设计 ', '40.70', 'book_img/1358e6f2-ebb1-405a-b487-efa471a5ce7f_25240873-1_b_3.jpg');
INSERT INTO `t_orderitem` VALUES ('25', '1', '78.20', '25', '20', ' Java语言程序设计（基础篇）（英文版·第10版） ', '78.20', 'book_img/ec3ea428-6cb7-4d82-a870-898941c44a29_25104109-1_b_3.jpg');
INSERT INTO `t_orderitem` VALUES ('26', '1', '40.70', '31', '20', ' Java程序设计教程（第七版）（英文版）', '40.70', 'book_img/3105e54e-cc9f-4d87-8a29-33cea5088462_22733164-1_b_1.jpg');
INSERT INTO `t_orderitem` VALUES ('27', '1', '40.70', '32', '20', ' Java程序设计之网络编程基础教程 ', '40.70', 'book_img/b1b813b2-e731-4f23-8a17-dbff281f825b_23761173-1_b_670.jpg');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int(12) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(50) DEFAULT NULL,
  `loginpass` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  `activationCode` char(64) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `loginname` (`loginname`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'hgxhgxhgx', 'hgxhgxhgx', 'hgx@163.com', '0', '25096a5b-ae19-41e6-9389-48047e69c6ba');
INSERT INTO `t_user` VALUES ('2', 'hgxhgxhgxhgx', '123456', '123@163.com', '0', '76383667-cc30-417f-bf7f-9215f4126b66');
INSERT INTO `t_user` VALUES ('3', '123456', '666666', '1234@163.com', '0', '1161be78-c181-4354-9e62-f323c1ceb51b');
