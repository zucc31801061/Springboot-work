DROP TABLE IF EXISTS `student`;
DROP TABLE IF EXISTS `resume`;

CREATE TABLE `student` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    `number` varchar(255) DEFAULT NULL,
    `email` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `resume` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `content` varchar(255) DEFAULT NULL,
    `s_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `student` VALUES ('1','abc','31801000','1000@qq.com');
INSERT INTO `student` VALUES ('2','def','31801001','1001@qq.com');
INSERT INTO `student` VALUES ('3','ghi','31801002','1002@qq.com');

INSERT INTO `resume` VALUES ('1','****','1');
INSERT INTO `resume` VALUES ('2','***','2');