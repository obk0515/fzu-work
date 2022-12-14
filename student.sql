
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `sid` varchar(20) NOT NULL COMMENT '学号',
  `name` varchar(30) NOT NULL COMMENT '姓名',
  `valid_cnt` int NOT NULL DEFAULT '0' COMMENT '被点到缺勤次数',
  `consecutive_attend_cnt` int NOT NULL DEFAULT '0' COMMENT '连续出席次数',
  `score_position` int NOT NULL COMMENT '绩点排名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `student` */

insert  into `student`(`id`,`sid`,`name`,`valid_cnt`,`consecutive_attend_cnt`,`score_position`) values 
(1,'032002101','查瑞',0,0,1),
(2,'032002102','暴素',0,0,2),
(3,'032002103','任思思',0,0,3),
(4,'032002104','濮博',0,0,4),
(5,'032002105','胥民',0,0,5),
(6,'032002106','辛超',0,0,6),
(7,'032002107','佴瑞素',0,0,7),
(8,'032002108','沃龙',0,0,8),
(9,'032002109','哈梦',0,0,9),
(10,'032002110','从利',0,0,10),
(11,'032002111','伊谦元',0,0,11),
(12,'032002112','祝璐嘉',0,0,12),
(13,'032002113','柏丽芳',0,0,13),
(14,'032002114','瞿友',0,0,14),
(15,'032002115','杜振',0,0,15),
(16,'032002116','家凡',0,0,16),
(17,'032002117','昌海力',0,0,17),
(18,'032002118','乜伊媛',0,0,18),
(19,'032002119','褚燕',0,0,19),
(20,'032002120','况旭',0,0,20),
(21,'032002121','梁丘锦',0,0,21),
(22,'032002122','童美',0,0,22),
(23,'032002123','隆安生',0,0,23),
(24,'032002124','支丹',0,0,24),
(25,'032002125','羊舌蕊颖',0,0,25),
(26,'032002126','姚倩',0,0,26),
(27,'032002127','马全',0,0,27),
(28,'032002128','夔利时',0,0,28),
(29,'032002129','福眉琬',0,0,29),
(30,'032002130','游妍',0,0,30),
(31,'032002131','麴美',0,0,31),
(32,'032002132','席义',0,0,32),
(33,'032002133','张浩',0,0,33),
(34,'032002134','宁蕊瑞',0,0,34),
(35,'032002135','洪进武',0,0,35),
(36,'032002136','浦珊',0,0,36),
(37,'032002137','向凡',0,0,37),
(38,'032002138','裴茗',0,0,38),
(39,'032002139','鞠宁',0,0,39),
(40,'032002140','仰环',0,0,40),
(41,'032002141','边飘',0,0,41),
(42,'032002142','花才',0,0,42),
(43,'032002143','鲜于功',0,0,43),
(44,'032002144','祁仁',0,0,44),
(45,'032002145','东东茂',0,0,45),
(46,'032002146','许瑞',0,0,46),
(47,'032002147','柴伟元',0,0,47),
(48,'032002148','霍心',0,0,48),
(49,'032002149','邵志',0,0,49),
(50,'032002150','赖伦东',0,0,50),
(51,'032002151','王晶锦',0,0,51),
(52,'032002152','仰璧枫',0,0,52),
(53,'032002153','滑全',0,0,53),
(54,'032002154','左倩洁',0,0,54),
(55,'032002155','海彩',0,0,55),
(56,'032002156','班坚明',0,0,56),
(57,'032002157','温安飞',0,0,57),
(58,'032002158','段承',0,0,58),
(59,'032002159','晋蓉仪',0,0,59),
(60,'032002160','邬伯维',0,0,60),
(61,'032002161','巢可',0,0,61),
(62,'032002162','屠茜秀',0,0,62),
(63,'032002163','燕群顺',0,0,63),
(64,'032002164','慎璧',0,0,64),
(65,'032002165','池桂',0,0,65),
(66,'032002166','凌春凡',0,0,66),
(67,'032002167','薄和',0,0,67),
(68,'032002168','狄毓',0,0,68),
(69,'032002169','利安',0,0,69),
(70,'032002170','傅融纯',0,0,70),
(71,'032002171','夔河广',0,0,71),
(72,'032002172','殴进',0,0,72),
(73,'032002173','宦惠蓓',0,0,73),
(74,'032002174','钟离绍',0,0,74),
(75,'032002175','李凡',0,0,75),
(76,'032002176','龚静芝',0,0,76),
(77,'032002177','鱼月',0,0,77),
(78,'032002178','滑会',0,0,78),
(79,'032002179','邰强',0,0,79),
(80,'032002180','严山',0,0,80),
(81,'032002181','闵倩',0,0,81),
(82,'032002182','後宁娴',0,0,82),
(83,'032002183','饶莉梅',0,0,83),
(84,'032002184','安瑶',0,0,84),
(85,'032002185','暴澜荣',0,0,85),
(86,'032002186','柴春',0,0,86),
(87,'032002187','魏思',0,0,87),
(88,'032002188','毛环玲',0,0,88),
(89,'032002189','房泽国',0,0,89),
(90,'032002190','姜军',0,0,90);
