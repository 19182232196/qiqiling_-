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

 Date: 02/11/2023 15:33:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pop
-- ----------------------------
DROP TABLE IF EXISTS `pop`;
CREATE TABLE `pop`  (
  `id` int NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pw` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bir` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pop
-- ----------------------------
INSERT INTO `pop` VALUES (1, 'qw', 'man', '@', '1111');
INSERT INTO `pop` VALUES (2, 'qe', 'man', '!', '2222');
INSERT INTO `pop` VALUES (3, 'qr', 'woman', '$', '3333');
INSERT INTO `pop` VALUES (4, 'we', 'man', '%', '4444');
INSERT INTO `pop` VALUES (5, 'wr', 'man', '^', '5555');
INSERT INTO `pop` VALUES (6, 'er', 'woman', '&', '0000');

SET FOREIGN_KEY_CHECKS = 1;
