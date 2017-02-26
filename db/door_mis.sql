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

/*Table structure for table `t_client` */

DROP TABLE IF EXISTS `t_client`;

CREATE TABLE `t_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ver_nbr` int(11) NOT NULL DEFAULT '1',
  `real_name` varchar(20) NOT NULL,
  `code` varchar(20) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_client` */

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

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `ver_nbr` int(11) NOT NULL DEFAULT '1',
  `login_name` varchar(50) NOT NULL,
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
  UNIQUE KEY `uq_user_login_name` (`login_name`),
  KEY `idx_add_time` (`add_time`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`ver_nbr`,`login_name`,`pwd`,`role`,`phone`,`real_name`,`state_id`,`add_user_id`,`add_time`,`remark`,`last_login_time`,`last_access_time`) values (1,1,'admin','aa','ADMIN',NULL,'夏',1,1,'2017-02-26 11:15:30',NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
