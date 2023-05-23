
CREATE TABLE `cms_article` (
	`id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
	`article_id` varchar(64) NULL COMMENT 'article业务主键',
	`title` varchar(64) NULL COMMENT '标题',
	`content` text NOT NULL COMMENT '内容',
	`publish_state` int NOT NULL COMMENT '发布状态,[0-待发布；1-已发布]',
	`deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标记[0-正常；1-已删除]',
	`created_by` VARCHAR(100) COMMENT '创建人',
	`created_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`modified_by` VARCHAR(100) COMMENT '更新人',
	`modified_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`version` bigint DEFAULT 1 COMMENT '乐观锁',
	PRIMARY KEY (`id`)
) ;