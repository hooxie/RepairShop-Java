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
    brand      varchar(255) NOT NULL,
    model       varchar(255) NOT NULL,
    mechanic_id int   DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE car_repairshop
(
    car_id  int DEFAULT NULL,
    repairshop_id int DEFAULT NULL
);

INSERT INTO `repairshop`(`id`, `address`, `name`)
VALUES ('1', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Multikino_logo.png/1198px-Multikino_logo.png',
        'Multikino');
INSERT INTO `repairshop`(`id`, `address`, `name`)
VALUES ('2', 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Imax.svg/330px-Imax.svg.png', 'IMAX');
INSERT INTO `repairshop`(`id`, `address`, `name`)
VALUES ('3', 'https://www.cinema-city.pl/xmedia/img/10103/logo.svg', 'Cinema City');

INSERT INTO `mechanic`(`id`, `firstname`, `lastname`)
VALUES ('1', 'Steven', 'Spielberg');
INSERT INTO `mechanic`(`id`, `firstname`, `lastname`)
VALUES ('2', 'Woody', 'Allen');
INSERT INTO `mechanic`(`id`, `firstname`, `lastname`)
VALUES ('3', 'Guy', 'Ritchie');

INSERT INTO car(`id`, brand, model, mechanic_id)
VALUES ('1', 'https://static.posters.cz/image/750webp/73584.webp', 'Jaws', '1');
INSERT INTO car(`id`, brand,  model, mechanic_id)
VALUES ('2', 'https://fwcdn.pl/fpo/01/79/179/7710998.6.jpg',  'Saving Private Ryan', '1');
INSERT INTO car(`id`, brand,  model, mechanic_id)
VALUES ('3', 'https://fwcdn.pl/fpo/12/15/1215/6918508.6.jpg',  'E.T.', '1');
INSERT INTO car(`id`, brand,  model, mechanic_id)
VALUES ('4', 'https://upload.wikimedia.org/wikipedia/en/0/05/Vicky_Cristina_Barcelona_film_poster.png',
        'Vicky Cristina Barcelona', '2');
INSERT INTO car(`id`, brand,  model, mechanic_id)
VALUES ('5', 'https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Manhattan-poster01.jpg/220px-Manhattan-poster01.jpg',
        'Manhattan', '2');
INSERT INTO car(`id`, brand,  model, mechanic_id)
VALUES ('6', 'https://fwcdn.pl/fpo/13/26/1326/7635628.6.jpg',  'Snatch', '3');
INSERT INTO car(`id`, brand,  model, mechanic_id)
VALUES ('7', 'https://fwcdn.pl/fpo/19/97/441997/7239460.6.jpg',  'RockNRolla', '3');

INSERT INTO car_repairshop(car_id, repairshop_id)
VALUES ('1', '1');
INSERT INTO car_repairshop(car_id, repairshop_id)
VALUES ('1', '3');
INSERT INTO car_repairshop(car_id, repairshop_id)
VALUES ('2', '3');
INSERT INTO car_repairshop(car_id, repairshop_id)
VALUES ('3', '1');
INSERT INTO car_repairshop(car_id, repairshop_id)
VALUES ('3', '2');
INSERT INTO car_repairshop(car_id, repairshop_id)
VALUES ('4', '1');
INSERT INTO car_repairshop(car_id, repairshop_id)
VALUES ('4', '3');
INSERT INTO car_repairshop(car_id, repairshop_id)
VALUES ('5', '2');
INSERT INTO car_repairshop(car_id, repairshop_id)
VALUES ('5', '3');
INSERT INTO car_repairshop(car_id, repairshop_id)
VALUES ('6', '1');
INSERT INTO car_repairshop(car_id, repairshop_id)
VALUES ('7', '2');
















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
VALUES ('dbuser1', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser2', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser3', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS');


INSERT INTO role(username, role)
VALUES ('dbuser1', 'USER_ADMIN'),
       ('dbuser2', 'AUTHOR_ADMIN'),
       ('dbuser3', 'BOOK_ADMIN');




