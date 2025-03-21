-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:4406
-- Generation Time: Jan 02, 2025 at 11:45 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_ms`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_data`
--

CREATE TABLE `admin_data` (
  `user_id` int(8) NOT NULL,
  `admin_type` varchar(20) DEFAULT 'SIMPLE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin_data`
--

INSERT INTO `admin_data` (`user_id`, `admin_type`) VALUES
(1, 'ROOT');

-- --------------------------------------------------------

--
-- Table structure for table `book_data`
--

CREATE TABLE `book_data` (
  `book_id` int(6) NOT NULL,
  `book_name` varchar(200) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `book_part` int(2) DEFAULT NULL,
  `book_type` varchar(20) DEFAULT NULL,
  `price` int(5) DEFAULT NULL,
  `few_i_line` varchar(500) DEFAULT NULL,
  `quantity` int(4) DEFAULT NULL,
  `book_source` varchar(200) NOT NULL,
  `b_status` varchar(10) DEFAULT 'REGULER'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book_data`
--

INSERT INTO `book_data` (`book_id`, `book_name`, `author`, `book_part`, `book_type`, `price`, `few_i_line`, `quantity`, `book_source`, `b_status`) VALUES
(121, '1', '1', 1, '1', 1, '1', 1, '1', 'REGULER'),
(122, 'SINO', 'MH SIAM', 1, 'xyz', 9999, 'SICK BOY SIAM. \nAKJON BERTHU PRAMIK.', 99, 'MOHAMMAD MOMINUL HAQ SIAM', 'REGULER'),
(1673, 'ROMJAN ALI THE DEVELOPER', 'MD ROMJAN ALI', 1, 'XYZ', 9999, 'NOTHING INTERASTING. EVERYTHONG GOING OUT OF CONTROL.', 99, 'FROM DEVELOPER', 'REGULER');

-- --------------------------------------------------------

--
-- Table structure for table `book_history`
--

CREATE TABLE `book_history` (
  `book_id` int(6) DEFAULT NULL,
  `T_status` varchar(20) DEFAULT NULL,
  `T_time` time DEFAULT NULL,
  `T_date` date DEFAULT NULL,
  `student_id` int(8) DEFAULT NULL,
  `employee_id` int(8) DEFAULT NULL,
  `quantity` int(8) NOT NULL DEFAULT 1,
  `otp` varchar(6) DEFAULT NULL,
  `by_who` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book_history`
--

INSERT INTO `book_history` (`book_id`, `T_status`, `T_time`, `T_date`, `student_id`, `employee_id`, `quantity`, `otp`, `by_who`) VALUES
(121, 'ADDED', '15:21:24', '2024-06-12', NULL, 1, 1, NULL, NULL),
(121, 'ISSUED', '01:19:46', '2024-07-07', 246, NULL, 1, '706093', 'STUDENT'),
(121, 'ISSUED', '12:37:55', '2024-07-08', 246, NULL, 1, '308871', 'STUDENT'),
(121, 'ISSUED', '16:31:10', '2024-07-20', 246, NULL, 1, '635533', 'STUDENT'),
(121, 'ISSUED', '17:08:28', '2024-07-20', 246, NULL, 1, '401191', 'STUDENT'),
(121, 'ISSUED', '17:12:26', '2024-07-20', 246, NULL, 1, '951272', 'STUDENT'),
(121, 'ISSUED', '00:30:46', '2024-07-21', 249, NULL, 1, '709111', 'STUDENT'),
(12323, 'ADDED', '02:21:50', '2025-01-02', NULL, 1, 99, NULL, NULL),
(122, 'ADDED', '02:23:23', '2025-01-02', NULL, 1, 99, NULL, NULL),
(1673, 'UPDATED', '02:25:55', '2025-01-02', NULL, 1, 99, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `changes_student_data`
--

CREATE TABLE `changes_student_data` (
  `fast_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `nid_birth` bigint(20) NOT NULL,
  `dob` date DEFAULT NULL,
  `institute_office` varchar(400) DEFAULT NULL,
  `ins_office_id` varchar(20) DEFAULT NULL,
  `full_address` varchar(500) DEFAULT NULL,
  `remark` varchar(5000) DEFAULT NULL,
  `user_id` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `changes_student_data`
--

INSERT INTO `changes_student_data` (`fast_name`, `last_name`, `phone`, `email`, `gender`, `nid_birth`, `dob`, `institute_office`, `ins_office_id`, `full_address`, `remark`, `user_id`) VALUES
('D', 'D', 'D', 'D', 'Male', 363636, '2004-02-01', 'D', '1234', 'D', 'Remark Here...', 246);

-- --------------------------------------------------------

--
-- Table structure for table `employee_data`
--

CREATE TABLE `employee_data` (
  `user_id` int(8) UNSIGNED ZEROFILL NOT NULL,
  `position` varchar(10) NOT NULL,
  `fast_name` varchar(10) NOT NULL,
  `last_name` varchar(10) NOT NULL,
  `nid` bigint(17) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  `full_address` varchar(200) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(10) NOT NULL,
  `pass` varchar(100) NOT NULL DEFAULT '1234',
  `ftr_nid` bigint(17) DEFAULT NULL,
  `e_status` varchar(10) DEFAULT NULL,
  `ftr_name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee_data`
--

INSERT INTO `employee_data` (`user_id`, `position`, `fast_name`, `last_name`, `nid`, `phone`, `email`, `full_address`, `dob`, `gender`, `pass`, `ftr_nid`, `e_status`, `ftr_name`) VALUES
(00000001, 'ADMIN', 'MD ROMJAN', 'ALI', 4674583507, '+8801779852361', 'ROMJANALI01673@GMAIL.COM', '350-BAIRA, MURADNAGAR, CUMILLA.', '2004-02-01', 'MALE', '1234560', 101010101010, 'REGULER', 'KARIM'),
(00000035, 'LIBRARIAN', 'KAPIL', 'UDDIN', 1234567890, '01789757888', 'KAPILUDDIN@GMAIL.COM', '350-SDFS,SDFSA,COX\'S BAZER.', '2023-05-01', 'MALE', '1234', 1234567890, 'REGULER', 'XYZ'),
(00000036, 'MODERATOR', 'SDF', 'SDF', 453, '345', '435', '543', '2004-01-01', 'FEMALE', '1234', 435, 'SUSPENDED', '453');

-- --------------------------------------------------------

--
-- Table structure for table `employee_history`
--

CREATE TABLE `employee_history` (
  `E_id` int(8) DEFAULT NULL,
  `T_status` varchar(20) DEFAULT NULL,
  `by_who` varchar(200) DEFAULT NULL,
  `T_time` time DEFAULT NULL,
  `T_date` date DEFAULT NULL,
  `A_E_id` int(8) DEFAULT NULL,
  `U_type` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee_history`
--

INSERT INTO `employee_history` (`E_id`, `T_status`, `by_who`, `T_time`, `T_date`, `A_E_id`, `U_type`) VALUES
(1, 'ADDED', 'DEVELOPER', '23:23:23', '2024-06-12', -999999, 'ADMIN'),
(35, 'ADDED', 'ADMIN', '15:13:30', '2024-06-12', 1, 'LIBRARIAN'),
(36, 'ADDED', 'ADMIN', '01:40:23', '2024-07-07', 1, 'MODERATOR'),
(36, 'UPDATED', 'ADMIN', '01:41:20', '2024-07-07', 1, 'MODERATOR'),
(36, 'UPDATED', 'ADMIN', '01:41:22', '2024-07-07', 1, 'MODERATOR');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `student_id` int(8) DEFAULT NULL,
  `employee_id` int(8) DEFAULT NULL,
  `subject` varchar(111) NOT NULL,
  `T_time` time NOT NULL,
  `T_date` date NOT NULL,
  `message` varchar(800) NOT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `From_who` varchar(20) DEFAULT NULL,
  `A_E_ID` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`student_id`, `employee_id`, `subject`, `T_time`, `T_date`, `message`, `description`, `From_who`, `A_E_ID`) VALUES
(246, NULL, 'book issue', '01:19:46', '2024-07-07', 'Your OTP is : 751767', 'Hay dear student thanks for book issue and having with us. this is your OTP remind it and within very soon complete the necessary step to take your issued book.', 'STUDENT', NULL),
(246, NULL, 'book issue', '12:37:55', '2024-07-08', 'Your OTP is : 531485', 'Hay dear student thanks for book issue and having with us. this is your OTP remind it and within very soon complete the necessary step to take your issued book.', 'STUDENT', NULL),
(246, NULL, 'xyz', '12:41:38', '2024-07-08', 'ehg34j', 'ref45tg5rt', 'ADMIN', 1),
(246, NULL, 'book issue', '16:31:10', '2024-07-20', 'Your OTP is : 705082', 'Hay dear student thanks for book issue and having with us. this is your OTP remind it and within very soon complete the necessary step to take your issued book.', 'STUDENT', NULL),
(246, NULL, 'book issue', '17:08:28', '2024-07-20', 'Your OTP is : 370219', 'Hay dear student thanks for book issue and having with us. this is your OTP remind it and within very soon complete the necessary step to take your issued book.', 'STUDENT', NULL),
(246, NULL, 'book issue', '17:12:26', '2024-07-20', 'Your OTP is : 738829', 'Hay dear student thanks for book issue and having with us. this is your OTP remind it and within very soon complete the necessary step to take your issued book.', 'STUDENT', NULL),
(249, NULL, 'book issue', '00:30:46', '2024-07-21', 'Your OTP is : 439394', 'Hay dear student thanks for book issue and having with us. this is your OTP remind it and within very soon complete the necessary step to take your issued book.', 'STUDENT', NULL),
(249, NULL, 'fdgds', '00:44:14', '2024-07-21', 'dfgds', 'dfgdsfg', 'ADMIN', 1);

-- --------------------------------------------------------

--
-- Table structure for table `registaed_student_data`
--

CREATE TABLE `registaed_student_data` (
  `fast_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `nid_birth` bigint(17) DEFAULT NULL,
  `institute_office` varchar(200) DEFAULT NULL,
  `ins_office_id` varchar(30) DEFAULT NULL,
  `full_address` varchar(200) DEFAULT NULL,
  `pass` varchar(100) DEFAULT NULL,
  `registation_time` time DEFAULT NULL,
  `registation_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `registaed_student_data`
--

INSERT INTO `registaed_student_data` (`fast_name`, `last_name`, `phone`, `email`, `gender`, `dob`, `nid_birth`, `institute_office`, `ins_office_id`, `full_address`, `pass`, `registation_time`, `registation_date`) VALUES
('KAPIL', 'UDDIN', '+8801872018309', 'KAPILUDDIN36000@GMAIL.COM', 'MALE', '2008-06-19', 22009983293424797, 'BRAHMANBARIA POLYTECHNIC INSTITUTE', '677829', 'XYZ, COX\'S BAZER', '1234', '11:07:14', '2024-06-13');

-- --------------------------------------------------------

--
-- Table structure for table `student_book`
--

CREATE TABLE `student_book` (
  `student_id` int(8) NOT NULL,
  `book_id` int(6) NOT NULL,
  `T_time` time NOT NULL,
  `T_date` date NOT NULL,
  `T_status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_book`
--

INSERT INTO `student_book` (`student_id`, `book_id`, `T_time`, `T_date`, `T_status`) VALUES
(246, 121, '17:08:28', '2024-07-20', 'RETURNED'),
(246, 121, '17:12:26', '2024-07-20', 'ISSUED'),
(249, 121, '00:30:46', '2024-07-21', 'ISSUED');

-- --------------------------------------------------------

--
-- Table structure for table `student_data`
--

CREATE TABLE `student_data` (
  `fast_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `nid_birth` bigint(17) DEFAULT NULL,
  `institute_office` varchar(200) DEFAULT NULL,
  `ins_office_id` varchar(30) DEFAULT NULL,
  `full_address` varchar(200) DEFAULT NULL,
  `pass` varchar(100) DEFAULT NULL,
  `user_id` int(8) UNSIGNED ZEROFILL NOT NULL,
  `s_status` varchar(10) NOT NULL DEFAULT 'REGULER'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_data`
--

INSERT INTO `student_data` (`fast_name`, `last_name`, `phone`, `email`, `gender`, `dob`, `nid_birth`, `institute_office`, `ins_office_id`, `full_address`, `pass`, `user_id`, `s_status`) VALUES
('D', 'D', 'D', 'D', 'MALE', '2004-02-01', 363636, 'D', '', 'D', '1111', 00000246, 'REGULER'),
('2', '2', '2', '2', 'FEMALE', '2024-07-17', 7, '2', '2', '2', 'aa', 00000249, 'REGULER'),
('A', 'A', 'A', 'A', 'MALE', '2005-06-21', 13, 'A', 'A', 'A', 'A', 00000253, 'REGULER'),
('SDFSD', 'SDFSDF', 'ASDF', 'SDF', 'MALE', '2004-07-11', 3423, 'WER', 'WER', 'WER', '111', 00000254, 'REGULER');

-- --------------------------------------------------------

--
-- Table structure for table `student_history`
--

CREATE TABLE `student_history` (
  `user_id` int(8) DEFAULT NULL,
  `T_status` varchar(20) DEFAULT NULL,
  `by_who` varchar(150) DEFAULT NULL,
  `employee_id` int(8) DEFAULT NULL,
  `T_time` time DEFAULT NULL,
  `T_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_history`
--

INSERT INTO `student_history` (`user_id`, `T_status`, `by_who`, `employee_id`, `T_time`, `T_date`) VALUES
(246, 'ADDED', 'ADMIN', 1, '15:12:04', '2024-06-12'),
(246, 'REGISTATION', 'STUDENT', NULL, '15:11:32', '1970-01-01'),
(246, 'CHANGE', 'STUDENT', NULL, '15:19:32', '2024-06-12'),
(246, 'UPDATED', 'ADMIN', 1, '15:20:49', '2024-06-12'),
(249, 'ADDED', 'ADMIN', 1, '15:36:58', '2024-06-12'),
(249, 'REGISTATION', 'STUDENT', NULL, '15:36:31', '1970-01-01'),
(250, 'REGISTATION', 'STUDENT', 56, '15:40:14', '2024-06-12'),
(250, 'ADDED', 'MODERATOR', 56, '15:51:03', '2024-06-12'),
(0, 'DELETED', 'ADMIN', 1, '16:01:43', '2024-06-12'),
(253, 'ADDED', 'ADMIN', 1, '16:06:38', '2024-06-12'),
(253, 'REGISTATION', 'STUDENT', NULL, '16:05:07', '1970-01-01'),
(254, 'REGISTATION', 'STUDENT', 36, '00:29:59', '2024-07-21'),
(254, 'ADDED', 'MODERATOR', 36, '00:40:39', '2024-07-21'),
(246, 'CHANGE', 'STUDENT', NULL, '21:38:51', '2024-11-18');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_data`
--
ALTER TABLE `admin_data`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `book_data`
--
ALTER TABLE `book_data`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `changes_student_data`
--
ALTER TABLE `changes_student_data`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `nid_birth` (`nid_birth`);

--
-- Indexes for table `employee_data`
--
ALTER TABLE `employee_data`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `nid` (`nid`);

--
-- Indexes for table `student_data`
--
ALTER TABLE `student_data`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `nid_birth` (`nid_birth`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee_data`
--
ALTER TABLE `employee_data`
  MODIFY `user_id` int(8) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `student_data`
--
ALTER TABLE `student_data`
  MODIFY `user_id` int(8) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=255;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
