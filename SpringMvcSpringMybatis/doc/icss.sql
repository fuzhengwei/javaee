/*
MySQL Data Transfer
Source Host: localhost
Source Database: icss
Target Host: localhost
Target Database: icss
Date: 2014-8-28 22:05:04
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for icss_department
-- ----------------------------
CREATE TABLE `icss_department` (
  `dt_id` int(11) NOT NULL AUTO_INCREMENT,
  `dt_no` varchar(20) DEFAULT NULL,
  `dt_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for icss_emp
-- ----------------------------
CREATE TABLE `icss_emp` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) DEFAULT NULL,
  `emp_age` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `icss_emp` VALUES ('1', 'admin', '25');
INSERT INTO `icss_emp` VALUES ('2', 'root', '90');
INSERT INTO `icss_emp` VALUES ('3', null, null);
INSERT INTO `icss_emp` VALUES ('4', 'db2admin', null);
INSERT INTO `icss_emp` VALUES ('5', null, null);
