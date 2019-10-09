-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 21 Juin 2019 à 12:07
-- Version du serveur :  5.7.14
-- Version de PHP :  7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pfe`
--

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `id` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `mdp` varchar(8) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `fournisseur`
--

INSERT INTO `fournisseur` (`id`, `nom`, `mail`, `mdp`) VALUES
(5, 'fournisseurx', 'fournisseurx@gmail.com', '12345678'),
(4, 'Societexxx', 'societexxx@gmail.com', '12345678');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `NOM` varchar(15) NOT NULL,
  `PRENOM` varchar(15) NOT NULL,
  `MAIL` varchar(50) NOT NULL,
  `MDP` varchar(8) NOT NULL,
  `Type_Sensor` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `NOM`, `PRENOM`, `MAIL`, `MDP`, `Type_Sensor`) VALUES
(7, 'Sagar', 'Samya', 'samya.sagar@gmail.com', '12345678', 'SmartSportSMS18'),
(6, 'Soussi', 'Maissa', 'maissa.soussi@gmail.com', '12345678', 'SmartSportSMS21'),
(11, 'haddad', 'souha', 'souha.haddad@gmail.com', '12345678', 'SmartSportSMS20'),
(8, 'gaied', 'hamdi', 'hamdi.gaied@gmail.com', '12345678', 'SmartSportSMS16'),
(9, 'gamoudi', 'fedi', 'fedi.gamoudi@gmail.com', '12345678', 'SmartSportSMS17'),
(10, 'boughamoura', 'ryhab', 'ryhab.boughamoura@gmail.com', '12345678', 'SmartSportSMS19'),
(14, 'sonia', 'kefi', 'sonia@gmail.com', '12345678', 'SmartSportSMS21');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
