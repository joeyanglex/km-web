
/*CREATE TABLE `schedule_job` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `class_name` varchar(50) NOT NULL,
  `cron_expression` varchar(50) NOT NULL COMMENT 'cron表达式',
  `job_name` varchar(50) NOT NULL COMMENT '任务名称',
  `job_group` varchar(50) NOT NULL COMMENT '任务分组',
  `trigger_name` varchar(50) NOT NULL COMMENT '定时器名称',
  `trigger_group` varchar(50) NOT NULL COMMENT '定时器分组',
  `pause` TINYINT(1) NOT NULL COMMENT '暂停',
  `enable` TINYINT(1) NOT NULL COMMENT '启用/停用',
	`description` varchar(50) NOT NULL COMMENT '描述',
	`create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8;*/


-- INSERT INTO schedule_job (id, class_name, cron_expression, job_name, job_group, trigger_name, trigger_group, pause, enable, description, create_time, last_update_time)
-- VALUES (2, 'top.keepmoving.kmweb.web.quartz.job.TestJob', '*/10 * * * * ?', 'testJob', 'TEST_GROUP', 'TEST_TRIGGER',
--            'TEST_GROUP', 0, 1, 'test Job for SpringBoot', '2018-02-12 14:14:03', '2018-02-12 15:23:24');