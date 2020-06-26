DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       int(11)                                                NOT NULL AUTO_INCREMENT,
    `name`     varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `email`    varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `username` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

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
