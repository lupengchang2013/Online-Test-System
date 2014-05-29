//this file is containing all the commands need to generate the tables used in this program in MySQL


#
#This is all the sql needed to create the database in MySQL
#


DROP DATABASE IF EXISTS `db_examsystem`;
CREATE DATABASE `db_examsystem`
USE `db_examsystem`;

#
# Table structure for table tb_student
#

CREATE TABLE `tb_student` (
  `studentID` varchar(20) NOT NULL default '',
  `password` varchar(20) default NULL,
  `studentName` varchar(20) default NULL,
  `result` int(11) default NULL,
  `sclass` varchar(20) default NULL,
  PRIMARY KEY  (`studentID`)
)
INSERT INTO `tb_student` VALUES ('0509302*21','student’,’Minghua Li’,20,'0509302');
INSERT INTO `tb_student` VALUES ('05099301*21','fsdfsdf’,’Lin Hong’,100,'0509301');

#
# Table structure for table tb_subject
#

CREATE TABLE `tb_subject` (
  `subjectID` int(11) NOT NULL auto_increment,
  `subjectTitle` varchar(255) default NULL,
  `subjectOptionA` varchar(50) default NULL,
  `subjectOptionB` varchar(50) default NULL,
  `subjectOptionC` varchar(50) default NULL,
  `subjectOptionD` varchar(50) default NULL,
  `subjectAnswer` varchar(1) default NULL,
  `subjectParse` text,
  PRIMARY KEY  (`subjectID`)
)
INSERT INTO `tb_subject` VALUES (2,’which one of the flowing is wrong?’,’227O','1FFH','1010001B','789D','D',NULL);


#
# Table structure for table tb_teacher
#

CREATE TABLE `tb_teacher` (
  `teacherID` varchar(20) NOT NULL default '',
  `password` varchar(20) default NULL,
  PRIMARY KEY  (`teacherID`)
)
INSERT INTO `tb_teacher` VALUES ('teacher','teacher');
