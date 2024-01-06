-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1
-- 生成日期： 2023-12-18 02:37:01
-- 服务器版本： 10.4.28-MariaDB
-- PHP 版本： 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `codefornature`
--

-- --------------------------------------------------------

--
-- 表的结构 `home`
--

CREATE TABLE `home` (
  `email` varchar(255) NOT NULL,
  `checked` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 转存表中的数据 `home`
--

INSERT INTO `home` (`email`, `checked`, `date`) VALUES
('bobby123@gmail.com', '2023-12-18', '2023-12-18'),
('lauduanhang@gmail.com', '2023-12-18', '2023-12-18'),
('qibin041227@gmail.com', '2023-12-17', '2023-12-17'),
('qijingtee1227@gmail.com', '2023-12-18', '2023-12-18'),
('sasa@gmail.com', '2023-12-18', '2023-12-18'),
('test123@gmail.com', '2023-12-18', '2023-12-18'),
('zhenyu123@gmail.com', '2023-12-18', '2023-12-18');

--
-- 转储表的索引
--

--
-- 表的索引 `home`
--
ALTER TABLE `home`
  ADD PRIMARY KEY (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
