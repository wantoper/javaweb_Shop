CREATE DATABASE `MyCart`;
use `MyCart`;
CREATE TABLE `OrderItem` (
`id` varchar(50) NOT NULL,
`pid` varchar(50) NOT NULL,
`oid` varchar(50) NOT NULL,
`num` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Product` (
`id` int(11) NOT NULL,
`name` varchar(20) NOT NULL,
`price` float NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO MyCart.Product (id, name, price) VALUES(1, '苹果', 2.5);
INSERT INTO MyCart.Product (id, name, price) VALUES(2, '香蕉', 2.3);
INSERT INTO MyCart.Product (id, name, price) VALUES(3, '葡萄', 4.5);
INSERT INTO MyCart.Product (id, name, price) VALUES(4, '黄焖鸡', 10.0);
INSERT INTO MyCart.Product (id, name, price) VALUES(5, '皮鞭', 12.0);
INSERT INTO MyCart.Product (id, name, price) VALUES(6, '蜡烛', 0.5);
INSERT INTO MyCart.Product (id, name, price) VALUES(7, '红酒', 2500.0);



CREATE TABLE `User` (
`id` varchar(50) NOT NULL,
`name` varchar(20) NOT NULL,
`password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Order` (
`id` varchar(50) NOT NULL,
`uid` varchar(50) NOT NULL,
`createdata` datetime NOT NULL,
`OrderMoney` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;