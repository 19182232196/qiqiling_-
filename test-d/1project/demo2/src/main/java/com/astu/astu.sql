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

 Date: 18/11/2023 00:17:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `userAccount` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `userName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `userSex` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `userBirthday` varchar(22) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `userIdCard` varchar(18) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `userPassword` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `userIdentify` int NULL DEFAULT NULL,
  `userOtherName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('12345678', '李四', '男', '2003-02-01', '545125200302015698', '1', 0, '普通学生');
INSERT INTO `person` VALUES ('12569874', '季布', '男', '2002-12-05', '598965200212054587', '1', 0, '普通学生');
INSERT INTO `person` VALUES ('58975262', '李婷', '女', '1988-03-08', '456987198803085269', '1', 1, '数据结构');
INSERT INTO `person` VALUES ('69854896', '陈伟', '男', '1890-05-06', '569785198005061254', '1', 1, '计网');
INSERT INTO `person` VALUES ('96589751', '董平', '男', '2000-02-05', '598758920020205456', '1', 0, '普通学生');
INSERT INTO `person` VALUES ('admin', '管理员', NULL, NULL, NULL, 'aa', 2, NULL);

-- ----------------------------
-- Table structure for studenttask
-- ----------------------------
DROP TABLE IF EXISTS `studenttask`;
CREATE TABLE `studenttask`  (
  `taskAccount` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `studentAccount` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `studentAnswer` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `isFinish` int NULL DEFAULT NULL,
  `isScore` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studenttask
-- ----------------------------
INSERT INTO `studenttask` VALUES ('56984568', '12345678', NULL, 0, 0);
INSERT INTO `studenttask` VALUES ('36359476', '96589751', NULL, 0, 0);
INSERT INTO `studenttask` VALUES ('67878997', '96589751', NULL, 0, 0);

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `taskAccount` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `teacherAccount` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `taskDate` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `taskName` varchar(400) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('56984568', '58975262', '2023-04-18', '请写出图的种类');
INSERT INTO `task` VALUES ('675310249', '58975262', '2023-04-19 18:47:20', '请写出你理解的数据报是什么');

-- ----------------------------
-- Table structure for userteacher
-- ----------------------------
DROP TABLE IF EXISTS `userteacher`;
CREATE TABLE `userteacher`  (
  `userAccount` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `teacherAccount` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userteacher
-- ----------------------------
INSERT INTO `userteacher` VALUES ('12345678', '58975262');

SET FOREIGN_KEY_CHECKS = 1;
