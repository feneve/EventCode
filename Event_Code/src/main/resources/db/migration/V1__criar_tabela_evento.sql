CREATE TABLE eventos (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    capacidade INT NOT NULL,
    tipo VARCHAR(50) NOT NULL, -- enum será salvo como string
    local_evento VARCHAR NOT NULL,
    identificador VARCHAR NOT NULL UNIQUE,
    organizador VARCHAR,
    inicio_evento TIMESTAMP NOT NULL,
    termino_evento TIMESTAMP NOT NULL
);
