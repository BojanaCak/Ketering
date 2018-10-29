-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 02, 2018 at 10:10 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `keteringdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `idKorisnika` int(4) NOT NULL,
  `imePrezime` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `telefon` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`idKorisnika`, `imePrezime`, `email`, `telefon`, `username`, `password`) VALUES
(33, 'Marta Maricic', 'marta@gmail.com', '123343', 'admin', 'admin'),
(37, 'Bojana Cakmak', 'boja@yahoo.com', '333222', 'boja', 'boja'),
(36, 'Ivana Milic', 'iva@yahoo.com', '544544', 'glmen', 'glmen'),
(40, 'Mimi', 'mimi@gmail.com', '381115', 'mimi', 'mimi'),
(34, 'Zika Pantic', 'ziks@yahoo.com', '223322', 'sefkuh', 'sefkuh'),
(35, 'Mila Maric', 'mila@gmail.com', '381123', 'sefposl', 'sefposl');

-- --------------------------------------------------------

--
-- Table structure for table `narudzbenica`
--

CREATE TABLE `narudzbenica` (
  `idNarudzbenice` int(11) NOT NULL,
  `datumDostave` date NOT NULL,
  `adresaDostave` varchar(50) NOT NULL,
  `telefon` varchar(15) NOT NULL,
  `ukupnaCena` int(5) NOT NULL,
  `username` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `narudzbenica`
--

INSERT INTO `narudzbenica` (`idNarudzbenice`, `datumDostave`, `adresaDostave`, `telefon`, `ukupnaCena`, `username`) VALUES
(1, '2018-04-18', 'Zaplanjska 12', '555333', 2000, 'boja'),
(3, '2018-04-04', 'ggg', 'ddddd', 30, 'boja'),
(4, '2018-04-20', 'Milentija Popovica 23', '063999874', 30, 'boja'),
(5, '2018-04-26', 'Milana Rakica 22', '555333', 90, 'boja'),
(6, '2018-04-05', 'ff', '2233564', 30, 'boja'),
(7, '2018-04-18', 'd', 'dd', 90, 'boja');

-- --------------------------------------------------------

--
-- Table structure for table `proizvodi`
--

CREATE TABLE `proizvodi` (
  `IdProizvoda` int(4) NOT NULL,
  `imeProizvoda` varchar(30) NOT NULL,
  `cena` int(5) NOT NULL,
  `zalihe` int(5) NOT NULL,
  `kategorija` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proizvodi`
--

INSERT INTO `proizvodi` (`IdProizvoda`, `imeProizvoda`, `cena`, `zalihe`, `kategorija`) VALUES
(13, 'kiflice', 30, 96, 'Slano'),
(14, 'sendvici', 30, 60, 'Slano'),
(15, 'cokoladna torta', 2000, 20, 'Slatko');

-- --------------------------------------------------------

--
-- Table structure for table `reklamacije`
--

CREATE TABLE `reklamacije` (
  `idReklamacije` int(11) NOT NULL,
  `opis` varchar(300) NOT NULL,
  `telefon` varchar(15) NOT NULL,
  `idNarudzbenice` int(4) NOT NULL,
  `username` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reklamacije`
--

INSERT INTO `reklamacije` (`idReklamacije`, `opis`, `telefon`, `idNarudzbenice`, `username`) VALUES
(1, 'rrr', '77858', 1, 'boja'),
(5, 'sss', '77858', 1, 'boja'),
(6, 'sss', '77858', 1, 'boja'),
(7, 'sss', '77858', 1, 'boja'),
(10, 'vv', '77858', 1, 'boja'),
(14, 'test', '2011', 1, 'boja');

-- --------------------------------------------------------

--
-- Table structure for table `stavkanarudzbenice`
--

CREATE TABLE `stavkanarudzbenice` (
  `idStavkeNarudzbenice` int(11) NOT NULL,
  `kolicina` int(5) NOT NULL,
  `idProizvoda` int(5) NOT NULL,
  `idNarudzbenice` int(5) NOT NULL,
  `username` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `narudzbenica`
--
ALTER TABLE `narudzbenica`
  ADD PRIMARY KEY (`idNarudzbenice`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `proizvodi`
--
ALTER TABLE `proizvodi`
  ADD PRIMARY KEY (`IdProizvoda`),
  ADD KEY `IdKategorija` (`kategorija`);

--
-- Indexes for table `reklamacije`
--
ALTER TABLE `reklamacije`
  ADD PRIMARY KEY (`idReklamacije`),
  ADD KEY `idNarudzbenice` (`idNarudzbenice`,`username`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `stavkanarudzbenice`
--
ALTER TABLE `stavkanarudzbenice`
  ADD PRIMARY KEY (`idStavkeNarudzbenice`),
  ADD KEY `idProizvoda` (`idProizvoda`,`idNarudzbenice`),
  ADD KEY `idNarudzbenice` (`idNarudzbenice`),
  ADD KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `narudzbenica`
--
ALTER TABLE `narudzbenica`
  MODIFY `idNarudzbenice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `proizvodi`
--
ALTER TABLE `proizvodi`
  MODIFY `IdProizvoda` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `reklamacije`
--
ALTER TABLE `reklamacije`
  MODIFY `idReklamacije` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `stavkanarudzbenice`
--
ALTER TABLE `stavkanarudzbenice`
  MODIFY `idStavkeNarudzbenice` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `narudzbenica`
--
ALTER TABLE `narudzbenica`
  ADD CONSTRAINT `narudzbenica_ibfk_1` FOREIGN KEY (`username`) REFERENCES `korisnik` (`username`);

--
-- Constraints for table `reklamacije`
--
ALTER TABLE `reklamacije`
  ADD CONSTRAINT `reklamacije_ibfk_2` FOREIGN KEY (`idNarudzbenice`) REFERENCES `narudzbenica` (`idNarudzbenice`),
  ADD CONSTRAINT `reklamacije_ibfk_3` FOREIGN KEY (`username`) REFERENCES `korisnik` (`username`);

--
-- Constraints for table `stavkanarudzbenice`
--
ALTER TABLE `stavkanarudzbenice`
  ADD CONSTRAINT `stavkanarudzbenice_ibfk_1` FOREIGN KEY (`idNarudzbenice`) REFERENCES `narudzbenica` (`idNarudzbenice`),
  ADD CONSTRAINT `stavkanarudzbenice_ibfk_2` FOREIGN KEY (`idProizvoda`) REFERENCES `proizvodi` (`IdProizvoda`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
