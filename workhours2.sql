-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 01. Nov 2021 um 14:28
-- Server-Version: 10.4.19-MariaDB
-- PHP-Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `workhours2`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `entry`
--

CREATE TABLE `entry` (
  `id_entry` int(11) NOT NULL,
  `hours` double NOT NULL,
  `date` date NOT NULL,
  `id_project` int(11) NOT NULL,
  `id_worksheet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `entry`
--

INSERT INTO `entry` (`id_entry`, `hours`, `date`, `id_project`, `id_worksheet`) VALUES
(1, 5, '2021-09-13', 1, 1),
(4, 1, '2021-10-14', 4, 1),
(5, 1, '2021-10-14', 4, 1),
(6, 12, '2021-10-15', 4, 1),
(7, 12, '2021-10-14', 7, 1),
(8, 12, '2021-10-14', 1, 1),
(9, 12, '2021-10-14', 1, 1),
(10, 12, '2021-10-01', 1, 1),
(11, 9, '2021-10-22', 1, 2),
(12, 12, '2021-10-22', 4, 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `project`
--

CREATE TABLE `project` (
  `id_project` int(11) NOT NULL,
  `name` text NOT NULL,
  `worktime` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `project`
--

INSERT INTO `project` (`id_project`, `name`, `worktime`) VALUES
(1, 'testprojectss', 1),
(4, 'adasd', 0),
(7, 'asasdas', 1),
(9, 'sdfsdfs', 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `firstname` text NOT NULL,
  `lastname` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`id_user`, `firstname`, `lastname`) VALUES
(1, 'dimitri', 'derungs'),
(5, 'hallu', 'hullu'),
(7, 'wsw', 'wdw');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `worksheet`
--

CREATE TABLE `worksheet` (
  `id_worksheet` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `worksheet`
--

INSERT INTO `worksheet` (`id_worksheet`, `id_user`) VALUES
(1, 1),
(6, 1),
(2, 5);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `entry`
--
ALTER TABLE `entry`
  ADD PRIMARY KEY (`id_entry`),
  ADD KEY `id_project` (`id_project`),
  ADD KEY `id_worksheet` (`id_worksheet`);

--
-- Indizes für die Tabelle `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id_project`);

--
-- Indizes für die Tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indizes für die Tabelle `worksheet`
--
ALTER TABLE `worksheet`
  ADD PRIMARY KEY (`id_worksheet`),
  ADD KEY `id_user` (`id_user`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `entry`
--
ALTER TABLE `entry`
  MODIFY `id_entry` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT für Tabelle `project`
--
ALTER TABLE `project`
  MODIFY `id_project` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT für Tabelle `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT für Tabelle `worksheet`
--
ALTER TABLE `worksheet`
  MODIFY `id_worksheet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `entry`
--
ALTER TABLE `entry`
  ADD CONSTRAINT `entry_ibfk_1` FOREIGN KEY (`id_project`) REFERENCES `project` (`id_project`),
  ADD CONSTRAINT `entry_ibfk_2` FOREIGN KEY (`id_worksheet`) REFERENCES `worksheet` (`id_worksheet`);

--
-- Constraints der Tabelle `worksheet`
--
ALTER TABLE `worksheet`
  ADD CONSTRAINT `worksheet_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
