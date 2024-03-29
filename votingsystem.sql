-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 29, 2024 at 07:50 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `votingsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Name` varchar(30) NOT NULL,
  `FatherName` varchar(30) NOT NULL,
  `CNIC` varchar(13) NOT NULL,
  `Gender` varchar(3) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `PhoneNumber` varchar(11) NOT NULL,
  `Username` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Name`, `FatherName`, `CNIC`, `Gender`, `Email`, `PhoneNumber`, `Username`, `Password`) VALUES
('admin', 'admin', '0', '0', '', '', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `stats`
--

CREATE TABLE `stats` (
  `PTI` int(20) NOT NULL,
  `PPP` int(20) NOT NULL,
  `PMLN` int(20) NOT NULL,
  `MQM` int(20) NOT NULL,
  `ANP` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stats`
--

INSERT INTO `stats` (`PTI`, `PPP`, `PMLN`, `MQM`, `ANP`) VALUES
(4, 0, 1, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `voter`
--

CREATE TABLE `voter` (
  `ID` int(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `FatherName` varchar(50) NOT NULL,
  `CNIC` varchar(13) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `BirthYear` int(4) UNSIGNED NOT NULL,
  `PhoneNo` varchar(11) NOT NULL,
  `Adress` varchar(100) NOT NULL,
  `City` varchar(30) NOT NULL,
  `Vote` varchar(3) NOT NULL,
  `Voted` varchar(3) DEFAULT 'No'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `voter`
--

INSERT INTO `voter` (`ID`, `Name`, `FatherName`, `CNIC`, `Gender`, `BirthYear`, `PhoneNo`, `Adress`, `City`, `Vote`, `Voted`) VALUES
(1, 'User1', 'User', '321', 'Male', 2003, '030000', 'bwp', 'Karachi', 'Yes', 'Yes'),
(2, 'User2', 'user', '123', 'Male', 2003, '030000', 'bwp', 'Karachi', 'Yes', 'Yes'),
(3, 'User3', 'user', '111', 'Male', 2003, '0300000000', 'Bindra Pulli', 'Karachi', 'Yes', 'Yes'),
(13, 'User4', 'user', '222', 'Male', 2003, '0300000', 'bwp', 'Karachi', 'Yes', 'Yes'),
(14, 'newUser', 'user', '555', 'Male', 2003, '0000000', '0000000', 'Karachi', 'Yes', 'No'),
(15, 'Talha', 'Zahid', '31205', 'Male', 2003, '0200000', '21321', 'Karachi', 'Yes', 'Yes');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`CNIC`),
  ADD UNIQUE KEY `Email` (`Email`,`Username`);

--
-- Indexes for table `voter`
--
ALTER TABLE `voter`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `voter`
--
ALTER TABLE `voter`
  MODIFY `ID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
