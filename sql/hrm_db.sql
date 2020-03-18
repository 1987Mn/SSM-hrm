/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : hrm_db

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-03-17 15:18:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept_inf`
-- ----------------------------
DROP TABLE IF EXISTS `dept_inf`;
CREATE TABLE `dept_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept_inf
-- ----------------------------
INSERT INTO `dept_inf` VALUES ('1', '技术部', '技术部');
INSERT INTO `dept_inf` VALUES ('2', '运营部', '运营部');

-- ----------------------------
-- Table structure for `document_inf`
-- ----------------------------
DROP TABLE IF EXISTS `document_inf`;
CREATE TABLE `document_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(50) NOT NULL,
  `filename` varchar(300) NOT NULL,
  `filetype` varchar(100) NOT NULL,
  `filebytes` longblob NOT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_DOCUMENT_USER` (`USER_ID`),
  CONSTRAINT `doc_user` FOREIGN KEY (`USER_ID`) REFERENCES `user_inf` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of document_inf
-- ----------------------------
INSERT INTO `document_inf` VALUES ('1', '阿斯蒂芬', '大学主修', 'txt', 0xC8EDBCFECFEEC4BFB9DCC0EDA1A2C8EDBCFEB9A4B3CCA1A2CAFDBEDDBDE1B9B9A1A2CAFDBEDDBFE2D4ADC0EDA1A2CAFDBEDDBFE2BCBCCAF5BCB0D3A6D3C3A1A2CBE3B7A8C9E8BCC6D3EBB7D6CEF6A1A2C8EDBCFEC9E8BCC6D3EBCCE5CFB5BDE1B9B9A1A2C8EDBCFEBDA8C4A3D3EB554D4CA1A2C8EDBCFEB2E2CAD4A1A2C8CBBBFABDBBBBA5BCBCCAF5A1A2CFB5CDB3B7D6CEF6D3EBC9E8BCC6A1A2BCC6CBE3BBFACDF8C2E7A1A2204A415641B3CCD0F2C9E8BCC6A1A2CDF8D5BEBDA8C9E8D3EBCDF8D2B3C9E8BCC6A1A2C3E6CFF2B6D4CFF3B3CCD0F2C9E8BCC6A1A2B3CCD0F2C9E8BCC6BBF9B4A1A1A2C8EDBCFEBFAAB7A2CAB5D1B5A1A24323D3EB576562D3A6D3C3BFAAB7A2A1A250485020576562BFAAB7A2A1A256697375616C20432B2BD3EB57696E646F7773D3A6D3C3BFAAB7A2A1A220BCC6CBE3BBFABFC6D1A7B5BCC2DBA1A2B2D9D7F7CFB5CDB3A1A2BCC6CBE3BBFAD7E9B3C9D4ADC0EDA1A2BBE3B1E0D3EFD1D4A1A220B8DFB5C8CAFDD1A7A1A2C0EBC9A2CAFDD1A7A1A2CFDFD0D4B4FACAFDB5C8, '阿斯蒂芬', '2020-03-05 14:15:48', '1');
INSERT INTO `document_inf` VALUES ('2', '阿斯蒂芬', '大学主修', 'txt', 0xC8EDBCFECFEEC4BFB9DCC0EDA1A2C8EDBCFEB9A4B3CCA1A2CAFDBEDDBDE1B9B9A1A2CAFDBEDDBFE2D4ADC0EDA1A2CAFDBEDDBFE2BCBCCAF5BCB0D3A6D3C3A1A2CBE3B7A8C9E8BCC6D3EBB7D6CEF6A1A2C8EDBCFEC9E8BCC6D3EBCCE5CFB5BDE1B9B9A1A2C8EDBCFEBDA8C4A3D3EB554D4CA1A2C8EDBCFEB2E2CAD4A1A2C8CBBBFABDBBBBA5BCBCCAF5A1A2CFB5CDB3B7D6CEF6D3EBC9E8BCC6A1A2BCC6CBE3BBFACDF8C2E7A1A2204A415641B3CCD0F2C9E8BCC6A1A2CDF8D5BEBDA8C9E8D3EBCDF8D2B3C9E8BCC6A1A2C3E6CFF2B6D4CFF3B3CCD0F2C9E8BCC6A1A2B3CCD0F2C9E8BCC6BBF9B4A1A1A2C8EDBCFEBFAAB7A2CAB5D1B5A1A24323D3EB576562D3A6D3C3BFAAB7A2A1A250485020576562BFAAB7A2A1A256697375616C20432B2BD3EB57696E646F7773D3A6D3C3BFAAB7A2A1A220BCC6CBE3BBFABFC6D1A7B5BCC2DBA1A2B2D9D7F7CFB5CDB3A1A2BCC6CBE3BBFAD7E9B3C9D4ADC0EDA1A2BBE3B1E0D3EFD1D4A1A220B8DFB5C8CAFDD1A7A1A2C0EBC9A2CAFDD1A7A1A2CFDFD0D4B4FACAFDB5C8, '阿斯蒂芬', '2020-03-05 14:33:00', '1');
INSERT INTO `document_inf` VALUES ('3', '阿斯蒂芬', '大学主修', 'txt', 0xC8EDBCFECFEEC4BFB9DCC0EDA1A2C8EDBCFEB9A4B3CCA1A2CAFDBEDDBDE1B9B9A1A2CAFDBEDDBFE2D4ADC0EDA1A2CAFDBEDDBFE2BCBCCAF5BCB0D3A6D3C3A1A2CBE3B7A8C9E8BCC6D3EBB7D6CEF6A1A2C8EDBCFEC9E8BCC6D3EBCCE5CFB5BDE1B9B9A1A2C8EDBCFEBDA8C4A3D3EB554D4CA1A2C8EDBCFEB2E2CAD4A1A2C8CBBBFABDBBBBA5BCBCCAF5A1A2CFB5CDB3B7D6CEF6D3EBC9E8BCC6A1A2BCC6CBE3BBFACDF8C2E7A1A2204A415641B3CCD0F2C9E8BCC6A1A2CDF8D5BEBDA8C9E8D3EBCDF8D2B3C9E8BCC6A1A2C3E6CFF2B6D4CFF3B3CCD0F2C9E8BCC6A1A2B3CCD0F2C9E8BCC6BBF9B4A1A1A2C8EDBCFEBFAAB7A2CAB5D1B5A1A24323D3EB576562D3A6D3C3BFAAB7A2A1A250485020576562BFAAB7A2A1A256697375616C20432B2BD3EB57696E646F7773D3A6D3C3BFAAB7A2A1A220BCC6CBE3BBFABFC6D1A7B5BCC2DBA1A2B2D9D7F7CFB5CDB3A1A2BCC6CBE3BBFAD7E9B3C9D4ADC0EDA1A2BBE3B1E0D3EFD1D4A1A220B8DFB5C8CAFDD1A7A1A2C0EBC9A2CAFDD1A7A1A2CFDFD0D4B4FACAFDB5C8, '阿斯蒂芬', '2020-03-05 14:54:57', '1');
INSERT INTO `document_inf` VALUES ('4', '过分啊', '大学主修', 'txt', 0xC8EDBCFECFEEC4BFB9DCC0EDA1A2C8EDBCFEB9A4B3CCA1A2CAFDBEDDBDE1B9B9A1A2CAFDBEDDBFE2D4ADC0EDA1A2CAFDBEDDBFE2BCBCCAF5BCB0D3A6D3C3A1A2CBE3B7A8C9E8BCC6D3EBB7D6CEF6A1A2C8EDBCFEC9E8BCC6D3EBCCE5CFB5BDE1B9B9A1A2C8EDBCFEBDA8C4A3D3EB554D4CA1A2C8EDBCFEB2E2CAD4A1A2C8CBBBFABDBBBBA5BCBCCAF5A1A2CFB5CDB3B7D6CEF6D3EBC9E8BCC6A1A2BCC6CBE3BBFACDF8C2E7A1A2204A415641B3CCD0F2C9E8BCC6A1A2CDF8D5BEBDA8C9E8D3EBCDF8D2B3C9E8BCC6A1A2C3E6CFF2B6D4CFF3B3CCD0F2C9E8BCC6A1A2B3CCD0F2C9E8BCC6BBF9B4A1A1A2C8EDBCFEBFAAB7A2CAB5D1B5A1A24323D3EB576562D3A6D3C3BFAAB7A2A1A250485020576562BFAAB7A2A1A256697375616C20432B2BD3EB57696E646F7773D3A6D3C3BFAAB7A2A1A220BCC6CBE3BBFABFC6D1A7B5BCC2DBA1A2B2D9D7F7CFB5CDB3A1A2BCC6CBE3BBFAD7E9B3C9D4ADC0EDA1A2BBE3B1E0D3EFD1D4A1A220B8DFB5C8CAFDD1A7A1A2C0EBC9A2CAFDD1A7A1A2CFDFD0D4B4FACAFDB5C8, '撒旦法', '2020-03-05 15:24:49', '1');

