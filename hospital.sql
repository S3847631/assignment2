# Host: localhost  (Version: 5.5.42)
# Date: 2021-05-18 16:35:23
# Generator: MySQL-Front 5.3  (Build 4.13)

/*!40101 SET NAMES utf8 */;

#
# Source for table "resident"
#

DROP TABLE IF EXISTS `resident`;
CREATE TABLE `resident` (
  `ID` varchar(35) DEFAULT NULL,
  `Name` varchar(35) DEFAULT NULL,
  `Dob` varchar(35) DEFAULT NULL,
  `Admitted` varchar(35) DEFAULT NULL,
  `Discharged` varchar(35) DEFAULT NULL,
  `Gender` varchar(35) DEFAULT NULL,
  `BedID` int(11) NOT NULL DEFAULT '0',
  `Prescription` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "resident"
#

INSERT INTO `resident` VALUES ('12546','Micheal','2021-05-16-11:05:22','2021-05-13','2021-05-28','Male',0,'4667?67464664622222222222222222222222222222222222222222222\n2222222222222222\ndsaf'),('52321','jack','2021-05-16-11:06:52','2021-05-29','2021-06-04','Female',1,NULL),('AX5213','Rose','2021-05-16-11:07:50','2021-05-26','2021-06-05','Female',2,NULL),('xa20513','Mchery','2021-05-16-11:29:43','2021-06-04','2021-06-05','Male',3,NULL),('xz125356','Micehals','2021-05-16-11:32:06','2021-06-04','2021-06-05','Male',4,NULL),('xz125356','Micehals','2021-05-16-11:32:10','2021-06-04','2021-06-05','Male',5,NULL),('sda02','sddadf','2021-05-16-11:52:11','2021-05-06','2021-05-04','Male',6,NULL),('AD54653','Rosead','2021-05-17-15:35:52','2021-05-21','2021-06-05','Male',7,NULL),('Az021455','Mcisdasf','2021-05-17-19:48:17','2021-05-07','2021-06-04','Female',8,NULL),('XS2543','Mark','2021-05-17-20:48:29','2021-05-14','2021-05-28','Male',17,NULL);

#
# Source for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Staff_ID` varchar(35) DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `passWord` varchar(20) DEFAULT NULL,
  `Job` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `StartTime` time DEFAULT NULL,
  `EndTime` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES ('Admin01','Micheal','123456','Manager',NULL,NULL,NULL),('nur95431','Nancy','54321','Nurse',NULL,'01:00:00','09:00:00'),('doc95431','Jacson','123456','Doctor',NULL,'08:25:00','18:25:00'),('Admin03','Soer','562531','Doctor','158966532','08:25:00','12:02:31');
