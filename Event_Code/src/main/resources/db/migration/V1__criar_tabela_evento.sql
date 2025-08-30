CREATE TYPE tipos AS ENUM('MUSICA','NETWORK','COMICOM','CINEMA');
CREATE TABLE Eventos(
nome VARCHAR(255) NOT NULL,
id BIGSERIAL PRIMARY KEY,
descricao TEXT,
capacidade INT NOT NULL,
tipo tipos,
local_evento VARCHAR NOT NULL,
identificador VARCHAR NOT NULL UNIQUE,
organizador VARCHAR,
inicio_evento TIMESTAMP NOT NULL,
termino_evento TIMESTAMP NOT NULL
);