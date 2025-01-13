CREATE TABLE IF NOT EXISTS endereco (
    id BIGSERIAL PRIMARY KEY,
    rua VARCHAR(255) NOT NULL,
    numero VARCHAR(10),
    complemento VARCHAR(255),
    bairro VARCHAR(255),
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(100) NOT NULL,
    pais VARCHAR(100) NOT NULL,
    cep VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS usuario (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    login VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    ultima_alteracao DATE,
    id_endereco BIGINT,
    CONSTRAINT fk_usuario_endereco FOREIGN KEY (id_endereco) REFERENCES endereco (id)
);