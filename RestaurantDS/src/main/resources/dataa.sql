INSERT INTO `client` (`id`, `courriel`, `date_naissance`, `nom`, `prenom`, `telephone`) VALUES(1, 'oussamazaghdoud1991@gmail.com', '2015-02-02', 'oussama', 'zaghdoud', '27652211');
INSERT INTO `client` (`id`, `courriel`, `date_naissance`, `nom`, `prenom`, `telephone`) VALUES(2, 'mehdi@gmail.com', '2010-01-01', 'Nasri', 'mehdi', '99999999');
INSERT INTO `client` (`id`, `courriel`, `date_naissance`, `nom`, `prenom`, `telephone`) VALUES(3, 'Ahmed@gmail.com', '2000-01-01', 'Ahmed', 'Karou', '22222222');
INSERT INTO `client` (`id`, `courriel`, `date_naissance`, `nom`, `prenom`, `telephone`) VALUES(4, 'Turki@gmail.com', '1999-01-01', 'Oumar', 'Turki', '77777777');
INSERT INTO `met` (`type`, `id`, `nom`, `prix`) VALUES('Plat', 1, 'Kosksi', 20);
INSERT INTO `met` (`type`, `id`, `nom`, `prix`) VALUES('Plat', 2, 'Kammounia', 17);
INSERT INTO `met` (`type`, `id`, `nom`, `prix`) VALUES('Plat', 3, 'Loubia', 15);
INSERT INTO `met` (`type`, `id`, `nom`, `prix`) VALUES('Entree', 4, 'slata mechwia', 7);
INSERT INTO `met` (`type`, `id`, `nom`, `prix`) VALUES('Entree', 5, 'Chorba', 8);
INSERT INTO `met` (`type`, `id`, `nom`, `prix`) VALUES('Dessert', 6, 'fruits', 6);
INSERT INTO `met` (`type`, `id`, `nom`, `prix`) VALUES('Dessert', 7, '7low', 6);
INSERT INTO `table_resto` (`numero`, `nb_couvert`, `supplement`, `type`) VALUES (1, 5, 4, 'petite terrasse');
INSERT INTO `table_resto` (`numero`, `nb_couvert`, `supplement`, `type`) VALUES (2, 2, 2, 'grand terrasse');
INSERT INTO `user` (`id`, `active`, `password`, `roles`, `user_name`) VALUES (1, 1, 'oussama', 'ROLE_USER', 'oussama');