DROP TABLE IF EXISTS boarding;

CREATE TABLE boarding (
 ID VARCHAR(5) NOT NULL PRIMARY KEY,
 Name VARCHAR(20),
 Contact int,
 Email VARCHAR(20),
 BusID VARCHAR(25),
 Tickets int
);