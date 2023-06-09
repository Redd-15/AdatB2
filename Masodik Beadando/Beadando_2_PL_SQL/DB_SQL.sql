CREATE TABLE HIVAS (
    HID INT PRIMARY KEY, 
    Idopont TIMESTAMP NOT NULL, 
    Hivo_nev VARCHAR2(50) NOT NULL, 
    Telefonszam VARCHAR2(20) NOT NULL, 
    Cim VARCHAR2(50) NOT NULL, 
    Fontossagi_szint INT NOT NULL CHECK(Fontossagi_szint BETWEEN 0 AND 5) )

CREATE TABLE AUTO(
    AID INT PRIMARY KEY,
    Rendszam VARCHAR2(8) NOT NULL,
    Marka VARCHAR2(50) NOT NULL)

CREATE TABLE MENTOS(
    MID INT PRIMARY KEY,
    Nev VARCHAR2(60) NOT NULL,
    Beosztas VARCHAR2(40) NOT NULL)

CREATE TABLE KIVONULAS (
    KID INT PRIMARY KEY, 
    HID REFERENCES HIVAS(HID),
    AID REFERENCES AUTO(AID),
    Erkezes TIMESTAMP, 
    Kimenetel VARCHAR2(50))
    
CREATE TABLE OSZTAG(
    KID INT REFERENCES KIVONULAS(KID),
    MID INT REFERENCES MENTOS(MID))
    