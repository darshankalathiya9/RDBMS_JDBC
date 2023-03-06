-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 06, 2023 at 11:43 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rdbms_jdbc`
--

-- --------------------------------------------------------

--
-- Table structure for table `dept_table`
--

CREATE TABLE `dept_table` (
  `Deptno` int(2) NOT NULL,
  `Dname` varchar(14) DEFAULT NULL,
  `Loc` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dept_table`
--

INSERT INTO `dept_table` (`Deptno`, `Dname`, `Loc`) VALUES
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'SALES', 'CHICAGO'),
(40, 'OPERATIONS', 'BOSTON');

-- --------------------------------------------------------

--
-- Table structure for table `emp_log_table`
--

CREATE TABLE `emp_log_table` (
  `Emp_id` int(5) NOT NULL,
  `Log_date` date DEFAULT NULL,
  `New_salary` int(10) DEFAULT NULL,
  `Action` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `emp_table`
--

CREATE TABLE `emp_table` (
  `Empno` int(4) NOT NULL,
  `Ename` varchar(10) DEFAULT NULL,
  `Job` varchar(9) DEFAULT NULL,
  `Mgr` int(4) DEFAULT NULL,
  `Hiredate` date DEFAULT NULL,
  `Sal` decimal(7,2) DEFAULT NULL,
  `Comm` decimal(7,2) DEFAULT NULL,
  `Deptno` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `emp_table`
--

INSERT INTO `emp_table` (`Empno`, `Ename`, `Job`, `Mgr`, `Hiredate`, `Sal`, `Comm`, `Deptno`) VALUES
(7369, 'SMITH', 'CLERK', 7902, '2022-12-17', '800.00', NULL, 20),
(7499, 'ALLEN', 'SALESMAN', 7698, '2022-02-20', '1600.00', '300.00', 30),
(7521, 'WARD', 'SALESMAN', 7698, '2022-02-22', '1250.00', '500.00', 30),
(7566, 'JONES', 'MANAGER', 7839, '2022-04-02', '2975.00', NULL, 20),
(7654, 'MARTIN', 'SALESMAN', 7698, '2022-09-28', '1250.00', '1400.00', 30),
(7698, 'BLAKE', 'MANAGER', 7839, '2022-05-01', '2850.00', NULL, 30),
(7782, 'CLARK', 'MANAGER', 7839, '2022-06-09', '2450.00', NULL, 10),
(7788, 'SCOTT', 'ANALYST', 7566, '2022-06-11', '3000.00', NULL, 20),
(7839, 'KING', 'PRESIDENT', NULL, '2022-11-17', '5000.00', NULL, 10),
(7844, 'TURNER', 'SALESMAN', 7698, '2022-08-09', '1500.00', '0.00', 30),
(7876, 'ADAMS', 'CLERK', 7788, '2022-07-13', '1100.00', NULL, 20),
(7900, 'JAMES', 'CLERK', 7698, '2022-03-12', '950.00', NULL, 30),
(7902, 'FORD', 'ANALYST', 7566, '2022-03-12', '3000.00', NULL, 20),
(7934, 'MILLER', 'CLERK', 7782, '2022-01-23', '1300.00', NULL, 10);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Rno` int(2) NOT NULL,
  `Sname` varchar(14) DEFAULT NULL,
  `City` varchar(20) DEFAULT NULL,
  `State` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dept_table`
--
ALTER TABLE `dept_table`
  ADD PRIMARY KEY (`Deptno`);

--
-- Indexes for table `emp_table`
--
ALTER TABLE `emp_table`
  ADD PRIMARY KEY (`Empno`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`Rno`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dept_table`
--
ALTER TABLE `dept_table`
  MODIFY `Deptno` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
