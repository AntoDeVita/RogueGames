DROP database IF EXISTS GameRogue;
CREATE database GameRogue;

USE GameRogue;

DROP TABLE IF EXISTS ClienteReg;
CREATE TABLE ClienteReg
(
	Email varchar(45) PRIMARY KEY NOT NULL,
    Password varchar(100) NOT NULL,
	Nome varchar(45) NOT NULL,
    Cognome varchar(45) NOT NULL,
    Eta int NOT NULL,
    Indirizzo varchar(45) NOT NULL,
    Tel varchar(10) NOT NULL,
    Ruolo varchar(45) NOT NULL DEFAULT 'utente'
);

INSERT INTO ClienteReg VALUES ('antoniodevita25@gmail.com', sha2('Client1', 256), 'Antonio', 'De Vita', 21, 'Faiano', '123456789', default);
INSERT INTO ClienteReg VALUES ('g.lavorato@studenti.unisa.it', sha2('Admin1', 256), 'Giovanni', 'Lavorato', 21, 'San Vito', '123456789', 'admin');
INSERT INTO ClienteReg VALUES ('m.battaglia13@studenti.unisa.it', sha2('Client2', 256), 'Marco', 'Battaglia', 21, 'Bellizzi', '123456789', default);

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
INSERT INTO tipologia VALUES ('Videogiochi');
INSERT INTO tipologia VALUES ('Console');
INSERT INTO tipologia VALUES ('AF');
INSERT INTO tipologia VALUES ('Accessori');

DROP TABLE IF EXISTS Prodotti;
CREATE TABLE Prodotti
(
	idProdotti int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Nome varchar(45) NOT NULL,
    Immagine varchar(255) NOT NULL,
    Descrizione TEXT(255) NOT NULL,
    CoV tinyint(1) DEFAULT 0,
    prezzo double(10,2) NOT NULL,
    CasaProd varchar(45) NOT NULL,
    Piattaforma ENUM('PlayStation', 'Xbox', 'Pc', 'Nintendo Switch'),
    Genere varchar(45) NOT NULL,
    Tipo ENUM('Videogiochi', 'Console', 'AF', 'Accessori') NOT NULL,
    DataRilascio date NOT NULL,
	Quantita int NOT NULL,
    FOREIGN KEY(Tipo) REFERENCES Tipologia(Tipologia) ON UPDATE cascade ON DELETE cascade
)ENGINE=InnoDB;

