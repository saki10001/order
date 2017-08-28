/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost
 Source Database       : order

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 08/29/2017 06:53:11 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_company`
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL COMMENT '公司名称',
  `contacts` varchar(20) DEFAULT NULL COMMENT '联系人',
  `address` varchar(100) DEFAULT NULL COMMENT '联系地址',
  `business` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '主营业务',
  `level` varchar(10) DEFAULT NULL COMMENT '企业星级',
  `remark` varchar(255) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_company`
-- ----------------------------
BEGIN;
INSERT INTO `t_company` VALUES ('1', null, null, null, null, null, null, null, null), ('2', null, null, null, null, null, null, null, null), ('4', '4', '4', '4', '4', '4', '4', null, null), ('5', '333333', '6', '7', '1', '1', '1', '1', '123'), ('14', '1', '1', '1', '1', '1', '1', null, null), ('15', 'awef', '123', '1', '1', '1', '1', '3', 'test'), ('17', '34q3r', '123', '1', '1', '1', '1', null, null), ('18', '132', '123', '123', '123', '123', '123', null, null), ('19', 'abcdefg', '123', '123', '123', '123', '123', '2', 'abcd');
COMMIT;

-- ----------------------------
--  Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `company_id` int(10) DEFAULT NULL COMMENT '公司id',
  `order_no` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `start_date` datetime DEFAULT NULL COMMENT '下单时间',
  `confirm_date` datetime DEFAULT NULL COMMENT '订单确认时间，管理员确认订单',
  `pill_date` datetime DEFAULT NULL COMMENT '付款时间',
  `end_date` datetime DEFAULT NULL COMMENT '结束时间',
  `status` varchar(5) DEFAULT NULL COMMENT '订单状态',
  `amount` decimal(10,5) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_order`
-- ----------------------------
BEGIN;
INSERT INTO `t_order` VALUES ('1', '1', '1', '2017-07-16 23:19:24', '2017-07-28 23:19:21', '2017-07-03 23:19:39', '2017-07-05 23:19:16', '1', '1.00000', '1'), ('2', '1', '1111', '2017-08-21 21:35:15', null, null, null, null, '0.00000', null), ('3', '20', 'customer_Wed Aug 23 21:39:41 CST 2017', '2017-08-23 21:39:42', null, null, null, null, '0.00000', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_id` int(10) DEFAULT NULL,
  `product_detail_id` int(10) DEFAULT NULL COMMENT '产品小类ID',
  `num` int(10) DEFAULT NULL COMMENT '数量',
  `price` decimal(10,0) DEFAULT NULL COMMENT '单价',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_order_detail`
-- ----------------------------
BEGIN;
INSERT INTO `t_order_detail` VALUES ('1', '2', '2', '111', '0', null), ('2', '3', '2', '100', '0', null), ('3', '1', '7', '1000', '0', null), ('4', '1', '2', '50', '0', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_order_mapping`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_mapping`;
CREATE TABLE `t_order_mapping` (
  `order_id` int(11) NOT NULL COMMENT '客户订单号',
  `supllier_order_id` int(11) NOT NULL COMMENT '供应商订单号',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `product` varchar(50) NOT NULL COMMENT '产品大类名称',
  `type` varchar(50) DEFAULT NULL COMMENT '种类',
  `unit` varchar(10) DEFAULT NULL COMMENT '单位',
  `base` varchar(10) DEFAULT NULL COMMENT '基础采购量',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_product`
