-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 10, 2019 at 07:47 PM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parkinsondisease`
--

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `event_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `descrip` varchar(255) DEFAULT NULL,
  `date1` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `past_weblink` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`event_id`, `name`, `descrip`, `date1`, `place`, `time`, `website`, `past_weblink`) VALUES
(1, 'Advanced Treatment for Parkinson', 'Parkinson\'s and Palliative Care: The What, Why, and How', '12/02/19', 'Mumbai', '6pm onwards', 'https://parkinson.org/events/2019/Heartland/PalliativeCare', 'https://www.parkinsons.org.uk/events'),
(2, 'Parkinson\'s Connection', 'Exercise and the Brain: The Parkinson\'s Connection', '22/02/19', 'Delhi', '10.30 to 13.30', 'https://parkinson.org/events/2019/Exercise-Brain-Parkinsons-Connection-Camarillo-Library', 'https://www.parkinsons.org.uk/events');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `f_id` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `arising` int(11) DEFAULT NULL,
  `speech` int(11) DEFAULT NULL,
  `walking` int(11) DEFAULT NULL,
  `date1` date DEFAULT NULL,
  `no` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`f_id`, `username`, `arising`, `speech`, `walking`, `date1`, `no`) VALUES
(1, '5', 3, 1, 2, '0000-00-00', 1),
(2, '5', 4, 4, 3, '0000-00-00', 2),
(3, '5', 3, 2, 2, '0000-00-00', 3),
(4, '5', 3, 4, 4, '0000-00-00', 4),
(4, '4', 4, 4, 3, '2019-02-10', 1),
(5, '5', 3, 2, 2, '0000-00-00', 5),
(6, '5', 3, 3, 0, '0000-00-00', 6),
(7, '5', 2, 1, 2, '2019-02-10', 7),
(8, '4', 4, 1, 0, '2019-02-10', 2),
(9, '4', 4, 4, 0, '2019-02-10', 3),
(10, '5', 2, 1, 0, '2019-02-10', 8),
(11, '4', 2, 3, 0, '2019-02-10', 4),
(12, '4', 4, 1, 1, '2019-02-10', 5);

-- --------------------------------------------------------

--
-- Table structure for table `tips`
--

CREATE TABLE `tips` (
  `t_id` int(11) DEFAULT NULL,
  `pdf` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tips`
--

INSERT INTO `tips` (`t_id`, `pdf`) VALUES
(1, 'tips1.pdf'),
(2, 'tips2.pdf'),
(3, 'tips3.pdf'),
(4, 'tips4.pdf');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `diagnosis_type` varchar(255) DEFAULT NULL,
  `disease` varchar(255) DEFAULT NULL,
  `yr_of_diag` varchar(255) DEFAULT NULL,
  `medicine` varchar(255) DEFAULT NULL,
  `doc_name` varchar(255) DEFAULT NULL,
  `emergency_contact` varchar(255) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `sign_up` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `email`, `password`, `name`, `age`, `gender`, `phone`, `diagnosis_type`, `disease`, `yr_of_diag`, `medicine`, `doc_name`, `emergency_contact`, `address`, `sign_up`) VALUES
('4', 's@gmail.com', '1234', 'sonal', '27', 'Female', '9819817895', 'Ayurveda', 'Essential Tremorous', '2001', 'Amantral', 'Shivani Bhat', '8878789875', 'China Wall', '1'),
('5', 'madcat@gmail.com', '1234', 'pinky', '56', 'Female', '9858748511', 'Natropathy', 'Essential Tremorous', '2005', 'Ropark', 'Rehan', '7787410230', 'Chruchgate', '1'),
('8', 'pokemon@gmail.com', '1234', 'rahul', '87', 'Male', '8885552210', 'Natropathy', 'Essential Tremorous', '1995', 'Rosalect', 'Tejas', '9822157841', 'Thane', '1'),
('7', 'k@gmail.com', '1234', '', '', '', '', '', '', '', '', '', '', '', '0'),
('27', 'sonal@gmail.com', '1234', '', '', '', '', '', '', '', '', '', '', '', '0');

-- --------------------------------------------------------

--
-- Table structure for table `videos`
--

CREATE TABLE `videos` (
  `disease_name` varchar(255) NOT NULL,
  `video_name` varchar(500) NOT NULL,
  `video_url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `videos`
--

INSERT INTO `videos` (`disease_name`, `video_name`, `video_url`) VALUES
('Parkinson', 'Parkinsons Move and Shout Class	LiEpzFKBdhw', 'LiEpzFKBdhw'),
('Parkinson', 'Balls & Balance, Home Power for Parkinson\'s class', 'zpeHXcdn_C0'),
('Parkinson', 'Power for Parkinson\'s Home Move & Shout Video #2', 'S66AM4QAhww'),
('Parkinson', 'Power for Parkinson\'s Home Workout with Weights & a Ball and Balance Series too', 'SNcsOiclxxA'),
('Parkinson', 'Election-themed (non-partisan) Full Length Parkinson\'s Move & Shout Exerciseclass', 'v00Wsm9EZOM'),
('', '', ''),
('Parkinson', 'Parkinson\'s Home Exercise Class, Brain Teasers and More!', 'ewFluJlK-Lc'),
('PSP', 'Exercises for Parkinson\'s: Balance Exercises', 'wkDiOCIX_xA'),
('PSP', '7 Helpful Hand Exercises for Parkinson\'s (to Improve Handwriting, Flexibility, and Dexterity)', 'Ez2GeaMa4c8'),
('PSP', 'Exercises for Parkinson\'s: Flexibility Exercises', '7CFLm1SL5EU'),
('PSP', 'Walking Exercises for Parkinsons Disease', '4FHbqaBt6q0'),
('PSP', 'Movement Tips for People with Parkinson\'s Disease', 'qo7kXKgo2AE'),
('PSP', 'PSP exercise', '5-ZVfS_Dtgc'),
('PSP', 'Tongue Exercise for speech and swallowing abilities', 'v5rYiUlXL3Y'),
('PSP', 'Occupational Therapy Treatment for PSP, CBD and MSA', '4V4-1VGIi24'),
('MSA', 'Occupational Therapy Treatment for PSP, CBD and MSA', '4V4-1VGIi24'),
('MSA', 'MSA Exercises program 1of 2\r\n', 'gymqORWaWvI'),
('MSA', 'MSA Exercises program 2 of 2', 'k5xNvotrC4I'),
('Essential Tremorous', 'Occupational Therapy Hand Exercises', 'xQrP97h4MMg'),
('Essential Tremorous', 'Wrist, Hand & Finger Stretching Routine - Active Isolated Stretching', 'uPO-zST-7EE'),
('Essential Tremorous', '7 Helpful Hand Exercises for Parkinson\'s (to Improve Handwriting, Flexibility, and Dexterity)', 'Ez2GeaMa4c8'),
('Other', '5 Acupressure Point for Parkinsons Disease', 'xwI8RwVamDQ'),
('Other', 'PARKINSONISM - MUDRA WILL MAKE YOU STABLE ', 'aT3X2o0fdm0');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
