-- database: ../DataBase/EcuaFauna2K24A.SQLite
/*DROP TABLE IF EXISTS Hormiga;
DROP TABLE IF EXISTS Sexo;
DROP TABLE IF EXISTS GenoAlimento;
DROP TABLE IF EXISTS IngestaNativa;
DROP TABLE IF EXISTS Provincia;
DROP TABLE IF EXISTS Region;
DROP TABLE IF EXISTS Pais;

CREATE TABLE Pais (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL UNIQUE
    ,Estado VARCHAR(1) NOT NULL DEFAULT('A')
    ,FechaCrea DATETIME DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
);

CREATE TABLE Region (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL UNIQUE
    ,pais_id INTEGER
    ,Estado VARCHAR(1) NOT NULL DEFAULT('A')
    ,FechaCrea DATETIME DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
    ,FOREIGN KEY (pais_id) REFERENCES Pais(id)
);

CREATE TABLE Provincia (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL UNIQUE
    ,region_id INTEGER
    ,Estado VARCHAR(1) NOT NULL DEFAULT('A')
    ,FechaCrea DATETIME DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
    ,FOREIGN KEY (region_id) REFERENCES Region(id)
);

CREATE TABLE IngestaNativa (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    tipo TEXT NOT NULL UNIQUE
    ,Estado VARCHAR(1) NOT NULL DEFAULT('A')
    ,FechaCrea DATETIME DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
);

CREATE TABLE GenoAlimento (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    tipo TEXT NOT NULL UNIQUE
    ,Estado VARCHAR(1) NOT NULL DEFAULT('A')
    ,FechaCrea DATETIME DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
);

CREATE TABLE Sexo (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    tipo TEXT NOT NULL UNIQUE
    ,Estado VARCHAR(1) NOT NULL DEFAULT('A')
    ,FechaCrea DATETIME DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
);

CREATE TABLE Hormiga (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    tipo_hormiga TEXT NOT NULL
    ,sexo_id INTEGER
    ,provincia_id INTEGER
    ,geno_alimento_id INTEGER
    ,ingesta_nativa_id INTEGER
    ,Estado VARCHAR(1) NOT NULL DEFAULT('A')
    ,FechaCrea DATETIME DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
    ,FOREIGN KEY (sexo_id) REFERENCES Sexo(id)
    ,FOREIGN KEY (provincia_id) REFERENCES Provincia(id)
    ,FOREIGN KEY (geno_alimento_id) REFERENCES GenoAlimento(id)
    ,FOREIGN KEY (ingesta_nativa_id) REFERENCES IngestaNativa(id)
);*/
DROP TABLE IF EXISTS Hormiga;
DROP TABLE IF EXISTS IngestaNativa;
DROP TABLE IF EXISTS GenoAlimento;
DROP TABLE IF EXISTS TipoHormiga;
DROP TABLE IF EXISTS AlimentoTipo;
DROP TABLE IF EXISTS Ecuador;
DROP TABLE IF EXISTS Catalogo;
DROP TABLE IF EXISTS CatalogoTipo;
DROP TABLE IF EXISTS Entomologos;

CREATE TABLE CatalogoTipo(
    IdCatalogoTipo INTEGER PRIMARY KEY AUTOINCREMENT,     
    Nombre         VARCHAR(50) NOT NULL,
    Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X')),
    FechaCrea      DATETIME DEFAULT (DATETIME('now', 'localtime')),
    FechaModifica  DATETIME 
);
CREATE TABLE Catalogo(
    IdCatalogo     INTEGER PRIMARY KEY AUTOINCREMENT,
    IdCatalogoTipo INTEGER REFERENCES CatalogoTipo(IdCatalogoTipo),
    Nombre         VARCHAR(50) NOT NULL,
    Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X')),
    FechaCrea      DATETIME DEFAULT (DATETIME('now', 'localtime')),
    FechaModifica  DATETIME 
);

CREATE TABLE Localidad(
    IdLocalidad       INTEGER PRIMARY KEY AUTOINCREMENT,
    IdLocaliadPadre   INTEGER REFERENCES Localidad (IdLocalidad), 
    IdCatalogo        INTEGER REFERENCES Catalogo (IdCatalogo),
    Nombre            VARCHAR(50) NOT NULL,
    Estado            VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X')),
    FechaCrea         DATETIME DEFAULT (DATETIME('now', 'localtime')),
    FechaModifica     DATETIME 
);

CREATE TABLE IngestaNativa(
    IdIngestaNativa   INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre            VARCHAR(50) NOT NULL,
    Estado            VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X')),
    FechaCrea         DATETIME DEFAULT (DATETIME('now', 'localtime')),
    FechaModifica     DATETIME 
);

CREATE TABLE GenoAlimento(
    IdGenoAlimento   INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre            VARCHAR(50) NOT NULL,
    Estado            VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X')),
    FechaCrea         DATETIME DEFAULT (DATETIME('now', 'localtime')),
    FechaModifica     DATETIME 
);

CREATE TABLE TipoHormiga(
    IdTipoHormiga     INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre            VARCHAR(50) NOT NULL,
    Estado            VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X')),
    FechaCrea         DATETIME DEFAULT (DATETIME('now', 'localtime')),
    FechaModifica     DATETIME 
);

CREATE TABLE Hormiga(
    IdHormiga         INTEGER PRIMARY KEY AUTOINCREMENT,
    TipoHormiga       INTEGER REFERENCES TipoHormiga(IdTipoHormiga),
    Sexo              INTEGER REFERENCES Catalogo(IdCatalogo),
    Provincia         INTEGER REFERENCES Localidad (IdLocalidad),
    GenoAlimento      INTEGER REFERENCES GenoAlimento(IdGenoAlimento),
    IngestaNativa     INTEGER REFERENCES IngestaNativa(IdIngestaNativa),
    Estado            VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X')),
    FechaCrea         DATETIME DEFAULT (DATETIME('now', 'localtime')),
    FechaModifica     DATETIME 
);
