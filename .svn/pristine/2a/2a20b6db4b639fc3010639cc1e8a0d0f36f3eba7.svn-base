/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : gansu

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 11/02/2019 09:37:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_answer
-- ----------------------------
DROP TABLE IF EXISTS `tbl_answer`;
CREATE TABLE `tbl_answer`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '投票的用户id',
  `questionnaire_id` bigint(20) NULL DEFAULT NULL COMMENT '问题调查表id',
  `question_id` bigint(20) NULL DEFAULT NULL COMMENT '用户作出选择的问题id',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简答题答案',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_user`(`user_id`) USING BTREE,
  INDEX `fk_questionnaire`(`questionnaire_id`) USING BTREE,
  INDEX `fk_question`(`question_id`) USING BTREE,
  CONSTRAINT `fk_question` FOREIGN KEY (`question_id`) REFERENCES `tbl_question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_questionnaire` FOREIGN KEY (`questionnaire_id`) REFERENCES `tbl_questionnaire` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_banner
-- ----------------------------
DROP TABLE IF EXISTS `tbl_banner`;
CREATE TABLE `tbl_banner`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `banner_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'banner图片名称',
  `banner_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'banner图片地址',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序字段',
  `status` int(2) NULL DEFAULT NULL COMMENT '启用状态（0：不展示,1展示）',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_catagory
-- ----------------------------
DROP TABLE IF EXISTS `tbl_catagory`;
CREATE TABLE `tbl_catagory`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `sort` int(10) NULL DEFAULT NULL COMMENT '分类排序',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_city
-- ----------------------------
DROP TABLE IF EXISTS `tbl_city`;
CREATE TABLE `tbl_city`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市州名',
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市州code',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `code`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_collection
-- ----------------------------
DROP TABLE IF EXISTS `tbl_collection`;
CREATE TABLE `tbl_collection`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id（收藏者）',
  `course_id` bigint(20) NULL DEFAULT NULL COMMENT '课程id',
  `collection_time` datetime(0) NULL DEFAULT NULL COMMENT '收藏时间',
  `status` int(2) NULL DEFAULT NULL COMMENT '收藏状态',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_collection_user`(`user_id`) USING BTREE,
  INDEX `fk_collection_course`(`course_id`) USING BTREE,
  CONSTRAINT `fk_collection_course` FOREIGN KEY (`course_id`) REFERENCES `tbl_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_collection_user` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_collectiontag
-- ----------------------------
DROP TABLE IF EXISTS `tbl_collectiontag`;
CREATE TABLE `tbl_collectiontag`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名',
  `collection_id` bigint(20) NULL DEFAULT NULL COMMENT '收藏id',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '标签所属用户id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_collectiontag`(`collection_id`) USING BTREE,
  INDEX `fk_collectiontag_user`(`user_id`) USING BTREE,
  CONSTRAINT `fk_collectiontag` FOREIGN KEY (`collection_id`) REFERENCES `tbl_collection` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_collectiontag_user` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_course
-- ----------------------------
DROP TABLE IF EXISTS `tbl_course`;
CREATE TABLE `tbl_course`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程标题',
  `thumbnail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缩略图',
  `author_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程作者（老师）',
  `type_id` int(10) NULL DEFAULT NULL COMMENT '课程类型（暂未定）',
  `tag_id` bigint(20) NULL DEFAULT NULL COMMENT '课程标签id',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程简介',
  `audit_status` int(2) NULL DEFAULT NULL COMMENT '课程状态（0：未审核，1：审核通过，2：审核未通过，3：下架）',
  `audit_opinion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员审核意见',
  `star_level` int(2) NULL DEFAULT NULL COMMENT '星级（0：0星，1:1星，以此类推到5：5星）',
  `status` int(2) NULL DEFAULT NULL COMMENT '更新状态（0：正在更新，1：已完结）',
  `view_count` bigint(20) NULL DEFAULT NULL COMMENT '浏览量',
  `collection_count` bigint(20) NULL DEFAULT NULL COMMENT '收藏量',
  `add_study_count` bigint(20) NULL DEFAULT NULL COMMENT '被加入学习计划数量',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_course_tag`(`tag_id`) USING BTREE,
  CONSTRAINT `fk_course_tag` FOREIGN KEY (`tag_id`) REFERENCES `tbl_course_tag` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_course_tag
-- ----------------------------
DROP TABLE IF EXISTS `tbl_course_tag`;
CREATE TABLE `tbl_course_tag`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `tag_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签code',
  `tag_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签value',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_courseperiod
-- ----------------------------
DROP TABLE IF EXISTS `tbl_courseperiod`;
CREATE TABLE `tbl_courseperiod`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课时标题',
  `sort` int(10) NULL DEFAULT NULL COMMENT '排序字段',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '时长',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频url',
  `course_id` bigint(20) NULL DEFAULT NULL COMMENT '课程id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_period_course`(`course_id`) USING BTREE,
  CONSTRAINT `fk_period_course` FOREIGN KEY (`course_id`) REFERENCES `tbl_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_credit_record
-- ----------------------------
DROP TABLE IF EXISTS `tbl_credit_record`;
CREATE TABLE `tbl_credit_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `type` int(2) NULL DEFAULT NULL COMMENT '加分类型（0：看新闻，1：看课时，2：兑换商品）',
  `change_count` bigint(20) NULL DEFAULT NULL COMMENT '本次变化分值',
  `previous_credit` bigint(20) NULL DEFAULT NULL COMMENT '加分前总学分',
  `now_credit` bigint(20) NULL DEFAULT NULL COMMENT '加分后总学分',
  `news_id` bigint(20) NULL DEFAULT NULL COMMENT '新闻id',
  `course_period_id` bigint(20) NULL DEFAULT NULL COMMENT '课时id',
  `goods_id` bigint(20) NULL DEFAULT NULL COMMENT '商品id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_credit_record_userId`(`user_id`) USING BTREE,
  INDEX `fk_credit_record_news`(`news_id`) USING BTREE,
  INDEX `fk_credit_record_coursePriod`(`course_period_id`) USING BTREE,
  INDEX `fk_credit_goods`(`goods_id`) USING BTREE,
  CONSTRAINT `fk_credit_goods` FOREIGN KEY (`goods_id`) REFERENCES `tbl_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_credit_record_coursePriod` FOREIGN KEY (`course_period_id`) REFERENCES `tbl_courseperiod` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_credit_record_news` FOREIGN KEY (`news_id`) REFERENCES `tbl_news` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_credit_record_userId` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_file