-- ----------------------------
-- Table structure for `employee_inf`
-- ----------------------------
DROP TABLE IF EXISTS `employee_inf`;
CREATE TABLE `employee_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPT_ID` int(11) NOT NULL,
  `JOB_ID` int(11) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `CARD_ID` varchar(18) NOT NULL,
  `ADDRESS` varchar(50) NOT NULL,
  `POST_CODE` varchar(50) DEFAULT NULL,
  `TEL` varchar(16) DEFAULT NULL,
  `PHONE` varchar(11) NOT NULL,
  `QQ_NUM` varchar(10) DEFAULT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `SEX` int(11) NOT NULL DEFAULT '1',
  `PARTY` varchar(10) DEFAULT NULL,
  `BIRTHDAY` datetime DEFAULT NULL,
  `RACE` varchar(100) DEFAULT NULL,
  `EDUCATION` varchar(10) DEFAULT NULL,
  `SPECIALITY` varchar(20) DEFAULT NULL,
  `HOBBY` varchar(100) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `FK_EMP_DEPT` (`DEPT_ID`),
  KEY `FK_EMP_JOB` (`JOB_ID`),
  CONSTRAINT `FK_EMP_DEPT` FOREIGN KEY (`DEPT_ID`) REFERENCES `dept_inf` (`ID`),
  CONSTRAINT `FK_EMP_JOB` FOREIGN KEY (`JOB_ID`) REFERENCES `job_inf` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_inf
