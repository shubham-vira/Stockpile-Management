-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2020 at 06:25 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `billid` int(3) NOT NULL,
  `cgst` float NOT NULL,
  `sgst` float NOT NULL,
  `igst` float NOT NULL,
  `discount` float NOT NULL,
  `total` float NOT NULL,
  `date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`billid`, `cgst`, `sgst`, `igst`, `discount`, `total`, `date`) VALUES
(1, 1.5, 1.5, 0, 0, 33, '03-03-2018'),
(2, 1.5, 1.5, 0, 0, 33, '03-03-2018'),
(3, 3, 3, 0, 0, 66, '03-03-2018'),
(4, 1.5, 1.5, 0, 0, 33, '03-03-2018'),
(5, 3, 3, 0, 0, 66, '03-03-2018'),
(6, 3, 3, 0, 0, 66, '03-03-2018'),
(7, 10.8, 10.8, 0, 0, 237.6, '03-03-2018'),
(8, 1.5, 1.5, 0, 0, 33, '03-03-2018'),
(9, 4.5, 4.5, 0, 0, 99, '03-03-2018'),
(10, 18, 18, 0, 0, 396, '03-03-2018'),
(11, 0, 0, 0, 0, 99, '03-03-2018'),
(12, 0, 0, 0, 0, 0, '03-03-2018'),
(13, 1.5, 1.5, 0, 0, 33, '03-03-2018'),
(14, 31.5, 31.5, 0, 0, 1093, '03-03-2018'),
(15, 16.5, 7.5, 7.5, 0, 381.5, '03-03-2018'),
(16, 4.5, 4.5, 0, 0, 99, '03-03-2018'),
(17, 1.5, 1.5, 0, 0, 33, '03-03-2018'),
(18, 3, 3, 0, 0, 66, '03-03-2018'),
(19, 9, 9, 0, 0, 198, '03-03-2018'),
(20, 6, 6, 0, 0, 132, '03-03-2018'),
(21, 30, 30, 0, 0, 1060, '03-03-2018'),
(22, 5, 5, 0, 0, 110, '03-03-2018'),
(23, 2, 2, 0, 0, 44, '03-03-2018'),
(24, 1, 1, 0, 0, 22, '03-03-2018'),
(25, 3, 0, 3, 0, 66, '03-03-2018'),
(26, 0, 0, 0, 0, 99, '04-03-2018'),
(27, 0, 0, 0, 0, 0, '04-03-2018'),
(28, 11.7, 11.7, 0, 0, 257.4, '04-03-2018'),
(29, 3, 3, 0, 0, 66, '04-03-2018'),
(30, 3, 3, 0, 0, 66, '04-03-2018'),
(31, 75, 75, 0, 0, 1650, '04-03-2018'),
(32, 8.1, 8.1, 0, 0, 178.2, '04-03-2018'),
(33, 4.9, 4.9, 0, 0, 107.8, '04-03-2018'),
(34, 0, 0, 0, 0, 0, '04-03-2018'),
(35, 0, 0, 0, 0, 712.8, '04-03-2018'),
(36, 0, 0, 0, 0, 0, '04-03-2018'),
(37, 3, 3, 0, 0, 66, '04-03-2018'),
(38, 4.8, 4.8, 0, 0, 105.6, '04-03-2018'),
(39, 4.6, 4.6, 0, 0, 101.2, '07-03-2018'),
(40, 3, 3, 0, 0, 66, '31-03-2018'),
(41, 3, 3, 0, 0, 66, '31-03-2018'),
(42, 5.5, 5.5, 0, 0, 121, '31-03-2018'),
(43, 6, 6, 0, 0, 132, '31-03-2018'),
(44, 0, 0, 0, 0, 66, '31-03-2018'),
(45, 0, 0, 0, 0, 0, '31-03-2018'),
(46, 0, 0, 0, 0, 0, '31-03-2018'),
(47, 6, 6, 0, 0, 132, '31-03-2018'),
(48, 3, 3, 0, 0, 66, '31-03-2018'),
(49, 3, 3, 0, 0, 66, '28-07-2018');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `productid` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `categoryid` int(11) NOT NULL,
  `categoryname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`categoryid`, `categoryname`) VALUES