-- ----------------------------
DROP TABLE IF EXISTS `tbl_file`;
CREATE TABLE `tbl_file`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件地址',
  `course_id` bigint(20) NULL DEFAULT NULL COMMENT '关联的课程id',
  `upload_time` datetime(0) NULL DEFAULT NULL COMMENT '上传时间',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_course`(`course_id`) USING BTREE,
  CONSTRAINT `fk_course` FOREIGN KEY (`course_id`) REFERENCES `tbl_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_goods
-- ----------------------------
DROP TABLE IF EXISTS `tbl_goods`;
CREATE TABLE `tbl_goods`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `thumb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缩略小图',
  `imgs` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '详情大图片数组',
  `price` int(10) NULL DEFAULT NULL COMMENT '商品价格（兑换所需学分）',
  `persistent_stock` int(10) NULL DEFAULT NULL COMMENT '管理员定义的原有总库存',
  `stock` int(10) NULL DEFAULT NULL COMMENT '剩余库存',
  `creator_id` bigint(20) NULL DEFAULT NULL COMMENT '管理员id',
  `exchange_start_time` datetime(0) NULL DEFAULT NULL COMMENT '商品可兑换开始时间',
  `exchange_end_time` datetime(0) NULL DEFAULT NULL COMMENT '商品可兑换截止时间',
  `catagory_id` bigint(20) NULL DEFAULT NULL COMMENT '商品所属类别id',
  `view_count` bigint(20) NULL DEFAULT NULL COMMENT '浏览量',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_goods_catagory`(`catagory_id`) USING BTREE,
  CONSTRAINT `fk_goods_catagory` FOREIGN KEY (`catagory_id`) REFERENCES `tbl_catagory` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_livecourse
-- ----------------------------
DROP TABLE IF EXISTS `tbl_livecourse`;
CREATE TABLE `tbl_livecourse`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '直播课程名',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '直播开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '直播结束时间',
  `creator_id` bigint(20) NULL DEFAULT NULL COMMENT '直播的老师id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_live_user`(`creator_id`) USING BTREE,
  CONSTRAINT `fk_live_user` FOREIGN KEY (`creator_id`) REFERENCES `tbl_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_news
-- ----------------------------
DROP TABLE IF EXISTS `tbl_news`;
CREATE TABLE `tbl_news`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新闻标题',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新闻描述',
  `content_id` bigint(20) NULL DEFAULT NULL COMMENT '新闻内容Id（暂定被富文本编辑器转义后的html）',
  `view_count` bigint(20) NULL DEFAULT NULL COMMENT '浏览量',
  `like_count` bigint(20) NULL DEFAULT NULL COMMENT '点赞量',
  `collection_count` bigint(20) NULL DEFAULT NULL COMMENT '收藏量',
  `creator` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `thumbnail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缩略图',
  `status` int(2) NULL DEFAULT 0 COMMENT '是否在首页以缩略图的形式展示（0：不展示，1展示）',
  `updator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `attachment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件地址',
  `key_words` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关键词',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_news_tag
