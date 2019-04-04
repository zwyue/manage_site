新增数据库表news  site_id字段  用于关联子站表site

==========================================2019/1/24  新闻标签表tbl_tag==========================================
ALTER TABLE `gansu`.`tbl_tag`
DROP COLUMN `is_deleted`,
CHANGE COLUMN `name` `tagName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名' AFTER `id`;

==========================================2019/1/24  主题颜色表tbl_themecolor==========================================
ALTER TABLE `gansu`.`tbl_themecolor`
DROP COLUMN `is_deleted`;

ALTER TABLE `gansu`.`tbl_themecolor`
ADD COLUMN `status` int(2) NULL DEFAULT 状态是否启用（0表示未启用  1表示启用） AFTER `gmt_modified`;

==========================================2019/1/24  banner图tbl_banner==========================================
ALTER TABLE `gansu`.`tbl_banner`
DROP COLUMN `banner_id`;

==========================================2019/1/29  新闻tbl_news==========================================
ALTER TABLE `gansu`.`tbl_news`
ADD COLUMN `tag_id` bigint(20) NULL COMMENT '新闻分类id(用于关联新闻id)' AFTER `site_id`;

==========================================2019/2/11  删除表  tbl_news_tag==========================================


==========================================2019/2/12  问卷表  tbl_questionnaire==========================================
ALTER TABLE `gansu`.`tbl_questionnaire`
ADD COLUMN `status` int(2) NULL COMMENT '问卷的状态（0表示未保存  1表示可发布）' AFTER `is_deleted`;

==========================================2019/2/12  问卷问题表 tbl_question=========================================
ALTER TABLE `gansu`.`tbl_question`
DROP COLUMN `status`;


######################################## 2019/2/21  角色表 tbl_role ########################################
CREATE TABLE `gansu`.`tbl_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role` varchar(50) NULL COMMENT '权限',
  `name` varchar(50) NULL COMMENT '权限名',
  `description` varchar(100) NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) COMMENT = '角色表';
######################################## 2019/2/21  用户权限(角色)表 tbl_user_role ########################################
CREATE TABLE `gansu`.`tbl_user_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(0) NULL COMMENT '用户id',
  `role_id` bigint(0) NULL COMMENT '角色(权限)id',
  PRIMARY KEY (`id`)
) COMMENT = '用户权限(角色)表';
######################################## 2019/2/21  github用户表 tbl_user_github ########################################
CREATE TABLE `gansu`.`tbl_user_github`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(255) NULL COMMENT 'github用户名',
  `avater_url` varchar(255) NULL COMMENT '头像url',
  `html_url` varchar(255) NULL COMMENT 'github主页',
  `email` varchar(255) NULL COMMENT '邮箱',
  `user_id` bigint(20) NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) COMMENT = 'github用户表';
######################################## 2019/2/21  qq用户表 tbl_user_qq ########################################
CREATE TABLE `gansu`.`tbl_user_qq`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `open_id` int(0) NULL COMMENT 'openid',
  `nick_name` varchar(255) NULL COMMENT '用户名',
  `figure_url` varchar(255) NULL COMMENT '头像url',
  `gender` varchar(255) NULL COMMENT '性别',
  `user_id` bigint(20) NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) COMMENT = 'qq用户表';
######################################## 2019/2/21  修改用户表 tbl_user ########################################
ALTER TABLE `gansu`.`tbl_user`
ADD COLUMN `qq_id` varchar(255) NULL COMMENT 'qq的openid' AFTER `wechat`,
COMMENT = '用户表';
########################################2019/2/25  修改用户表 tbl_user ########################################
ALTER TABLE `gansu`.`tbl_user`
ADD COLUMN `github_id` varchar(255) NULL COMMENT 'github的id' AFTER `qq_id`;
######################################## 2019/2/25  修改用户表 tbl_user########################################################
ALTER TABLE `gansu`.`tbl_user`
MODIFY COLUMN `qq_id` bigint(20) NULL DEFAULT NULL COMMENT 'qq用户的id' AFTER `site_id`,
MODIFY COLUMN `github_id` bigint(20) NULL DEFAULT NULL COMMENT 'github用户的id' AFTER `qq_id`;
######################################## 2019/2/26  修改用户表 tbl_user########################################################
ALTER TABLE `gansu`.`tbl_user`
ADD COLUMN `login_name` varchar(50) NULL COMMENT '登录名(用于账号密码登录)' AFTER `id`;
######################################## 2019/2/27  修改用户表 tbl_user########################################################
ALTER TABLE `gansu`.`tbl_user`
DROP COLUMN `qq_id`,
DROP COLUMN `github_id`,
MODIFY COLUMN `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户真实姓名' AFTER `login_name`;

######################################## 2019/2/27  修改用户表 tbl_user########################################################
create table tbl_UserConnection (userId varchar(255) not null,
	providerId varchar(255) not null,
	providerUserId varchar(255),
	rank int not null,
	displayName varchar(255),
	profileUrl varchar(512),
	imageUrl varchar(512),
	accessToken varchar(512) not null,
	secret varchar(512),
	refreshToken varchar(512),
	expireTime bigint,
	primary key (userId, providerId, providerUserId));
create unique index UserConnectionRank on tbl_UserConnection(userId, providerId, rank);
######################################## 2019/2/27  修改用户表 tbl_user########################################################
CREATE TABLE `gansu`.`tbl_resourceurl`  (
  `id` bigint(0) NOT NULL COMMENT '主键id',
  `resource_url` varchar(255) NULL COMMENT '资源访问路径',
  `description` varchar(255) NULL COMMENT '访问路径资源详细描述',
  PRIMARY KEY (`id`)
) COMMENT = '各资源访问路径表---标识各个可能受限资源的访问路径';

CREATE TABLE `gansu`.`tbl_role_resourceurl`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `resourceurl_id` bigint(20) NULL COMMENT '资源访问路径主键',
  `role_id` bigint(20) NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) COMMENT = '角色-访问路径表';

ALTER TABLE `gansu`.`tbl_resourceurl`
MODIFY COLUMN `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' FIRST;