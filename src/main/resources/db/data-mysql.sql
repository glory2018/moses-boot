DELETE FROM user;

INSERT INTO `user`
VALUES (1, 'admin', 'admin@cn.ibm.com', 'admin', 'admin');
INSERT INTO `user`
VALUES (2, 'user', 'user@cn.ibm.com', 'user', 'user');

-- ----------------------------
-- Records of t_doc_ueditor
-- ----------------------------
INSERT INTO `t_doc_ueditor`
VALUES ('20200329', '1', 'freemarker导出word',
        '<p>《人月神话》，是由清华大学出版社于2002年11月出版的一本关于计算机软件的图书，作者是布鲁克斯(FrederickP.Brooks.Jr.) ，译者是汪颖。</p>',
        '<img style=\'height:100px;width:200px;display:block;\' src=\'/C:/Project/Moses/moses-boot/target/classes/ftl\\1.png\' /><p>《人月神话》内容源于作者Brooks在IBM公司任System计算机系列以及其庞大的软件系统OS项目经理时的实践经验。<img style=\'height:100px;width:200px;display:block;\' src=\'/C:/Project/Moses/moses-boot/target/classes/ftl\\2.png\' /><p>1.1编程系统产品</p><p>1.2职业的乐趣</p><p>1.3职业的苦恼</p>');
