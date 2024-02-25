-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 25, 2024 at 11:21 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `atm_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `pin_code` varchar(10) DEFAULT NULL,
  `date` varchar(40) DEFAULT NULL,
  `mode` varchar(30) DEFAULT NULL,
  `amount` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`pin_code`, `date`, `mode`, `amount`) VALUES
('1234', 'Sat Feb 24 14:49:24 EET 2024', 'Deposit', '500'),
('1234', 'Sat Feb 24 15:06:20 EET 2024', 'Withdraw', '50'),
('1234', 'Sat Feb 24 15:53:38 EET 2024', 'Withdraw', '2'),
('1234', 'Sat Feb 24 15:57:16 EET 2024', 'Withdraw', '1'),
('1234', 'Sat Feb 24 16:12:32 EET 2024', 'Withdraw', '10'),
('1234', 'Sun Feb 25 10:10:59 EET 2024', 'Withdraw', '5'),
('1234', 'Sun Feb 25 10:11:30 EET 2024', 'Withdraw', '5'),
('1234', 'Sun Feb 25 12:02:19 EET 2024', 'Deposit', '1000'),
('1234', 'Sun Feb 25 12:05:13 EET 2024', 'Withdraw', '100'),
('1234', 'Sun Feb 25 12:09:00 EET 2024', 'Withdraw', '20'),
('1234', 'Sun Feb 25 12:10:03 EET 2024', 'Withdraw', '5');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `form_number` varchar(20) DEFAULT NULL,
  `card_number` varchar(30) DEFAULT NULL,
  `pin_code` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`form_number`, `card_number`, `pin_code`) VALUES
('8020', '5040935954688230', '1234'),
('1359', '5040936050716511', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

CREATE TABLE `signup` (
  `form_number` varchar(20) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `father_name` varchar(30) DEFAULT NULL,
  `date_of_birth` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `marital_status` varchar(20) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `pin_code` varchar(20) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`form_number`, `name`, `father_name`, `date_of_birth`, `gender`, `email`, `marital_status`, `address`, `city`, `pin_code`, `state`) VALUES
('3200', 'Name1', 'Father1', '5 apr. 2000', 'Male', 'name1@gmail.com', 'Unmarried', 'Address1', 'City1', '123456', 'State1'),
('2814', 'Name1', 'Father1', '10 apr. 2000', 'Male', 'name1@gmail.com', 'Married', 'Address1', 'City1', '123456', 'State1'),
('9410', 'Name1', 'Father1', '10 apr. 2000', 'Male', 'Address1', 'Unmarried', 'Address1', 'City1', '123456', 'State1'),
('4247', 'Name1', 'Father1', '10 apr. 2000', 'Male', 'name1@gmail.com', 'Unmarried', 'Address1', 'City1', '123456', 'State1'),
('3148', 'Name1', 'Father1', '16 apr. 2000', 'Male', 'name1@gmail.com', 'Married', 'Address1', 'City1', '123456', 'State1'),
('3148', 'Name1', 'Father1', '16 apr. 2000', 'Male', 'name1@gmail.com', 'Married', 'Address1', 'City1', '123456', 'State1'),
('3148', 'Name1', 'Father1', '16 apr. 2000', 'Male', 'name1@gmail.com', 'Unmarried', 'Address1', 'City1', '123456', 'State1'),
('7284', 'Name1', 'Father1', '10 apr. 2000', 'Male', 'name1@gmail.com', 'Married', 'Address1', 'City1', '123456', 'State1'),
('6790', 'Name1', 'Father1', '10 apr. 2000', 'Male', 'name1@gmail.com', 'Unmarried', 'Address1', 'City1', '123456', 'State'),
('8046', 'Name1', 'Father1', '10 apr. 2000', 'Male', 'name1@gmail.com', 'Unmarried', 'Address1', 'City1', '123456', 'State1'),
('5896', 'Name1', 'Father1', '10 apr. 2000', 'Male', 'name1@gmail.com', 'Unmarried', 'Address1', 'City1', '123456', 'State1'),
('36', 'Name1', 'Father1', '10 apr. 2000', 'Male', 'name1@gmail.com', 'Unmarried', 'Address1', 'City1', '123456', 'State1'),
('8020', 'Name1', 'Father1', '10 apr. 2000', 'Male', 'name1@gmail.com', 'Unmarried', 'Address1', 'City1', '123456', 'State1'),
('7198', 'Name2', 'Father1', '6 feb. 1990', 'Female', 'name2@yahoo.com', 'Married', 'Address2', 'City2', '123456', 'State2'),
('4854', 'Name2', 'Father2', '6 feb. 1990', 'Female', 'name2', 'Married', 'Address2', 'City2', '123456', 'State2'),
('8615', 'Name2', 'Father2', '6 feb. 1990', 'Female', 'name2@yahoo.com', 'Married', 'Address2', 'City2', '123456', 'State2'),
('1359', 'Name2', 'Father2', '6 feb. 1990', 'Female', 'name2@yahoo.com', 'Married', 'Address2', 'City2', '123456', 'State2');

-- --------------------------------------------------------

--
-- Table structure for table `signup2`
--

CREATE TABLE `signup2` (
  `form_number` varchar(20) DEFAULT NULL,
  `religion` varchar(20) DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  `income` varchar(30) DEFAULT NULL,
  `education` varchar(20) DEFAULT NULL,
  `occupation` varchar(20) DEFAULT NULL,
  `qualification` varchar(20) NOT NULL,
  `personal_identification_number` varchar(20) DEFAULT NULL,
  `senior_citizen` varchar(40) DEFAULT NULL,
  `existing_account` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signup2`
--

INSERT INTO `signup2` (`form_number`, `religion`, `category`, `income`, `education`, `occupation`, `qualification`, `personal_identification_number`, `senior_citizen`, `existing_account`) VALUES
('36', 'Orthodox Christian', 'Refugees and Immigrants', '<1714', 'Graduate', 'Salaried', 'Diploma', '1000410342525', 'No', 'No'),
('8020', 'Orthodox Christian', 'Refugees and Immigrants', '<1714', 'Graduate', 'Salaried', 'Diploma', '1000410342525', 'No', 'No'),
('1359', 'Catholic', 'General', '<2857', 'Post-Graduate', 'Salaried', 'Master\'s Degree', '2900206253545', 'No', 'No');

-- --------------------------------------------------------

--
-- Table structure for table `signup3`
--

CREATE TABLE `signup3` (
  `form_number` varchar(20) DEFAULT NULL,
  `account_type` varchar(20) DEFAULT NULL,
  `card_number` varchar(30) DEFAULT NULL,
  `pin_code` varchar(20) DEFAULT NULL,
  `facility` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signup3`
--

INSERT INTO `signup3` (`form_number`, `account_type`, `card_number`, `pin_code`, `facility`) VALUES
('8020', 'Saving Account', '5040935954688230', '1234', ' ATM Card Internet Banking Mobile Banking'),
('1359', 'Saving Account', '5040936050716511', '1234', ' ATM Card Internet Banking Mobile Banking');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
