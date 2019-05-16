-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: mai 16, 2019 la 08:20 AM
-- Versiune server: 10.1.36-MariaDB
-- Versiune PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Bază de date: `banca`
--

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `clienti`
--

CREATE TABLE `clienti` (
  `id` int(11) NOT NULL,
  `numar_cont` int(11) NOT NULL,
  `nume` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adresa` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tip_cont` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sex` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `data_nasterii` date NOT NULL,
  `parola` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `data_crearii` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Eliminarea datelor din tabel `clienti`
--

INSERT INTO `clienti` (`id`, `numar_cont`, `nume`, `adresa`, `tip_cont`, `sex`, `data_nasterii`, `parola`, `data_crearii`) VALUES
(2, 1013, 'Radu Adrian', 'Timisoara', 'Client', 'Masculin', '1974-06-18', '1234', '2019-05-11 16:07:18');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `depuneri`
--

CREATE TABLE `depuneri` (
  `id` int(11) NOT NULL,
  `numar_cont` int(15) NOT NULL,
  `suma_depunere` double NOT NULL,
  `data_crearii` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Eliminarea datelor din tabel `depuneri`
--

INSERT INTO `depuneri` (`id`, `numar_cont`, `suma_depunere`, `data_crearii`) VALUES
(1, 1013, 70000, '2019-05-12 19:57:27'),
(2, 1013, 40000, '2019-05-12 19:58:49'),
(3, 1013, 5000, '2019-05-12 20:43:48'),
(4, 1013, 3000, '2019-05-12 20:46:21');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `retrageri`
--

CREATE TABLE `retrageri` (
  `id` int(11) NOT NULL,
  `numar_cont` int(11) NOT NULL,
  `suma_retragere` double NOT NULL,
  `data_crearii` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Eliminarea datelor din tabel `retrageri`
--

INSERT INTO `retrageri` (`id`, `numar_cont`, `suma_retragere`, `data_crearii`) VALUES
(1, 1013, 1400, '2019-05-13 08:48:42'),
(2, 1013, 2400, '2019-05-13 08:53:06'),
(3, 1013, 113200, '2019-05-13 09:29:02');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `utilizatori`
--

CREATE TABLE `utilizatori` (
  `id` int(11) NOT NULL,
  `nume` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `numar_cont` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `parola` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `functie` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Eliminarea datelor din tabel `utilizatori`
--

INSERT INTO `utilizatori` (`id`, `nume`, `numar_cont`, `parola`, `functie`, `status`) VALUES
(41, 'Radu Adrian', '1013', '1234', 'Client', 'online'),
(42, 'admin', '0000', 'root', 'Administrator', 'online');

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `clienti`
--
ALTER TABLE `clienti`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `depuneri`
--
ALTER TABLE `depuneri`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `retrageri`
--
ALTER TABLE `retrageri`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `utilizatori`
--
ALTER TABLE `utilizatori`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pentru tabele eliminate
--

--
-- AUTO_INCREMENT pentru tabele `clienti`
--
ALTER TABLE `clienti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pentru tabele `depuneri`
--
ALTER TABLE `depuneri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pentru tabele `retrageri`
--
ALTER TABLE `retrageri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pentru tabele `utilizatori`
--
ALTER TABLE `utilizatori`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
