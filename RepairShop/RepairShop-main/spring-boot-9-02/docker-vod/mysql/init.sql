CREATE TABLE `repairshop`
(
    `id`   int          NOT NULL AUTO_INCREMENT,
    `address` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `mechanic`
(
    `id`        int          NOT NULL AUTO_INCREMENT,
    `firstname` varchar(255) NOT NULL,
    `lastname`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE car
(
    `id`          int          NOT NULL AUTO_INCREMENT,
    brand         varchar(255) NOT NULL,
    model         varchar(255) NOT NULL,
    mechanic_id   int   DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE car_repairshop
(
    car_id        int DEFAULT NULL,
    repairshop_id int DEFAULT NULL
);

-- =========================================
-- WARSZTATY (5 ³¹cznie)
-- =========================================
INSERT INTO `repairshop`(`id`, `address`, `name`) VALUES ('1', 'ul. Mechaniczna 1, Warszawa', 'Auto-Fix Centrum');
INSERT INTO `repairshop`(`id`, `address`, `name`) VALUES ('2', 'ul. Naprawcza 15, Kraków', 'Szybki Serwis Nowak');
INSERT INTO `repairshop`(`id`, `address`, `name`) VALUES ('3', 'ul. Olejowa 7, Poznañ', 'Moto-Klinika');
-- Nowe warsztaty:
INSERT INTO `repairshop`(`id`, `address`, `name`) VALUES ('4', 'ul. D³uga 12, Gdañsk', 'Auto-Klinika Premium');
INSERT INTO `repairshop`(`id`, `address`, `name`) VALUES ('5', 'ul. Leœna 4, Wroc³aw', 'Warsztat pod Dêbem');

-- =========================================
-- MECHANICY (5 ³¹cznie)
-- =========================================
INSERT INTO `mechanic`(`id`, `firstname`, `lastname`) VALUES ('1', 'Jan', 'Kowalski');
INSERT INTO `mechanic`(`id`, `firstname`, `lastname`) VALUES ('2', 'Piotr', 'Nowak');
INSERT INTO `mechanic`(`id`, `firstname`, `lastname`) VALUES ('3', 'Adam', 'Wiœniewski');
-- Nowi mechanicy:
INSERT INTO `mechanic`(`id`, `firstname`, `lastname`) VALUES ('4', 'Marek', 'Zieliñski');
INSERT INTO `mechanic`(`id`, `firstname`, `lastname`) VALUES ('5', 'Tomasz', 'Kaczmarek');

-- =========================================
-- SAMOCHODY (10 ³¹cznie)
-- =========================================
INSERT INTO car(`id`, brand, model, mechanic_id) VALUES ('1', 'Toyota', 'Yaris', '1');
INSERT INTO car(`id`, brand,  model, mechanic_id) VALUES ('2', 'Ford', 'Focus', '2');
INSERT INTO car(`id`, brand,  model, mechanic_id) VALUES ('3', 'BMW', 'Seria 3', '1');
INSERT INTO car(`id`, brand,  model, mechanic_id) VALUES ('4', 'Audi', 'A4', '3');
INSERT INTO car(`id`, brand,  model, mechanic_id) VALUES ('5', 'Skoda', 'Octavia', '2');
-- Nowe auta:
INSERT INTO car(`id`, brand,  model, mechanic_id) VALUES ('6', 'Volkswagen', 'Golf', '4');
INSERT INTO car(`id`, brand,  model, mechanic_id) VALUES ('7', 'Honda', 'Civic', '5');
INSERT INTO car(`id`, brand,  model, mechanic_id) VALUES ('8', 'Renault', 'Clio', '4');
INSERT INTO car(`id`, brand,  model, mechanic_id) VALUES ('9', 'Opel', 'Astra', '5');
INSERT INTO car(`id`, brand,  model, mechanic_id) VALUES ('10', 'Mazda', '6', '1');

-- =========================================
-- POWI¥ZANIA (car_repairshop) - Gdzie by³o auto?
-- =========================================
INSERT INTO car_repairshop(car_id, repairshop_id) VALUES ('1', '1');
INSERT INTO car_repairshop(car_id, repairshop_id) VALUES ('1', '3');
INSERT INTO car_repairshop(car_id, repairshop_id) VALUES ('2', '2');
INSERT INTO car_repairshop(car_id, repairshop_id) VALUES ('3', '1');
INSERT INTO car_repairshop(car_id, repairshop_id) VALUES ('4', '3');
INSERT INTO car_repairshop(car_id, repairshop_id) VALUES ('5', '2');
-- Nowe powi¹zania:
INSERT INTO car_repairshop(car_id, repairshop_id) VALUES ('6', '4');
INSERT INTO car_repairshop(car_id, repairshop_id) VALUES ('7', '5');
INSERT INTO car_repairshop(car_id, repairshop_id) VALUES ('8', '4');
INSERT INTO car_repairshop(car_id, repairshop_id) VALUES ('8', '1');
INSERT INTO car_repairshop(car_id, repairshop_id) VALUES ('9', '5');
INSERT INTO car_repairshop(car_id, repairshop_id) VALUES ('10', '2');
INSERT INTO car_repairshop(car_id, repairshop_id) VALUES ('10', '4');

-- =========================================
-- U¯YTKOWNICY DO LOGOWANIA (Spring Security)
-- =========================================
CREATE TABLE user
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE role
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    role     VARCHAR(255)
);

INSERT INTO user(username, password)
VALUES ('dbuser1', 'dbuser1'),
       ('dbuser2', 'dbuser2'),
       ('dbuser3', 'dbuser3');

INSERT INTO role(username, role)
VALUES ('dbuser1', 'ROLE_ADMIN'),
       ('dbuser2', 'ROLE_MECHANIC'),
       ('dbuser3', 'ROLE_CUSTOMER');