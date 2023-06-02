-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 02. Jun 2023 um 11:18
-- Server-Version: 10.4.27-MariaDB
-- PHP-Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `intiscasino`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `gluecksspiel`
--

CREATE TABLE `gluecksspiel` (
  `Glueckspieltyp_ID` int(11) NOT NULL,
  `Spielname` varchar(32) NOT NULL,
  `Spieltyp` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `gluecksspiel`
--

INSERT INTO `gluecksspiel` (`Glueckspieltyp_ID`, `Spielname`, `Spieltyp`) VALUES
(1, 'Blackjack', 'Kartenspiel'),
(2, 'Roulette', 'Tischspiel'),
(3, 'Texas Holdem', 'Kartenspiel'),
(4, 'three card Poker', 'Kartenspiel'),
(5, 'Craps', 'Würfelspiel'),
(6, 'Baccarat', 'Kartenspiel');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `kunde`
--

CREATE TABLE `kunde` (
  `Kunden_ID` int(11) NOT NULL,
  `Kontostand` double DEFAULT NULL,
  `Vorname` varchar(32) DEFAULT NULL,
  `Nachname` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `kunde`
--

INSERT INTO `kunde` (`Kunden_ID`, `Kontostand`, `Vorname`, `Nachname`) VALUES
(1, 352481.32, 'Benjamin', 'Lewis'),
(2, 759348.76, 'Charlotte', 'Charlotte'),
(3, 210495.62, 'Henry', 'Mitchell'),
(4, 893271.89, 'Emily', 'Thompson'),
(5, 167824.95, 'Samuel', 'Wright'),
(6, 408267.53, 'Grace', 'Carter'),
(7, 625376.89, 'Alexander', 'Phillips'),
(8, 349126.75, 'Olivia', 'Green'),
(9, 729157.42, 'Daniel', 'Walker'),
(10, 512493.1, 'Harper', 'Cooper');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `mitarbeiter`
--

CREATE TABLE `mitarbeiter` (
  `Mitarbeiter_ID` int(11) NOT NULL,
  `Vorname` varchar(32) NOT NULL,
  `Nachname` varchar(64) DEFAULT NULL,
  `Gehalt` double DEFAULT NULL,
  `Addresse` varchar(64) DEFAULT NULL,
  `HausNR` varchar(16) DEFAULT NULL,
  `PLZ` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `mitarbeiter`
--

INSERT INTO `mitarbeiter` (`Mitarbeiter_ID`, `Vorname`, `Nachname`, `Gehalt`, `Addresse`, `HausNR`, `PLZ`) VALUES
(1, 'Maximus', 'Steel', 2960, 'Goethestraße', '12a', '5678'),
(2, 'Aurora', 'Frost', 3152.53, 'Mozartplatz', '155', '4284'),
(3, 'Ethan', 'Drake', 2800, 'Schillerweg', '375', '9755'),
(4, 'Seraphina', 'Rivers', 2976, 'Bachgasse', '78b', '2684'),
(5, 'Xavier', 'Blackwood', 3050.2, 'Gutenbergallee', '11', '2064'),
(6, 'Olivia', 'Knight', 4250, 'Humboldtstraße', '95', '3060'),
(7, 'Asher', 'Monroe', 3000, 'Einsteinring', '17a', '6204'),
(8, 'Penelope', 'Hart', 2865, 'Beethovenweg', '25a', '4722'),
(9, 'Jasper', 'Brooks', 2960, 'Mendelssohnplatz', '3', '9720'),
(10, 'Willow', 'Fox', 3065, 'Schopenhauerstraße', '154c', '2462');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `spiel`
--

CREATE TABLE `spiel` (
  `Gluecksspiel_ID` int(11) NOT NULL,
  `Tischnummer` int(11) DEFAULT NULL,
  `Mitarbeiter_ID` int(11) DEFAULT NULL,
  `Gluecksspieltyp_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `spiel`
--

INSERT INTO `spiel` (`Gluecksspiel_ID`, `Tischnummer`, `Mitarbeiter_ID`, `Gluecksspieltyp_ID`) VALUES
(1, 1, 1, 1),
(2, 2, 2, 1),
(3, 3, 3, 1),
(4, 4, 4, 2),
(5, 5, 5, 3),
(6, 6, 6, 3),
(7, 7, 7, 4),
(8, 8, 8, 5),
(9, 9, 9, 5),
(10, 10, 10, 6);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `spielaktivitaet`
--

CREATE TABLE `spielaktivitaet` (
  `SpielAktivaets_ID` int(11) NOT NULL,
  `Gewinn` double DEFAULT NULL,
  `Verlust` double DEFAULT NULL,
  `Kunden_ID` int(11) DEFAULT NULL,
  `Spiel_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `spielaktivitaet`
--

INSERT INTO `spielaktivitaet` (`SpielAktivaets_ID`, `Gewinn`, `Verlust`, `Kunden_ID`, `Spiel_ID`) VALUES
(1, 5, 0, 1, 1),
(2, 50, 0, 2, 1),
(3, 0, 10, 2, 3),
(4, 15, 0, 4, 2),
(5, 0, 30, 6, 3),
(6, 20, 0, 4, 1),
(7, 0, 5, 7, 2),
(8, 0, 5, 1, 2),
(9, 5, 0, 2, 1),
(10, 0, 20, 1, 3);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `spieltisch`
--

CREATE TABLE `spieltisch` (
  `Tischnummer` int(11) NOT NULL,
  `Spieltyp` int(11) NOT NULL,
  `Kapazitaet` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `spieltisch`
--

INSERT INTO `spieltisch` (`Tischnummer`, `Spieltyp`, `Kapazitaet`) VALUES
(1, 1, 4),
(2, 1, 4),
(3, 1, 4),
(4, 2, 6),
(5, 3, 8),
(6, 3, 8),
(7, 4, 3),
(8, 5, 6),
(9, 5, 6),
(10, 6, 4);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `gluecksspiel`
--
ALTER TABLE `gluecksspiel`
  ADD PRIMARY KEY (`Glueckspieltyp_ID`);

--
-- Indizes für die Tabelle `kunde`
--
ALTER TABLE `kunde`
  ADD PRIMARY KEY (`Kunden_ID`);

--
-- Indizes für die Tabelle `mitarbeiter`
--
ALTER TABLE `mitarbeiter`
  ADD PRIMARY KEY (`Mitarbeiter_ID`);

--
-- Indizes für die Tabelle `spiel`
--
ALTER TABLE `spiel`
  ADD PRIMARY KEY (`Gluecksspiel_ID`),
  ADD KEY `Tischnummer` (`Tischnummer`),
  ADD KEY `Mitarbeiter_ID` (`Mitarbeiter_ID`),
  ADD KEY `Gluecksspieltyp_ID` (`Gluecksspieltyp_ID`);

--
-- Indizes für die Tabelle `spielaktivitaet`
--
ALTER TABLE `spielaktivitaet`
  ADD PRIMARY KEY (`SpielAktivaets_ID`),
  ADD KEY `Kunden_ID` (`Kunden_ID`),
  ADD KEY `Gluecksspiel_ID` (`Spiel_ID`);

--
-- Indizes für die Tabelle `spieltisch`
--
ALTER TABLE `spieltisch`
  ADD PRIMARY KEY (`Tischnummer`),
  ADD KEY `Spieltyp` (`Spieltyp`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `gluecksspiel`
--
ALTER TABLE `gluecksspiel`
  MODIFY `Glueckspieltyp_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT für Tabelle `kunde`
--
ALTER TABLE `kunde`
  MODIFY `Kunden_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT für Tabelle `mitarbeiter`
--
ALTER TABLE `mitarbeiter`
  MODIFY `Mitarbeiter_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT für Tabelle `spiel`
--
ALTER TABLE `spiel`
  MODIFY `Gluecksspiel_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT für Tabelle `spielaktivitaet`
--
ALTER TABLE `spielaktivitaet`
  MODIFY `SpielAktivaets_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT für Tabelle `spieltisch`
--
ALTER TABLE `spieltisch`
  MODIFY `Tischnummer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `spiel`
--
ALTER TABLE `spiel`
  ADD CONSTRAINT `spiel_ibfk_2` FOREIGN KEY (`Tischnummer`) REFERENCES `spieltisch` (`Tischnummer`),
  ADD CONSTRAINT `spiel_ibfk_3` FOREIGN KEY (`Mitarbeiter_ID`) REFERENCES `mitarbeiter` (`Mitarbeiter_ID`),
  ADD CONSTRAINT `spiel_ibfk_4` FOREIGN KEY (`Gluecksspieltyp_ID`) REFERENCES `gluecksspiel` (`Glueckspieltyp_ID`);

--
-- Constraints der Tabelle `spielaktivitaet`
--
ALTER TABLE `spielaktivitaet`
  ADD CONSTRAINT `spielaktivitaet_ibfk_1` FOREIGN KEY (`Kunden_ID`) REFERENCES `kunde` (`Kunden_ID`),
  ADD CONSTRAINT `spielaktivitaet_ibfk_2` FOREIGN KEY (`Spiel_ID`) REFERENCES `spiel` (`Gluecksspiel_ID`);

--
-- Constraints der Tabelle `spieltisch`
--
ALTER TABLE `spieltisch`
  ADD CONSTRAINT `spieltisch_ibfk_1` FOREIGN KEY (`Spieltyp`) REFERENCES `gluecksspiel` (`Glueckspieltyp_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
