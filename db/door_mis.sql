/*
SQLyog Ultimate v8.53 
MySQL - 5.5.27 : Database - door_mis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`door_mis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `door_mis`;

/*Table structure for table `t_authority` */

DROP TABLE IF EXISTS `t_authority`;

CREATE TABLE `t_authority` (
  `name` varchar(50) NOT NULL COMMENT '权限名',
  `value` varchar(100) DEFAULT NULL COMMENT '权限值，比如url',
  `for_all` int(1) DEFAULT '0' COMMENT '是否对所有的权限都有权限',
  `must_has_login` int(1) DEFAULT '0' COMMENT '必须已经登陆， 此字段只有在for_all=1时才有意义',
  `comments` varchar(200) DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_authority` */

insert  into `t_authority`(`name`,`value`,`for_all`,`must_has_login`,`comments`) values ('client_add','/client/add',0,0,'新增客户'),('client_delete','/client/delete',0,0,'删除客户'),('client_goto_add_page','/client/goto_add_page',0,0,'打开新增客户页面'),('client_goto_main_page','/client/goto_main_page',0,0,'打开客户管理页面'),('client_goto_update_page','/client/goto_update_page',0,0,'打开修改客户页面'),('client_update','/client/update',0,0,'修改客户信息'),('goto_login_page','/goto_login_page',1,0,'打开登陆页面'),('login','/login',1,0,'登陆'),('logout','/logout',1,0,'注销'),('user_add','/user/add',0,0,'新增用户'),('user_delete','/user/delete',0,0,'删除用户'),('user_goto_add_page','/user/goto_add_page',0,0,'打开新增用户页面'),('user_goto_main_page','/user/goto_main_page',0,0,'打开用户管理页面'),('user_goto_update_page','/user/goto_update_page',0,0,'打开修改用户页面'),('user_goto_update_pwd_page','/user/goto_update_pwd_page',1,1,'打开修改密码页面'),('user_update','/user/update',0,0,'修改用户信息'),('user_update_pwd','/user/update_pwd',1,1,'修改密码');

/*Table structure for table `t_client` */

DROP TABLE IF EXISTS `t_client`;

CREATE TABLE `t_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ver_nbr` int(11) NOT NULL DEFAULT '1',
  `real_name` varchar(30) NOT NULL,
  `code` varchar(20) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `wechat` varchar(100) DEFAULT NULL,
  `logistics` varchar(100) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `add_user_id` int(11) NOT NULL,
  `add_time` datetime NOT NULL,
  `soft_del` int(11) DEFAULT '0' COMMENT '是否已删除，软删除',
  `del_user_id` int(11) DEFAULT '0' COMMENT '删除人id',
  `del_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_client_real_name` (`real_name`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `t_client` */

insert  into `t_client`(`id`,`ver_nbr`,`real_name`,`code`,`phone`,`address`,`wechat`,`logistics`,`remark`,`add_user_id`,`add_time`,`soft_del`,`del_user_id`,`del_time`) values (1,1,'a','b','c','d','e','f',NULL,1,'2017-03-05 20:29:54',0,0,NULL),(3,1,'aa','b','c','d','e','f','g',1,'2017-03-05 20:36:57',0,0,NULL),(6,3,'asdfsaf','bb','cc','dd','ee','ff','gg',1,'2017-03-05 20:39:17',0,0,NULL),(7,1,'sdf','asas','asf','asfd','asfas','fasd','fsaf',1,'2017-03-08 21:45:46',0,0,NULL),(8,1,'as','dfsad','fsadf','asdf','','','',1,'2017-03-08 21:45:50',0,0,NULL),(9,1,'aaaaaaaaaaaaaa','aaaaaaaaaaaaaaaaaaaa','aaaaaaaaaaa','aaaaaaaaaa','aaaaaaaaa','','',1,'2017-03-08 21:45:55',0,0,NULL),(10,1,'213','3','2323','2','33','','',1,'2017-03-08 21:46:00',0,0,NULL),(11,1,'32','4','23423','423','4234','','',1,'2017-03-08 21:46:04',0,0,NULL),(13,1,'23423423','432','423','423432','','','',1,'2017-03-08 21:46:16',0,0,NULL),(14,1,'333333333333333','33','3','3','33','','',1,'2017-03-08 21:46:22',0,0,NULL),(15,1,'ere','234','234','234','','','',1,'2017-03-08 21:46:31',0,0,NULL),(16,1,'ghj','ghj','ghj','ghj','','','',1,'2017-03-08 21:46:35',0,0,NULL),(17,1,'ghjt','ghjh','gjhg','jgh','j','','',1,'2017-03-08 21:46:40',0,0,NULL),(18,1,'ytuoui','uio','uioui','oui','ouio','','',1,'2017-03-08 21:46:45',0,0,NULL),(19,1,'uio','uioiuo','uio','uio','uio','','',1,'2017-03-08 21:46:49',0,0,NULL),(20,1,'uioiuou','uio','uioui','ouio','','','',1,'2017-03-08 21:46:54',0,0,NULL),(21,1,'uuuuuuu','uuuuuuu','uuuuuuuuuuuu','uuuuuuuuuu','uuuuuuuuuuuu','','',1,'2017-03-08 21:46:59',0,0,NULL),(22,2,'2222222','iuoiu','ui','oiuo','ouiouio','','',1,'2017-03-08 21:47:09',0,0,NULL),(23,1,'asd','fsda','fsdaf','sadf','','','',1,'2017-03-08 21:49:10',0,0,NULL),(24,1,'6867','67','867','8678','','','',1,'2017-03-08 21:49:15',0,0,NULL),(25,1,'hjkghjk','ghkj','hgjk','hgkhgjk','hgkjj','hgkhg','',1,'2017-03-08 21:49:21',0,0,NULL),(26,1,'df','sgsd','sfsaf','dsfa','sdfsa','dfsadf','safsafdas',1,'2017-03-09 21:49:10',0,0,NULL),(27,1,'asddfadsfasd','fsaf','dsafsad','fsdf','sad','fasd','fasdfa',1,'2017-03-09 22:42:53',0,0,NULL);

/*Table structure for table `t_client_query` */

DROP TABLE IF EXISTS `t_client_query`;

CREATE TABLE `t_client_query` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `query_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_client_query` */

/*Table structure for table `t_role_authority` */

DROP TABLE IF EXISTS `t_role_authority`;

CREATE TABLE `t_role_authority` (
  `role` varchar(20) NOT NULL,
  `authority` varchar(50) NOT NULL,
  PRIMARY KEY (`role`,`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_role_authority` */

insert  into `t_role_authority`(`role`,`authority`) values ('ADMIN','client_add'),('ADMIN','client_delete'),('ADMIN','client_goto_add_page'),('ADMIN','client_goto_main_page'),('ADMIN','client_goto_update_page'),('ADMIN','client_update'),('ADMIN','user_add'),('ADMIN','user_delete'),('ADMIN','user_goto_add_page'),('ADMIN','user_goto_main_page'),('ADMIN','user_goto_update_page'),('ADMIN','user_update'),('EMPL','client_goto_main_page');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `ver_nbr` int(11) NOT NULL DEFAULT '1',
  `user_name` varchar(50) NOT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `role` varchar(10) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `real_name` varchar(50) DEFAULT NULL,
  `state_id` int(11) NOT NULL,
  `add_user_id` int(11) NOT NULL,
  `add_time` datetime NOT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `last_access_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_user_login_name` (`user_name`),
  KEY `idx_add_time` (`add_time`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`ver_nbr`,`user_name`,`pwd`,`role`,`phone`,`real_name`,`state_id`,`add_user_id`,`add_time`,`remark`,`last_login_time`,`last_access_time`) values (1,5,'admin','aa','ADMIN',NULL,'夏',1,1,'2017-02-26 11:15:30',NULL,'2017-03-09 22:42:18',NULL),(2,1,'op1','aa','EMPL',NULL,NULL,1,1,'2017-03-02 22:44:00',NULL,NULL,NULL),(3,1,'a','c','EMPL','asdfsaf','b',1,1,'2017-03-05 21:31:12','',NULL,NULL),(4,5,'aa','aa','EMPL','asdfsaf','b',1,1,'2017-03-05 21:32:47','asdfadsf','2017-03-09 22:56:09',NULL),(5,1,'ddd','ddd','EMPL','ddd','ddd',1,1,'2017-03-05 21:45:57','ddd',NULL,NULL),(6,1,'1','3','ADMIN','4','2',0,1,'2017-03-05 21:46:14','5',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
