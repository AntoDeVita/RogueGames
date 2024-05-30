DROP database IF EXISTS GameRogue;
CREATE database GameRogue;

USE GameRogue;

DROP TABLE IF EXISTS ClienteReg;
CREATE TABLE ClienteReg
(
	Email varchar(45) PRIMARY KEY NOT NULL,
    Password varchar(45) NOT NULL,
	Nome varchar(45) NOT NULL,
    Cognome varchar(45) NOT NULL,
    Eta int NOT NULL,
    Indirizzo varchar(45) NOT NULL,
    Tel int NOT NULL,
    Ruolo varchar(45) NOT NULL DEFAULT 'utente'
);

DROP TABLE IF EXISTS CartaDiCredito;
CREATE TABLE CartaDiCredito
(
    16cif int PRIMARY KEY NOT NULL,
    Scadenza date NOT NULL,
    CVV int NOT NULL
);

DROP TABLE IF EXISTS Usa;
CREATE TABLE Usa
(
    16cif int NOT NULL,
    Email varchar(45) NOT NULL,
    PRIMARY KEY(16cif,Email),
	FOREIGN KEY(16cif) REFERENCES CartaDiCredito(16cif) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY(Email) REFERENCES ClienteReg(Email) ON UPDATE cascade ON DELETE cascade
);

DROP TABLE IF EXISTS Tipologia;
CREATE TABLE Tipologia
(
    Tipologia ENUM('Videogiochi', 'Console', 'AF', 'Accessori') PRIMARY KEY NOT NULL
);

DROP TABLE IF EXISTS Prodotti;
CREATE TABLE Prodotti
(
	idProdotti int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Nome varchar(45) NOT NULL,
    Descrizione TEXT(50) NOT NULL,
    CoV tinyint(1) DEFAULT 0,
    prezzo double(10,2) NOT NULL,
    CasaProd varchar(45) NOT NULL,
    Genere ENUM('Funko', 'Statuette', 'Console', 'Azione', 'RPG', 'Fantasy') NOT NULL,
    Tipo ENUM('Videogiochi', 'Console', 'AF', 'Accessori') NOT NULL,
    DataRilascio date NOT NULL,
    FOREIGN KEY(Tipo) REFERENCES Tipologia(Tipologia) ON UPDATE cascade ON DELETE cascade
)ENGINE=InnoDB;

DROP TABLE IF EXISTS Ordine;
CREATE TABLE Ordine
(
	idOrdine int NOT NULL AUTO_INCREMENT,
    idProdotto int NOT NULL,
    Email varchar(45) NOT NULL,
    PrezzoTot double(10,2) NOT NULL,
    Quantita int NOT NULL,
    Data date NOT NULL,
    PRIMARY KEY(idOrdine,idProdotto),
    FOREIGN KEY(idProdotto) REFERENCES Prodotti(idProdotti) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY(Email) REFERENCES ClienteReg(Email) ON UPDATE cascade ON DELETE cascade
)ENGINE=InnoDB;


DROP TABLE IF EXISTS Preferiti;
CREATE TABLE Preferiti
(
	idProdo int NOT NULL,
    Email varchar(45) NOT NULL,
    PRIMARY KEY(idProdo,Email),
    FOREIGN KEY(idProdo) REFERENCES Prodotti(idProdotti) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY(Email) REFERENCES ClienteReg(Email) ON UPDATE cascade ON DELETE cascade
);

USE GameRogue;
