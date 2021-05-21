-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 14 avr. 2021 à 21:50
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `hotel`
--

-- --------------------------------------------------------

--
-- Structure de la table `bloc`
--

CREATE TABLE `bloc` (
  `num_bloc` int(11) NOT NULL,
  `nbr_chambre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

CREATE TABLE `chambre` (
  `num_ch` int(11) NOT NULL,
  `type_ch` enum('p1','p2','p3','c') NOT NULL,
  `disponibilité` enum('l','o') NOT NULL,
  `prix` int(11) NOT NULL,
  `num_bloc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_cl` int(11) NOT NULL,
  `nom_cl` varchar(255) NOT NULL,
  `prenom_cl` varchar(255) NOT NULL,
  `date_n` date NOT NULL,
  `lieu_n` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tel` int(11) NOT NULL,
  `num_p` int(11) NOT NULL,
  `type_p` enum('p','c') NOT NULL,
  `nationalite` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `num_f` int(11) NOT NULL,
  `frais_l` int(11) NOT NULL,
  `frais_t` int(11) NOT NULL,
  `frais_r` int(11) NOT NULL,
  `id_cl` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `location_ch`
--

CREATE TABLE `location_ch` (
  `id_loc` int(11) NOT NULL,
  `id_cl` int(11) NOT NULL,
  `id_ch` int(11) NOT NULL,
  `date_d` date NOT NULL,
  `date_f` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `reservation_ch`
--

CREATE TABLE `reservation_ch` (
  `id_res` int(11) NOT NULL,
  `id_cl` int(11) NOT NULL,
  `num_ch` int(11) NOT NULL,
  `date_d` date NOT NULL,
  `date_f` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `reservation_salle`
--

CREATE TABLE `reservation_salle` (
  `id_ressalle` int(11) NOT NULL,
  `id_cl` int(11) NOT NULL,
  `num_s` int(11) NOT NULL,
  `date_d` int(11) NOT NULL,
  `date_f` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE `salle` (
  `num_s` int(11) NOT NULL,
  `type_s` enum('f','c') NOT NULL,
  `disponibilité` enum('l','o') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `bloc`
--
ALTER TABLE `bloc`
  ADD PRIMARY KEY (`num_bloc`);

--
-- Index pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD PRIMARY KEY (`num_ch`),
  ADD KEY `contrainte_bloc` (`num_bloc`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_cl`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`num_f`),
  ADD KEY `contrainte_cl3` (`id_cl`);

--
-- Index pour la table `location_ch`
--
ALTER TABLE `location_ch`
  ADD PRIMARY KEY (`id_loc`),
  ADD KEY `contrainte_cl2` (`id_cl`),
  ADD KEY `contrainte_ch2` (`id_ch`);

--
-- Index pour la table `reservation_ch`
--
ALTER TABLE `reservation_ch`
  ADD PRIMARY KEY (`id_res`),
  ADD KEY `contrainte_cl` (`id_cl`),
  ADD KEY `contrainte_ch` (`num_ch`);

--
-- Index pour la table `reservation_salle`
--
ALTER TABLE `reservation_salle`
  ADD PRIMARY KEY (`id_ressalle`);

--
-- Index pour la table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`num_s`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `bloc`
--
ALTER TABLE `bloc`
  MODIFY `num_bloc` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `chambre`
--
ALTER TABLE `chambre`
  MODIFY `num_ch` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_cl` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `facture`
--
ALTER TABLE `facture`
  MODIFY `num_f` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `location_ch`
--
ALTER TABLE `location_ch`
  MODIFY `id_loc` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `reservation_ch`
--
ALTER TABLE `reservation_ch`
  MODIFY `id_res` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `reservation_salle`
--
ALTER TABLE `reservation_salle`
  MODIFY `id_ressalle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `salle`
--
ALTER TABLE `salle`
  MODIFY `num_s` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD CONSTRAINT `contrainte_bloc` FOREIGN KEY (`num_bloc`) REFERENCES `bloc` (`num_bloc`);

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `contrainte_cl3` FOREIGN KEY (`id_cl`) REFERENCES `client` (`id_cl`);

--
-- Contraintes pour la table `location_ch`
--
ALTER TABLE `location_ch`
  ADD CONSTRAINT `contrainte_ch2` FOREIGN KEY (`id_ch`) REFERENCES `client` (`id_cl`),
  ADD CONSTRAINT `contrainte_cl2` FOREIGN KEY (`id_cl`) REFERENCES `client` (`id_cl`);

--
-- Contraintes pour la table `reservation_ch`
--
ALTER TABLE `reservation_ch`
  ADD CONSTRAINT `contrainte_ch` FOREIGN KEY (`num_ch`) REFERENCES `chambre` (`num_ch`),
  ADD CONSTRAINT `contrainte_cl` FOREIGN KEY (`id_cl`) REFERENCES `client` (`id_cl`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
