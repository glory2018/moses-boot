/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : moses

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2020-10-10 09:10:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for doc_abroad
-- ----------------------------
DROP TABLE IF EXISTS `doc_abroad`;
CREATE TABLE `doc_abroad` (
  `id` int(11) NOT NULL,
  `template_id` int(11) DEFAULT NULL,
  `project_name_c_n` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `country_code_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `policy_insured` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `passwd_set_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `group_equity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `share_c_n_p_c_view` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `brokercname` varchar(255) DEFAULT NULL,
  `deduction` varchar(255) DEFAULT NULL,
  `bill_com_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `chief` varchar(255) DEFAULT NULL,
  `info_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sumpaid` varchar(255) DEFAULT NULL,
  `cosremark` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `operateuser` varchar(255) DEFAULT NULL,
  `claim_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doc_abroad
-- ----------------------------
INSERT INTO `doc_abroad` VALUES ('1', '2', 'CPE职业责任险、综合责任险', '全球美加除外', 'CHINA PETROLEUM ENGINEERING CO. LTD', '自2020年3月15日00：01起，至2021年3月15日00：01时止', '100%', '50%', '昆仑', '20%经纪费', 'Generali China Insurance Company Limited', null, '<p><span style=\"font-family: 宋体; font-size: 16px;\">√再保条&nbsp;&nbsp; □保险条款&nbsp;&nbsp; □保费计算表&nbsp;&nbsp; □风险查勘报告</span></p><p><span style=\"font-family: 宋体; font-size: 16px;\">□项目信息 □其他__________</span></p>', '无', '<p>    1、PI和TPL为年度保单，目前CPE业务的地域只是中东地区，且已签订合同并执行的为伊拉克9区、Luk Oil两个项目，近期也正在商谈一个项目是在阿联酋，但是设计办公地点依然是在迪拜。<br/>2.该项目为昆仑提请邀约，建议按照集团规定，我司参照区域审批险种的相关要求，承接50%份额<br/>3、以再保分入形式接入，前端中意出单，但手续费为0<br/></p>', '陈铄伊', '2020.3.12');

-- ----------------------------
-- Table structure for doc_abroad_detail
-- ----------------------------
DROP TABLE IF EXISTS `doc_abroad_detail`;
CREATE TABLE `doc_abroad_detail` (
  `id` int(11) NOT NULL,
  `insurance_id` int(11) DEFAULT NULL,
  `risk_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `confm_amount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `deductible` varchar(255) DEFAULT NULL,
  `confm_prem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `share_cnpc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doc_abroad_detail
-- ----------------------------
INSERT INTO `doc_abroad_detail` VALUES ('1', '1', '职业责任险', '每次限额1000万美元；\r\n累计限额4500万美元\r\n', '财产损失5万，\r\n人身无免赔\r\n', '11.5万', '5.75万');
INSERT INTO `doc_abroad_detail` VALUES ('2', '1', '三者责任险', 'bb', 'cc', 'dd', 'ee');

-- ----------------------------
-- Table structure for doc_domestic
-- ----------------------------
DROP TABLE IF EXISTS `doc_domestic`;
CREATE TABLE `doc_domestic` (
  `id` int(11) NOT NULL,
  `template_id` int(11) DEFAULT NULL,
  `project_name_c_n` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `country_code_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `policy_insured` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `passwd_set_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `group_equity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `share_c_n_p_c` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `linfen` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cost` varchar(255) DEFAULT NULL,
  `e_s_g_p` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `brokercname` varchar(255) DEFAULT NULL,
  `deduction` varchar(255) DEFAULT NULL,
  `bill_com_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `chief` varchar(255) DEFAULT NULL,
  `info_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sumpaid` varchar(255) DEFAULT NULL,
  `cosremark` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `operateuser` varchar(255) DEFAULT NULL,
  `claim_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doc_domestic
-- ----------------------------
INSERT INTO `doc_domestic` VALUES ('1', '3', '赵东项目', '大港油田', '中石油大港赵东油田作业公司', '2019.08.01-2020.8.1', '51%', '共保20%再保31%', '是', '204万美元', '104万美元', '昆仑经纪', '直保经纪费21.2%，防灾防损费5.3%，平安部分出单费1.5%，再保经纪费3.5% 均基于不含税保费', '平安10.5%，人保8%，太保5%，国寿财6.5%，太平财1%', '平安', '<p>    □再保条&nbsp; &nbsp;□保险条款&nbsp; &nbsp;□保费计算表&nbsp; &nbsp;□风险查勘报告</p><p>□项目信息&nbsp; &nbsp; □其他__________</p>', '2019年6月发生溢油事故，目前估损金额尚未提供我方', '<p>ee</p>', '仲 晴', '2019-07-24');

-- ----------------------------
-- Table structure for doc_domestic_detail
-- ----------------------------
DROP TABLE IF EXISTS `doc_domestic_detail`;
CREATE TABLE `doc_domestic_detail` (
  `id` int(11) NOT NULL,
  `domestic_id` int(11) DEFAULT NULL,
  `risk_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `confm_amount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `d_d` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `confm_prem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doc_domestic_detail
-- ----------------------------
INSERT INTO `doc_domestic_detail` VALUES ('1', '1', '财产险（上游）', '4.1亿美元', '50万美元', '921,631');
INSERT INTO `doc_domestic_detail` VALUES ('2', '1', 'aa', 'bb', 'cc', 'dd');

-- ----------------------------
-- Table structure for t_doc_template_config
-- ----------------------------
DROP TABLE IF EXISTS `t_doc_template_config`;
CREATE TABLE `t_doc_template_config` (
  `TEMPLATE_ID` int(40) DEFAULT NULL,
  `TEMPLATE_NAME` varchar(40) DEFAULT NULL,
  `LOCATION_PREX` varchar(40) DEFAULT NULL,
  `NEXT_PART_ID` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_doc_template_config
-- ----------------------------
INSERT INTO `t_doc_template_config` VALUES ('1', 'template', '213792E5', '01D605E0.15DC7170');
INSERT INTO `t_doc_template_config` VALUES ('2', 'abroad', '085AC884', '01D69E61.B0279A10');
INSERT INTO `t_doc_template_config` VALUES ('3', 'domestic', 'A08B5D83', '01D69E4C.2F757BE0');

-- ----------------------------
-- Table structure for t_doc_ueditor
-- ----------------------------
DROP TABLE IF EXISTS `t_doc_ueditor`;
CREATE TABLE `t_doc_ueditor` (
  `id` int(11) DEFAULT NULL,
  `templateId` int(11) DEFAULT NULL,
  `title` varchar(40) DEFAULT NULL,
  `note` text,
  `content` longtext
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_doc_ueditor
-- ----------------------------
INSERT INTO `t_doc_ueditor` VALUES ('20200329', '1', 'freemarker导出word', '<p>《人月神话》，是由清华大学出版社于2002年11月出版的一本关于计算机软件的图书，作者是布鲁克斯(FrederickP.Brooks.Jr.) ，译者是汪颖。</p>', '<img style=\'height:100px;width:200px;display:block;\' src=\'/E:\\Project\\moses-boot-master\\src\\main\\resources\\ftl\\1.png\' /><p>《人月神话》内容源于作者Brooks在IBM公司任System计算机系列以及其庞大的软件系统OS项目经理时的实践经验。<img style=\'height:100px;width:200px;display:block;\' src=\'/E:\\Project\\moses-boot-master\\src\\main\\resources\\ftl\\2.png\' /><p>1.1编程系统产品</p><p>1.2职业的乐趣</p><p>1.3职业的苦恼</p>');
INSERT INTO `t_doc_ueditor` VALUES ('2', '2', 'freemarker导出word', '<p>《人月神话》，是由清华大学出版社于2002年11月出版的一本关于计算机软件的图书，作者是布鲁克斯(FrederickP.Brooks.Jr.) ，译者是汪颖。</p>', '20200329<p>《人月神话》，是由清华大学出版社于2002年11月出版的一本关于计算机软件的图书，作者是布鲁克斯(FrederickP.Brooks.Jr.) ，译者是汪颖。</p>');
INSERT INTO `t_doc_ueditor` VALUES ('1', '2', 'freemarker导出word', '<p class=\"MsoListParagraph\" style=\"margin-top:auto;margin-bottom: auto;margin-left:24px;text-align:left;text-indent:0;line-height:125%\"><span style=\"font-size:16px;line-height:125%;font-family:宋体\">1</span><span style=\"font-size:16px;line-height:125%;font-family:宋体\">、PI和TPL为年度保单，目前CPE业务的地域只是中东地区，且已签订合同并执行的为伊拉克9区、Luk Oil两个项目，近期也正在商谈一个项目是在阿联酋，但是设计办公地点依然是在迪拜。</span></p><p class=\"MsoListParagraph\" style=\"margin-top:auto;margin-bottom: auto;margin-left:24px;text-align:left;text-indent:0;line-height:125%\"><span style=\"font-size:16px;line-height:125%;font-family:宋体\">2. </span><span style=\"font-size: 16px;line-height:125%;font-family:宋体\">该项目为昆仑提请邀约，建议按照集团规定，我司参照区域审批险种的相关要求，承接50%份额</span></p><p class=\"MsoListParagraph\" style=\"margin-top:auto;margin-bottom: auto;margin-left:24px;text-align:left;text-indent:0;line-height:125%\"><span style=\"font-size:16px;line-height:125%;font-family:宋体\">3</span><span style=\"font-size:16px;line-height:125%;font-family:宋体\">、以再保分入形式接入，前端中意出单，但手续费为0</span></p><p><br/></p>', '<p>20200329&lt;p&gt;《人月神话》，是由清华大学出版社于2002年11月出版的一本关于计算机软件的图书，作者是布鲁克斯(FrederickP.Brooks.Jr.) ，译者是汪颖。&lt;/p&gt;</p>');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin@cn.ibm.com', 'admin', 'admin');
INSERT INTO `user` VALUES ('2', 'user', 'user@cn.ibm.com', 'user', 'user');