-- ----------------------------
INSERT INTO `employee_inf` VALUES ('1', '2', '3', '爱丽丝', '432801197711251034', '广州天河', '510000', '020-77777777', '13902001111', '36750066', '36750064@qq.com', '1', '党员', '2020-03-09 00:00:00', '满', '本科', '美声', '唱歌', '四大天王', '2020-03-05 10:58:00');
INSERT INTO `employee_inf` VALUES ('2', '1', '1', '杰克', '432801197711251037', '43234', '510000', '020-99999999', '13907351532', '36750064', '36750064@qq.com', '2', '党员', '2020-02-12 10:32:01', '汉', '本科', '计算机', '爬山', null, '2016-03-14 11:35:18');
INSERT INTO `employee_inf` VALUES ('3', '2', '2', 'bb', '432801197711251038', '广州', '510000', '020-99999999', '13907351532', '36750064', '36750064@qq.com', '1', '党员', '2020-03-23 00:00:00', '汉', '本科', '计算机', '爬山', '无', '2020-03-05 10:57:25');
INSERT INTO `employee_inf` VALUES ('5', '1', '2', '12', '432801197711251023', '啊士大夫', '510000', '020-99999999', '13902001111', '22015400', '22015400@qq.com', '1', '团有', '2020-03-17 00:00:00', '汗珠', '本科', '软件', '打球', '啊士大夫', '2020-03-05 11:00:30');

-- ----------------------------
-- Table structure for `job_inf`
-- ----------------------------
DROP TABLE IF EXISTS `job_inf`;
CREATE TABLE `job_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_inf
-- ----------------------------
INSERT INTO `job_inf` VALUES ('1', '职员', '职员');
INSERT INTO `job_inf` VALUES ('2', 'Java开发工程师', 'Java开发工程师');
INSERT INTO `job_inf` VALUES ('3', 'Java中级开发工程师', 'Java中级开发工程师');
INSERT INTO `job_inf` VALUES ('4', 'Java高级开发工程师', 'Java高级开发工程师');
INSERT INTO `job_inf` VALUES ('5', '系统管理员', '系统管理员');
INSERT INTO `job_inf` VALUES ('6', '架构师', '架构师');
INSERT INTO `job_inf` VALUES ('7', '主管', '主管');
INSERT INTO `job_inf` VALUES ('8', '经理', '经理');
INSERT INTO `job_inf` VALUES ('9', '总经理', '总经理');

-- ----------------------------
-- Table structure for `user_inf`
-- ----------------------------
DROP TABLE IF EXISTS `user_inf`;
CREATE TABLE `user_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) NOT NULL,
  `PASSWORD` varchar(16) NOT NULL,
  `STATUS` int(11) NOT NULL DEFAULT '1',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_inf
-- ----------------------------
INSERT INTO `user_inf` VALUES ('1', 'admin', '123456', '1', '2020-03-04 11:19:44', 'admin');
INSERT INTO `user_inf` VALUES ('3', 'user', '123456', '1', '2020-03-04 11:03:09', 'user');
INSERT INTO `user_inf` VALUES ('4', 'user1', '123', '1', '2020-03-04 11:57:07', 'user1');
INSERT INTO `user_inf` VALUES ('7', '小红', '123', '1', '2020-03-04 13:02:15', '小红');
INSERT INTO `user_inf` VALUES ('8', '小兰', '123', '1', '2020-03-04 19:30:00', '小兰');