-- ----------------------------
BEGIN;
INSERT INTO `t_product` VALUES ('1', '焊丝', '二保焊丝', '公斤', '1件(72盒)', null), ('2', '焊丝', '埋弧焊丝', '公斤', '5盘以上', null), ('3', '焊丝', '药芯焊丝', '公斤', '1件', null), ('6', '磨具', '百叶轮', '片', '一箱以上', null), ('7', '磨具', '切割机片', '片', '一箱以上', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_product_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_product_detail`;
CREATE TABLE `t_product_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `product_id` int(10) DEFAULT NULL,
  `sub_product` varchar(50) DEFAULT NULL COMMENT '小类名称',
  `format` varchar(50) DEFAULT NULL COMMENT '规格',
  `material` varchar(20) DEFAULT NULL COMMENT '材质',
  `remark` varchar(255) DEFAULT NULL,
  `selected` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_product_detail`
-- ----------------------------
BEGIN;
INSERT INTO `t_product_detail` VALUES ('1', '1', '1.2', '20KG/盒', 'ER50-6', null, '0'), ('2', '1', '4.0', '25kg/?', 'HO8A', null, '1'), ('3', '1', '1.2', '15kg/盒', 'HY-E711(Q)', null, '0'), ('4', '6', '60#', '300片/箱', '煅烧砂', null, '1'), ('5', '6', '80#', '300片/箱', '煅烧砂', null, '1'), ('6', '6', '100#', '300片/箱', '煅烧砂', null, '0'), ('7', '6', '120#', '300?/?', '???', null, '1'), ('8', '7', '400#', '25?/?', null, null, '1'), ('9', '7', '350#', '25/?', null, null, '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_supllier_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_supllier_order`;
CREATE TABLE `t_supllier_order` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `supplier_order_no` varchar(30) DEFAULT NULL COMMENT '供应商订单编号',
  `transport_date` datetime DEFAULT NULL COMMENT '发货时间',
  `status` varchar(5) DEFAULT NULL COMMENT '订单状态',
  `amount` decimal(10,5) DEFAULT NULL COMMENT '订单总价',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_supllier_order`
-- ----------------------------
BEGIN;
INSERT INTO `t_supllier_order` VALUES ('1', 'S_2017-08-27 14:45:00', null, '0', '1261.00000', null), ('2', 'S_2017-08-27 12:05:00', null, '0', '1261.00000', null), ('3', 'S_2017-08-27 22:45:00', null, '0', '1261.00000', null), ('4', 'S_2017-08-27 22:50:00', null, '0', '1261.00000', null), ('5', 'S_2017-08-27 22:55:00', null, '0', '1261.00000', null), ('6', 'S_2017-08-27 23:00:00', null, '0', '1261.00000', null), ('7', 'S_2017-08-27 23:05:00', null, '0', '1261.00000', null), ('8', 'S_2017-08-27 23:10:00', null, '0', '1261.00000', null), ('9', 'S_2017-08-27 23:15:00', null, '0', '1261.00000', null), ('10', 'S_2017-08-28 08:29:54', null, '0', '1261.00000', null), ('11', 'S_2017-08-28 08:30:00', null, '0', '1261.00000', null), ('12', 'S_2017-08-28 08:35:00', null, '0', '1261.00000', null), ('13', 'S_2017-08-28 08:40:00', null, '0', '1261.00000', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_supllier_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_supllier_order_detail`;
CREATE TABLE `t_supllier_order_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `conpany_id` int(10) DEFAULT NULL COMMENT '供应商ID,详情与具体供应商关联，可能出现一个商品从多家供应商采购的情况',
  `supllier_order_id` int(10) DEFAULT NULL COMMENT '供应商订单ID',
  `product_detail_id` int(10) DEFAULT NULL COMMENT '产品分类id',
  `num` int(10) DEFAULT NULL COMMENT '订单数量',
  `price` decimal(10,3) DEFAULT NULL COMMENT '供应商报价',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_supllier_order_detail`
-- ----------------------------
BEGIN;
INSERT INTO `t_supllier_order_detail` VALUES ('9', null, '3', '2', '111', '0.000', null), ('10', null, '3', '2', '100', '0.000', null), ('11', null, '3', '7', '1000', '0.000', null), ('12', null, '3', '2', '50', '0.000', null), ('13', null, '4', '2', '111', '0.000', null), ('14', null, '4', '2', '100', '0.000', null), ('15', null, '4', '7', '1000', '0.000', null), ('16', null, '4', '2', '50', '0.000', null), ('17', null, '5', '2', '111', '0.000', null), ('18', null, '5', '2', '100', '0.000', null), ('19', null, '5', '7', '1000', '0.000', null), ('20', null, '5', '2', '50', '0.000', null), ('21', null, '6', '2', '111', '0.000', null), ('22', null, '6', '2', '100', '0.000', null), ('23', null, '6', '7', '1000', '0.000', null), ('24', null, '6', '2', '50', '0.000', null), ('25', null, '7', '2', '111', '0.000', null), ('26', null, '7', '2', '100', '0.000', null), ('27', null, '7', '7', '1000', '0.000', null), ('28', null, '7', '2', '50', '0.000', null), ('29', null, '8', '2', '111', '0.000', null), ('30', null, '8', '2', '100', '0.000', null), ('31', null, '8', '7', '1000', '0.000', null), ('32', null, '8', '2', '50', '0.000', null), ('33', null, '9', '2', '111', '0.000', null), ('34', null, '9', '2', '100', '0.000', null), ('35', null, '9', '7', '1000', '0.000', null), ('36', null, '9', '2', '50', '0.000', null), ('37', null, '10', '2', '111', '0.000', null), ('38', null, '10', '2', '100', '0.000', null), ('39', null, '10', '7', '1000', '0.000', null), ('40', null, '10', '2', '50', '0.000', null), ('41', null, '11', '2', '111', '0.000', null), ('42', null, '11', '2', '100', '0.000', null), ('43', null, '11', '7', '1000', '0.000', null), ('44', null, '11', '2', '50', '0.000', null), ('45', null, '12', '2', '111', '0.000', null), ('46', null, '12', '2', '100', '0.000', null), ('47', null, '12', '7', '1000', '0.000', null), ('48', null, '12', '2', '50', '0.000', null), ('49', null, '13', '2', '111', '0.000', null), ('50', null, '13', '2', '100', '0.000', null), ('51', null, '13', '7', '1000', '0.000', null), ('52', null, '13', '2', '50', '0.000', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL COMMENT '1管理员 2供应商 3客户',
  `user_name` varchar(30) DEFAULT NULL,
  `user_pwd` varchar(50) DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('2', '5', '1', '123', '670b14728ad9902aecba32e22fa4f6bd', '333333'), ('10', '5', '3', 'test', '670b14728ad9902aecba32e22fa4f6bd', '333333'), ('11', '19', '2', 'abcd', '670b14728ad9902aecba32e22fa4f6bd', 'abcdefg'), ('12', null, '1', '123', '670b14728ad9902aecba32e22fa4f6bd', null), ('14', null, '1', 'admin2', '670b14728ad9902aecba32e22fa4f6bd', null), ('15', null, '1', 'wyk', '670b14728ad9902aecba32e22fa4f6bd', null), ('16', '20', '2', 'wyj', '670b14728ad9902aecba32e22fa4f6bd', '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_user_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_product`;
CREATE TABLE `t_user_product` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `company_id` int(10) DEFAULT NULL COMMENT '公司id ，拟定一家公司关联一个大类',
  `product_detail_id` int(10) DEFAULT NULL COMMENT '产品小类ID',
  `status` varchar(10) DEFAULT NULL COMMENT '分类状态。隐藏/显示',
  `role_id` int(10) DEFAULT NULL COMMENT '角色id， 判断是客户还是供应商',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_user_product`
-- ----------------------------
BEGIN;
INSERT INTO `t_user_product` VALUES ('18', '5', '2', null, null), ('19', '5', '7', null, null), ('20', '5', '8', null, null), ('21', '20', '2', null, null), ('22', '20', '7', null, null), ('23', '20', '8', null, null), ('24', '20', '4', null, null), ('25', '20', '5', null, null), ('26', '20', '9', null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