-- ----------------------------
DROP TABLE IF EXISTS `tbl_news_tag`;
CREATE TABLE `tbl_news_tag`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `news_id` bigint(20) NULL DEFAULT NULL COMMENT '新闻id',
  `tag_id` bigint(20) NULL DEFAULT NULL COMMENT '标签id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_newsId`(`news_id`) USING BTREE,
  INDEX `fk_tagId`(`tag_id`) USING BTREE,
  CONSTRAINT `fk_newsId` FOREIGN KEY (`news_id`) REFERENCES `tbl_news` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tagId` FOREIGN KEY (`tag_id`) REFERENCES `tbl_tag` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_news_text
-- ----------------------------
DROP TABLE IF EXISTS `tbl_news_text`;
CREATE TABLE `tbl_news_text`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '新闻内容html',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_notice
-- ----------------------------
DROP TABLE IF EXISTS `tbl_notice`;
CREATE TABLE `tbl_notice`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告标题',
  `creator_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者id',
  `lesson_id` bigint(20) NULL DEFAULT NULL COMMENT '公告所属课程',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `content_id` bigint(20) NULL DEFAULT NULL COMMENT '关联公告内容Id',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_notice_creator`(`creator_id`) USING BTREE,
  CONSTRAINT `fk_notice_creator` FOREIGN KEY (`creator_id`) REFERENCES `tbl_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_notice_text
-- ----------------------------
DROP TABLE IF EXISTS `tbl_notice_text`;
CREATE TABLE `tbl_notice_text`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '公告内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_option
-- ----------------------------
DROP TABLE IF EXISTS `tbl_option`;
CREATE TABLE `tbl_option`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `option` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项内容',
  `question_id` bigint(20) NULL DEFAULT NULL COMMENT '选项所属问题id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_question1`(`question_id`) USING BTREE,
  CONSTRAINT `fk_question1` FOREIGN KEY (`question_id`) REFERENCES `tbl_question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_question
-- ----------------------------
DROP TABLE IF EXISTS `tbl_question`;
CREATE TABLE `tbl_question`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问题题干（问题内容）',
  `questionnaire_id` bigint(20) NULL DEFAULT NULL COMMENT '所属问卷调查表id',
  `quesion_no` int(11) NULL DEFAULT NULL COMMENT '题号（题目排序顺序）',
  `type` int(2) NULL DEFAULT NULL COMMENT '题目类型（0：选择，1：简答题）',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_tbl_question_tbl_questionnaire_1`(`questionnaire_id`) USING BTREE,
  CONSTRAINT `fk_tbl_question_tbl_questionnaire_1` FOREIGN KEY (`questionnaire_id`) REFERENCES `tbl_questionnaire` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `tbl_questionnaire`;
