/*
 Navicat Premium Data Transfer

 Source Server         : 139.155.39.185
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 139.155.39.185:3306
 Source Schema         : pims

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 21/04/2020 16:36:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attract
-- ----------------------------
DROP TABLE IF EXISTS `attract`;
CREATE TABLE `attract`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) UNSIGNED DEFAULT NULL COMMENT '用户id',
  `project_id` bigint(11) DEFAULT NULL COMMENT '项目id',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '申请留言',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目状态：0未审核、1审核通过进行中、2正常关闭、9未通过',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attract
-- ----------------------------
INSERT INTO `attract` VALUES (1, 2, 2, '你好，我要报名', '0', '2020-01-03 13:53:39', NULL);
INSERT INTO `attract` VALUES (2, 3, 3, '嗨嗨嗨', '1', '2020-01-03 13:55:52', NULL);
INSERT INTO `attract` VALUES (3, 1, 2, '我要报名', '2', '2020-01-03 14:01:59', NULL);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户昵称',
  `project_id` bigint(20) UNSIGNED DEFAULT NULL COMMENT '项目id',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `status` int(5) DEFAULT NULL COMMENT '状态：1正常，2不通过',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公司名',
  `legal_person` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '法人名',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所在地',
  `money` double(10, 2) UNSIGNED DEFAULT NULL COMMENT '注册资金',
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '基本信息',
  `view_count` int(10) UNSIGNED DEFAULT NULL COMMENT '查看次数',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES (1, 0, 1, '徐州协和', '张二', '徐州', 5688.00, '徐州欢迎你', 0, '2020-01-01 11:49:33', NULL, '122');
INSERT INTO `company` VALUES (2, 1, 11, 'e', 'd', 'd', 11.00, '111', 0, '2020-01-01 22:28:35', NULL, '2222');
INSERT INTO `company` VALUES (3, 0, 1, '111', '22', '44', 555.00, '666', 333, '2020-01-03 17:47:27', NULL, '0');

-- ----------------------------
-- Table structure for complaint
-- ----------------------------
DROP TABLE IF EXISTS `complaint`;
CREATE TABLE `complaint`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容',
  `status` int(5) UNSIGNED DEFAULT NULL COMMENT '状态：0未处理、1已处理',
  `process_msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '处理信息',
  `type` int(5) UNSIGNED DEFAULT NULL COMMENT '类型：1投诉、2是司法求助',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of complaint
-- ----------------------------
INSERT INTO `complaint` VALUES (1, 1, '哈哈哈', '你好', '申请', 1, NULL, 2, '2019-12-31 21:15:56', NULL);
INSERT INTO `complaint` VALUES (2, 2, '222', '22', '22', 0, NULL, 2, '2020-01-01 10:45:49', NULL);
INSERT INTO `complaint` VALUES (3, 1, 'admin', '投诉', '投诉内容。。。。', 1, '同意', 2, '2020-01-01 10:51:54', NULL);
INSERT INTO `complaint` VALUES (4, 1, 'admin', '测试司法', '投诉。。。', 0, NULL, 2, '2020-01-01 10:57:48', NULL);
INSERT INTO `complaint` VALUES (6, 11, 'xxxx', '求助', '6666', 2, 'xx', 2, '2020-01-01 22:30:27', NULL);
INSERT INTO `complaint` VALUES (7, 6, 'd222', '到22', 'ddd', 0, NULL, 2, '2020-01-01 22:31:14', NULL);
INSERT INTO `complaint` VALUES (8, 1, 'admin', '333', 'e33', 0, NULL, 2, '2020-01-01 22:56:12', NULL);
INSERT INTO `complaint` VALUES (10, 10, '李先生', '5', '22222', 2, '', 2, '2020-01-01 23:55:12', NULL);
INSERT INTO `complaint` VALUES (12, 19, 'wtt', '11111', '111111111111111111', 1, '', 2, '2020-01-03 14:49:22', NULL);
INSERT INTO `complaint` VALUES (13, 1, 'admin', '??', 'ditie', 0, NULL, 2, '2020-01-03 15:09:41', NULL);
INSERT INTO `complaint` VALUES (14, 1, 'admin', 'qqqq', 'qqqqqqq', 0, NULL, 2, '2020-01-03 16:29:07', NULL);

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_party` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '甲方',
  `second_party` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '乙方',
  `money` double(10, 2) DEFAULT NULL COMMENT '金额',
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '详情',
  `create_time` datetime(0) DEFAULT NULL COMMENT '签约时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '合同名',
  `sign` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '签约人',
  `status` int(3) DEFAULT 0 COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES (2, '22', '33', 44.00, '<p>请添加合同图片<img alt=\"\" src=\"/file/2c0ffec8-7b30-4c1b-8671-a8a2e9b29f91.png\" style=\"height:256px; width:256px\" /></p>', '2020-01-06 00:00:00', NULL, '11', '55', NULL);
INSERT INTO `contract` VALUES (3, '小明', '小红', 2233.00, '<p><img alt=\"\" src=\"/file/34c6027b-ebba-4c78-83d0-b6a01dd46f10.jpg\" style=\"height:312px; width:312px\" /></p>', '2020-01-06 00:00:00', NULL, '绿源', '啊啊啊啊啊', NULL);
INSERT INTO `contract` VALUES (4, 'wwww', 'www', 12233.00, '<p><img alt=\"\" src=\"/file/30a82664-9c27-4f89-bb76-aec007dafeca.jpg\" style=\"height:200px; width:225px\" />请添加合同图片</p>', '2020-01-05 00:00:00', NULL, 'www', 'wwww', NULL);
INSERT INTO `contract` VALUES (5, '2', '3', 44.00, '<p>111</p>', '2020-01-05 00:00:00', NULL, '1', '1', NULL);

-- ----------------------------
-- Table structure for page
-- ----------------------------
DROP TABLE IF EXISTS `page`;
CREATE TABLE `page`  (
  `page_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `parent_id` int(11) DEFAULT NULL COMMENT '父页面id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '页面名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '页面地址',
  `level_type` int(11) DEFAULT NULL COMMENT '页面层级',
  `level_index` int(11) DEFAULT NULL COMMENT '页面索引',
  `delete_flag` int(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '是否删除',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`page_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of page
-- ----------------------------
INSERT INTO `page` VALUES (1, 0, '系统设置', NULL, 0, 10, 0, 'manager');
INSERT INTO `page` VALUES (2, 1, '用户管理', '/admin/userPage', 1, 22, 0, 'manager');
INSERT INTO `page` VALUES (3, 1, '页面管理', '/admin/page', 1, 23, 0, 'manager');
INSERT INTO `page` VALUES (4, 1, '角色管理', '/admin/role', 1, 24, 0, 'manager');
INSERT INTO `page` VALUES (6, 0, '招商管理', '', 0, 1, 0, 'left_menu_shop');
INSERT INTO `page` VALUES (7, 6, '招商列表', '/admin/attract/list', 1, 1, 0, '');
INSERT INTO `page` VALUES (9, 0, '公司管理', '', 0, 2, 0, 'left_menu_data');
INSERT INTO `page` VALUES (10, 9, '公司列表', '/admin/company/list', 1, 1, 0, NULL);
INSERT INTO `page` VALUES (12, 0, '投诉管理', '', 0, 3, 0, 'user');
INSERT INTO `page` VALUES (13, 12, '投诉列表', '/admin/complaint/list', 1, 1, 0, '');
INSERT INTO `page` VALUES (14, 0, '合同管理', '', 0, 4, 0, 'left_menu_house');
INSERT INTO `page` VALUES (15, 14, '合同列表', '/admin/contract/list', 1, 1, 0, NULL);
INSERT INTO `page` VALUES (16, 0, '项目管理', '', 0, 4, 0, 'left_menu_house');
INSERT INTO `page` VALUES (17, 16, '项目列表', '/admin/project/list', 1, 1, 0, NULL);
INSERT INTO `page` VALUES (18, 0, '新闻管理', '', 0, 4, 0, 'left_menu_house');
INSERT INTO `page` VALUES (19, 18, '新闻列表', '/admin/word/list', 1, 1, 0, NULL);
INSERT INTO `page` VALUES (20, 9, '我的申请', '/company/list', 1, 1, 0, NULL);
INSERT INTO `page` VALUES (21, 16, '我的项目', '/user/project/list', 1, 1, 0, NULL);
INSERT INTO `page` VALUES (22, 12, '我的投诉', '/user/complaint/list', 1, 1, 0, NULL);

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `company_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '详情',
  `contact` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公司名',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目状态：0未审核、1审核通过进行中、2正常关闭、9未通过',
  `start_time` datetime(0) DEFAULT NULL COMMENT '项目开始时间',
  `end_time` datetime(0) DEFAULT NULL COMMENT '项目结束时间',
  `view_count` int(10) UNSIGNED DEFAULT 0 COMMENT '查看次数',
  `apply_count` int(10) UNSIGNED DEFAULT 0 COMMENT '报名次数',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (2, 1, '好好', '招标', '阿里巴巴', '1', '2020-01-03 00:00:00', '2020-01-18 00:00:00', 6, 2, '2020-01-03 13:11:53', NULL);
INSERT INTO `project` VALUES (3, 1, 'java工程师', '腾讯内部招聘', '腾讯', '0', '2020-01-01 00:00:00', '2020-01-02 00:00:00', 5, 0, '2020-01-03 14:08:52', NULL);
INSERT INTO `project` VALUES (4, 1, '公司内部人员', '百度招聘', '百度', '1', '2020-01-01 00:00:00', '2020-01-02 00:00:00', 33, 0, '2020-01-03 14:09:42', NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型名称',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', '超级管理员');
INSERT INTO `role` VALUES (2, '企业人员', '企业人员');
INSERT INTO `role` VALUES (3, '高级用户', '高级用户');

-- ----------------------------
-- Table structure for role_page
-- ----------------------------
DROP TABLE IF EXISTS `role_page`;
CREATE TABLE `role_page`  (
  `rp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `page_id` int(11) DEFAULT NULL COMMENT '页面id',
  PRIMARY KEY (`rp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 673 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_page
-- ----------------------------
INSERT INTO `role_page` VALUES (1, 1, 1);
INSERT INTO `role_page` VALUES (2, 1, 2);
INSERT INTO `role_page` VALUES (3, 1, 3);
INSERT INTO `role_page` VALUES (4, 1, 4);
INSERT INTO `role_page` VALUES (551, 3, 6);
INSERT INTO `role_page` VALUES (552, 3, 8);
INSERT INTO `role_page` VALUES (589, 2, 9);
INSERT INTO `role_page` VALUES (590, 2, 11);
INSERT INTO `role_page` VALUES (591, 2, 12);
INSERT INTO `role_page` VALUES (592, 2, 14);
INSERT INTO `role_page` VALUES (593, 2, 16);
INSERT INTO `role_page` VALUES (594, 2, 18);
INSERT INTO `role_page` VALUES (656, 1, 6);
INSERT INTO `role_page` VALUES (657, 1, 7);
INSERT INTO `role_page` VALUES (658, 1, 8);
INSERT INTO `role_page` VALUES (659, 1, 9);
INSERT INTO `role_page` VALUES (660, 1, 10);
INSERT INTO `role_page` VALUES (661, 1, 11);
INSERT INTO `role_page` VALUES (662, 1, 12);
INSERT INTO `role_page` VALUES (663, 1, 13);
INSERT INTO `role_page` VALUES (664, 1, 14);
INSERT INTO `role_page` VALUES (665, 1, 15);
INSERT INTO `role_page` VALUES (666, 1, 16);
INSERT INTO `role_page` VALUES (667, 1, 17);
INSERT INTO `role_page` VALUES (668, 1, 18);
INSERT INTO `role_page` VALUES (669, 1, 19);
INSERT INTO `role_page` VALUES (670, 1, 20);
INSERT INTO `role_page` VALUES (671, 1, 21);
INSERT INTO `role_page` VALUES (672, 1, 22);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `id_card` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证号',
  `company_id` bigint(20) UNSIGNED DEFAULT NULL COMMENT '入住公司id',
  `post` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职位',
  `role` int(5) UNSIGNED NOT NULL COMMENT '角色id',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改日期',
  `company_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公司名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '18899998888', '123111@qq.com', '123', NULL, '超级管理员11', 1, '2019-12-30 21:37:30', NULL, NULL);
INSERT INTO `user` VALUES (3, 'test1', 'e10adc3949ba59abbe56e057f20f883e', '17788889999', '445@qq.com', '123456789', 12, 'dd', 2, '2019-12-31 10:23:43', NULL, NULL);
INSERT INTO `user` VALUES (5, 'e5551', 'e10adc3949ba59abbe56e057f20f883e', '17788885555', '111@qq.com', '123456', NULL, 'dd', 2, '2019-12-31 11:12:25', NULL, NULL);
INSERT INTO `user` VALUES (6, 'd222', 'e10adc3949ba59abbe56e057f20f883e', '17788882222', '111@qq.com', 'ddd', NULL, 'dd', 2, '2019-12-31 11:21:51', NULL, NULL);
INSERT INTO `user` VALUES (7, 'admin1', 'e10adc3949ba59abbe56e057f20f883e', '155', '123@qq.com', '666', NULL, '', 3, '2020-01-01 12:53:06', NULL, '');
INSERT INTO `user` VALUES (8, '55ttt', 'e10adc3949ba59abbe56e057f20f883e', '155', '155', '1555', NULL, '开发', 2, '2020-01-01 12:57:31', NULL, '徐州工程');
INSERT INTO `user` VALUES (9, '王仁', 'e10adc3949ba59abbe56e057f20f883e', '155', '156', '555', NULL, '', 3, '2020-01-01 13:00:32', NULL, '');
INSERT INTO `user` VALUES (10, '李先生', 'e10adc3949ba59abbe56e057f20f883e', '13685175222', '1234678@qq.com', '303336198807140561', NULL, 'dd', 3, '2020-01-01 19:50:48', NULL, NULL);
INSERT INTO `user` VALUES (11, 'xxxx', 'e10adc3949ba59abbe56e057f20f883e', '1111', '111', '111', NULL, '', 3, '2020-01-01 22:20:06', NULL, '');
INSERT INTO `user` VALUES (15, '公务员', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', '1111@qq.com', '', NULL, '科员', 2, '2020-01-02 00:06:30', NULL, NULL);
INSERT INTO `user` VALUES (16, '考研', 'e10adc3949ba59abbe56e057f20f883e', '11111111113', '345@qq.com', '', NULL, '科员', 3, '2020-01-02 00:07:05', NULL, NULL);
INSERT INTO `user` VALUES (19, 'wtt', 'e10adc3949ba59abbe56e057f20f883e', '12345678900', '', '1234567890', NULL, '', 2, '2020-01-02 09:51:44', NULL, NULL);
INSERT INTO `user` VALUES (20, 'aaa', '47bce5c74f589f4867dbd57e9ca9f808', '12345678901', 'aadfa', 'aadfa', NULL, 'adasf', 2, '2020-01-09 17:55:58', NULL, 'adadfa');
INSERT INTO `user` VALUES (21, '王者归来', '3a300c48b47b714d9821dc473304aa84', '13826161592', '1713134824@qq.com', '5689741', NULL, 'afadfasfas', 2, '2020-01-13 12:23:04', NULL, 'adafafa');
INSERT INTO `user` VALUES (22, 'Vicetone', '03e9ccadff599770e5a0f09747b9fb0e', '15396985413', '260294702@qq.com', '320122199810150078', NULL, '', 3, '2020-03-12 15:47:26', NULL, '');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `ur_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`ur_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 150 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, '1', 1);
INSERT INTO `user_role` VALUES (129, '5', 2);
INSERT INTO `user_role` VALUES (131, '3', 2);
INSERT INTO `user_role` VALUES (133, '6', 2);
INSERT INTO `user_role` VALUES (135, '11', 3);
INSERT INTO `user_role` VALUES (142, '10', 1);
INSERT INTO `user_role` VALUES (143, '15', 2);
INSERT INTO `user_role` VALUES (144, '16', 3);
INSERT INTO `user_role` VALUES (145, '7', 3);
INSERT INTO `user_role` VALUES (148, '19', 2);
INSERT INTO `user_role` VALUES (149, '9', 2);

-- ----------------------------
-- Table structure for word
-- ----------------------------
DROP TABLE IF EXISTS `word`;
CREATE TABLE `word`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容',
  `view_count` int(10) UNSIGNED DEFAULT 0 COMMENT '查看次数',
  `type` int(5) DEFAULT NULL COMMENT '类型：2概况、3公告、4新闻快递、11国家政策、12省市政策、13园区政策',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of word
-- ----------------------------
INSERT INTO `word` VALUES (1, '国家政策1', '<p>要显示的文字内容</p>', 3, 15, '2019-12-31 16:27:03', NULL);
INSERT INTO `word` VALUES (2, '国家政策2带图片', '<p><img alt=\"\" src=\"/file/bb12d36f-c1f8-4d81-be8e-88c93a4432c0.png\" style=\"height:512px; width:512px\" />要显示的文字内容</p>', 2, 15, '2019-12-31 22:09:54', NULL);
INSERT INTO `word` VALUES (6, '555555', '<p><strong>请填写文字内容</strong></p>\n\n<p><strong><img alt=\"\" src=\"/file/0f7283aa-2187-44ef-92e5-b71dc4fbaaa1.jpg\" style=\"height:75px; width:120px\" /></strong></p>', 4, 15, '2020-01-01 22:26:00', NULL);
INSERT INTO `word` VALUES (8, '新闻', '<p><strong>请填写文字内容</strong><img alt=\"\" src=\"/file/d937f9a9-a096-48f9-9c0e-b662c787f3e7.png\" style=\"height:256px; width:256px\" /></p>', 14, 15, '2020-01-02 21:53:23', NULL);
INSERT INTO `word` VALUES (10, '委屈恶气呃', '<p>撒旦飒飒大大</p>', 0, 12, '2020-01-03 15:50:12', NULL);
INSERT INTO `word` VALUES (11, '放无色无', '<p>你好nsidasd</p>', 1, 11, '2020-01-03 15:51:00', NULL);
INSERT INTO `word` VALUES (12, 'ghg', '<p><img alt=\"\" src=\"/file/cc32a26f-ece8-4bf0-81a2-12e7da7ab90e.jpg\" style=\"height:1200px; width:1920px\" />请填写文字内容</p>', 5, 11, '2020-01-03 16:26:01', NULL);
INSERT INTO `word` VALUES (13, '哆啦', '<p><img alt=\"\" src=\"/file/ac97b035-0722-4374-b0f1-8aea4efe81b7.jpg\" style=\"height:1921px; width:1080px\" />请填写文字内容</p>', 2, 15, '2020-01-06 14:21:29', NULL);
INSERT INTO `word` VALUES (14, '哆啦', '<p><img alt=\"\" src=\"/file/ac97b035-0722-4374-b0f1-8aea4efe81b7.jpg\" style=\"height:1921px; width:1080px\" />请填写文字内容</p>', 6, 15, '2020-01-06 14:21:31', NULL);
INSERT INTO `word` VALUES (15, '校园景石拆运及安装摆放项目', '<table align=\"center\" style=\"width:1002px\">\n	<tbody>\n		<tr>\n			<td style=\"vertical-align:top; width:794px\">\n			<table align=\"center\" style=\"width:794px\">\n				<tbody>\n					<tr>\n						<td style=\"height:120px; width:772px\">\n						<h1>评审结果公示：校园景石拆运及安装摆放项目</h1>\n\n						<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;招投标办公室于2020年1月6日组织了&ldquo;校园景石拆运及安装摆放&rdquo;项目采购评审，（服）[2019]019号。评审委员会依据采购文件确定的程序，经过客观公正的评定，确定了该项目评审结果，现公示如下：</p>\n\n						<p>&nbsp;&nbsp;&nbsp;&nbsp;拟中标人：重庆龙力园林建设有限公司，中标价（￥）110000元。</p>\n\n						<p>其他有效投标人：江苏共铸建筑工程有限公司，投标报价（￥）117900元；江苏子午建设工程有限公司；投标报价（￥）138000元。</p>\n\n						<p>各投标人对评审结果有异议的，可以在知道或者应当知道其权益受到损害之日起按《政府采购质疑和投诉办法》（财政部令第94号）和采购文件要求，在规定的时间内，以书面形式（法定代表人或委托代理人签字，并加盖投标人单位公章有效）向徐州工程学院招投标办公室提出质疑，逾期不再受理。</p>\n\n						<p>请拟中标人务必于三日内（2020年1月9日16：00时前）按采购文件规定交纳履约保证金。三日内无异议，且已经交纳履约保证金，将向拟中标人发出中标通知书，不再发布中标公告。</p>\n\n						<p>联系电话：0516-83200231。</p>\n\n						<p>在此，谨对参与本项目的投标人表示感谢!</p>\n\n						<p><img alt=\"\" src=\"/file/10bdd4dd-95c9-4327-8921-800d5f025810.jpg\" style=\"height:397px; width:224px\" /></p>\n						</td>\n					</tr>\n				</tbody>\n			</table>\n			</td>\n		</tr>\n	</tbody>\n</table>\n\n<p>请填写文字内容</p>', 12, 16, '2020-01-06 17:04:05', NULL);
INSERT INTO `word` VALUES (17, '123', '<p>请填写文字内容耳温枪无</p>', 3, 16, '2020-01-07 12:52:01', NULL);
INSERT INTO `word` VALUES (18, '12', '<p>请填写文字内容</p>', 2, 15, '2020-03-24 15:40:21', NULL);

SET FOREIGN_KEY_CHECKS = 1;
