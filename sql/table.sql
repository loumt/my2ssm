CREATE TABLE `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '日志触发时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

alter table log add `username` varchar(255) DEFAULT null comment '用户名';

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(64) NOT NULL COMMENT '用户账号',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(255) DEFAULT NULL COMMENT '用户地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';


CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(255) NOT NULL COMMENT '角色名',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色表';


CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';