CREATE TABLE `tbl_questionnaire`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问卷题干',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问答题内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `creator_id` bigint(20) NULL DEFAULT NULL COMMENT '创建问卷的教师',
  `course_id` bigint(20) NULL DEFAULT NULL COMMENT '课程id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_creator`(`creator_id`) USING BTREE,
  INDEX `fk_questionnaire_course`(`course_id`) USING BTREE,
  CONSTRAINT `fk_creator` FOREIGN KEY (`creator_id`) REFERENCES `tbl_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_questionnaire_course` FOREIGN KEY (`course_id`) REFERENCES `tbl_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_site
-- ----------------------------
DROP TABLE IF EXISTS `tbl_site`;
CREATE TABLE `tbl_site`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子站名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子站url',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_tag
-- ----------------------------
DROP TABLE IF EXISTS `tbl_tag`;
CREATE TABLE `tbl_tag`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_teachingresource
-- ----------------------------
DROP TABLE IF EXISTS `tbl_teachingresource`;
CREATE TABLE `tbl_teachingresource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源标题',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源描述',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源类型（0：视频，1：图文）',
  `content` bigint(20) NULL DEFAULT NULL COMMENT '资源内容id（图文的html，视频的地址）',
  `view_count` bigint(20) NULL DEFAULT NULL COMMENT '浏览量',
  `like_count` bigint(20) NULL DEFAULT NULL COMMENT '点赞量',
  `collection_count` bigint(20) NULL DEFAULT NULL COMMENT '收藏量',
  `thumbnail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缩略图地址',
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_teachingresource_text
-- ----------------------------
DROP TABLE IF EXISTS `tbl_teachingresource_text`;
CREATE TABLE `tbl_teachingresource_text`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'content 教学资源内容，按照type确认内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_themecolor
-- ----------------------------
DROP TABLE IF EXISTS `tbl_themecolor`;
CREATE TABLE `tbl_themecolor`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `theme_color` int(2) NULL DEFAULT NULL COMMENT '主题颜色（1：日常绿色，2：重阳节菊黄色，3：春节大红色，4：学习周墨绿色）',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `identification_no` int(5) NULL DEFAULT NULL COMMENT '用户身份证号',
  `credit` int(10) NULL DEFAULT NULL COMMENT '用户学分总分',
  `role` int(2) NULL DEFAULT NULL COMMENT '(0:学生，1：老师)',
  `city` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属市、州',
  `is_volunteer` int(2) NULL DEFAULT 0 COMMENT '是否为志愿者（0：不是，1：是）',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户电话号码',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像地址',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱地址',
  `sex` int(2) NULL DEFAULT NULL COMMENT '用户性别(0:女，1：男)',
  `age` int(11) NULL DEFAULT NULL COMMENT '用户年龄',
  `sign` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户签名',
  `qq` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户qq号码',
  `wechat` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户微信号',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_city`(`city`) USING BTREE,
  CONSTRAINT `fk_city` FOREIGN KEY (`city`) REFERENCES `tbl_city` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_user_course
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_course`;
CREATE TABLE `tbl_user_course`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `course_id` bigint(20) NULL DEFAULT NULL COMMENT '课程id',
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '加入学习计划时间',
  `status` int(2) NULL DEFAULT NULL COMMENT '学习状态（0：学习中，1：已学完）',
  `percent` int(2) NULL DEFAULT NULL COMMENT '课程学习进度百分比',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_user_courseId`(`course_id`) USING BTREE,
  INDEX `fk_user_course_user`(`user_id`) USING BTREE,
  CONSTRAINT `fk_user_courseId` FOREIGN KEY (`course_id`) REFERENCES `tbl_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_user_course_user` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_user_coursepriod
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_coursepriod`;
CREATE TABLE `tbl_user_coursepriod`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `course_priodId` bigint(20) NULL DEFAULT NULL COMMENT '课时id',
  `percent` int(2) NULL DEFAULT NULL COMMENT '用户学习课时已看完的百分比（学习进度）',
  `status` int(2) NULL DEFAULT NULL COMMENT '课时学习状态（0：未看，1：已看，尚未看完，2：已看完（大于等于80%算看完））',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_user_coursePeriod`(`course_priodId`) USING BTREE,
  INDEX `fk_coursePriod_userId`(`user_id`) USING BTREE,
  CONSTRAINT `fk_coursePriod_userId` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_user_coursePeriod` FOREIGN KEY (`course_priodId`) REFERENCES `tbl_courseperiod` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_vote
-- ----------------------------
DROP TABLE IF EXISTS `tbl_vote`;
CREATE TABLE `tbl_vote`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投票的问题（标题）',
  `type` int(2) NULL DEFAULT NULL COMMENT '问题类型（0：纯文字，1：纯图片）',
  `option_id` int(2) NULL DEFAULT NULL COMMENT '选项id',
  `creator_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `course_id` bigint(20) NULL DEFAULT NULL COMMENT '投票所属课程id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_vote_user`(`creator_id`) USING BTREE,
  INDEX `fk_vote_course`(`course_id`) USING BTREE,
  CONSTRAINT `fk_vote_course` FOREIGN KEY (`course_id`) REFERENCES `tbl_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_vote_user` FOREIGN KEY (`creator_id`) REFERENCES `tbl_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_voteanswer
-- ----------------------------
DROP TABLE IF EXISTS `tbl_voteanswer`;
CREATE TABLE `tbl_voteanswer`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `vote_id` bigint(20) NULL DEFAULT NULL COMMENT '投票id',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户回答',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_voteanswer_user`(`user_id`) USING BTREE,
  INDEX `fk_voteanswer_vote`(`vote_id`) USING BTREE,
  CONSTRAINT `fk_voteanswer_user` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_voteanswer_vote` FOREIGN KEY (`vote_id`) REFERENCES `tbl_vote` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_voteoption
-- ----------------------------
DROP TABLE IF EXISTS `tbl_voteoption`;
CREATE TABLE `tbl_voteoption`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `option` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项',
  `content` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项内容',
  `vote_id` bigint(20) NULL DEFAULT NULL COMMENT '选项所属投票id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(2) NULL DEFAULT 1 COMMENT '0:已删除，1:未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_vote`(`vote_id`) USING BTREE,
  CONSTRAINT `fk_vote` FOREIGN KEY (`vote_id`) REFERENCES `tbl_vote` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gmt _create` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
