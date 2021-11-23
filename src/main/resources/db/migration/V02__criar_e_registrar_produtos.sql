CREATE TABLE produto (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(100) NOT NULL,
	quantidade INTEGER NOT NULL,
	preco_curto DECIMAL(10,2) NOT NULL,
	preco_venda DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(500),
	id_categoria BIGINT NOT NULL,
	FOREIGN KEY (id_categoria) REFERENCES categoria(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Blusa do Coringa', 10, 30, 60, 'Blusa rosa do Coriga', 1);
INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Calça preta', 10, 20, 40, 'Calça com bixinhos', 1);
INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Bermuda Jeans Claro', 10, 25, 1073.36, 'Bermuda com ziper quebrado', 1);
INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Vestido floral', 25, 40, 80, 'Vestido longo florido', 1);
INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Saia jeans', 15, 40, 60, 'Saia de crente', 1);
INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Sutiã preto', 10, 24, 54, 'Sutiã preto de rendinha', 3);
INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Cueca azul', 10, 10, 20, 'Cueca azul DF', 3);
INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Calcinha azul', 10, 8, 15, 'Calcinha azul florida', 3);
INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Cinto de couro', 30, 70.90, 139.90, 'Cinto de couro de jacaré', 4);
INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Camisa Preta Gamer', 8, 60.80, 106.80, 'Camisa preta de joguinho', 4);
INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Sapato Social', 20, 280.50, 424.86, 'Sapato de couro, de pastor', 4);
INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Jaqueta do Freefire', 30, 100, 200, 'Jaqueta do Freefire Mestre', 4);
INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Brinco de Coração', 22, 31, 41, 'Brinco de coração azul', 5);
INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Cordão Crystal Edition', 50, 1, 10000, 'Cordão corações Crystal', 5);
INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Pulseira dourada', 35, 10, 30, 'Pulsera dourada de bolinha', 5);
INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Tornozeleira Life Cintrino', 50, 100, 570, 'Tornozeleira de prata colorida', 5);
INSERT INTO produto (descricao, quantidade, preco_curto, preco_venda, observacao, id_categoria) values ('Anel Maciço Ouro 18k', 60, 210, 299.90, 'Anel Solitario Maciço Ouro 18k 750 7mm Escolha A Cor', 5);