INSERT INTO Prodotti VALUES(NULL, 'God of War Ragnarök', "images/Gow4.jpg", 'Accompagnato solamente da Mimir, Kratos parte per un viaggio estremamente personale e riflessivo che lo spinge a dominare il corpo e la mente attraverso le sfide che il Valhalla gli propone, in una grande avventura rigiocabile che unisce il tanto apprezzato sistema di combattimento di God of War Ragnarök con nuovi elementi ispirati al genere roguelite. Il viaggio di Kratos continua entrando nel Valhalla, un nuovo luogo della saga norrena di God of War. Affrontando gli echi del suo passato, combatte per superare le tribolazioni dentro sé stesso e percorrere la strada che gli si apre dinnanzi.', 0, 49.99, 'Santa Monica Studio', 'PlayStation', 'Azione', 'Videogiochi', '2022-11-09', 2);
INSERT INTO Prodotti VALUES(NULL, 'The legend of Zelda Action figure Link', 'images/LinkAF.jpg', "C'era una volta un disastro che divenne noto come 'Calamità'. E Hyrule Kingdom è crollato. Questa è una storia di 100 anni dopo 'Calamity'. Link, come personaggio principale, si sveglia da un lungo sonno nella rovina sotterranea. Poi sente una voce misteriosa. Successivamente, entra nella terra selvaggia. First 4 Figures è orgogliosa di presentare questa tanto attesa statua in PVC di Link del videogioco The Legend of Zelda: Breath of the Wild. 25 cm di altezza e viene fornito con base coordinata in una confezione deluxe a colori.", 0, 651.57, 'Fairyland Studio', null, 'Statuette', 'AF', '2020-01-20',  6);
INSERT INTO Prodotti VALUES(NULL, 'PlayStation 5 Digital Edition', 'images/PS5.png', 'PS5 Digital Edition è una versione completamente digitale della console PS5 senza lettore di dischi. Accedi al tuo account di PlayStation Network e vai al PlayStation®Store per acquistare e scaricare i giochi***. Spedizione standard gratuita per tutti gli ordini. Base verticale venduta separatamente.', 0, 399.99, 'Sony Interactive Studio', null, 'Console', 'Console', '2020-11-12',  8);
INSERT INTO Prodotti VALUES(NULL, 'Tazza 3D Pokeball', 'images/TazzaPokemon.jpg', "Tazza in ceramica con forma 3D, con capacità di 500 ml. Ideale per l'uso quotidiano o come regalo e disegnata con i personaggi più famosi del cinema e della televisione.", 0, 19.99, 'Abysse', null, 'Tazza', 'Accessori', '2012-10-28', 1);
INSERT INTO Prodotti VALUES (NULL, 'EldenRing', 'images/EldenRing.jpg', "Alzati, Senzaluce, e lasciati guidare dalla grazia verso la conquista dell'Anello ancestrale, il cui potere ti renderà lord dell'Interregno. Un vasto mondo, in cui lande sconfinate e dense di pericoli si intersecano senza soluzione di continuità a dedali sotterranei dalle sontuose architetture tridimensionali. Esplora l'ignoto e combatti minacce mortali in un mondo in cui la sopravvivenza è una conquista. Oltre a creare da zero l'aspetto del tuo eroe, puoi personalizzarne l'equipaggiamento scegliendo armi, corazze e incantesimi. Sviluppa le sue capacità in base al tuo stile di gioco, favorendo la forza fisica o puntando sulle pratiche magiche.", '0', '39.99', 'FromSoftware', 'Xbox', 'RPG', 'Videogiochi', '2022-02-25',  10);
INSERT INTO Prodotti VALUES (NULL, 'Pokemon Perla Splendente', 'images/PokemonPerla.jpg', "Pokémon Diamante Lucente e Pokémon Perla Splendente sono la seconda coppia di videogiochi di ottava generazione, nonché i remake dei primi giochi di quarta generazione: Diamante e Perla. I giochi sono stati annunciati alla mezzanotte giapponese del 27 febbraio 2021[1] durante il Pokémon Presents dedicato al 25º Anniversario dalla pubblicazione di Pokémon Rosso e Verde. Sono stati pubblicati in tutto il mondo il 19 novembre 2021[2]. Tutte le copie saranno giocabili in nove lingue: giapponese, inglese, tedesco, spagnolo, francese, italiano, coreano, cinese semplificato e cinese tradizionale.", '0', '49.99', 'Studio ILCA', 'Nintendo Switch', 'Fantasy', 'Videogiochi', '2021-11-19',  50);
INSERT INTO Prodotti VALUES (NULL, 'Tom Clancy\'s Rainbow Six Siege', 'images/R6S.jpg', "Tom Clancy's Rainbow Six® Siege è uno sparatutto d'élite a squadre, tattico e realistico, in cui trionfano pianificazione ed esecuzione ad alto livello. È caratterizzato da un gameplay 5v5 attacco contro difesa e da intensi combattimenti ravvicinati in ambienti distruttibili. Mettiti alla prova con un nuovo stile di assalti caratterizzati da un livello di distruzione e impiego di gadget senza precedenti. Da difensore, coordina i tuoi compagni per trasformare l'ambiente in una fortezza. Colloca trappole, erigi fortificazioni e crea sistemi difensivi per impedire al nemico di fare breccia. Da assalitore, guida i compagni tra stretti corridoi, porte barricate e pareti rinforzate. Combina l'utilizzo di mappe tattiche, droni da ricognizione, rampini e altro ancora per pianificare l'attacco e pacificare ogni situazione.", '0', '19.99', 'Ubisoft', 'Pc', 'Sparatutto', 'Videogiochi', '2015-12-01', 30);
INSERT INTO Prodotti VALUES (NULL, 'Fairytail Happy Peluche', 'images/Happy.jpg', "Peluche del personaggio Happy di Fairytail. Peluche Happy in qualità super morbida: il nostro peluche Happy è realizzato con materiali di alta qualità ed è prodotto secondo le norme di sicurezza. Peluche del gatto Happy. Blu con ali bianche. Dettaglio dello zaino verde sulla schiena e del suo marchio stampato. Con espressione felice e bocca e occhi ricamati. Presentato in blister.", '0', '10.97', 'Jilijia', null, 'Peluche', 'AF', '2017-10-16',  20);
INSERT INTO Prodotti VALUES (NULL, 'Xbox Series X', 'images/Xbox.jpg', "Xbox Series X dispone di un hardware di fascia più alta e supporta una risoluzione video fino a 8K, insieme a un frame rate più elevato fino a 120 fps, ray tracing, Dolby Vision e tempi di caricamento ridotti grazie ad un'unità a stato solido ad alta velocità.", '0', '479.99', 'Microsoft', null, 'Console', 'Console', '2020-11-10', 200);
INSERT INTO Prodotti VALUES (NULL, 'Jujutsu Kaisen Gojo Satuoru FunkoPop', 'images/FunkoGojo.jpg', "Funko pop di Gojo Satoru. Funko è una parte importante nello stile di vita della cultura pop. Fornisce connessione alla cultura pop con una linea di prodotti che include personaggi in vinile, giocattoli d'azione, peluche, abbigliamento, giochi da tavolo, articoli per la casa, NFT e accessori. In quanto detentore di licenze, gli appassionati d'intrattenimento mostrano il loro fandom attraverso la lente dei prodotti Funko. L'azienda alimenta Loungefly, Funko Games e Digital Pop!, offrendo anche un'ampia selezione di prodotti di consumo della cultura pop attraverso i suoi siti web.", '1', '21.99', 'Funko', null, 'Funko', 'AF', '2022-07-14', 33);
INSERT INTO Prodotti VALUES (NULL, 'Outlast', 'images/Outlast.jpg', "Outlast è una serie di giochi survival horror in prima persona sviluppata da Red Barrels. I protagonisti di Outlast non hanno abilità di combattimento. Devono correre, nascondersi o morire. L'unica arma che hanno è una videocamera che usano per registrare gli orribili eventi che si dipanano mentre avanzano nel gioco.", '0', '19.99', 'Red Barrels', 'Pc', 'Horror', 'Videogiochi', '2013-09-04', 50);

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

INSERT INTO Ordine VALUES (1, 9, 'm.battaglia13@studenti.unisa.it', 959.98, 2, '2022-11-10');
INSERT INTO Ordine VALUES (2, 1, 'antoniodevita25@gmail.com', 49.99, 1, '2021-07-03');
INSERT INTO Ordine VALUES (3, 8, 'g.lavorato@studenti.unisa.it', 32.91, 3, '2022-03-20');
INSERT INTO Ordine VALUES (2, 3, 'antoniodevita25@gmail.com', 399.99, 1, '2021-07-03');

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
