DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `article`;
DROP TABLE IF EXISTS `comment`;

CREATE TABLE `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    `age` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `article` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `title` varchar(255) DEFAULT NULL,
    `content` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `comment` (
     `id` int(11) NOT NULL AUTO_INCREMENT,
     `content` varchar(255) DEFAULT NULL,
     `author` varchar(255) DEFAULT NULL,
     `a_id` int(11) DEFAULT NULL,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `article` VALUES ('1','SpringBoot','实战派');
INSERT INTO `article` VALUES ('2','MyBatis','了解');

INSERT INTO `comment` VALUES ('1','*****','c1','1');
INSERT INTO `comment` VALUES ('2','****','c2','1');
INSERT INTO `comment` VALUES ('3','***','c3','1');
INSERT INTO `comment` VALUES ('4','**','c4','1');
INSERT INTO `comment` VALUES ('5','*','c5','2');