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

 Date: 17/11/2023 21:49:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for userteacher
-- ----------------------------
DROP TABLE IF EXISTS `userteacher`;
CREATE TABLE `userteacher`  (
  `userAccount` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `teacherAccount` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userteacher
-- ----------------------------
INSERT INTO `userteacher` VALUES ('12569874', '58975262');
INSERT INTO `userteacher` VALUES ('17365896', '58975262');
INSERT INTO `userteacher` VALUES ('96589751', '58975262');

SET FOREIGN_KEY_CHECKS = 1;