(1, 'Syrups'),
(2, 'Fruits'),
(3, 'Aeriated Drinks'),
(4, 'DryFruit'),
(5, 'IceCreams'),
(6, 'Dairy Products');

-- --------------------------------------------------------

--
-- Table structure for table `cheque_info`
--

CREATE TABLE `cheque_info` (
  `id` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `bill_id` int(11) NOT NULL,
  `chequenum` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cheque_info`
--

INSERT INTO `cheque_info` (`id`, `status`, `bill_id`, `chequenum`) VALUES
(1, 1, 2, 25847852),
(2, 1, 3, 1233),
(3, 1, 5, 1234),
(4, 1, 6, 123459),
(5, 1, 7, 23456),
(6, 1, 8, 456789),
(7, 1, 9, 2181296),
(8, 1, 10, 7654),
(9, 1, 14, 8520),
(10, 1, 15, 999999),
(11, 1, 16, 13456),
(12, 1, 17, 5432),
(13, 1, 18, 7654),
(14, 1, 19, 5432),
(15, 1, 20, 4565),
(16, 1, 23, 8526963),
(17, 1, 24, 852036),
(18, 0, 27, 852695),
(19, 1, 28, 123456),
(20, 1, 31, 95284123),
(21, 1, 32, 52523),
(22, 1, 33, 541254),
(23, 1, 34, 520),
(24, 1, 36, 2312),
(25, 1, 38, 852),
(26, 1, 40, 123786),
(27, 0, 42, 852),
(28, 1, 43, 7890),
(29, 0, 49, 786);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerid` int(11) NOT NULL,
  `customername` varchar(255) NOT NULL,
  `contactno` varchar(255) NOT NULL,
  `gst` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerid`, `customername`, `contactno`, `gst`, `email`) VALUES
(1, 'shubham vira', '9167843033', '', 'shubhamvira@gmail.com'),
(2, 'mohit nagpal', '9987836701', '', 'mohittnagpal@gmail.com'),
(3, '', '', '', ''),
(4, 'shailesh jain', '9146169988', '', 'jainshail@gmail.com'),
(7, 'kirti', '9422508108', '', 'kirtimotwani303@gmail.com'),
(8, 'reyna binny', '78945612', '', 'reynabinny@gmail.com'),
(9, '-', '-', '', '-'),
(11, 'rohan', '9820098200', '1234567890', 'r@ghj.dfg'),
(12, 'jaynam sanghvi', '9820820002', '123456789', 'jaynam@gmail.com'),
(15, 'nikhil', '8584871993', '', 'nnagdev58@gmail.com'),
(16, 'kapil sharma', '9767663690', '', 'kapilsharmag99@gmail.com'),
(17, 'Rama Sharma', '987654345', '', 'rama303@gmail.com'),
(18, 'Sunita Vira', '9820921311', '', 'qwertyuiop@gmail.com'),
(19, 'pratik sitlani', '8433826699', '', 'psitlani99@gmail.com'),
(20, 'om rao', '8655403749', '', 'sasuke7221@gmail.com'),
(21, 'Kirna Vira', '9167843034', '0987654321', 'kirnavira@gmail.com'),
(22, 'Tanmay Shelatkar', '9167832109', '36485121', 'tanmayshelatkar@gmail.com'),
(23, 'Sahil ', '9819531186', '125487892', 'sahil.pradhan51@gmail.com'),
(24, 'abc', '987652', '', 'abc@gmail.vom'),
(25, 'sanjay makhija', '87654321', '', 'sanjay@ggmmaail.com'),
(26, 'shubham mangade', '9820481621', '', 'shubhammangade1599@gmail.com'),
(27, 'abc', '987456321', '', 'ABC@GMAIL.COM'),
(28, 'abcde', '39595243', '', 'abcd@mail.com'),
(29, 'nisarg shah', '9869710245', '', 'nisarg@gmail.com'),
(30, 'simran', '12487', '', 'simrangaani@gmail.com'),
(31, 'johnny rao ', ' 9224245435', '', 'palakdavd2@3gmail.com'),
(32, 'shraddha narkhede', '982081621', '', 'shraddhanarkhede288@gmail.com'),
(33, 'aman thakur', '9768187027', '', 'amanthakur2408@gmail.com'),
(34, 'vrushali shah', '8888444422', '', 'vrushalishah99@gmail.com'),
(35, 'abce', '55555', '896245', 'abce@gmail.com'),
(36, 'ayn', '85200', '12345', 'ayv@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `custtosell`
--

CREATE TABLE `custtosell` (
  `billid` int(11) NOT NULL,
  `customerid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `custtosell`
--

INSERT INTO `custtosell` (`billid`, `customerid`) VALUES
(1, 9),
(2, 11),
(3, 1),
(4, 11),
(5, 1),
(6, 11),
(7, 1),
(8, 1),
(9, 22),
(10, 1),
(11, 11),
(12, 11),
(13, 22),
(14, 11),
(15, 19),
(16, 29),
(17, 1),
(18, 11),
(19, 1),
(20, 19),
(21, 11),
(22, 22),
(23, 19),
(24, 19),
(25, 19),
(26, 19),
(27, 19),
(28, 1),
(29, 9),
(30, 1),
(31, 19),
(32, 34),
(33, 19),
(34, 19),
(35, 11),
(36, 11),
(37, 9),
(38, 19),
(39, 1),
(40, 9),
(41, 35),
(42, 19),
(43, 36),
(44, 36),
(45, 36),
(46, 36),
(47, 9),
(48, 36),
(49, 9);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productid` int(11) NOT NULL,
  `productname` varchar(255) NOT NULL,
  `mass` varchar(255) NOT NULL,
  `cost` float NOT NULL,
  `cgst` float NOT NULL,
  `sgst` float NOT NULL,
  `igst` float NOT NULL,
  `mrp` float NOT NULL,
  `stock` int(11) NOT NULL,
  `categoryid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productid`, `productname`, `mass`, `cost`, `cgst`, `sgst`, `igst`, `mrp`, `stock`, `categoryid`) VALUES
(1, 'mango', '750 ml', 108, 5, 5, 0, 118.8, 131, 1),
(2, 'apple(fruit)', '1kg', 100, 5, 2, 2.5, 109.5, 17, 2),
(3, 'pineapple', '1l', 1000, 3, 3, 0, 1060, 16, 1),
(5, 'Custerapple(fruit)', '1kg', 35, 5, 5, 0, 38.5, 29, 2),
(7, 'Sprite', '600ml', 30, 5, 5, 0, 33, 6, 3),
(8, 'Miranda', '600ml', 30, 5, 0, 5, 33, 14, 3),
(9, 'Maza', '500ml', 32, 5, 5, 0, 35.2, 3, 3),
(10, 'Fanta', '500ml', 30, 5, 5, 0, 33, 23, 3),
(12, '7Up', '500ml', 30, 5, 5, 0, 33, 20, 3),
(13, 'Appy Fizz', '300ml', 20, 5, 5, 0, 22, 28, 3),
(15, 'PEPSI', '500ml', 30, 5, 5, 0, 33, 8, 3),
(16, 'CocaCola', '500ml', 30, 5, 5, 0, 33, 10, 3),
(17, 'MountainDew', '500ml', 30, 5, 5, 0, 33, 30, 3),
(18, 'Mangola', '500ml', 30, 5, 5, 0, 33, 20, 3),
(19, 'Mango(fruit)', '1kg', 30, 5, 5, 0, 33, 30, 2),
(20, 'Banana(fruit)', '1kg', 20, 5, 5, 0, 22, 20, 2),
(21, 'Banana (syrup)', '500ml', 80, 5, 5, 0, 88, 20, 1),
(22, 'Litchi(Fruit)', '1 KG', 50, 5, 5, 0, 55, 7, 2),
(23, 'Strawberry (fruit)', '1kg', 50, 5, 5, 0, 55, 20, 2),
(24, 'Pomegranate(fruit)', '1kg', 40, 5, 5, 0, 44, 29, 2),
(25, 'watermelon(fruit)', '1kg', 18, 5, 5, 0, 19.8, 39, 2),
(26, 'Pineapple(fruit)', '1kg', 15, 5, 5, 0, 16.5, 20, 2),
(27, 'Orange (fruit)', '1kg', 30, 5, 5, 0, 33, 20, 2),
(28, 'Kiwi(fruit)', '1kg', 20, 5, 5, 0, 22, 18, 2),
(29, 'Guava(fruit)', '1kg', 50, 5, 5, 0, 55, 26, 2),
(30, 'Cherry(fruit)', '1kg', 35, 5, 5, 0, 38.5, 20, 2),
(31, 'Grape(fruit)', '1kg', 20, 5, 5, 0, 22, 23, 2),
(32, 'Peach(fruit)', '1kg', 25, 5, 5, 0, 27.5, 50, 2),
(33, 'Blueberry(fruit)', '1kg', 60, 5, 5, 0, 66, 19, 2),
(34, 'Muskmelon(fruit)', '1kg', 30, 5, 5, 0, 33, 30, 2),
(35, 'Jackfruit(fruit)', '1kg', 55, 5, 5, 0, 60.5, 25, 2),
(36, 'Custerapple(fruit)', '1kg', 35, 5, 5, 0, 38.5, 30, 2),
(37, 'Chicoo (fruit)', '1kg', 20, 5, 5, 0, 22, 30, 2),
(38, 'Fig(fruit)', '1kg', 66, 5, 5, 0, 72.6, 29, 2),
(39, 'Almonds', '250gm', 98, 5, 5, 0, 107.8, 47, 4),
(40, 'Pista', '250gm', 400, 5, 5, 0, 440, 25, 4),
(41, 'Cashewnut(salted)', '250gm', 140, 5, 5, 0, 154, 40, 4),
(42, 'Cashewnut(plain)', '250gm', 110, 5, 5, 0, 121, 39, 4),
(43, 'Cashewnut(roasted)', '250gm', 163, 5, 5, 0, 179.3, 30, 4),
(44, 'Rasin', '250gm', 85, 5, 5, 0, 93.5, 30, 4),
(45, 'Walnut', '250gm', 250, 5, 5, 0, 275, 24, 4),
(46, 'Anjeer', '250gm', 170, 5, 5, 0, 187, 39, 4),
(47, 'Rasin(black)', '250gm', 60, 5, 5, 0, 66, 35, 4),
(48, 'Apple(syrup)', '500ml', 80, 5, 5, 0, 88, 20, 1),
(49, 'Mango (syrup)', '500ml', 70, 5, 5, 0, 77, 40, 1),
(50, 'Pineapple(syrup)', '500ml', 60, 5, 5, 0, 66, 39, 1),
(51, 'Kokum(syrup)', '500ml', 80, 5, 5, 0, 88, 40, 1),
(52, 'Blueberry(syrup)', '500ml', 85, 5, 5, 0, 93.5, 41, 1),
(53, 'Whiteberry(syrup)', '500ml', 83, 5, 5, 0, 91.3, 43, 1),
(54, 'Redberry(syrup)', '500ml', 70, 5, 5, 0, 77, 21, 1),
(55, 'Rassberry(syrup)', '500ml', 71, 5, 5, 0, 78.1, 43, 1),
(56, 'Blackcurrent(syrup)', '500ml', 73, 5, 5, 0, 80.3, 50, 1),
(57, 'Choclate(syrup)', '500ml', 30, 5, 5, 0, 33, 41, 1),
(58, 'Darkchoclate(syrup)', '500ml', 35, 5, 5, 0, 38.5, 35, 1),
(59, 'RawMango(syrup)', '500ml', 90, 5, 5, 0, 99, 40, 1),
(60, 'Vanilla(syrup)', '500ml', 66, 5, 5, 0, 72.6, 32, 1),
(61, 'Butterscotch(syrup)', '500ml', 50, 5, 5, 0, 55, 40, 1),
(62, 'chocobar', '1pkt', 8, 5, 5, 0, 8.8, 30, 5),
(63, 'Saffron', '300gm', 60, 5, 5, 0, 66, 26, 5),
(64, 'Raspberry', '300gm', 60, 5, 5, 0, 66, 40, 5),
(65, 'Vanilla', '300gm', 80, 5, 5, 0, 88, 29, 5),
(66, 'Pan', '300gm', 60, 5, 5, 0, 66, 40, 5),
(67, 'Americanbites', '300gm', 65, 5, 5, 0, 71.5, 45, 5),
(68, 'Strawberry', '300gm', 65, 5, 5, 0, 71.5, 41, 5),
(69, 'Oreo', '300gm', 75, 5, 5, 0, 82.5, 31, 5),
(70, 'Cornatto', '1pkt', 25, 5, 5, 0, 27.5, 31, 5),
(71, 'Mojito(syrup)', '500ml', 65, 5, 5, 0, 71.5, 30, 1),
(72, 'Pudina(syrup)', '500ml', 73, 5, 5, 0, 80.3, 50, 1),
(73, 'Herbalmix(syrup)', '500ml', 110, 5, 5, 0, 121, 24, 1),
(74, 'Candy(syrup)', '500ml', 54, 5, 5, 0, 59.4, 40, 1),
(75, 'Pomegranate(syrup)', '500ml', 60, 5, 5, 0, 66, 12, 1),
(76, 'Rose(syrup)', '500ml', 80, 5, 5, 0, 88, 32, 1),
(77, 'Lemonade(syrup)', '500ml', 82, 5, 5, 0, 90.2, 49, 1),
(78, 'Freshlime(syrup)', '500ml', 73, 5, 5, 0, 80.3, 30, 1),
(79, 'Rasna', '200ml', 15, 5, 5, 0, 16.5, 15, 3),
(80, 'Nibooz', '600ml', 32, 5, 5, 0, 35.2, 22, 3),
(81, 'Monster', '500ml', 80, 5, 5, 0, 88, 15, 3),
(82, 'Zing', '200ml', 30, 5, 5, 0, 33, 12, 3),
(83, 'Choclate nuts', '500gm', 60, 5, 5, 0, 66, 40, 5),
(84, 'Cookiecream', '500gm', 60, 5, 5, 0, 66, 41, 5),
(85, 'Cookienuts', '500gm', 65, 5, 5, 0, 71.5, 45, 5),
(86, 'ChilliGuava', '500gm', 61, 5, 5, 0, 67.1, 20, 5),
(87, 'Custerapple', '300gm', 50, 5, 5, 0, 55, 30, 5),
(88, 'Choclatewalnut', '500gm', 62, 5, 5, 0, 68.2, 41, 5),
(89, 'Cashewnut', '500gm', 55, 5, 5, 0, 60.5, 30, 5),
(90, 'Rasin', '400gm', 60, 5, 5, 0, 66, 35, 5),
(91, 'Avocado ', '1kg', 60, 5, 5, 0, 66, 50, 2),
(92, 'Mulberry ', '1kg', 50, 2, 5, 3, 55, 50, 2),
(93, 'Coconut(syrup)', '600ml', 100, 5, 5, 0, 110, 12, 1),
(94, 'Gulucose(syrup)', '600ml', 75, 5, 5, 0, 82.5, 19, 1),
(95, 'Corn(syrup)', '600ml', 90, 5, 5, 0, 99, 12, 1),
(96, 'Dry Coconut(syrup)', '600ml', 100, 5, 5, 0, 110, 10, 1),
(97, 'Hazelnut(syrup)', '500ml', 50, 5, 5, 0, 55, 14, 1),
(98, 'Avocodo(syrup)', '600ml', 80, 5, 5, 0, 88, 25, 1),
(99, 'Beetroot(syrup)', '600ml', 90, 5, 5, 0, 99, 19, 1),
(100, 'Butternut Squash(syrup)', '600ml', 87, 5, 5, 0, 95.7, 20, 1),
(101, 'Carrot(syrup)', '600ml', 80, 5, 5, 0, 88, 25, 1),
(102, 'Date(syrup)', '500ml', 60, 5, 5, 0, 66, 11, 1),
(103, 'Pineapple (syrup)', '600ml', 60, 5, 5, 0, 66, 14, 1),
(104, 'Melon(syrup)', '600ml', 65, 5, 5, 0, 71.5, 22, 1),
(105, 'Pineapple (syrup)', '600ml', 60, 5, 5, 0, 66, 15, 1),
(106, 'Tomato(syrup)', '500ml', 50, 3, 3, 0, 53, 9, 1),
(107, 'Rose simple (syrup)', '600ml', 60, 5, 5, 0, 66, 15, 1),
(108, 'Fresh mint (syrup)', '600ml', 70, 5, 5, 0, 77, 20, 1),
(109, 'Amul milk', '500ml', 15, 5, 5, 0, 16.5, 50, 6),
(110, 'Gokul milk', '500ml', 14, 5, 5, 0, 15.4, 49, 6),
(111, 'Mahanand milk', '500ml', 13, 5, 5, 0, 14.3, 20, 6),
(112, 'Amul butter', '250gm', 30, 5, 5, 0, 33, 49, 6),
(113, 'Mahanand butter', '250gm', 28, 5, 5, 0, 30.8, 30, 6),
(114, 'Gokul butter', '250gm', 31, 5, 5, 0, 34.1, 20, 6),
(115, 'Amul cheese', '1kg', 250, 5, 5, 0, 275, 30, 6),
(116, 'Mahanand cheese', '1kg', 220, 5, 5, 0, 242, 35, 6),
(117, 'Gokul cheese', '1kg', 200, 5, 5, 0, 220, 20, 6),
(118, 'Go cheese', '1kg', 150, 5, 5, 0, 165, 25, 6),
(119, 'Gokul cottage cheese', '1kg', 220, 5, 5, 0, 242, 20, 6),
(120, 'Mahanand cottage cheese', '1kg', 240, 5, 5, 0, 264, 35, 6),
(121, 'Amul cottage cheese', '1kg', 270, 5, 5, 0, 297, 30, 6),
(122, 'Go cottage cheese', '1kg', 170, 5, 5, 0, 187, 27, 6),
(123, 'Amul cream cheese', '1kg', 275, 5, 5, 0, 302.5, 30, 6),
(124, 'Mahanand cream cheese', '1kg', 245, 5, 5, 0, 269.5, 35, 6),
(125, 'Gokul cream cheese', '1kg', 245, 5, 5, 0, 269.5, 22, 6),
(126, 'Amul milkmaid', '300gm', 60, 5, 5, 0, 66, 20, 6),
(127, 'Mahanand milkmaid', '300gm', 40, 5, 5, 0, 44, 20, 6),
(128, 'Amul Lassi', '250ml', 15, 5, 5, 0, 16.5, 20, 6),
(129, 'Gokul Lassi', '250ml', 16, 5, 5, 0, 17.6, 20, 6),
(130, 'Go Lassi', '250ml', 15, 5, 5, 0, 16.5, 20, 6),
(131, 'Amul shrikhand', '500gm', 28, 5, 5, 0, 30.8, 15, 6),
(132, 'Chitale shrikhand', '500gm', 30, 5, 5, 0, 33, 15, 6),
(133, 'Gokul shrikhand', '500gm', 35, 5, 5, 0, 38.5, 18, 6),
(134, 'Paneer', '1kg', 120, 5, 5, 0, 132, 40, 6),
(135, 'Thumbs Up', '600ml', 30, 5, 5, 0, 33, 0, 3),
(136, 'Lonavali', '500ml', 100, 5, 5, 0, 110, 15, 5),
(138, 'Tender Coconut', '250gm', 45, 2.5, 2.5, 0, 47.25, 14, 5),
(139, 'dragon fruit', '1kg', 100, 5, 5, 0, 110, 17, 2),
(140, 'coconut', '250gm', 234, 5, 5, 0, 257.4, 49, 5),
(141, 'milk powder d', '250gm', 100, 9, 9, 0, 118, 20, 6),
(142, 'nuts', '200gms', 70, 10, 10, 0, 84, 20, 4);

-- --------------------------------------------------------

--
-- Table structure for table `sell`
--

CREATE TABLE `sell` (
  `billid` int(11) NOT NULL,
  `sellid` int(11) NOT NULL,
  `productid` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sell`
--

INSERT INTO `sell` (`billid`, `sellid`, `productid`, `quantity`) VALUES
(1, 1, 15, 1),
(2, 2, 7, 1),
(3, 3, 63, 1),
(4, 4, 15, 1),
(5, 5, 15, 2),
(6, 6, 63, 1),
(7, 7, 1, 2),
(8, 8, 15, 1),
(9, 9, 99, 1),
(10, 10, 139, 3),
(10, 11, 63, 1),
(11, 12, 15, 3),
(13, 13, 15, 1),
(14, 14, 15, 1),
(14, 15, 3, 1),
(15, 16, 106, 1),
(15, 17, 2, 3),
(16, 18, 7, 1),
(16, 19, 63, 1),
(17, 20, 7, 1),
(18, 21, 10, 2),
(19, 22, 63, 3),
(20, 23, 63, 2),
(21, 24, 3, 1),
(22, 25, 22, 2),
(23, 26, 24, 1),
(24, 27, 28, 1),
(25, 28, 8, 2),
(26, 29, 16, 3),
(28, 30, 140, 1),
(29, 31, 63, 1),
(30, 32, 63, 1),
(31, 33, 45, 6),
(32, 34, 60, 2),
(32, 35, 135, 1),
(33, 36, 39, 1),
(35, 37, 1, 6),
(37, 38, 63, 1),
(38, 39, 9, 3),
(39, 40, 15, 2),
(39, 41, 9, 1),
(40, 42, 7, 1),
(40, 43, 15, 1),
(41, 44, 63, 1),
(42, 45, 42, 1),
(43, 46, 15, 2),
(43, 47, 63, 1),
(44, 48, 8, 2),
(47, 49, 63, 2),
(48, 50, 63, 1),
(49, 51, 16, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userid` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `isEmployee` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userid`, `username`, `password`, `isEmployee`) VALUES
(1, 'admin', 'admin123', 0),
(2, 'employee', 'employee123', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`billid`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryid`);

--
-- Indexes for table `cheque_info`
--
ALTER TABLE `cheque_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productid`);

--
-- Indexes for table `sell`
--
ALTER TABLE `sell`
  ADD PRIMARY KEY (`sellid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `billid` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `categoryid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `cheque_info`
--
ALTER TABLE `cheque_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customerid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `productid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=143;

--
-- AUTO_INCREMENT for table `sell`
--
ALTER TABLE `sell`
  MODIFY `sellid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
