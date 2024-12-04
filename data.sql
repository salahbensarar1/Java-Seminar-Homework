-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 05, 2024 at 12:52 AM
-- Server version: 9.0.1
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `exercisesec`
--

-- --------------------------------------------------------

--
-- Table structure for table `contact_messages`
--

CREATE TABLE `contact_messages` (
  `id` bigint NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `message` varchar(500) COLLATE utf8mb4_general_ci NOT NULL,
  `timestamp` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contact_messages`
--

INSERT INTO `contact_messages` (`id`, `name`, `email`, `message`, `timestamp`) VALUES
(3, 'Jane Doe', 'janedoe@example.com', 'Updated message content.', '2024-12-05 00:22:11'),
(5, 'John Doe', 'johndoe@example.com', 'Hello, this is a test message!', '2024-12-05 00:38:30'),
(6, 'Salah Ben Sarar2', 'sa.bensarar@gmail.com', 'Szia, this is a test message!', '2024-12-05 00:44:32');

-- --------------------------------------------------------

--
-- Table structure for table `entries`
--

CREATE TABLE `entries` (
  `spectatorid` int NOT NULL,
  `matchid` int NOT NULL,
  `timestamp` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `entries`
--

INSERT INTO `entries` (`spectatorid`, `matchid`, `timestamp`) VALUES
(1, 1, '10:10:10'),
(1, 15, '14:18:00'),
(2, 16, '15:44:00'),
(3, 5, '13:17:00'),
(4, 3, '15:36:00'),
(5, 19, '14:38:00'),
(6, 11, '16:08:00'),
(7, 7, '13:00:00'),
(8, 11, '16:42:00'),
(9, 19, '15:16:00'),
(10, 7, '13:26:00'),
(11, 11, '11:11:00'),
(11, 13, '13:07:00'),
(12, 8, '15:05:00'),
(13, 12, '13:58:00'),
(14, 18, '17:10:00'),
(15, 12, '13:05:00'),
(16, 1, '14:23:00'),
(17, 6, '16:20:00'),
(18, 8, '15:00:00'),
(21, 1, '12:12:12');

-- --------------------------------------------------------

--
-- Table structure for table `matches`
--

CREATE TABLE `matches` (
  `id` int NOT NULL,
  `mdate` date DEFAULT NULL,
  `startsat` time DEFAULT NULL,
  `ticketprice` decimal(10,2) DEFAULT NULL,
  `mtype` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `matches`
--

INSERT INTO `matches` (`id`, `mdate`, `startsat`, `ticketprice`, `mtype`) VALUES
(1, '2024-03-22', '15:00:00', 500.00, 'championship'),
(2, '2019-04-20', '15:30:00', 1000.00, 'cup'),
(3, '2000-05-11', '10:00:00', 1000.00, 'championship'),
(4, '2018-11-03', '13:30:00', 500.00, 'championship'),
(5, '2018-12-01', '13:30:00', 500.00, 'championship'),
(6, '2018-08-15', '17:00:00', 200.00, 'cup'),
(7, '2018-11-17', '13:30:00', 1000.00, 'championship'),
(8, '2019-05-18', '16:00:00', 1111.00, 'cup'),
(9, '2018-08-22', '17:00:00', 200.00, 'cup'),
(10, '2018-09-22', '15:30:00', 500.00, 'championship'),
(11, '2018-08-25', '17:00:00', 500.00, 'championship'),
(12, '2018-10-06', '14:00:00', 1000.00, 'championship'),
(13, '2018-10-20', '13:30:00', 500.00, 'championship'),
(14, '2019-03-09', '13:30:00', 500.00, 'championship'),
(15, '2018-09-26', '15:00:00', 500.00, 'cup'),
(16, '2019-05-04', '16:00:00', 500.00, 'championship'),
(17, '2018-10-24', '14:00:00', 1000.00, 'cup'),
(18, '2018-08-11', '17:00:00', 500.00, 'championship'),
(19, '2019-04-06', '15:30:00', 500.00, 'championship'),
(20, '2010-01-01', '11:11:11', 1111.00, 'cup');

-- --------------------------------------------------------

--
-- Table structure for table `spectators`
--

CREATE TABLE `spectators` (
  `id` int NOT NULL,
  `sname` varchar(100) DEFAULT NULL,
  `male` tinyint(1) DEFAULT NULL,
  `haspass` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `spectators`
--

INSERT INTO `spectators` (`id`, `sname`, `male`, `haspass`) VALUES
(1, 'salah ben sarar', 1, 0),
(2, 'Kertész Bence', -1, 0),
(3, 'Molnár Alex', -1, -1),
(4, 'Bóka Nátán', -1, -1),
(5, 'Réti Dániel', -1, -1),
(6, 'Varga Zsolt', -1, 0),
(7, 'Elek Miklós', -1, 0),
(8, 'Balázs Domonkos', -1, 0),
(9, 'Tóth Ákos', -1, -1),
(10, 'Sári Péter', -1, 0),
(11, 'Kiss Dorina', 0, -1),
(12, 'Csuka Beáta', 0, 0),
(13, 'Kun Tamás', -1, -1),
(14, 'Zsolczai Balázs', -1, -1),
(15, 'Bertók Dániel', -1, -1),
(16, 'Fehér Orsolya', 0, -1),
(17, 'Márton Hunor', -1, 0),
(18, 'Vass András', -1, 0),
(19, 'Szepes Edit', 0, 0),
(20, 'Kónya Barbara', 0, 0),
(21, 'Tóth Luca', 0, 0),
(23, 'Oláh Soma', -1, 0),
(24, 'Bajnai Krisztián', -1, 0),
(25, 'Csáki Márton', -1, 0),
(26, 'Deák István', -1, 0),
(27, 'Török Róbert', -1, 0),
(28, 'Bogdándi Dávid', -1, -1),
(29, 'Szolga Ádám', -1, 0),
(30, 'Molnár Márton', -1, -1),
(31, 'Árva Ákos', -1, 0),
(32, 'Schiss Bence', -1, -1),
(33, 'Szűcs Kornél', -1, 0),
(34, 'Stephe', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `role` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'ROLE_USER'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `role`) VALUES
(1, 'Admin', 'admin@gmail.com', '$2a$10$orbE87z0ZV5rkmrgtib7KOjhSScCIxQymfUIpqrUMMl/UxWglmy5C', 'ROLE_ADMIN'),
(3, 'User', 'user@gmail.com', '$2a$10$exVjZOnYQ3oFdNTFP7qVHOoL8K2XhKpWXY3r8duw8v9pTNxmC0qbm', 'ROLE_USER'),
(4, 'Salah', 'salah@gmail.com', 'wahwah12', 'ROLE_VISITOR'),
(5, 'Salah2', 'salah2@gmail.com', '$2y$10$ERfnmAaS1xd/RaAflc4MUu10e3hYgjI9R8dqRNHiRgRpPzyFn7Vbq', 'ROLE_USER'),
(6, 'salah3', 'salah3@gmail.com', '$2y$10$BkkLWzFzWTBpbndvbdzvTOo7iKGULqIZLAzh.5ddlyAXFK1H7ffse', 'ROLE_VISITOR');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contact_messages`
--
ALTER TABLE `contact_messages`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `entries`
--
ALTER TABLE `entries`
  ADD PRIMARY KEY (`spectatorid`,`matchid`),
  ADD KEY `matchid` (`matchid`);

--
-- Indexes for table `matches`
--
ALTER TABLE `matches`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `spectators`
--
ALTER TABLE `spectators`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contact_messages`
--
ALTER TABLE `contact_messages`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `entries`
--
ALTER TABLE `entries`
  ADD CONSTRAINT `entries_ibfk_1` FOREIGN KEY (`spectatorid`) REFERENCES `spectators` (`id`),
  ADD CONSTRAINT `entries_ibfk_2` FOREIGN KEY (`matchid`) REFERENCES `matches` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
