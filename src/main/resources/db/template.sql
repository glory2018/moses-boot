-- ----------------------------
-- Table structure for t_doc_template_config
-- ----------------------------
DROP TABLE IF EXISTS `t_doc_template_config`;
CREATE TABLE `t_doc_template_config`
(
    `TEMPLATE_ID`   int(40)     DEFAULT NULL,
    `TEMPLATE_NAME` varchar(40) DEFAULT NULL,
    `LOCATION_PREX` varchar(40) DEFAULT NULL,
    `NEXT_PART_ID`  varchar(40) DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_doc_template_config
-- ----------------------------
INSERT INTO `t_doc_template_config`
VALUES ('1', 'template', '213792E5', '01D605E0.15DC7170');
-- ----------------------------
-- Table structure for t_doc_ueditor
-- ----------------------------
DROP TABLE IF EXISTS `t_doc_ueditor`;
CREATE TABLE `t_doc_ueditor`
(
    `id`         int(11)     DEFAULT NULL,
    `templateId` int(11)     DEFAULT NULL,
    `title`      varchar(40) DEFAULT NULL,
    `note`       text,
    `content`    longtext
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_doc_ueditor
-- ----------------------------
INSERT INTO `t_doc_ueditor`
VALUES ('20200329', '1', 'freemarker导出word',
        '<p>《人月神话》，是由清华大学出版社于2002年11月出版的一本关于计算机软件的图书，作者是布鲁克斯(FrederickP.Brooks.Jr.) ，译者是汪颖。</p>',
        '<img style=\'height:100px;width:200px;display:block;\' src=\'/C:/Project/Moses/moses-boot/target/classes/ftl\\1.png\' /><p>《人月神话》内容源于作者Brooks在IBM公司任System计算机系列以及其庞大的软件系统OS项目经理时的实践经验。<img style=\'height:100px;width:200px;display:block;\' src=\'/C:/Project/Moses/moses-boot/target/classes/ftl\\2.png\' /><p>1.1编程系统产品</p><p>1.2职业的乐趣</p><p>1.3职业的苦恼</p>');
