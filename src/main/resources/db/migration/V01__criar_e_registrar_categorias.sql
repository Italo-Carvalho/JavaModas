CREATE TABLE categoria(
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria (nome) values ('Roupas');
INSERT INTO categoria (nome) values ('Moda Feminina');
INSERT INTO categoria (nome) values ('Moda íntima');
INSERT INTO categoria (nome) values ('Moda Masculina');
INSERT INTO categoria (nome) values ('Joias e Relógios');