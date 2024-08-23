/*
 Navicat Premium Data Transfer

 Source Server         : Localhost mysql-8.0.12
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : user_management

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 22/08/2024 16:55:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`
(
    `id`         int(11)                                                 NOT NULL AUTO_INCREMENT,
    `user_id`    int(11)                                                 NULL     DEFAULT NULL COMMENT '用户id',
    `ip`         varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL     DEFAULT NULL COMMENT '用户ip',
    `login_time` datetime(0)                                             NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '用户登录时间',
    `platform`   tinyint(4)                                              NOT NULL COMMENT '用户登陆平台',
    `is_deleted` tinyint(4)                                              NOT NULL DEFAULT 0 COMMENT '是否删除 0-否 1-是',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci COMMENT = '登陆日志表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`
(
    `id`          int(11)                                                 NOT NULL AUTO_INCREMENT,
    `name`        varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci  NOT NULL COMMENT '权限名称',
    `code`        varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci  NOT NULL COMMENT '权限代码',
    `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '权限描述',
    `parent_id`   int(11)                                                 NULL DEFAULT NULL COMMENT '父权限id',
    `platform`    tinyint(4)                                              NOT NULL COMMENT '平台',
    `create_time` datetime(0)                                             NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime(0)                                             NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
    `is_deleted`  tinyint(4)                                              NULL DEFAULT 0 COMMENT '是否删除 0-否 1-是',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci COMMENT = '权限表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission`
VALUES (1, '展示平台', 'DISPLAY', '展示平台权限', NULL, 1, '2024-08-22 16:50:24', '2024-08-22 16:50:24', 0);
INSERT INTO `permission`
VALUES (2, '管理平台', 'MANAGE', '管理平台权限', NULL, 2, '2024-08-22 16:50:24', '2024-08-22 16:50:24', 0);
INSERT INTO `permission`
VALUES (101, '展示平台浏览权限', 'DISPLAY:BROWSE', '展示平台浏览权限', 1, 1, '2024-08-22 16:50:24', '2024-08-22 16:50:24', 0);
INSERT INTO `permission`
VALUES (102, '展示平台个人中心权限', 'DISPLAY:EDIT', '展示平台个人中心权限', 1, 1, '2024-08-22 16:50:24', '2024-08-22 16:50:24', 0);
INSERT INTO `permission`
VALUES (201, '数据管理权限', 'MANAGE:DATA', '数据管理权限', 2, 2, '2024-08-22 16:50:24', '2024-08-22 16:50:24', 0);
INSERT INTO `permission`
VALUES (202, '用户管理权限', 'MANAGE:USER', '用户管理权限', 2, 2, '2024-08-22 16:50:24', '2024-08-22 16:50:24', 0);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    `id`          int(11)                                                 NOT NULL AUTO_INCREMENT,
    `name`        varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci  NOT NULL COMMENT '角色名称',
    `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL     DEFAULT NULL COMMENT '角色描述',
    `create_time` datetime(0)                                             NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime(0)                                             NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
    `status`      tinyint(4)                                              NOT NULL DEFAULT 1 COMMENT '角色状态 0-禁用 1-启用 2-删除',
    `is_deleted`  tinyint(4)                                              NOT NULL DEFAULT 0 COMMENT '是否删除 0-否 1-是',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci COMMENT = '角色表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role`
VALUES (1, '超级管理员', '拥有所有权限', '2024-08-22 16:50:19', '2024-08-22 16:50:19', 1, 0);
INSERT INTO `role`
VALUES (2, '普通用户', '拥有部分权限', '2024-08-22 16:50:19', '2024-08-22 16:50:19', 1, 0);
INSERT INTO `role`
VALUES (3, '管理员', '拥有管理权限', '2024-08-22 16:50:19', '2024-08-22 16:50:19', 1, 0);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`
(
    `id`            int(11)     NOT NULL AUTO_INCREMENT,
    `role_id`       int(11)     NOT NULL COMMENT '角色id',
    `permission_id` int(11)     NOT NULL COMMENT '权限id',
    `create_time`   datetime(0) NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `is_deleted`    tinyint(4)  NOT NULL DEFAULT 0 COMMENT '是否删除 0-否 1-是',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci COMMENT = '角色权限关联表'
  ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission`
VALUES (1, 1, 1, '2024-08-22 16:51:05', 0);
INSERT INTO `role_permission`
VALUES (2, 1, 2, '2024-08-22 16:51:05', 0);
INSERT INTO `role_permission`
VALUES (3, 1, 101, '2024-08-22 16:51:05', 0);
INSERT INTO `role_permission`
VALUES (4, 1, 102, '2024-08-22 16:51:05', 0);
INSERT INTO `role_permission`
VALUES (5, 1, 201, '2024-08-22 16:51:05', 0);
INSERT INTO `role_permission`
VALUES (6, 1, 202, '2024-08-22 16:51:05', 0);
INSERT INTO `role_permission`
VALUES (7, 2, 1, '2024-08-22 16:51:09', 0);
INSERT INTO `role_permission`
VALUES (8, 2, 101, '2024-08-22 16:51:09', 0);
INSERT INTO `role_permission`
VALUES (9, 2, 102, '2024-08-22 16:51:09', 0);
INSERT INTO `role_permission`
VALUES (10, 2, 103, '2024-08-22 16:51:09', 0);
INSERT INTO `role_permission`
VALUES (11, 2, 104, '2024-08-22 16:51:09', 0);
INSERT INTO `role_permission`
VALUES (12, 3, 201, '2024-08-22 16:51:09', 0);
INSERT INTO `role_permission`
VALUES (13, 3, 202, '2024-08-22 16:51:09', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`           bigint                                                  NOT NULL AUTO_INCREMENT,
    `user_name`    varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci  NOT NULL COMMENT '用户名称',
    `password`     varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
    `avatar_path`  varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL     DEFAULT NULL COMMENT '头像url',
    `phone`        varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci  NULL     DEFAULT NULL COMMENT '电话号码',
    `email`        varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL     DEFAULT NULL COMMENT '电子邮箱',
    `gender`       tinyint(4)                                              NULL     DEFAULT NULL COMMENT '性别 0-女 1-男',
    `address`      varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL     DEFAULT NULL COMMENT '地址',
    `introduction` text CHARACTER SET utf8 COLLATE utf8_unicode_ci         NULL COMMENT '自我介绍',
    `true_name`    varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci  NULL     DEFAULT NULL COMMENT '真实姓名',
    `create_time`  datetime(0)                                             NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  datetime(0)                                             NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
    `status`       tinyint(4)                                              NOT NULL DEFAULT 1 COMMENT '用户状态 0-禁用 1-启用 2-删除',
    `is_deleted`   tinyint(4)                                              NOT NULL DEFAULT 0 COMMENT '是否删除 0-否 1-是',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci COMMENT = '用户表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2024-08-22 16:52:05',
        '2024-08-22 16:54:27', 1, 0);
INSERT INTO `user`
VALUES (2, 'user', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2024-08-22 16:52:05',
        '2024-08-22 16:54:28', 1, 0);
INSERT INTO `user`
VALUES (3, 'system-manager', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        '2024-08-22 16:52:05', '2024-08-22 16:54:29', 1, 0);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT,
    `user_id`     int(11)     NOT NULL COMMENT '用户id',
    `role_id`     int(11)     NOT NULL COMMENT '角色id',
    `create_time` datetime(0) NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `is_deleted`  tinyint(4)  NOT NULL DEFAULT 0 COMMENT '是否删除 0-否 1-是',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci COMMENT = '用户角色关联表'
  ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role`
VALUES (1, 1, 1, '2024-08-22 16:52:21', 0);
INSERT INTO `user_role`
VALUES (2, 2, 2, '2024-08-22 16:52:21', 0);
INSERT INTO `user_role`
VALUES (3, 3, 3, '2024-08-22 16:52:21', 0);

SET FOREIGN_KEY_CHECKS = 1;