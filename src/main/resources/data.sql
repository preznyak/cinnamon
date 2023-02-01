INSERT INTO ROOM (NAME, ROOM_NUMBER, BED_INFO, CAPACITY, TYPE) VALUES ('Tulipan', '1P', '1Q', 2, 'Standard');
INSERT INTO ROOM (NAME, ROOM_NUMBER, BED_INFO, CAPACITY, TYPE) VALUES ('Tavirozsa', '2P', '2K', 4, 'Suite');
INSERT INTO ROOM (NAME, ROOM_NUMBER, BED_INFO, CAPACITY, TYPE) VALUES ('Levendula', '3P', '2S', 2, 'Standard');
INSERT INTO ROOM (NAME, ROOM_NUMBER, BED_INFO, CAPACITY, TYPE) VALUES ('Barack', '2A', '1Q', 2, 'Standard');
INSERT INTO ROOM (NAME, ROOM_NUMBER, BED_INFO, CAPACITY, TYPE) VALUES ('Jazmin', '3A', '1Q2S', 4, 'Suite');
INSERT INTO ROOM (NAME, ROOM_NUMBER, BED_INFO, CAPACITY, TYPE) VALUES ('Oregano', '3D', '1Q', 2, 'Suite');
INSERT INTO ROOM (NAME, ROOM_NUMBER, BED_INFO, CAPACITY, TYPE) VALUES ('Ananasz', '3O', '1Q1S', 4, 'Suite');

-- Q=queen bed, K=king size bed, S=double bed

INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, STATE, PHONE_NUMBER) VALUES ('John', 'Cena', 'john2cena@gmail.com', 'Hungary', 'Debrecen, Dozsa str. 5', 'Hajdu-Bihar', '+36504256987');
INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, STATE, PHONE_NUMBER) VALUES ('Papp', 'Janos', 'ezittpappjancsi1@gmail.com', 'Hungary', 'Pecs, Kossuth Lajos str. 91', 'Baranya', '+52458961121');
INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, STATE, PHONE_NUMBER) VALUES ('Mora', 'Ferenc', 'moraferike77@gmail.com', 'Hungary', 'Nyiregyhaza, Forradalom str. 73', 'Szabolcs-Szatmar-Bereg', '+36924568127');
INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, STATE, PHONE_NUMBER) VALUES ('Lukacs', 'Jozsef', 'ljozsi485@gmail.com', 'Hungary', 'Debrecen, Derek str. 22', 'Hajdu-Bihar', '+40725147896');
INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, STATE, PHONE_NUMBER) VALUES ('Lakatos', 'Arnold', 'lakatosarny@gmail.com', 'Hungary', 'Budapest, Blaha Lujza str. 98.', 'Pest', '+40734111111');
INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, STATE, PHONE_NUMBER) VALUES ('Juhasz', 'Roland', 'juhaszroli22@gmail.com', 'Hungary', 'Letavertes, Sandor str. 15', 'Hajdu-Bihar', '+36458214664');

INSERT INTO RESERVATION (ROOM_ID, GUEST_ID, RES_DATE_START, RES_DATE_END, PRICE) VALUES (1, 2, '2022-01-01', '2022-01-03', 50);
INSERT INTO RESERVATION (ROOM_ID, GUEST_ID, RES_DATE_START, RES_DATE_END, PRICE) VALUES (1, 2, '2022-02-04', '2022-02-14', 50);