create table `template` (
    `id` int not null auto_increment,
    `template_id` varchar(32) not null,
    `template_status` tinyint(3) DEFAULT '0' COMMENT '模版状态,0可用1不可用',
    `template_content` TEXT NOT NULL,
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key(`id`),
    CONSTRAINT `uqe_template_id` UNIQUE (`template_id`)
) comment '模版信息表' DEFAULT CHARSET=utf8;

create table `jsondata` (
    `id` int not null auto_increment,
    `data_id` varchar(32) not null,
    `data_content` TEXT NOT NULL,
    `template_id` varchar(32) not null,
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key(`id`)
) comment 'json数据信息表' DEFAULT CHARSET=utf8;