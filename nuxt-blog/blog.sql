create table `blog`
(
    `id`          int          not null auto_increment primary key comment '博客ID',
    `title`       varchar(128) not null comment '标题',
    `tag`         varchar(64)  not null comment '标签',
    `content`     longtext     not null comment '内容',
    `is_top`      tinyint(1)   not null default 0 comment '是否置顶 0否 1是',
    `is_delete`   tinyint(1)   not null default 0 comment '是否删除 0 1是',
    `status`      tinyint(1)   not null default 1 comment '状态值 1公开 2私密 3评论可见',
    `create_time` datetime     not null comment '发表时间',
    `update_time` datetime     not null comment '更新时间'
);

create table `user`
(
    `id`            int         not null auto_increment primary key comment '用户id',
    `nickname`      varchar(64) not null comment '用户昵称',
    `email`         varchar(64) not null comment '邮箱',
    `website`       varchar(64) comment '用户网站',
    `register_time` datetime    not null comment '注册时间'
);

create table `comment`
(
    `id`               int           not null auto_increment primary key comment 'id',
    `user_id`          int           not null comment '用户的id',
    `blog_id`          int           not null comment '博客的id',
    `content`          varchar(1024) not null comment '评论的内容',
    `parent_id`        int           null     default null comment '父评论id',
    `reply_comment_id` int           null     default null comment '回复评论id',
    `is_delete`        tinyint(1)    not null default 0 comment '是否删除 0否 1是',
    `is_review`        tinyint(1)    not null default 0 comment '是否审核过 0未审核，1审核过，审核过定时发送给回复的用户',
    `status`           tinyint(1)    not null default 0 comment '是否发送过 0未发送 1发送',
    `create_time`      datetime      not null comment '评论时间',
    `update_time`      datetime      not null comment '更新时间',
    `ip_source`        varchar(100)  not null comment 'IP 来源',
    `ip_address`       varchar(100)  not null comment 'IP地址',

    INDEX `comment_user` (`user_id`) USING BTREE,
    INDEX `comment_parent` (`parent_id`) USING BTREE
) auto_increment = 724;

