/*
 Navicat Premium Data Transfer

 Source Server         : Test
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : localhost:3306
 Source Schema         : astu

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 17/11/2023 21:46:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `userAccount` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `userSex` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `userBirthday` varchar(22) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `userIdCard` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `userPassword` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `userIdentify` int NULL DEFAULT NULL,
  `userOtherName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userAccount`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('12345678', '张三', '男', '2002-02-09', '545897200202095897', '1', 1, '机组');
INSERT INTO `person` VALUES ('12569874', '季布', '男', '2002-12-05', '598965200212054587', '1', 0, '普通学生');
INSERT INTO `person` VALUES ('17365896', '李四', '男', '2003-02-01', '545125200302015698', '1', 0, '普通学生');
INSERT INTO `person` VALUES ('58975262', '李婷', '女', '1988-03-08', '456987198803085269', '1', 1, '数据结构');
INSERT INTO `person` VALUES ('69854896', '陈伟', '男', '1980-05-06', '569785198005061254', '1', 1, '计网');
INSERT INTO `person` VALUES ('96589751', '董平', '男', '2000-02-05', '598758920000205456', '1', 0, '普通学生');
INSERT INTO `person` VALUES ('admin', ' 管理员', NULL, NULL, NULL, '1', 2, NULL);

SET FOREIGN_KEY_CHECKS = 1;
