/*
 Navicat Premium Data Transfer

 Source Server         : qwer
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : study

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 01/11/2023 14:17:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pop
-- ----------------------------
DROP TABLE IF EXISTS `pop`;
CREATE TABLE `pop`  (
  `no` int NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pop
-- ----------------------------
INSERT INTO `pop` VALUES (1, 'qw', 'man');
INSERT INTO `pop` VALUES (2, 'qe', 'man');
INSERT INTO `pop` VALUES (3, 'qr', 'woman');
INSERT INTO `pop` VALUES (4, 'we', 'man');
INSERT INTO `pop` VALUES (5, 'wr', 'man');
INSERT INTO `pop` VALUES (6, 'er', 'woman');

SET FOREIGN_KEY_CHECKS = 1;
