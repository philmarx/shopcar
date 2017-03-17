/*
SQLyog v10.2 
MySQL - 5.7.10-enterprise-commercial-advanced-log : Database - shopcar
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shopcar` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `shopcar`;

/*Table structure for table `buy` */

DROP TABLE IF EXISTS `buy`;

CREATE TABLE `buy` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `shopcar_id` int(11) NOT NULL COMMENT '购物车ID',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品ID',
  `count` int(11) DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`),
  KEY `shopcar_id` (`shopcar_id`),
  KEY `goods_id` (`goods_id`),
  CONSTRAINT `buy_ibfk_1` FOREIGN KEY (`shopcar_id`) REFERENCES `shopcar` (`id`),
  CONSTRAINT `buy_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `buy` */

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `view_pic` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '预览图',
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `store_number` int(11) DEFAULT NULL COMMENT '库存量',
  `stock_time` datetime DEFAULT NULL COMMENT '上架时间',
  `info` varchar(400) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `maker` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '制造厂商',
  `type_id` int(11) DEFAULT NULL COMMENT '商品分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `goods` */

insert  into `goods`(`id`,`view_pic`,`name`,`store_number`,`stock_time`,`info`,`maker`,`type_id`) values (5,NULL,'name',0,NULL,'info',NULL,NULL),(6,NULL,'name',0,NULL,'info',NULL,NULL);

/*Table structure for table `goods_type` */

DROP TABLE IF EXISTS `goods_type`;

CREATE TABLE `goods_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8_bin NOT NULL,
  `parent_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `goods_type` */

/*Table structure for table `shopcar` */

DROP TABLE IF EXISTS `shopcar`;

CREATE TABLE `shopcar` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `create_time` datetime NOT NULL COMMENT '购物车创建时间',
  `user_id` int(11) DEFAULT NULL COMMENT '购买者的ID',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `shopcar_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `shopcar` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) COLLATE utf8_bin NOT NULL,
  `password` varchar(500) COLLATE utf8_bin NOT NULL,
  `token` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `role` enum('管理员','卖家','买家') COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`token`,`role`) values (4,'test','e10adc3949ba59abbe56e057f20f883e',NULL,'管理员'),(5,'443428773@qq.com','e10adc3949ba59abbe56e057f20f883e',NULL,'买家'),(6,'443428772@qq.com','e10adc3949ba59abbe56e057f20f883e',NULL,'买家'),(8,'443428774','e10adc3949ba59abbe56e057f20f883e',NULL,'买家'),(14,'444','e10adc3949ba59abbe56e057f20f883e',NULL,'买家');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
