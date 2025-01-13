INSERT INTO endereco (rua, numero, complemento, bairro, cidade, estado, pais, cep)
VALUES
    ('Av. Paulista', '1106', '7º andar', 'Bela Vista', 'São Paulo', 'SP', 'Brasil', '01311-000');

INSERT INTO usuario (nome, email, login, senha, ultima_alteracao, id_endereco)
VALUES ('João da Silva', 'joao.silva@email.com', 'joaosilva', '$2a$10$TmKKqj.rrcfAG9Oy/4ZsJOrk1Uf0lrRwtcmSCLnLVA92l1cbyFIoG', '2025-01-09', 1);