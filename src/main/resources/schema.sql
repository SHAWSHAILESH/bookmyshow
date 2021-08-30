create database bookmyshownew; 
use bookmyshownew;

DROP TABLE IF EXISTS user;  
CREATE TABLE user (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
username VARCHAR(50) UNIQUE NOT NULL,
password VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS movie;
CREATE TABLE movie (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
title VARCHAR(250) UNIQUE NOT NULL
); 

INSERT INTO movie VALUES (1, "Bell Bottom");
INSERT INTO movie VALUES (2, "F9"); 

DROP TABLE IF EXISTS city;
CREATE TABLE city (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
name VARCHAR(50) UNIQUE NOT NULL
);

INSERT INTO city VALUES (1, "Kolkata");
INSERT INTO city VALUES (2, "Bangalore");

DROP TABLE IF EXISTS slot;
CREATE TABLE slot (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
showtime datetime NOT NULL
);

INSERT INTO slot VALUES (1, '2021-08-30 12:00:00');
INSERT INTO slot VALUES (2, '2021-08-30 15:00:00');
INSERT INTO slot VALUES (3, '2021-09-01 12:00:00');
INSERT INTO slot VALUES (4, '2021-09-01 15:00:00');


DROP TABLE IF EXISTS cinema;
CREATE TABLE cinema (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
name VARCHAR(50) UNIQUE NOT NULL,
city_id INT NOT NULL,
FOREIGN KEY (city_id) REFERENCES city(id)
);

INSERT INTO cinema VALUES (1, 'INOX-1', 1);
INSERT INTO cinema VALUES (2, 'PVR-1', 1);
INSERT INTO cinema VALUES (3, 'INOX-2', 2);
INSERT INTO cinema VALUES (4, 'PVR-2', 2);

DROP TABLE IF EXISTS cinemamovie;
CREATE TABLE cinemamovie (
id INT AUTO_INCREMENT  PRIMARY KEY,    
cinema_id INT NOT NULL,  
slot_id INT NOT NULL,
movie_id INT NOT NULL,	
FOREIGN KEY (cinema_id) REFERENCES cinema(id),
FOREIGN KEY (movie_id) REFERENCES movie(id),
FOREIGN KEY (slot_id) REFERENCES slot(id)
);

INSERT INTO cinemamovie VALUES (1,1, 1, 1);
INSERT INTO cinemamovie VALUES (2,1, 2, 2);
INSERT INTO cinemamovie VALUES (3,2, 1, 1);
INSERT INTO cinemamovie VALUES (4,2, 2, 2);

DROP TABLE IF EXISTS cinemaseat;
CREATE TABLE cinemaseat (  
seat_id INT AUTO_INCREMENT  PRIMARY KEY,
cinema_id INT NOT NULL,  
slot_id INT NOT NULL,
seat_no VARCHAR(50) NOT NULL,
status VARCHAR(50) NOT NULL,
FOREIGN KEY (cinema_id) REFERENCES cinema(id),
FOREIGN KEY (slot_id) REFERENCES slot(id)
);

INSERT INTO cinemaseat VALUES (1, 1, 1, 'A1', 'OPEN');
INSERT INTO cinemaseat VALUES (2, 1, 1, 'A2', 'OPEN');
INSERT INTO cinemaseat VALUES (3, 1, 1, 'A3', 'OPEN');
INSERT INTO cinemaseat VALUES (4, 1, 1, 'A4', 'OPEN');
INSERT INTO cinemaseat VALUES (5, 1, 1, 'A5', 'OPEN');

INSERT INTO cinemaseat VALUES (6, 2, 2,'B1', 'OPEN');
INSERT INTO cinemaseat VALUES (7, 2, 2,'B2', 'OPEN');
INSERT INTO cinemaseat VALUES (8, 2, 2,'B3', 'OPEN');
INSERT INTO cinemaseat VALUES (9, 2, 2,'B4', 'OPEN');
INSERT INTO cinemaseat VALUES (10, 2, 2,'B5', 'OPEN');

INSERT INTO cinemaseat VALUES (11, 1, 2,'B1', 'OPEN');
INSERT INTO cinemaseat VALUES (12, 1, 2,'B2', 'OPEN');
INSERT INTO cinemaseat VALUES (13, 1, 2,'B3', 'OPEN');
INSERT INTO cinemaseat VALUES (14, 1, 2,'B4', 'OPEN');
INSERT INTO cinemaseat VALUES (15, 1, 2,'B5', 'OPEN');


DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket (
ticket_id INT  AUTO_INCREMENT PRIMARY KEY,
user_id INT NOT NULL,  
seat_id INT NOT NULL,
status VARCHAR(50) NOT NULL,
FOREIGN KEY (seat_id) REFERENCES cinemaseat(seat_id),
FOREIGN KEY (user_id) REFERENCES user(id)
);