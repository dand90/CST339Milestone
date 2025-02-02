-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Feb 01, 2025 at 11:34 PM
-- Server version: 5.7.24
-- PHP Version: 8.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `recruit`
--

-- --------------------------------------------------------

--
-- Table structure for table `jobpostings`
--

CREATE TABLE `jobpostings` (
  `id` int(9) NOT NULL,
  `jobposting_name` varchar(45) NOT NULL,
  `employer_name` varchar(45) NOT NULL,
  `hourly_salary` float NOT NULL,
  `openings` int(3) NOT NULL,
  `job_description` text NOT NULL,
  `users_id` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `jobpostings`
--

INSERT INTO `jobpostings` (`id`, `jobposting_name`, `employer_name`, `hourly_salary`, `openings`, `job_description`, `users_id`) VALUES
(1, 'Head Chef', 'Sushi Shiro', 35, 1, 'Looking for a head chef with 10 years sushi crafting experience.', 1),
(2, 'Server', 'Sunday\'s', 15, 2, 'Sunday\'s is looking for a server with experience in customer service or food service.', 1),
(3, 'Clerk', 'Tao Tei', 15, 2, 'Tao Tei is in need of an entry level clerk for the daily lunch rush.', 1),
(4, 'Executive Chef', 'Pizza Planet', 55, 1, 'Pizza Planet is looking for an executive chef with 15 years of experience in a head chef position or similar.', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(9) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `emailaddress` varchar(45) NOT NULL,
  `phone_no` varchar(15) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `lastname`, `firstname`, `emailaddress`, `phone_no`, `username`, `password`) VALUES
(1, 'Administrator', 'System', 'sysadmin@recruit.com', '5555555555', '123', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jobpostings`
--
ALTER TABLE `jobpostings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_jobpostings_users_idx` (`users_id`) USING BTREE;

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jobpostings`
--
ALTER TABLE `jobpostings`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `jobpostings`
--
ALTER TABLE `jobpostings`
  ADD CONSTRAINT `fk_jobpostings_users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
