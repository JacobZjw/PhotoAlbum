/*
 Navicat Premium Data Transfer

 Source Server         : LocalMySQL
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : album

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 15/01/2021 17:34:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `id` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `photoId` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `content` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `photoId`(`photoId`) USING BTREE,
  INDEX `userName`(`userName`) USING BTREE,
  CONSTRAINT `photoId` FOREIGN KEY (`photoId`) REFERENCES `photo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userName` FOREIGN KEY (`userName`) REFERENCES `user` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES (0000000001, 0000000007, '好书', 'jacob');
INSERT INTO `comments` VALUES (0000000002, 0000000046, '好看', 'jacob');
INSERT INTO `comments` VALUES (0000000004, 0000000001, '这啥书啊', 'jacob');
INSERT INTO `comments` VALUES (0000000006, 0000000046, '怎么回事呢', 'jacob');
INSERT INTO `comments` VALUES (0000000007, 0000000046, '找bug', 'jacob');
INSERT INTO `comments` VALUES (0000000008, 0000000044, '找bug', 'jacob');
INSERT INTO `comments` VALUES (0000000009, 0000000045, '还是找BUG', 'jacob');
INSERT INTO `comments` VALUES (0000000010, 0000000045, '找到了吗', 'jacob');
INSERT INTO `comments` VALUES (0000000011, 0000000045, '找到了', 'jacob');
INSERT INTO `comments` VALUES (0000000012, 0000000044, 'BUG好多', 'nick');
INSERT INTO `comments` VALUES (0000000013, 0000000043, 'asdd', 'jacob');
INSERT INTO `comments` VALUES (0000000014, 0000000047, 'test for comment', 'jacob');

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo`  (
  `id` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `masterId` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `master`(`masterId`) USING BTREE,
  CONSTRAINT `master` FOREIGN KEY (`masterId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of photo
-- ----------------------------
INSERT INTO `photo` VALUES (0000000001, 'Java自然语言处理', 'http://img14.360buyimg.com/n1/s200x200_jfs/t1/132800/4/6450/56842/5f2e5afeE47528efc/d719b5c07869ec5c.jpg', 0000000001);
INSERT INTO `photo` VALUES (0000000006, '官方正版 设计模式就该这样学：基于经典框架源码和真实业务场景 咕泡学院Java架构师成长', 'http://img11.360buyimg.com/n1/s200x200_jfs/t1/146671/25/4489/420902/5f28dbe0Ed2b2b006/4d915f5c08895786.jpg', 0000000001);
INSERT INTO `photo` VALUES (0000000007, 'Java编程思想 (美)埃克尔 (Bruce Eckel) 著;陈吴鹏 译 著 编程语言', 'http://img11.360buyimg.com/n1/s200x200_jfs/t1/130833/16/5966/71454/5f2785c5Ee3f78346/ed0d2080a6674a45.jpg', 0000000001);
INSERT INTO `photo` VALUES (0000000008, '图解数据结构-使用Java(第2版)', 'http://img14.360buyimg.com/n1/s200x200_jfs/t1/122373/39/8868/39936/5f2cba0fE8e12d802/51fd62409b5ed1c1.jpg', 0000000001);
INSERT INTO `photo` VALUES (0000000009, '零基础Java从入门到精通', 'http://img12.360buyimg.com/n1/s200x200_jfs/t1/129181/33/8178/380857/5f1fc4cfEdbc109d8/9abb8809d4f5dfa8.jpg', 0000000001);
INSERT INTO `photo` VALUES (0000000010, '深入理解Java虚拟机：JVM高级特性与最佳实践（第3版）', 'http://img13.360buyimg.com/n1/s200x200_jfs/t1/139294/35/3944/256464/5f1e37deEbe68ca9b/209d414ca842808a.png', 0000000001);
INSERT INTO `photo` VALUES (0000000013, 'java核心技术卷1基础知识 卷II 高级特性（原书第11版） 中文版', 'http://img11.360buyimg.com/n1/s200x200_jfs/t1/117232/23/12988/446854/5f193e08E216ffa4e/34815cb0a66c689e.png', 0000000001);
INSERT INTO `photo` VALUES (0000000014, 'Java EE轻量框架技术SSM', 'http://img12.360buyimg.com/n1/s200x200_jfs/t1/128888/36/7256/81538/5f0ff419Ed4caf481/64c64b600a829f01.jpg', 0000000001);
INSERT INTO `photo` VALUES (0000000015, 'Java自然语言处理(原书第2版)', 'http://img11.360buyimg.com/n1/s200x200_jfs/t1/118197/11/12682/87719/5f167987Ec3b15ebd/ce998421db27c9aa.jpg', 0000000001);
INSERT INTO `photo` VALUES (0000000018, '官方正版 计算机程序设计（Java）（第2二版）王新萍 程序开发工程师岗位职业能力教材', 'http://img13.360buyimg.com/n1/s200x200_jfs/t1/120471/30/6940/142611/5f0bb44bEfbfeed27/74af2ecf597e3667.jpg', 0000000001);
INSERT INTO `photo` VALUES (0000000020, 'Java EE轻量级框架应用实战 SSM框架(Spring MVC+Spring', 'http://img12.360buyimg.com/n1/s200x200_jfs/t1/134842/32/4620/121014/5f0fb6b6E096472a3/47cf89b0aae83b3e.jpg', 0000000001);
INSERT INTO `photo` VALUES (0000000035, '李庚希', 'https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2795738345,4006890102&fm=26&gp=0.jpghttps://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2795738345,4006890102&fm=26&gp=0.jpg', 0000000002);
INSERT INTO `photo` VALUES (0000000036, '李庚希', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2880104690,3108997716&fm=26&gp=0.jpg', 0000000002);
INSERT INTO `photo` VALUES (0000000037, '草泥马', 'https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2552908554,599523063&fm=26&gp=0.jpg', 0000000003);
INSERT INTO `photo` VALUES (0000000039, '草泥马', 'https://dss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1940133004,3150584153&fm=26&gp=0.jpg', 0000000003);
INSERT INTO `photo` VALUES (0000000042, '动漫', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4276219045,4194292839&fm=11&gp=0.jpg', 0000000001);
INSERT INTO `photo` VALUES (0000000043, '李庚希', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1368091969,1601040369&fm=26&gp=0.jpg', 0000000002);
INSERT INTO `photo` VALUES (0000000044, '李庚希', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3444771761,1215782162&fm=26&gp=0.jpg', 0000000002);
INSERT INTO `photo` VALUES (0000000045, '李庚希', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3717208169,2575979334&fm=26&gp=0.jpg', 0000000002);
INSERT INTO `photo` VALUES (0000000046, '李庚希', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=964507932,4070155332&fm=26&gp=0.jpg', 0000000001);
INSERT INTO `photo` VALUES (0000000047, '李庚希', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2110857783,540825935&fm=26&gp=0.jpg', 0000000001);

-- ----------------------------
-- Table structure for photocolletions
-- ----------------------------
DROP TABLE IF EXISTS `photocolletions`;
CREATE TABLE `photocolletions`  (
  `photoId` int(10) UNSIGNED ZEROFILL NOT NULL,
  `userId` int(10) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (`photoId`, `userId`) USING BTREE,
  INDEX `user`(`userId`) USING BTREE,
  CONSTRAINT `photo` FOREIGN KEY (`photoId`) REFERENCES `photo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of photocolletions
-- ----------------------------
INSERT INTO `photocolletions` VALUES (0000000036, 0000000001);
INSERT INTO `photocolletions` VALUES (0000000043, 0000000001);
INSERT INTO `photocolletions` VALUES (0000000045, 0000000001);
INSERT INTO `photocolletions` VALUES (0000000047, 0000000001);
INSERT INTO `photocolletions` VALUES (0000000044, 0000000002);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `User_email_uindex`(`email`) USING BTREE,
  UNIQUE INDEX `User_name_uindex`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (0000000001, 'jacob', '1234', 'jw.life@qq.com');
INSERT INTO `user` VALUES (0000000002, 'nick', '1234', 'nick@qq.com');
INSERT INTO `user` VALUES (0000000003, '草泥马', '1234', 'caonima@qq.com');
INSERT INTO `user` VALUES (0000000006, 'jacobaaa', '123', 'jacob@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
