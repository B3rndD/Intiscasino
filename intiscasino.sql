-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 12. Mai 2023 um 11:58
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

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `kunde`
--

CREATE TABLE `kunde` (
  `Kunden_ID` int(11) NOT NULL,
  `Casinokontonummer` int(11) DEFAULT NULL,
  `Kontostand` double DEFAULT NULL,
  `Vorname` varchar(32) DEFAULT NULL,
  `Dachname` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `spiel`
--

CREATE TABLE `spiel` (
  `Gluecksspiel_ID` int(11) NOT NULL,
  `Gluecksspieltyp` int(11) DEFAULT NULL,
  `Tischnummer` int(11) DEFAULT NULL,
  `Mitarbeiter_ID` int(11) DEFAULT NULL,
  `SpielAktivitaetsID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `spielakivitaet`
--

CREATE TABLE `spielakivitaet` (
  `SpielAktivaetsID` int(11) NOT NULL,
  `Geiwnn` double DEFAULT NULL,
  `Verlusst` double DEFAULT NULL,
  `Kunden_ID` int(11) DEFAULT NULL,
  `Gluecksspiel_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `spieltisch`
--

CREATE TABLE `spieltisch` (
  `Tischnummer` int(11) NOT NULL,
  `Spieltyp` varchar(32) NOT NULL,
  `Kapazität` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  ADD PRIMARY KEY (`Gluecksspiel_ID`);

--
-- Indizes für die Tabelle `spielakivitaet`
--
ALTER TABLE `spielakivitaet`
  ADD PRIMARY KEY (`SpielAktivaetsID`);

--
-- Indizes für die Tabelle `spieltisch`
--
ALTER TABLE `spieltisch`
  ADD PRIMARY KEY (`Tischnummer`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `gluecksspiel`
--
ALTER TABLE `gluecksspiel`
  MODIFY `Glueckspieltyp_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `kunde`
--
ALTER TABLE `kunde`
  MODIFY `Kunden_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `mitarbeiter`
--
ALTER TABLE `mitarbeiter`
  MODIFY `Mitarbeiter_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `spiel`
--
ALTER TABLE `spiel`
  MODIFY `Gluecksspiel_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `spielakivitaet`
--
ALTER TABLE `spielakivitaet`
  MODIFY `SpielAktivaetsID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `spieltisch`
--
ALTER TABLE `spieltisch`
  MODIFY `Tischnummer` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
